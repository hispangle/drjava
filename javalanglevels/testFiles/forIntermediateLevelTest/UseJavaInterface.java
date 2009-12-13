// Language Level Converter line number map: dj*->java. Entries: 11
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12       10->13       11->14   
//This test makes sure that we know that precompiled interfaces have the methods in Object.

import java.security.acl.*;

class UseJavaInterface {
  private final Owner o;
  
  public String myMethod() {
    return o.toString();
  }

  /** This method is automatically generated by the Language Level Converter. */
  public UseJavaInterface(java.security.acl.Owner o) {
    super();
    this.o = o;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.security.acl.Owner o() {
    return o;
  }

  /** This method is automatically generated by the Language Level Converter. */
  public java.lang.String toString() {
    return getClass().getName() + "(" + 
        o() + 
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
      UseJavaInterface cast = ((UseJavaInterface) o);
      return (o() != null && o().equals(cast.o()));
    }
  }

  /** This method is automatically generated by the Language Level Converter. */
  public int hashCode() {
    return getClass().hashCode() ^ 
        (o() == null ? 0 : o().hashCode());
  }
}
