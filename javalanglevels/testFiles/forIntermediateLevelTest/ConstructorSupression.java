// Language Level Converter line number map: dj*->java. Entries: 12
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14       12->55   
class ConstructorSupression {
  private final int i;
  private final int j;
  public final static char c = 'e';
  
  public ConstructorSupression(final int mi, final int mj) {
    i=mi;
    j=mj;
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
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        i() + ", " + 
        j() + 
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
      ConstructorSupression cast = ((ConstructorSupression) o);
      return (i() == cast.i()) && 
          (j() == cast.j());
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        i() ^ 
        j();
  }
}
  
