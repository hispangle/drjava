// Language Level Converter line number map: dj*->java. Entries: 21
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21       18->22       19->23       20->24       21->25   
class A {
  int afield;
  
  class B {
    int bfield;
  }
  
  class C {
    int cfield;
    
    void method() {
      class D {
        class E {
          int efield;
        }
      }
//      B b = new B(2);
    }
  }
  
}
