// Language Level Converter line number map: dj*->java. Entries: 9
//     1->4         2->5         3->6         4->7         5->8         6->9         7->10        8->11   
//     9->12   
/**This file tests that a value can be assigned to an element in an array.*/

class TestArrayAssignment {
  int[] i = new int[5];
  
  void assignValue() {
    i[4]=2+5;
  }
}
