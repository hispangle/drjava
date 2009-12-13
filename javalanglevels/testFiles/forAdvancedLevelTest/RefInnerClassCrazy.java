// Language Level Converter line number map: dj*->java. Entries: 26
//     1->6         2->7         3->8         4->9         5->10        6->11        7->12        8->13   
//     9->14       10->15       11->16       12->17       13->18       14->19       15->20       16->21   
//    17->22       18->23       19->24       20->25       21->26       22->27       23->28       24->29   
//    25->30       26->31   
//This makes sure that you can use an unqualified name to reference an inner  class, 
//before the local class has been defined.

class RefInnerClassCrazy {
  
  class MyInnerClass {
    
  }
  
  void myMethod() {
    class YourClass {
      void myMethod2() {
        class AnotherClass {
          MyInnerClass c;
        }
      }
    }
  }

}

    

  

  
