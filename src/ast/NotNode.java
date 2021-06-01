package ast;

import lib.FOOLlib;

public class NotNode implements Node {

  private Node val;
  
  public NotNode (Node n) {
   val=n;
  }
  
  public String toPrint(String s) {
	  return s+"Not\n" + val.toPrint(s+"  ");
  }
  
  public Node typeCheck() {
	  if ( !(FOOLlib.isSubtype(val.typeCheck(), new BoolTypeNode())) ) {
		  System.out.println("non boolean condition in not");
	      System.exit(0);		
		}
	  return new BoolTypeNode();
  }
	  
  public String codeGeneration() {
	  String l1= FOOLlib.freshLabel();
	  String l2= FOOLlib.freshLabel();
	  return val.codeGeneration()+
			 "push 1\n"+
			 "beq "+l1+"\n"+
			 "push 1"+
			 "b "+l2+"\n"+
			 l1+": \n"+
			 "push 0"+
			 l2+": \n";
  }
      
}  