grammar FOOL;

@header{
import java.util.ArrayList;
import java.util.HashMap;
import ast.*;
}

@parser::members{
private int nestingLevel = 0;
private ArrayList<HashMap<String,STentry>> symTable = new ArrayList<HashMap<String,STentry>>();
/*livello ambiente con dichiarazioni piu' esterno � 0 (prima posizione ArrayList) invece che 1 (slides)
il "fronte" della lista di tabelle � symTable.get(nestingLevel)*/
}

@lexer::members {
int lexicalErrors=0;
}
 
/*------------------------------------------------------------------
 * PARSER RULES
 *------------------------------------------------------------------*/

prog returns [Node ast]
	: {HashMap<String,STentry> hm = new HashMap<String,STentry> ();
       symTable.add(hm);}          
	  ( e=exp 
        {$ast = new ProgNode($e.ast);} 
      | LET d=declist IN e=exp 
        {$ast = new ProgLetInNode($d.astlist,$e.ast);}      
	  ) 
	  {symTable.remove(nestingLevel);}
      SEMIC ;

declist	returns [ArrayList<Node> astlist]      
	: {$astlist= new ArrayList<Node>() ;
	   int offset=-2;}    
	  ( (
            VAR i=ID COLON t=hotype ASS e=exp 
            {VarNode v = new VarNode($i.text,$t.ast,$e.ast);  
             $astlist.add(v);
             HashMap<String,STentry> hm = symTable.get(nestingLevel);
             if ( hm.put($i.text,new STentry(nestingLevel,$t.ast,offset--)) != null  )
             {System.out.println("Var id "+$i.text+" at line "+$i.line+" already declared");
              System.exit(0);
              }
              if($t.ast instanceof ArrowTypeNode)
              		offset--; /*Se � variabile funzionale decremento offset ancora di 1*/
            }  
      |  
            FUN i=ID COLON tr=type
              {/*inserimento di ID nella symtable*/
               FunNode f = new FunNode($i.text,$tr.ast);      
               $astlist.add(f);                              
               HashMap<String,STentry> hm = symTable.get(nestingLevel);
               STentry entry=new STentry(nestingLevel, offset--);
               if ( hm.put($i.text,entry) != null  )
               {System.out.println("Fun id "+$i.text+" at line "+$i.line+" already declared");
                System.exit(0);
                }                
                /*creare una nuova hashmap per la symTable*/
                offset--;
                nestingLevel++;
                HashMap<String,STentry> hmn = new HashMap<String,STentry> ();
                symTable.add(hmn);
                }
              LPAR {ArrayList<Node> parTypes = new ArrayList<Node>();
              	    int paroffset=1;
                   }
                (fid=ID COLON fty=hotype
                  { 
                  if($fty.ast instanceof ArrowTypeNode)
	               		paroffset++; /*Se � parametro funzionale incremento offset ancora di 1*/
                  parTypes.add($fty.ast);
                  ParNode fpar = new ParNode($fid.text,$fty.ast); /*creo nodo ParNode*/
                  f.addPar(fpar);                                 /*lo attacco al FunNode con addPar*/
                  if ( hmn.put($fid.text,new STentry(nestingLevel,$fty.ast,paroffset++)) != null  ) /*aggiungo dich a hmn*/
                  {System.out.println("Parameter id "+$fid.text+" at line "+$fid.line+" already declared");
                   System.exit(0);
                   }
                  }
                  (COMMA id=ID COLON ty=hotype
                    {
                    if($ty.ast instanceof ArrowTypeNode)
	              		 paroffset++; /*Se � parametro funzionale incremento offset ancora di 1*/
                    parTypes.add($ty.ast);
                    ParNode par = new ParNode($id.text,$ty.ast);
                    f.addPar(par);
                    if ( hmn.put($id.text,new STentry(nestingLevel,$ty.ast,paroffset++)) != null  )
                    {System.out.println("Parameter id "+$id.text+" at line "+$id.line+" already declared");
                     System.exit(0);
                     } 
                   	 
                    }
                  )*
                )?
              RPAR {
              	Node symType = new ArrowTypeNode(parTypes,$tr.ast);
              	entry.addType(symType);
              	f.addSymType(symType);
              }
              (LET d=declist IN {f.addDec($d.astlist);})? e=exp
              {f.addBody($e.ast);
               /*rimuovere la hashmap corrente poich� esco dallo scope*/        
               symTable.remove(nestingLevel--);    
              }
      ) SEMIC
    )+          
	;
	
hotype returns [Node ast]
	: t=type {$ast=$t.ast;}
    | a=arrow {$ast=$a.ast;}
    ;
      
