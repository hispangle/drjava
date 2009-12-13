// Language Level Converter line number map: dj*->java. Entries: 44
//     1->8         2->9         3->10        4->11        5->12        6->13        7->14        8->15   
//     9->16       10->17       11->18       12->19       13->20       14->21       15->22       16->23   
//    17->24       18->25       19->26       20->27       21->28       22->29       23->30       24->31   
//    25->32       26->33       27->34       28->35       29->36       30->37       31->38       32->39   
//    33->40       34->41       35->42       36->43       37->44       38->45       39->46       40->47   
//    41->48       42->49       43->50       44->51   
// Test switch statements.  Should compile.

class FunWithSwitches {

  boolean method(int x, char y) {
  
    switch(x) {
      case 0:
        return true;
        
      case 1:
        boolean result = x + y * 3 > 27;
        return result;
        
      case 'q':
        break;
    
      default:
        return false;
        
    }
   
    boolean returnMe;
    
    switch(y) {
      case 0:
        returnMe = true;
        break;
        
      case 26:
      case 'z':
        returnMe = false;
        break;
        
      default:
        returnMe = false;
        return true;
    }
    
    return returnMe;
  
  }

}
