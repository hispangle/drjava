// Language Level Converter line number map: dj*->java. Entries: 23
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21       18->22       19->23       20->24       21->25       22->26       23->27   
//This makes sure that you can use an unqualified name to reference a local class of
//a method from within the method, after the local class has been defined.

class RefInnerClassOfMethodWithinMethod {
  
  void myMethod() {
    class MyInnerClass {
    
    }

    MyInnerClass c;
    

  }
    

}

    

  

  
