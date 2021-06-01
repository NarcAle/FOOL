package lib;

import java.util.ArrayList;

import ast.*;

public class FOOLlib {
  public static boolean isSubtype (Node a, Node b) {
	boolean eqClass = a.getClass().equals(b.getClass());
	boolean aArr = a.getClass().equals(ArrowTypeNode.class);
	boolean bArr = b.getClass().equals(ArrowTypeNode.class);
	boolean inst = (a instanceof BoolTypeNode) && (b instanceof IntTypeNode);
	
	//Controllo se entrambi i nodi sono di tipo ArrowTypeNode 
	if(aArr && bArr) {
		ArrowTypeNode tmpA = (ArrowTypeNode)a;
		ArrowTypeNode tmpB = (ArrowTypeNode)b;
		ArrayList<Node> pLa = tmpA.getParList();
		ArrayList<Node> pLb = tmpB.getParList();
		//Se diverso num di parametri non sono sottotipi. Quindi non ritorno
		if(pLa.size()!=pLb.size()) {
			return false;
		}
		//"a" sottotipo di "b" se i parametri di "b" sono sottotipo di quelli di "a"
		//se ce n'è almeno uno che non lo è --> non è sottotipo. Quindi non ritorno
		for(int i = 0;i<pLa.size();i++) {
			if(!isSubtype(pLb.get(i),pLa.get(i))) {
				return false;
			}
		}
		//"a" sottotipo di "b" se tipo di ritorno di "a" è <= del tipo di ritorno di "b"
		return isSubtype(tmpA.getRet(),tmpB.getRet());
	}
	
	//valuta se il tipo "a" è <= al tipo "b", dove "a" e "b" sono tipi di base: int o bool
	return (eqClass || inst);  
  }
  
  private static int labCount=0; 
  private static int funLabCount=0;
  private static String funCode="" ; 
  
  public static String freshLabel() { 
	return "label"+(labCount++);
  } 
	  
  public static String freshFunLabel() { 
		return "function"+(funLabCount++);
  } 

  public static void putCode(String c) { 
    funCode+="\n"+c; //aggiunge una linea vuota di separazione prima di funzione
  } 
  
  public static String getCode() { 
    return funCode;
  } 
	
}
