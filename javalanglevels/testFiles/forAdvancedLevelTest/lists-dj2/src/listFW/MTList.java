// Language Level Converter line number map: dj*->java. Entries: 12
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14       12->15   
package listFW;

public class MTList implements IList {
  static MTList Singleton = new MTList();
  private MTList() {
  }

  public int getLength() {
    return 0;
  }
  
}
