// Language Level Converter line number map: dj*->java. Entries: 14
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14       12->15       13->16       14->17   
/* Test that no error is given with implicit call to super constructor */

class MyParent {
  MyParent() {
  }

}

class ChildWithImplicitConstructorCall extends MyParent {
  ChildWithImplicitConstructorCall() {
    System.out.println("Made my child");
  }
 
}
