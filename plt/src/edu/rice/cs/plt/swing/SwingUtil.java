package edu.rice.cs.plt.swing;

import java.io.File;
import java.io.Reader;
import java.io.IOException;
// import java.io.FileFilter;  not imported to avoid ambiguity
import java.awt.Window;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Point;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GraphicsDevice;
import java.awt.GraphicsEnvironment;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
// import javax.swing.filechooser.FileFilter;  not imported to avoid ambiguity
import java.lang.reflect.InvocationTargetException;

//import java.awt.*;
//import java.awt.event.*;
//import javax.swing.*;
//import javax.swing.border.Border;
//import java.awt.datatransfer.*;

import edu.rice.cs.plt.lambda.LambdaUtil;
import edu.rice.cs.plt.lambda.WrappedException;
import edu.rice.cs.plt.lambda.Runnable1;
import edu.rice.cs.plt.lambda.Predicate;
import edu.rice.cs.plt.io.IOUtil;
import edu.rice.cs.plt.debug.DebugUtil;

public class SwingUtil {
  
  /** 
   * Runs the task synchronously if the current thread is the event thread; otherwise passes it to the
   * event thread to be run asynchronously after all events already on the queue have been processed.
   */
  public static void invokeLater(Runnable task) {
    if (EventQueue.isDispatchThread()) { task.run(); }
    else { EventQueue.invokeLater(task); }
  }
  
  /**
   * Runs the the task in the event thread, blocking until it is complete.
   * 
   * @throws WrappedException  Wrapping an {@link InterruptedException} if the current thread is interrupted
   * @throws RuntimeException  If an exception is thrown by {@code task}
   */
  public static void invokeAndWait(Runnable task) {
    if (EventQueue.isDispatchThread()) { task.run(); }
    else {
      try { EventQueue.invokeAndWait(task); }
      catch (InterruptedException e) { throw new WrappedException(e); }
      catch (InvocationTargetException e) {
        Throwable cause = e.getCause();
        // must be a RuntimeException or an Error, because Runnable's can't have checked exceptions
        if (cause instanceof RuntimeException) { throw (RuntimeException) cause; }
        else if (cause instanceof Error) { throw (Error) cause; }
        else { DebugUtil.error.log("Unexpected InvocationTargetException caused by invokeAndWait", cause); }
      }
    }
  }
  
  /** Wait for all items in the event queue to be handled.  This may be called by any thread. */
  public static void clearEventQueue() {
    invokeAndWait(LambdaUtil.NO_OP);
  }
  
