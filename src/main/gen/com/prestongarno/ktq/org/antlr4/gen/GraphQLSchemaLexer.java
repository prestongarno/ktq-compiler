// Generated from /home/preston/IdeaProjects/ktq-compiler/src/main/resources/GraphQLSchema.g4 by ANTLR 4.7
package com.prestongarno.ktq.org.antlr4.gen;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphQLSchemaLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		T__9=10, T__10=11, TypeDeclaration=12, TYPE=13, INTERFACE=14, UNION=15, 
		ENUM=16, SCALAR=17, INPUT=18, Name=19, BooleanValue=20, NullValue=21, 
		Null=22, IntValue=23, FloatValue=24, Sign=25, IntegerPart=26, NonZeroDigit=27, 
		ExponentPart=28, Digit=29, StringValue=30, Ignored=31;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "TypeDeclaration", "TYPE", "INTERFACE", "UNION", "ENUM", 
		"SCALAR", "INPUT", "Name", "BooleanValue", "NullValue", "Null", "IntValue", 
		"FloatValue", "Sign", "IntegerPart", "NonZeroDigit", "ExponentPart", "Digit", 
		"StringValue", "EscapedChar", "Unicode", "DoubleQuote", "Hex", "Ignored", 
		"Comment", "LineTerminator", "Whitespace", "Comma"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'{'", "'}'", "'implements'", "'='", "'|'", "':'", "'('", "')'", 
		"'['", "']'", "'!'", null, null, null, null, null, null, null, null, null, 
		null, "'null'", null, null, "'-'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"TypeDeclaration", "TYPE", "INTERFACE", "UNION", "ENUM", "SCALAR", "INPUT", 
		"Name", "BooleanValue", "NullValue", "Null", "IntValue", "FloatValue", 
		"Sign", "IntegerPart", "NonZeroDigit", "ExponentPart", "Digit", "StringValue", 
		"Ignored"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public GraphQLSchemaLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GraphQLSchema.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2!\u0138\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\3\2\3\2\3\3\3\3\3\4"+
		"\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\r\3\r\3\r\5\rw\n\r"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u0080\n\16\f\16\16\16\u0083\13"+
		"\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u0090"+
		"\n\17\f\17\16\17\u0093\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u009c"+
		"\n\20\f\20\16\20\u009f\13\20\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00a7"+
		"\n\21\f\21\16\21\u00aa\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7"+
		"\22\u00b4\n\22\f\22\16\22\u00b7\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\7\23\u00c0\n\23\f\23\16\23\u00c3\13\23\3\24\3\24\7\24\u00c7\n\24\f"+
		"\24\16\24\u00ca\13\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\5\25"+
		"\u00d5\n\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\5\30\u00df\n\30\3"+
		"\30\3\30\3\31\5\31\u00e4\n\31\3\31\3\31\3\31\6\31\u00e9\n\31\r\31\16\31"+
		"\u00ea\5\31\u00ed\n\31\3\31\5\31\u00f0\n\31\3\32\3\32\3\33\3\33\3\33\3"+
		"\33\6\33\u00f8\n\33\r\33\16\33\u00f9\5\33\u00fc\n\33\3\34\3\34\3\35\3"+
		"\35\5\35\u0102\n\35\3\35\6\35\u0105\n\35\r\35\16\35\u0106\3\36\3\36\3"+
		"\37\3\37\3\37\7\37\u010e\n\37\f\37\16\37\u0111\13\37\3\37\3\37\3 \3 \3"+
		" \5 \u0118\n \3!\3!\3!\3!\3!\3!\3\"\3\"\3#\3#\3$\3$\3$\3$\5$\u0128\n$"+
		"\3$\3$\3%\3%\7%\u012e\n%\f%\16%\u0131\13%\3&\3&\3\'\3\'\3(\3(\2\2)\3\3"+
		"\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?\2"+
		"A\2C\2E\2G!I\2K\2M\2O\2\3\2\n\4\2C\\c|\6\2\62;C\\aac|\4\2GGgg\7\2\f\f"+
		"\17\17$$^^\u202a\u202b\n\2$$\61\61^^ddhhppttvv\5\2\62;CHch\5\2\f\f\17"+
		"\17\u202a\u202b\6\2\13\13\r\16\"\"\u00a2\u00a2\2\u014d\2\3\3\2\2\2\2\5"+
		"\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2"+
		"\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33"+
		"\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2"+
		"\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2"+
		"\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2"+
		"\2G\3\2\2\2\3Q\3\2\2\2\5S\3\2\2\2\7U\3\2\2\2\t`\3\2\2\2\13b\3\2\2\2\r"+
		"d\3\2\2\2\17f\3\2\2\2\21h\3\2\2\2\23j\3\2\2\2\25l\3\2\2\2\27n\3\2\2\2"+
		"\31v\3\2\2\2\33x\3\2\2\2\35\u0084\3\2\2\2\37\u0094\3\2\2\2!\u00a0\3\2"+
		"\2\2#\u00ab\3\2\2\2%\u00b8\3\2\2\2\'\u00c4\3\2\2\2)\u00d4\3\2\2\2+\u00d6"+
		"\3\2\2\2-\u00d8\3\2\2\2/\u00de\3\2\2\2\61\u00e3\3\2\2\2\63\u00f1\3\2\2"+
		"\2\65\u00fb\3\2\2\2\67\u00fd\3\2\2\29\u00ff\3\2\2\2;\u0108\3\2\2\2=\u010a"+
		"\3\2\2\2?\u0114\3\2\2\2A\u0119\3\2\2\2C\u011f\3\2\2\2E\u0121\3\2\2\2G"+
		"\u0127\3\2\2\2I\u012b\3\2\2\2K\u0132\3\2\2\2M\u0134\3\2\2\2O\u0136\3\2"+
		"\2\2QR\7}\2\2R\4\3\2\2\2ST\7\177\2\2T\6\3\2\2\2UV\7k\2\2VW\7o\2\2WX\7"+
		"r\2\2XY\7n\2\2YZ\7g\2\2Z[\7o\2\2[\\\7g\2\2\\]\7p\2\2]^\7v\2\2^_\7u\2\2"+
		"_\b\3\2\2\2`a\7?\2\2a\n\3\2\2\2bc\7~\2\2c\f\3\2\2\2de\7<\2\2e\16\3\2\2"+
		"\2fg\7*\2\2g\20\3\2\2\2hi\7+\2\2i\22\3\2\2\2jk\7]\2\2k\24\3\2\2\2lm\7"+
		"_\2\2m\26\3\2\2\2no\7#\2\2o\30\3\2\2\2pw\5\33\16\2qw\5\35\17\2rw\5\37"+
		"\20\2sw\5!\21\2tw\5#\22\2uw\5%\23\2vp\3\2\2\2vq\3\2\2\2vr\3\2\2\2vs\3"+
		"\2\2\2vt\3\2\2\2vu\3\2\2\2w\32\3\2\2\2xy\7k\2\2yz\7p\2\2z{\7r\2\2{|\7"+
		"w\2\2|}\7v\2\2}\u0081\3\2\2\2~\u0080\5M\'\2\177~\3\2\2\2\u0080\u0083\3"+
		"\2\2\2\u0081\177\3\2\2\2\u0081\u0082\3\2\2\2\u0082\34\3\2\2\2\u0083\u0081"+
		"\3\2\2\2\u0084\u0085\7k\2\2\u0085\u0086\7p\2\2\u0086\u0087\7v\2\2\u0087"+
		"\u0088\7g\2\2\u0088\u0089\7t\2\2\u0089\u008a\7h\2\2\u008a\u008b\7c\2\2"+
		"\u008b\u008c\7e\2\2\u008c\u008d\7g\2\2\u008d\u0091\3\2\2\2\u008e\u0090"+
		"\5M\'\2\u008f\u008e\3\2\2\2\u0090\u0093\3\2\2\2\u0091\u008f\3\2\2\2\u0091"+
		"\u0092\3\2\2\2\u0092\36\3\2\2\2\u0093\u0091\3\2\2\2\u0094\u0095\7w\2\2"+
		"\u0095\u0096\7p\2\2\u0096\u0097\7k\2\2\u0097\u0098\7q\2\2\u0098\u0099"+
		"\7p\2\2\u0099\u009d\3\2\2\2\u009a\u009c\5M\'\2\u009b\u009a\3\2\2\2\u009c"+
		"\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d\u009e\3\2\2\2\u009e \3\2\2\2"+
		"\u009f\u009d\3\2\2\2\u00a0\u00a1\7g\2\2\u00a1\u00a2\7p\2\2\u00a2\u00a3"+
		"\7w\2\2\u00a3\u00a4\7o\2\2\u00a4\u00a8\3\2\2\2\u00a5\u00a7\5M\'\2\u00a6"+
		"\u00a5\3\2\2\2\u00a7\u00aa\3\2\2\2\u00a8\u00a6\3\2\2\2\u00a8\u00a9\3\2"+
		"\2\2\u00a9\"\3\2\2\2\u00aa\u00a8\3\2\2\2\u00ab\u00ac\7u\2\2\u00ac\u00ad"+
		"\7e\2\2\u00ad\u00ae\7c\2\2\u00ae\u00af\7n\2\2\u00af\u00b0\7c\2\2\u00b0"+
		"\u00b1\7t\2\2\u00b1\u00b5\3\2\2\2\u00b2\u00b4\5M\'\2\u00b3\u00b2\3\2\2"+
		"\2\u00b4\u00b7\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6$"+
		"\3\2\2\2\u00b7\u00b5\3\2\2\2\u00b8\u00b9\7k\2\2\u00b9\u00ba\7p\2\2\u00ba"+
		"\u00bb\7r\2\2\u00bb\u00bc\7w\2\2\u00bc\u00bd\7v\2\2\u00bd\u00c1\3\2\2"+
		"\2\u00be\u00c0\5M\'\2\u00bf\u00be\3\2\2\2\u00c0\u00c3\3\2\2\2\u00c1\u00bf"+
		"\3\2\2\2\u00c1\u00c2\3\2\2\2\u00c2&\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c4"+
		"\u00c8\t\2\2\2\u00c5\u00c7\t\3\2\2\u00c6\u00c5\3\2\2\2\u00c7\u00ca\3\2"+
		"\2\2\u00c8\u00c6\3\2\2\2\u00c8\u00c9\3\2\2\2\u00c9(\3\2\2\2\u00ca\u00c8"+
		"\3\2\2\2\u00cb\u00cc\7v\2\2\u00cc\u00cd\7t\2\2\u00cd\u00ce\7w\2\2\u00ce"+
		"\u00d5\7g\2\2\u00cf\u00d0\7h\2\2\u00d0\u00d1\7c\2\2\u00d1\u00d2\7n\2\2"+
		"\u00d2\u00d3\7u\2\2\u00d3\u00d5\7g\2\2\u00d4\u00cb\3\2\2\2\u00d4\u00cf"+
		"\3\2\2\2\u00d5*\3\2\2\2\u00d6\u00d7\5-\27\2\u00d7,\3\2\2\2\u00d8\u00d9"+
		"\7p\2\2\u00d9\u00da\7w\2\2\u00da\u00db\7n\2\2\u00db\u00dc\7n\2\2\u00dc"+
		".\3\2\2\2\u00dd\u00df\5\63\32\2\u00de\u00dd\3\2\2\2\u00de\u00df\3\2\2"+
		"\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\5\65\33\2\u00e1\60\3\2\2\2\u00e2\u00e4"+
		"\5\63\32\2\u00e3\u00e2\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4\u00e5\3\2\2\2"+
		"\u00e5\u00ec\5\65\33\2\u00e6\u00e8\7\60\2\2\u00e7\u00e9\5;\36\2\u00e8"+
		"\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00eb\3\2"+
		"\2\2\u00eb\u00ed\3\2\2\2\u00ec\u00e6\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed"+
		"\u00ef\3\2\2\2\u00ee\u00f0\59\35\2\u00ef\u00ee\3\2\2\2\u00ef\u00f0\3\2"+
		"\2\2\u00f0\62\3\2\2\2\u00f1\u00f2\7/\2\2\u00f2\64\3\2\2\2\u00f3\u00fc"+
		"\7\62\2\2\u00f4\u00fc\5\67\34\2\u00f5\u00f7\5\67\34\2\u00f6\u00f8\5;\36"+
		"\2\u00f7\u00f6\3\2\2\2\u00f8\u00f9\3\2\2\2\u00f9\u00f7\3\2\2\2\u00f9\u00fa"+
		"\3\2\2\2\u00fa\u00fc\3\2\2\2\u00fb\u00f3\3\2\2\2\u00fb\u00f4\3\2\2\2\u00fb"+
		"\u00f5\3\2\2\2\u00fc\66\3\2\2\2\u00fd\u00fe\4\63;\2\u00fe8\3\2\2\2\u00ff"+
		"\u0101\t\4\2\2\u0100\u0102\5\63\32\2\u0101\u0100\3\2\2\2\u0101\u0102\3"+
		"\2\2\2\u0102\u0104\3\2\2\2\u0103\u0105\5;\36\2\u0104\u0103\3\2\2\2\u0105"+
		"\u0106\3\2\2\2\u0106\u0104\3\2\2\2\u0106\u0107\3\2\2\2\u0107:\3\2\2\2"+
		"\u0108\u0109\4\62;\2\u0109<\3\2\2\2\u010a\u010f\5C\"\2\u010b\u010e\n\5"+
		"\2\2\u010c\u010e\5? \2\u010d\u010b\3\2\2\2\u010d\u010c\3\2\2\2\u010e\u0111"+
		"\3\2\2\2\u010f\u010d\3\2\2\2\u010f\u0110\3\2\2\2\u0110\u0112\3\2\2\2\u0111"+
		"\u010f\3\2\2\2\u0112\u0113\5C\"\2\u0113>\3\2\2\2\u0114\u0117\7^\2\2\u0115"+
		"\u0118\t\6\2\2\u0116\u0118\5A!\2\u0117\u0115\3\2\2\2\u0117\u0116\3\2\2"+
		"\2\u0118@\3\2\2\2\u0119\u011a\7w\2\2\u011a\u011b\5E#\2\u011b\u011c\5E"+
		"#\2\u011c\u011d\5E#\2\u011d\u011e\5E#\2\u011eB\3\2\2\2\u011f\u0120\7$"+
		"\2\2\u0120D\3\2\2\2\u0121\u0122\t\7\2\2\u0122F\3\2\2\2\u0123\u0128\5M"+
		"\'\2\u0124\u0128\5O(\2\u0125\u0128\5K&\2\u0126\u0128\5I%\2\u0127\u0123"+
		"\3\2\2\2\u0127\u0124\3\2\2\2\u0127\u0125\3\2\2\2\u0127\u0126\3\2\2\2\u0128"+
		"\u0129\3\2\2\2\u0129\u012a\b$\2\2\u012aH\3\2\2\2\u012b\u012f\7%\2\2\u012c"+
		"\u012e\n\b\2\2\u012d\u012c\3\2\2\2\u012e\u0131\3\2\2\2\u012f\u012d\3\2"+
		"\2\2\u012f\u0130\3\2\2\2\u0130J\3\2\2\2\u0131\u012f\3\2\2\2\u0132\u0133"+
		"\t\b\2\2\u0133L\3\2\2\2\u0134\u0135\t\t\2\2\u0135N\3\2\2\2\u0136\u0137"+
		"\7.\2\2\u0137P\3\2\2\2\32\2v\u0081\u0091\u009d\u00a8\u00b5\u00c1\u00c8"+
		"\u00d4\u00de\u00e3\u00ea\u00ec\u00ef\u00f9\u00fb\u0101\u0106\u010d\u010f"+
		"\u0117\u0127\u012f\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}