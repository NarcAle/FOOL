package ast;

import lib.FOOLlib;

public class OrNode implements Node {

	  private Node left;
	  private Node right;
	  
	  public OrNode (Node l, Node r) {
	   left=l;
	   right=r;
	  }
	  
	  public String toPrint(String s) {
	   return s+"Or\n" + left.toPrint(s+"  ")  
	                     + right.toPrint(s+"  ") ; 
	  }

	  public Node typeCheck() {
	   if ( ! ( FOOLlib.isSubtype(left.typeCheck(), new BoolTypeNode()) &&
			    FOOLlib.isSubtype(right.typeCheck(), new BoolTypeNode()) ) ) {
				  System.out.println("Non booleans in and");
				  System.exit(0);	
	   }
	   return new BoolTypeNode();
	  }
	  
	  public String codeGeneration() {
		  String l1= FOOLlib.freshLabel();
		  String l2= FOOLlib.freshLabel();
		  
		  //Esegue prima left e se necessario anche right
		  return left.codeGeneration()+
				 "push 1\n"+
				 "beq " + l1 + "\n"+ 
				 right.codeGeneration()+
				 "push 1\n"+
				 "beq " + l1 + "\n"+ 
				 "push 0\n"+
				 "b "+ l2 + "\n"+
				 l1 + ": \n"+
				 "push 1\n"+
				 l2 + ": \n"
				 ;
	  }

	}  
