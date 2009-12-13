// Language Level Converter line number map: dj*->java. Entries: 19
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21       18->22       19->23   
package forAdvancedLevelTest;
import forAdvancedLevelTest.importedFiles.ToReference;
import forAdvancedLevelTest.importedFiles2.*;

//this tests that if you have specifically imported a file, but you have a file in your package and have generally imported the same class name,
//the specifically imported one is used.
class TestImportStuff2 {
  ToReference tr;
  
  
  String printField() {
    return tr.toString();
  }
  
  int callMethod() { 
    return tr.yourMethod();
  }
  
}
