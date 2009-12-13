// Language Level Converter line number map: dj*->java. Entries: 17
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21   
//This test makes sure that ComplexAnonymousInnerClass instantiations are correctly parsed and augmented

class ComplexAnonClassInstantiation {
  int i = new E().new W() {
    public int q = 5;
  }.q;
    
}

class E {
  E() {
  }
  class W {
    W() {
    }
  }
}
