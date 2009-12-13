// Language Level Converter line number map: dj*->java. Entries: 15
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14       12->15       13->16       14->17       15->18   
//makes sure that if method uses final field before constructor that assigns it a value, no error is given

class TheCoolestClassEver {
  final String sunglasses;
  final int goldChain;
  
  void stare() {
    System.out.println(sunglasses);
  }
  
  public TheCoolestClassEver() {
    sunglasses = "dark shades stare back at you";
    goldChain = 42;
  }
}
