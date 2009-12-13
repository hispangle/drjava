// Language Level Converter line number map: dj*->java. Entries: 21
//     1->5         2->6         3->7         4->8         5->9         6->10        7->11        8->12   
//     9->13       10->14       11->15       12->16       13->17       14->18       15->19       16->20   
//    17->21       18->22       19->23       20->24       21->25   
package forAdvancedLevelTest;
import forAdvancedLevelTest.importedFiles.ToReference;
import forAdvancedLevelTest.importedFiles.IsItPackageAndImport;

//this tests that if you have specifically imported a file, but you have a file in your package,
//the one in your package is used.
class TestImportStuff {
  ToReference tr;
  IsItPackageAndImport iipai;
  
  
  String printField() {
    System.out.println(iipai.toString());
    return tr.toString();
  }
  
  int callMethod() { 
    return tr.yourMethod();
  }
  
}
