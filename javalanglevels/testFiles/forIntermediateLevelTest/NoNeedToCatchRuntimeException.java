// Language Level Converter line number map: dj*->java. Entries: 16
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14       12->15       13->16       14->17       15->18       16->19   
class NoNeedToCatchRuntimeException {
  private final int i;
  
  /**
   * This method throws 2 runtime exceptions, so it should be okay.
   */
  public int myMethod() {
    if (i<5) {
      throw new RuntimeException();
    }
    else {
      throw new NullPointerException();
    }
  }
  

  /** This method is automatically generated by the Language Level Converter. */
  public NoNeedToCatchRuntimeException(int i) {
    super();
    this.i = i;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int i() {
    return i;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        i() + 
        ")";
  }

  /** This method is automatically generated by the Language Level Converter. */
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    else if ((o == null) || (! o.getClass().equals(getClass()))) {
      return false;
    }
    else {
      NoNeedToCatchRuntimeException cast = ((NoNeedToCatchRuntimeException) o);
      return (i() == cast.i());
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        i();
  }
}
