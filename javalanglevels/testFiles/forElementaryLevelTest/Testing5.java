// Language Level Converter line number map: dj*->java. Entries: 35
//     1->7         2->8         3->9         4->10        5->11        6->12        7->13        8->14   
//     9->15       10->16       11->17       12->18       13->19       14->20       15->21       16->22   
//    17->23       18->24       19->25       20->26       21->27       22->28       23->29       24->30   
//    25->31       26->32       27->33       28->34       29->35       30->36       31->37       32->38   
//    33->39       34->123      35->124  
class Testing5 extends Object{
  private final boolean b;
  private final char c, d;
  private final int i, 
    j;
  private final double dd;
  
  //System.out.println("kadjfk");
  
  public boolean myMethod() {
    return false;
  }
  
  public boolean c(final char 
              toSetTo)  {
              b(1+1, 34, 'a', true);
              return 
    c 
    != 
    toSetTo;
  }
  
  public boolean b(final int wuz,
            
            final double d,            
           
            final char up,
            
            final boolean doh) {
    return wuz==up;
  }
  

  /** This method is automatically generated by the Language Level Converter. */
  public Testing5(boolean b, char c, char d, int i, int j, double dd) {
    super();
    this.b = b;
    this.c = c;
    this.d = d;
    this.i = i;
    this.j = j;
    this.dd = dd;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public boolean b() {
    return b;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public char c() {
    return c;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public char d() {
    return d;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int i() {
    return i;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int j() {
    return j;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public double dd() {
    return dd;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        b() + ", " + 
        c() + ", " + 
        d() + ", " + 
        i() + ", " + 
        j() + ", " + 
        dd() + 
        ")";
  }

  /** This method is automatically generated by the Language Level Converter. */
  public boolean equals(java.lang.Object o) {
    if (this == o) {
      return true;
    }
    else if ((o == null) || (! o.getClass().equals(getClass()))) {
      return false;
    }
    else {
      Testing5 cast = ((Testing5) o);
      return (b() == cast.b()) && 
          (c() == cast.c()) && 
          (d() == cast.d()) && 
          (i() == cast.i()) && 
          (j() == cast.j()) && 
          (dd() == cast.dd());
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        (b() ? 1 : 0) ^ 
        c() ^ 
        d() ^ 
        i() ^ 
        j() ^ 
        (int) dd();
  }
}
  
  
