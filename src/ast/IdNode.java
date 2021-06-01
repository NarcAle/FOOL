package ast;

public class IdNode implements Node {

  private String id;
  private int nestingLevel;
  private STentry entry;
  
  public IdNode (String i, STentry st, int nl) {
   id=i;
   nestingLevel=nl;
   entry=st;
  }
  
  public String toPrint(String s) {
	   return s+"Id:" + id + " at nestinglevel "+ nestingLevel + "\n" + 
              entry.toPrint(s+"  ") ;  
  }

  public Node typeCheck() {
	return entry.getType();
  }
  
  public String codeGeneration() {
      String getAR="";
      for (int i=0; i<nestingLevel-entry.getNestinglevel();i++)
    	  getAR+="lw\n";
      if(entry.getType() instanceof ArrowTypeNode) {
    	  return "push "+entry.getOffset()+"\n"+			 
    			 "lfp\n"+getAR+ //risalgo la catena statica per ottenere l'indirizzo dell'AR 
		              			//in cui è dichiarata la variabile			 
    			 "add\n"+
    			 "lw\n"+
    			 "push "+(entry.getOffset()-1)+"\n"+//TODO CHECK forse ci va +1
    			 "lfp\n"+getAR+ //risalgo la catena statica per ottenere l'indirizzo dell'AR 
		              			//in cui è dichiarata la variabile			 
    			 "add\n"+
    			 "lw\n";
      }
	  return "push "+entry.getOffset()+"\n"+			 
			 "lfp\n"+getAR+ //risalgo la catena statica per ottenere l'indirizzo dell'AR 
			                //in cui è dichiarata la variabile			 
			 "add\n"+
			 "lw\n";
  }

}  