// Language Level Converter line number map: dj*->java. Entries: 18
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21       18->22   
//Instantiating a ComplexAnonymousInnerClass that extends an Interface should not give an error



interface MyInterface2 {
  interface MyInnerInterface {
    int myMethod();
  }
}

class TestClass2 {
  MyInterface2.MyInnerInterface i = new MyInterface2.MyInnerInterface() {
    public int myMethod() {
      return 42;
    }
  };
} 
  
