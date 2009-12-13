// Language Level Converter line number map: dj*->java. Entries: 32
//     1->6         2->7         3->8         4->9         5->10        6->11        7->12        8->13   
//     9->14       10->15       11->16       12->17       13->18       14->19       15->20       16->21   
//    17->22       18->23       19->24       20->25       21->26       22->27       23->28       24->29   
//    25->30       26->31       27->32       28->33       29->34       30->35       31->36       32->37   
//Instantiating a ComplexAnonymousInnerClass that extends an Interface should not give an error
//This one is extra crazy just for grins.



interface MyMainInterface {
  interface MyInnerInterface {
    int myMethod();
  }
}

class MoreCrazyStuff {
  interface AnotherInnerInterface {
    int yourMethod();
  }
}

class MyCrazyTestClassEJS {
  MyMainInterface.MyInnerInterface i = new MyMainInterface.MyInnerInterface() {
    public int myMethod() {
      return 42;
    }
  };
  
  MoreCrazyStuff.AnotherInnerInterface j = new MoreCrazyStuff.AnotherInnerInterface() {
    public int yourMethod() {
      return 42;
    }
  };

} 
  