type returns [Node ast]
  : INT  {$ast=new IntTypeNode();}
  | BOOL {$ast=new BoolTypeNode();} 
	;	
	
arrow returns [Node ast] 
	: {ArrayList<Node> typeList = new ArrayList<Node>();}
	LPAR (h=hotype {typeList.add($h.ast);}
		(COMMA hot=hotype{typeList.add($hot.ast);})*
	)? RPAR ARROW rt=type {$ast=new ArrowTypeNode(typeList,$rt.ast);};  


exp	returns [Node ast]
 	: f=term {$ast= $f.ast;}
 	    ( PLUS l=term
 	     {$ast= new PlusNode ($ast,$l.ast);}
 	    | MINUS l=term
 	     {$ast= new MinusNode ($ast,$l.ast);}
 	    | OR l=term
 	     {$ast= new OrNode ($ast,$l.ast);}
 	    )*
 	;
 	
term	returns [Node ast]
	: f=factor {$ast= $f.ast;}
	    ( TIMES l=factor
	     {$ast= new MultNode ($ast,$l.ast);}
	    | DIV l=factor
	     {$ast= new DivNode ($ast,$l.ast);}
	    | AND l=factor
	     {$ast= new AndNode ($ast,$l.ast);}
	    )*
	;
	
factor	returns [Node ast]
	: f=value {$ast= $f.ast;}
	    ( EQ l=value 
	     {$ast= new EqualNode ($ast,$l.ast);}
	    | LE l=value 
	     {$ast= new LessEqualNode ($ast,$l.ast);}
	    | GE l=value 
	     {$ast= new GreaterEqualNode ($ast,$l.ast);}
	    )*
 	;	 	
 
value	returns [Node ast]
	: n=INTEGER   
	  {$ast= new IntNode(Integer.parseInt($n.text));}  
	| TRUE 
	  {$ast= new BoolNode(true);}  
	| FALSE
	  {$ast= new BoolNode(false);}  
	| LPAR e=exp RPAR
	  {$ast= $e.ast;}  
	| NOT LPAR e=exp RPAR	
	  {$ast = new NotNode($e.ast);}
	| IF x=exp THEN CLPAR y=exp CRPAR 
		   ELSE CLPAR z=exp CRPAR 
	  {$ast= new IfNode($x.ast,$y.ast,$z.ast);}	 
	| PRINT LPAR e=exp RPAR	
	  {$ast= new PrintNode($e.ast);}
	| i=ID 
	  {/*cercare la dichiarazione*/
           int j=nestingLevel;
           STentry entry=null; 
           while (j>=0 && entry==null)
             entry=(symTable.get(j--)).get($i.text);
           if (entry==null)
           {System.out.println("Id "+$i.text+" at line "+$i.line+" not declared");
            System.exit(0);}              
	   $ast= new IdNode($i.text,entry,nestingLevel);} 
	   ( LPAR
	   	 {ArrayList<Node> arglist = new ArrayList<Node>();} 
	   	 ( a=exp {arglist.add($a.ast);} 
	   	 	(COMMA a=exp {arglist.add($a.ast);} )*
	   	 )? 
	   	 RPAR
	   	 {$ast= new CallNode($i.text,entry,arglist,nestingLevel);} 
	   )?
 	; 

  		
/*------------------------------------------------------------------
 * LEXER RULES
 *------------------------------------------------------------------*/

COLON	: ':';
COMMA	: ',';
//
SEMIC : ';';
PLUS	: '+';
MINUS	: '-';
TIMES	: '*';
DIV		: '/';
LE		: '<=';
GE		: '>=';
EQ  : '==';
ASS	: '=';
INTEGER : ('-')?(('1'..'9')('0'..'9')*) | '0';
TRUE	: 'true';
FALSE	: 'false';
LPAR 	: '(';
RPAR	: ')';
CLPAR 	: '{';
CRPAR	: '}';
IF 	: 'if';
THEN 	: 'then';
ELSE 	: 'else';
OR		: '||';
AND		: '&&';
NOT		: '!';
PRINT	: 'print'; 
//
LET	: 'let';
IN	: 'in';
VAR	: 'var';
FUN	: 'fun';
INT	: 'int';
BOOL	: 'bool';
ARROW   : '->' ; 
 
ID 	: ('a'..'z'|'A'..'Z') ('a'..'z'|'A'..'Z'|'0'..'9')*; 
 
WHITESP : (' '|'\t'|'\n'|'\r')+ -> channel(HIDDEN);

COMMENT : '/*' (.)*? '*/' -> channel(HIDDEN);

ERR     : . { System.out.println("Invalid char: "+ getText()); lexicalErrors++; } -> channel(HIDDEN); 
