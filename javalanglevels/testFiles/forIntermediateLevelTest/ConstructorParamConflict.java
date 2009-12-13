// Language Level Converter line number map: dj*->java. Entries: 15
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->60       11->61       12->62       13->63       14->64       15->65   
/* Test that Child's constructor correctly uses super_x and super_x0 */

class Parent {

  private final int x;
  private final int y;
  


  /** This method is automatically generated by the Language Level Converter. */
  public Parent(int x, int y) {
    super();
    this.x = x;
    this.y = y;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int x() {
    return x;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int y() {
    return y;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        x() + ", " + 
        y() + 
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
      Parent cast = ((Parent) o);
      return (x() == cast.x()) && 
          (y() == cast.y());
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        x() ^ 
        y();
  }
}

class Child extends Parent {
  
  private final int super_x;
 

  /** This method is automatically generated by the Language Level Converter. */
  public Child(int super_x0, int super_y, int super_x) {
    super(super_x0, super_y);
    this.super_x = super_x;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int super_x() {
    return super_x;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        super_x() + ", " + 
        x() + ", " + 
        y() + 
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
      Child cast = ((Child) o);
      return (super_x() == cast.super_x()) && 
          (x() == cast.x()) && 
          (y() == cast.y());
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        super_x() ^ 
        x() ^ 
        y();
  }
}
