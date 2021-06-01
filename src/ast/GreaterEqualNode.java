package ast;

import lib.FOOLlib;

public class GreaterEqualNode implements Node {

  private Node left;
  private Node right;
  
  public GreaterEqualNode (Node l, Node r) {
   left=l;
   right=r;
  }
  
  public String toPrint(String s) {
   return s+"GreaterEqual\n" + left.toPrint(s+"  ")   
                      + right.toPrint(s+"  ") ; 
  }
    
  public Node typeCheck() {
	Node l= left.typeCheck();  
	Node r= right.typeCheck();  
    if ( !(FOOLlib.isSubtype(l, r) || FOOLlib.isSubtype(r, l)) ) {
      System.out.println("Incompatible types in greaterEqual");
	  System.exit(0);	
    }  
    return new BoolTypeNode();
  }
  
  public String codeGeneration() {
	  String l1= FOOLlib.freshLabel();
	  String l2= FOOLlib.freshLabel();
	  return right.codeGeneration()+
			 left.codeGeneration()+
			 "bleq "+l1+"\n"+
			 "push 0\n"+
			 "b "+l2+"\n"+
			 l1+": \n"+
			 "push 1\n"+
			 l2+": \n"
			 ;
  }
  
}  