  /** Convert a {@code Runnable} to an {@code ActionListener} */
  public static ActionListener asActionListener(final Runnable r) {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) { r.run(); }
    };
  }
  
  /** Convert a {@code Runnable1} to an {@code ActionListener} */
  public static ActionListener asActionListener(final Runnable1<? super ActionEvent> r) {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) { r.run(e); }
    };
  }
  
  /** Convert an {@code ActionListener} to a {@code Runnable1} */
  public static Runnable1<ActionEvent> asRunnable(final ActionListener l) {
    return new Runnable1<ActionEvent>() {
      public void run(ActionEvent e) { l.actionPerformed(e); }
    };
  }
  
  /**
   * Define a Swing file filter (for use with {@link javax.swing.JFileChooser}s) in terms if a 
   * {@code FileFilter}
   */
  public static javax.swing.filechooser.FileFilter asSwingFileFilter(final java.io.FileFilter filter, 
                                                                     final String description) {
    return new javax.swing.filechooser.FileFilter() {
      public boolean accept(File f) { return filter.accept(f); }
      public String getDescription() { return description; }
    };
  }
  
  /**
   * Define a Swing file filter (for use with {@link javax.swing.JFileChooser}s) in terms if a 
   * {@code FileFilter}
   */
  public static javax.swing.filechooser.FileFilter asSwingFileFilter(Predicate<? super File> p, String description) {
    return asSwingFileFilter(IOUtil.asFileFilter(p), description);
  }
  
  /** Create an action to invoke {@link Window#dispose} on the given window */
  public static ActionListener disposeAction(final Window w) {
    return new ActionListener() {
      public void actionPerformed(ActionEvent e) { w.dispose(); }
    };
  }
  
  /** Invoke {@link #showPopup} with title {@code "Debug Message"}.  This may be called by any thread. */
  public static void showDebug(String msg) { showPopup("Debug Message", msg); }
  
  /**
   * Show a modal message box with an OK button.  This may be called by any thread.
   * 
   * @param msg  String to display
   * @param title  Title of the box
   */
  public static void showPopup(final String title, final String msg) {
    invokeAndWait(new Runnable() { public void run() {
      TextAreaMessageDialog.showDialog(null, title, msg); 
    } } );
  }
  
  /** @return a string with the current clipboard selection, or null if not available. */
  public static String getClipboardSelection(Component c) {
    Clipboard cb = c.getToolkit().getSystemClipboard();
    if (cb==null) return null;
    Transferable t = cb.getContents(null);
    if (t==null) return null;
    String s = null;
    try {
      Reader r = DataFlavor.stringFlavor.getReaderForText(t);
      s = IOUtil.toString(r);
    }
    catch(UnsupportedFlavorException ufe) { /* ignore, return null */ }
    catch(java.io.IOException ioe) { /* ignore, return null */ }
    return s;
  }


  /** Convenience method for {@link #setPopupLoc(Window, Component)} that gets the owner from {@code popup.getOwner()} */
  public static void setPopupLoc(Window popup) { setPopupLoc(popup, popup.getOwner()); }
  
  /** 
   * <p>Sets the location of the popup in a consistent way.  If the popup has an owner, the popup is centered over the
   * owner.  If the popup has no owner (owner == null), the popup is centered over the first monitor.  In either case,
   * the popup is moved and scaled if any part of it is not on the screen.  This method should be called for all popups
   * to maintain consistancy.</p>
   * <p>This method should only be called from the event thread.</p>
   * 
   * @param popup the popup window
   * @param owner the parent component for the popup, or {@code null}
   */
  public static void setPopupLoc(Window popup, Component owner) {
    Rectangle frameRect = popup.getBounds();
    
    Point ownerLoc = null;
    Dimension ownerSize = null;
    if(owner!=null) {
      ownerLoc = owner.getLocation();
      ownerSize = owner.getSize();
    }
    else {
      //for multi-monitor support
      //Question: do we want it to popup on the first monitor always?
      GraphicsDevice[] dev = GraphicsEnvironment.getLocalGraphicsEnvironment().getScreenDevices();
      Rectangle rec = dev[0].getDefaultConfiguration().getBounds();
      ownerLoc = rec.getLocation();
      ownerSize = rec.getSize();
    }
    
    // center it on owner
    Point loc = new Point(ownerLoc.x + (ownerSize.width - frameRect.width) / 2,
                          ownerLoc.y + (ownerSize.height - frameRect.height) / 2);
    frameRect.setLocation(loc);
    
    // now find the GraphicsConfiguration the popup is on
    GraphicsConfiguration gcBest = null;
    int gcBestArea = -1;
    GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
    GraphicsDevice[] gs = ge.getScreenDevices();
    for (GraphicsDevice gd: gs) {
      GraphicsConfiguration gc = gd.getDefaultConfiguration();
      Rectangle isect = frameRect.intersection(gc.getBounds());
      int gcArea = isect.width*isect.height;
      if (gcArea>gcBestArea) {
        gcBest = gc;
        gcBestArea = gcArea;
      }
    }
    
    // make it fit on the screen
    Rectangle screenRect = gcBest.getBounds();
    Dimension screenSize = screenRect.getSize();
    Dimension frameSize = popup.getSize();

    if (frameSize.height > screenSize.height) frameSize.height = screenSize.height;
    if (frameSize.width > screenSize.width) frameSize.width = screenSize.width;

    frameRect.setSize(frameSize);
    
    // center it on owner again
    loc = new Point(ownerLoc.x + (ownerSize.width - frameRect.width) / 2,
                    ownerLoc.y + (ownerSize.height - frameRect.height) / 2);
    frameRect.setLocation(loc);
    
    // now fit it on the screen
    if (frameRect.x < screenRect.x) frameRect.x = screenRect.x;
    if (frameRect.x + frameRect.width > screenRect.x + screenRect.width)
      frameRect.x = screenRect.x + screenRect.width - frameRect.width;
    
    if (frameRect.y < screenRect.y) frameRect.y = screenRect.y;
    if (frameRect.y + frameRect.height > screenRect.y + screenRect.height)
      frameRect.y = screenRect.y + screenRect.height - frameRect.height;

    popup.setSize(frameRect.getSize());
    popup.setLocation(frameRect.getLocation());
  }
  
  
}