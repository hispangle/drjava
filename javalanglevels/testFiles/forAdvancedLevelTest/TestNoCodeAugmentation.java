// Language Level Converter line number map: dj*->java. Entries: 29
//     1->6         2->7         3->8         4->9         5->10        6->11        7->12        8->13   
//     9->14       10->15       11->16       12->17       13->18       14->19       15->20       16->21   
//    17->22       18->23       19->24       20->25       21->26       22->27       23->28       24->29   
//    25->30       26->31       27->32       28->33       29->34   
//This class makes sure that even though there is no code augmentation done at
//the Advanced Level, the default constructor can still be used.
class TestNoCodeAugmentation extends AParentClass {
  int i;
  
  static final CrazyClass c = new CrazyClass();
  
  void myMethod() {
    System.out.println(c.copyOfMe.i);
  }
}

class AParentClass {
  int i;
  int j;
  
  public AParentClass() {
    i = 42;
    j = 128;
  }
  
}

class CrazyClass {
  TestNoCodeAugmentation copyOfMe = new TestNoCodeAugmentation();
}


  
