// Generated from FOOL.g4 by ANTLR 4.4

import java.util.ArrayList;
import java.util.HashMap;
import ast.*;

import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class FOOLLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.4", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		COLON=1, COMMA=2, SEMIC=3, PLUS=4, MINUS=5, TIMES=6, DIV=7, LE=8, GE=9, 
		EQ=10, ASS=11, INTEGER=12, TRUE=13, FALSE=14, LPAR=15, RPAR=16, CLPAR=17, 
		CRPAR=18, IF=19, THEN=20, ELSE=21, OR=22, AND=23, NOT=24, PRINT=25, LET=26, 
		IN=27, VAR=28, FUN=29, INT=30, BOOL=31, ARROW=32, ID=33, WHITESP=34, COMMENT=35, 
		ERR=36;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] tokenNames = {
		"'\\u0000'", "'\\u0001'", "'\\u0002'", "'\\u0003'", "'\\u0004'", "'\\u0005'", 
		"'\\u0006'", "'\\u0007'", "'\b'", "'\t'", "'\n'", "'\\u000B'", "'\f'", 
		"'\r'", "'\\u000E'", "'\\u000F'", "'\\u0010'", "'\\u0011'", "'\\u0012'", 
		"'\\u0013'", "'\\u0014'", "'\\u0015'", "'\\u0016'", "'\\u0017'", "'\\u0018'", 
		"'\\u0019'", "'\\u001A'", "'\\u001B'", "'\\u001C'", "'\\u001D'", "'\\u001E'", 
		"'\\u001F'", "' '", "'!'", "'\"'", "'#'", "'$'"
	};
	public static final String[] ruleNames = {
		"COLON", "COMMA", "SEMIC", "PLUS", "MINUS", "TIMES", "DIV", "LE", "GE", 
		"EQ", "ASS", "INTEGER", "TRUE", "FALSE", "LPAR", "RPAR", "CLPAR", "CRPAR", 
		"IF", "THEN", "ELSE", "OR", "AND", "NOT", "PRINT", "LET", "IN", "VAR", 
		"FUN", "INT", "BOOL", "ARROW", "ID", "WHITESP", "COMMENT", "ERR"
	};


	int lexicalErrors=0;


	public FOOLLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "FOOL.g4"; }

	@Override
	public String[] getTokenNames() { return tokenNames; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	@Override
	public void action(RuleContext _localctx, int ruleIndex, int actionIndex) {
		switch (ruleIndex) {
		case 35: ERR_action((RuleContext)_localctx, actionIndex); break;
		}
	}
	private void ERR_action(RuleContext _localctx, int actionIndex) {
		switch (actionIndex) {
		case 0:  System.out.println("Invalid char: "+ getText()); lexicalErrors++;  break;
		}
	}

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2&\u00db\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6"+
		"\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\5"+
		"\rf\n\r\3\r\3\r\7\rj\n\r\f\r\16\rm\13\r\3\r\5\rp\n\r\3\16\3\16\3\16\3"+
		"\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3"+
		"\26\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\32\3\32\3\32\3"+
		"\32\3\33\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35\3\35\3\35\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3!\3!\3!\3\"\3\"\7\"\u00bd"+
		"\n\"\f\"\16\"\u00c0\13\"\3#\6#\u00c3\n#\r#\16#\u00c4\3#\3#\3$\3$\3$\3"+
		"$\7$\u00cd\n$\f$\16$\u00d0\13$\3$\3$\3$\3$\3$\3%\3%\3%\3%\3%\3\u00ce\2"+
		"&\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20"+
		"\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37"+
		"= ?!A\"C#E$G%I&\3\2\5\4\2C\\c|\5\2\62;C\\c|\5\2\13\f\17\17\"\"\u00e0\2"+
		"\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2"+
		"\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2"+
		"\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2"+
		"\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2"+
		"\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2"+
		"\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2"+
		"\2I\3\2\2\2\3K\3\2\2\2\5M\3\2\2\2\7O\3\2\2\2\tQ\3\2\2\2\13S\3\2\2\2\r"+
		"U\3\2\2\2\17W\3\2\2\2\21Y\3\2\2\2\23\\\3\2\2\2\25_\3\2\2\2\27b\3\2\2\2"+
		"\31o\3\2\2\2\33q\3\2\2\2\35v\3\2\2\2\37|\3\2\2\2!~\3\2\2\2#\u0080\3\2"+
		"\2\2%\u0082\3\2\2\2\'\u0084\3\2\2\2)\u0087\3\2\2\2+\u008c\3\2\2\2-\u0091"+
		"\3\2\2\2/\u0094\3\2\2\2\61\u0097\3\2\2\2\63\u0099\3\2\2\2\65\u009f\3\2"+
		"\2\2\67\u00a3\3\2\2\29\u00a6\3\2\2\2;\u00aa\3\2\2\2=\u00ae\3\2\2\2?\u00b2"+
		"\3\2\2\2A\u00b7\3\2\2\2C\u00ba\3\2\2\2E\u00c2\3\2\2\2G\u00c8\3\2\2\2I"+
		"\u00d6\3\2\2\2KL\7<\2\2L\4\3\2\2\2MN\7.\2\2N\6\3\2\2\2OP\7=\2\2P\b\3\2"+
		"\2\2QR\7-\2\2R\n\3\2\2\2ST\7/\2\2T\f\3\2\2\2UV\7,\2\2V\16\3\2\2\2WX\7"+
		"\61\2\2X\20\3\2\2\2YZ\7>\2\2Z[\7?\2\2[\22\3\2\2\2\\]\7@\2\2]^\7?\2\2^"+
		"\24\3\2\2\2_`\7?\2\2`a\7?\2\2a\26\3\2\2\2bc\7?\2\2c\30\3\2\2\2df\7/\2"+
		"\2ed\3\2\2\2ef\3\2\2\2fg\3\2\2\2gk\4\63;\2hj\4\62;\2ih\3\2\2\2jm\3\2\2"+
		"\2ki\3\2\2\2kl\3\2\2\2lp\3\2\2\2mk\3\2\2\2np\7\62\2\2oe\3\2\2\2on\3\2"+
		"\2\2p\32\3\2\2\2qr\7v\2\2rs\7t\2\2st\7w\2\2tu\7g\2\2u\34\3\2\2\2vw\7h"+
		"\2\2wx\7c\2\2xy\7n\2\2yz\7u\2\2z{\7g\2\2{\36\3\2\2\2|}\7*\2\2} \3\2\2"+
		"\2~\177\7+\2\2\177\"\3\2\2\2\u0080\u0081\7}\2\2\u0081$\3\2\2\2\u0082\u0083"+
		"\7\177\2\2\u0083&\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7h\2\2\u0086"+
		"(\3\2\2\2\u0087\u0088\7v\2\2\u0088\u0089\7j\2\2\u0089\u008a\7g\2\2\u008a"+
		"\u008b\7p\2\2\u008b*\3\2\2\2\u008c\u008d\7g\2\2\u008d\u008e\7n\2\2\u008e"+
		"\u008f\7u\2\2\u008f\u0090\7g\2\2\u0090,\3\2\2\2\u0091\u0092\7~\2\2\u0092"+
		"\u0093\7~\2\2\u0093.\3\2\2\2\u0094\u0095\7(\2\2\u0095\u0096\7(\2\2\u0096"+
		"\60\3\2\2\2\u0097\u0098\7#\2\2\u0098\62\3\2\2\2\u0099\u009a\7r\2\2\u009a"+
		"\u009b\7t\2\2\u009b\u009c\7k\2\2\u009c\u009d\7p\2\2\u009d\u009e\7v\2\2"+
		"\u009e\64\3\2\2\2\u009f\u00a0\7n\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7"+
		"v\2\2\u00a2\66\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7p\2\2\u00a58\3"+
		"\2\2\2\u00a6\u00a7\7x\2\2\u00a7\u00a8\7c\2\2\u00a8\u00a9\7t\2\2\u00a9"+
		":\3\2\2\2\u00aa\u00ab\7h\2\2\u00ab\u00ac\7w\2\2\u00ac\u00ad\7p\2\2\u00ad"+
		"<\3\2\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7p\2\2\u00b0\u00b1\7v\2\2\u00b1"+
		">\3\2\2\2\u00b2\u00b3\7d\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7q\2\2\u00b5"+
		"\u00b6\7n\2\2\u00b6@\3\2\2\2\u00b7\u00b8\7/\2\2\u00b8\u00b9\7@\2\2\u00b9"+
		"B\3\2\2\2\u00ba\u00be\t\2\2\2\u00bb\u00bd\t\3\2\2\u00bc\u00bb\3\2\2\2"+
		"\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bfD\3"+
		"\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c3\t\4\2\2\u00c2\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4\u00c5\3\2\2\2\u00c5\u00c6\3\2"+
		"\2\2\u00c6\u00c7\b#\2\2\u00c7F\3\2\2\2\u00c8\u00c9\7\61\2\2\u00c9\u00ca"+
		"\7,\2\2\u00ca\u00ce\3\2\2\2\u00cb\u00cd\13\2\2\2\u00cc\u00cb\3\2\2\2\u00cd"+
		"\u00d0\3\2\2\2\u00ce\u00cf\3\2\2\2\u00ce\u00cc\3\2\2\2\u00cf\u00d1\3\2"+
		"\2\2\u00d0\u00ce\3\2\2\2\u00d1\u00d2\7,\2\2\u00d2\u00d3\7\61\2\2\u00d3"+
		"\u00d4\3\2\2\2\u00d4\u00d5\b$\2\2\u00d5H\3\2\2\2\u00d6\u00d7\13\2\2\2"+
		"\u00d7\u00d8\b%\3\2\u00d8\u00d9\3\2\2\2\u00d9\u00da\b%\2\2\u00daJ\3\2"+
		"\2\2\t\2eko\u00be\u00c4\u00ce\4\2\3\2\3%\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}