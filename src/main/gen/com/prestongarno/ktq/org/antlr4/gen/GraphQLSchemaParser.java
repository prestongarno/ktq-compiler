// Generated from /home/preston/IdeaProjects/ktq-compiler/src/main/resources/GraphQLSchema.g4 by ANTLR 4.7
package com.prestongarno.ktq.org.antlr4.gen;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GraphQLSchemaParser extends Parser {
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
	public static final int
		RULE_graphqlSchema = 0, RULE_definition = 1, RULE_typeDef = 2, RULE_implementationDefs = 3, 
		RULE_inputTypeDef = 4, RULE_interfaceDef = 5, RULE_scalarDef = 6, RULE_unionDef = 7, 
		RULE_unionTypes = 8, RULE_enumDef = 9, RULE_scalarName = 10, RULE_fieldDef = 11, 
		RULE_fieldArgs = 12, RULE_fieldName = 13, RULE_argument = 14, RULE_typeSpec = 15, 
		RULE_listType = 16, RULE_nullable = 17, RULE_typeName = 18, RULE_defaultValue = 19, 
		RULE_value = 20, RULE_enumValue = 21, RULE_arrayValue = 22, RULE_objectValue = 23, 
		RULE_objectField = 24;
	public static final String[] ruleNames = {
		"graphqlSchema", "definition", "typeDef", "implementationDefs", "inputTypeDef", 
		"interfaceDef", "scalarDef", "unionDef", "unionTypes", "enumDef", "scalarName", 
		"fieldDef", "fieldArgs", "fieldName", "argument", "typeSpec", "listType", 
		"nullable", "typeName", "defaultValue", "value", "enumValue", "arrayValue", 
		"objectValue", "objectField"
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

	@Override
	public String getGrammarFileName() { return "GraphQLSchema.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GraphQLSchemaParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}
	public static class GraphqlSchemaContext extends ParserRuleContext {
		public List<TerminalNode> TypeDeclaration() { return getTokens(GraphQLSchemaParser.TypeDeclaration); }
		public TerminalNode TypeDeclaration(int i) {
			return getToken(GraphQLSchemaParser.TypeDeclaration, i);
		}
		public List<DefinitionContext> definition() {
			return getRuleContexts(DefinitionContext.class);
		}
		public DefinitionContext definition(int i) {
			return getRuleContext(DefinitionContext.class,i);
		}
		public GraphqlSchemaContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_graphqlSchema; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterGraphqlSchema(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitGraphqlSchema(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitGraphqlSchema(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GraphqlSchemaContext graphqlSchema() throws RecognitionException {
		GraphqlSchemaContext _localctx = new GraphqlSchemaContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_graphqlSchema);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==TypeDeclaration) {
				{
				{
				setState(50);
				match(TypeDeclaration);
				setState(51);
				definition();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefinitionContext extends ParserRuleContext {
		public TypeDefContext typeDef() {
			return getRuleContext(TypeDefContext.class,0);
		}
		public InputTypeDefContext inputTypeDef() {
			return getRuleContext(InputTypeDefContext.class,0);
		}
		public UnionDefContext unionDef() {
			return getRuleContext(UnionDefContext.class,0);
		}
		public EnumDefContext enumDef() {
			return getRuleContext(EnumDefContext.class,0);
		}
		public InterfaceDefContext interfaceDef() {
			return getRuleContext(InterfaceDefContext.class,0);
		}
		public ScalarDefContext scalarDef() {
			return getRuleContext(ScalarDefContext.class,0);
		}
		public DefinitionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_definition; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterDefinition(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitDefinition(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitDefinition(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefinitionContext definition() throws RecognitionException {
		DefinitionContext _localctx = new DefinitionContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_definition);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(63);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				{
				setState(57);
				typeDef();
				}
				break;
			case 2:
				{
				setState(58);
				inputTypeDef();
				}
				break;
			case 3:
				{
				setState(59);
				unionDef();
				}
				break;
			case 4:
				{
				setState(60);
				enumDef();
				}
				break;
			case 5:
				{
				setState(61);
				interfaceDef();
				}
				break;
			case 6:
				{
				setState(62);
				scalarDef();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ImplementationDefsContext implementationDefs() {
			return getRuleContext(ImplementationDefsContext.class,0);
		}
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public TypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterTypeDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitTypeDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitTypeDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeDefContext typeDef() throws RecognitionException {
		TypeDefContext _localctx = new TypeDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_typeDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(65);
			typeName();
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__2) {
				{
				setState(66);
				implementationDefs();
				}
			}

			setState(69);
			match(T__0);
			setState(71); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(70);
				fieldDef();
				}
				}
				setState(73); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			setState(75);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ImplementationDefsContext extends ParserRuleContext {
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public ImplementationDefsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_implementationDefs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterImplementationDefs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitImplementationDefs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitImplementationDefs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ImplementationDefsContext implementationDefs() throws RecognitionException {
		ImplementationDefsContext _localctx = new ImplementationDefsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_implementationDefs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(77);
			match(T__2);
			setState(79); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(78);
				typeName();
				}
				}
				setState(81); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InputTypeDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public InputTypeDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inputTypeDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterInputTypeDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitInputTypeDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitInputTypeDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InputTypeDefContext inputTypeDef() throws RecognitionException {
		InputTypeDefContext _localctx = new InputTypeDefContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_inputTypeDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			typeName();
			setState(84);
			match(T__0);
			setState(86); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(85);
				fieldDef();
				}
				}
				setState(88); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			setState(90);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InterfaceDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<FieldDefContext> fieldDef() {
			return getRuleContexts(FieldDefContext.class);
		}
		public FieldDefContext fieldDef(int i) {
			return getRuleContext(FieldDefContext.class,i);
		}
		public InterfaceDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_interfaceDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterInterfaceDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitInterfaceDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitInterfaceDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InterfaceDefContext interfaceDef() throws RecognitionException {
		InterfaceDefContext _localctx = new InterfaceDefContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_interfaceDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(92);
			typeName();
			setState(93);
			match(T__0);
			setState(95); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(94);
				fieldDef();
				}
				}
				setState(97); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			setState(99);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScalarDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ScalarDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterScalarDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitScalarDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitScalarDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarDefContext scalarDef() throws RecognitionException {
		ScalarDefContext _localctx = new ScalarDefContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_scalarDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(101);
			typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public UnionTypesContext unionTypes() {
			return getRuleContext(UnionTypesContext.class,0);
		}
		public UnionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterUnionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitUnionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitUnionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionDefContext unionDef() throws RecognitionException {
		UnionDefContext _localctx = new UnionDefContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_unionDef);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(103);
			typeName();
			setState(104);
			match(T__3);
			setState(105);
			unionTypes();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class UnionTypesContext extends ParserRuleContext {
		public List<TypeNameContext> typeName() {
			return getRuleContexts(TypeNameContext.class);
		}
		public TypeNameContext typeName(int i) {
			return getRuleContext(TypeNameContext.class,i);
		}
		public UnionTypesContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_unionTypes; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterUnionTypes(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitUnionTypes(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitUnionTypes(this);
			else return visitor.visitChildren(this);
		}
	}

	public final UnionTypesContext unionTypes() throws RecognitionException {
		UnionTypesContext _localctx = new UnionTypesContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_unionTypes);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(112);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					{
					{
					setState(107);
					typeName();
					setState(108);
					match(T__4);
					}
					} 
				}
				setState(114);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
			}
			setState(115);
			typeName();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumDefContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public List<ScalarNameContext> scalarName() {
			return getRuleContexts(ScalarNameContext.class);
		}
		public ScalarNameContext scalarName(int i) {
			return getRuleContext(ScalarNameContext.class,i);
		}
		public EnumDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterEnumDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitEnumDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitEnumDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumDefContext enumDef() throws RecognitionException {
		EnumDefContext _localctx = new EnumDefContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_enumDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			typeName();
			setState(118);
			match(T__0);
			setState(120); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(119);
				scalarName();
				}
				}
				setState(122); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			setState(124);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ScalarNameContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public ScalarNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scalarName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterScalarName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitScalarName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitScalarName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScalarNameContext scalarName() throws RecognitionException {
		ScalarNameContext _localctx = new ScalarNameContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_scalarName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(Name);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldDefContext extends ParserRuleContext {
		public FieldNameContext fieldName() {
			return getRuleContext(FieldNameContext.class,0);
		}
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public FieldArgsContext fieldArgs() {
			return getRuleContext(FieldArgsContext.class,0);
		}
		public FieldDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterFieldDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitFieldDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitFieldDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldDefContext fieldDef() throws RecognitionException {
		FieldDefContext _localctx = new FieldDefContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_fieldDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(128);
			fieldName();
			setState(130);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__6) {
				{
				setState(129);
				fieldArgs();
				}
			}

			setState(132);
			match(T__5);
			setState(133);
			typeSpec();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldArgsContext extends ParserRuleContext {
		public List<ArgumentContext> argument() {
			return getRuleContexts(ArgumentContext.class);
		}
		public ArgumentContext argument(int i) {
			return getRuleContext(ArgumentContext.class,i);
		}
		public FieldArgsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldArgs; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterFieldArgs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitFieldArgs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitFieldArgs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldArgsContext fieldArgs() throws RecognitionException {
		FieldArgsContext _localctx = new FieldArgsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_fieldArgs);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(T__6);
			setState(137); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(136);
				argument();
				}
				}
				setState(139); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==Name );
			setState(141);
			match(T__7);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class FieldNameContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public FieldNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_fieldName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterFieldName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitFieldName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitFieldName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FieldNameContext fieldName() throws RecognitionException {
		FieldNameContext _localctx = new FieldNameContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_fieldName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(143);
			match(Name);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArgumentContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public NullableContext nullable() {
			return getRuleContext(NullableContext.class,0);
		}
		public DefaultValueContext defaultValue() {
			return getRuleContext(DefaultValueContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_argument);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(145);
			match(Name);
			setState(146);
			match(T__5);
			setState(147);
			typeSpec();
			setState(149);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__10) {
				{
				setState(148);
				nullable();
				}
			}

			setState(152);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==T__3) {
				{
				setState(151);
				defaultValue();
				}
			}

			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeSpecContext extends ParserRuleContext {
		public TypeNameContext typeName() {
			return getRuleContext(TypeNameContext.class,0);
		}
		public ListTypeContext listType() {
			return getRuleContext(ListTypeContext.class,0);
		}
		public NullableContext nullable() {
			return getRuleContext(NullableContext.class,0);
		}
		public TypeSpecContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeSpec; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterTypeSpec(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitTypeSpec(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitTypeSpec(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeSpecContext typeSpec() throws RecognitionException {
		TypeSpecContext _localctx = new TypeSpecContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_typeSpec);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case Name:
				{
				setState(154);
				typeName();
				}
				break;
			case T__8:
				{
				setState(155);
				listType();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
			setState(159);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
			case 1:
				{
				setState(158);
				nullable();
				}
				break;
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ListTypeContext extends ParserRuleContext {
		public TypeSpecContext typeSpec() {
			return getRuleContext(TypeSpecContext.class,0);
		}
		public ListTypeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_listType; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterListType(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitListType(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitListType(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ListTypeContext listType() throws RecognitionException {
		ListTypeContext _localctx = new ListTypeContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_listType);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(161);
			match(T__8);
			setState(162);
			typeSpec();
			setState(163);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class NullableContext extends ParserRuleContext {
		public NullableContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_nullable; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterNullable(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitNullable(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitNullable(this);
			else return visitor.visitChildren(this);
		}
	}

	public final NullableContext nullable() throws RecognitionException {
		NullableContext _localctx = new NullableContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_nullable);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(165);
			match(T__10);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class TypeNameContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public TypeNameContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_typeName; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterTypeName(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitTypeName(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitTypeName(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TypeNameContext typeName() throws RecognitionException {
		TypeNameContext _localctx = new TypeNameContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_typeName);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			match(Name);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class DefaultValueContext extends ParserRuleContext {
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public DefaultValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_defaultValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterDefaultValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitDefaultValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitDefaultValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final DefaultValueContext defaultValue() throws RecognitionException {
		DefaultValueContext _localctx = new DefaultValueContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_defaultValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			match(T__3);
			setState(170);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ValueContext extends ParserRuleContext {
		public TerminalNode IntValue() { return getToken(GraphQLSchemaParser.IntValue, 0); }
		public TerminalNode FloatValue() { return getToken(GraphQLSchemaParser.FloatValue, 0); }
		public TerminalNode StringValue() { return getToken(GraphQLSchemaParser.StringValue, 0); }
		public TerminalNode BooleanValue() { return getToken(GraphQLSchemaParser.BooleanValue, 0); }
		public TerminalNode NullValue() { return getToken(GraphQLSchemaParser.NullValue, 0); }
		public EnumValueContext enumValue() {
			return getRuleContext(EnumValueContext.class,0);
		}
		public ArrayValueContext arrayValue() {
			return getRuleContext(ArrayValueContext.class,0);
		}
		public ObjectValueContext objectValue() {
			return getRuleContext(ObjectValueContext.class,0);
		}
		public ValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_value; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ValueContext value() throws RecognitionException {
		ValueContext _localctx = new ValueContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_value);
		try {
			setState(180);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case IntValue:
				enterOuterAlt(_localctx, 1);
				{
				setState(172);
				match(IntValue);
				}
				break;
			case FloatValue:
				enterOuterAlt(_localctx, 2);
				{
				setState(173);
				match(FloatValue);
				}
				break;
			case StringValue:
				enterOuterAlt(_localctx, 3);
				{
				setState(174);
				match(StringValue);
				}
				break;
			case BooleanValue:
				enterOuterAlt(_localctx, 4);
				{
				setState(175);
				match(BooleanValue);
				}
				break;
			case NullValue:
				enterOuterAlt(_localctx, 5);
				{
				setState(176);
				match(NullValue);
				}
				break;
			case Name:
				enterOuterAlt(_localctx, 6);
				{
				setState(177);
				enumValue();
				}
				break;
			case T__8:
				enterOuterAlt(_localctx, 7);
				{
				setState(178);
				arrayValue();
				}
				break;
			case T__0:
				enterOuterAlt(_localctx, 8);
				{
				setState(179);
				objectValue();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class EnumValueContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public EnumValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_enumValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterEnumValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitEnumValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitEnumValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EnumValueContext enumValue() throws RecognitionException {
		EnumValueContext _localctx = new EnumValueContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_enumValue);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			match(Name);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ArrayValueContext extends ParserRuleContext {
		public List<ValueContext> value() {
			return getRuleContexts(ValueContext.class);
		}
		public ValueContext value(int i) {
			return getRuleContext(ValueContext.class,i);
		}
		public ArrayValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arrayValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterArrayValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitArrayValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitArrayValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArrayValueContext arrayValue() throws RecognitionException {
		ArrayValueContext _localctx = new ArrayValueContext(_ctx, getState());
		enterRule(_localctx, 44, RULE_arrayValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(184);
			match(T__8);
			setState(188);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__8) | (1L << Name) | (1L << BooleanValue) | (1L << NullValue) | (1L << IntValue) | (1L << FloatValue) | (1L << StringValue))) != 0)) {
				{
				{
				setState(185);
				value();
				}
				}
				setState(190);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(191);
			match(T__9);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectValueContext extends ParserRuleContext {
		public List<ObjectFieldContext> objectField() {
			return getRuleContexts(ObjectFieldContext.class);
		}
		public ObjectFieldContext objectField(int i) {
			return getRuleContext(ObjectFieldContext.class,i);
		}
		public ObjectValueContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectValue; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterObjectValue(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitObjectValue(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitObjectValue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectValueContext objectValue() throws RecognitionException {
		ObjectValueContext _localctx = new ObjectValueContext(_ctx, getState());
		enterRule(_localctx, 46, RULE_objectValue);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			match(T__0);
			setState(197);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Name) {
				{
				{
				setState(194);
				objectField();
				}
				}
				setState(199);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(200);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class ObjectFieldContext extends ParserRuleContext {
		public TerminalNode Name() { return getToken(GraphQLSchemaParser.Name, 0); }
		public ValueContext value() {
			return getRuleContext(ValueContext.class,0);
		}
		public ObjectFieldContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_objectField; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).enterObjectField(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GraphQLSchemaListener ) ((GraphQLSchemaListener)listener).exitObjectField(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GraphQLSchemaVisitor ) return ((GraphQLSchemaVisitor<? extends T>)visitor).visitObjectField(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ObjectFieldContext objectField() throws RecognitionException {
		ObjectFieldContext _localctx = new ObjectFieldContext(_ctx, getState());
		enterRule(_localctx, 48, RULE_objectField);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(202);
			match(Name);
			setState(203);
			match(T__5);
			setState(204);
			value();
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3!\u00d1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\3\2\3\2\7\2\67\n\2\f\2\16\2:\13\2\3\3\3\3\3\3\3\3\3\3\3\3\5"+
		"\3B\n\3\3\4\3\4\5\4F\n\4\3\4\3\4\6\4J\n\4\r\4\16\4K\3\4\3\4\3\5\3\5\6"+
		"\5R\n\5\r\5\16\5S\3\6\3\6\3\6\6\6Y\n\6\r\6\16\6Z\3\6\3\6\3\7\3\7\3\7\6"+
		"\7b\n\7\r\7\16\7c\3\7\3\7\3\b\3\b\3\t\3\t\3\t\3\t\3\n\3\n\3\n\7\nq\n\n"+
		"\f\n\16\nt\13\n\3\n\3\n\3\13\3\13\3\13\6\13{\n\13\r\13\16\13|\3\13\3\13"+
		"\3\f\3\f\3\r\3\r\5\r\u0085\n\r\3\r\3\r\3\r\3\16\3\16\6\16\u008c\n\16\r"+
		"\16\16\16\u008d\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\5\20\u0098\n\20"+
		"\3\20\5\20\u009b\n\20\3\21\3\21\5\21\u009f\n\21\3\21\5\21\u00a2\n\21\3"+
		"\22\3\22\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\26\3"+
		"\26\3\26\3\26\3\26\3\26\5\26\u00b7\n\26\3\27\3\27\3\30\3\30\7\30\u00bd"+
		"\n\30\f\30\16\30\u00c0\13\30\3\30\3\30\3\31\3\31\7\31\u00c6\n\31\f\31"+
		"\16\31\u00c9\13\31\3\31\3\31\3\32\3\32\3\32\3\32\3\32\2\2\33\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\60\62\2\2\2\u00d3\28\3\2\2\2\4"+
		"A\3\2\2\2\6C\3\2\2\2\bO\3\2\2\2\nU\3\2\2\2\f^\3\2\2\2\16g\3\2\2\2\20i"+
		"\3\2\2\2\22r\3\2\2\2\24w\3\2\2\2\26\u0080\3\2\2\2\30\u0082\3\2\2\2\32"+
		"\u0089\3\2\2\2\34\u0091\3\2\2\2\36\u0093\3\2\2\2 \u009e\3\2\2\2\"\u00a3"+
		"\3\2\2\2$\u00a7\3\2\2\2&\u00a9\3\2\2\2(\u00ab\3\2\2\2*\u00b6\3\2\2\2,"+
		"\u00b8\3\2\2\2.\u00ba\3\2\2\2\60\u00c3\3\2\2\2\62\u00cc\3\2\2\2\64\65"+
		"\7\16\2\2\65\67\5\4\3\2\66\64\3\2\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2"+
		"\29\3\3\2\2\2:8\3\2\2\2;B\5\6\4\2<B\5\n\6\2=B\5\20\t\2>B\5\24\13\2?B\5"+
		"\f\7\2@B\5\16\b\2A;\3\2\2\2A<\3\2\2\2A=\3\2\2\2A>\3\2\2\2A?\3\2\2\2A@"+
		"\3\2\2\2B\5\3\2\2\2CE\5&\24\2DF\5\b\5\2ED\3\2\2\2EF\3\2\2\2FG\3\2\2\2"+
		"GI\7\3\2\2HJ\5\30\r\2IH\3\2\2\2JK\3\2\2\2KI\3\2\2\2KL\3\2\2\2LM\3\2\2"+
		"\2MN\7\4\2\2N\7\3\2\2\2OQ\7\5\2\2PR\5&\24\2QP\3\2\2\2RS\3\2\2\2SQ\3\2"+
		"\2\2ST\3\2\2\2T\t\3\2\2\2UV\5&\24\2VX\7\3\2\2WY\5\30\r\2XW\3\2\2\2YZ\3"+
		"\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\\\3\2\2\2\\]\7\4\2\2]\13\3\2\2\2^_\5&\24\2"+
		"_a\7\3\2\2`b\5\30\r\2a`\3\2\2\2bc\3\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2"+
		"\2ef\7\4\2\2f\r\3\2\2\2gh\5&\24\2h\17\3\2\2\2ij\5&\24\2jk\7\6\2\2kl\5"+
		"\22\n\2l\21\3\2\2\2mn\5&\24\2no\7\7\2\2oq\3\2\2\2pm\3\2\2\2qt\3\2\2\2"+
		"rp\3\2\2\2rs\3\2\2\2su\3\2\2\2tr\3\2\2\2uv\5&\24\2v\23\3\2\2\2wx\5&\24"+
		"\2xz\7\3\2\2y{\5\26\f\2zy\3\2\2\2{|\3\2\2\2|z\3\2\2\2|}\3\2\2\2}~\3\2"+
		"\2\2~\177\7\4\2\2\177\25\3\2\2\2\u0080\u0081\7\25\2\2\u0081\27\3\2\2\2"+
		"\u0082\u0084\5\34\17\2\u0083\u0085\5\32\16\2\u0084\u0083\3\2\2\2\u0084"+
		"\u0085\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\7\b\2\2\u0087\u0088\5 "+
		"\21\2\u0088\31\3\2\2\2\u0089\u008b\7\t\2\2\u008a\u008c\5\36\20\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0090\7\n\2\2\u0090\33\3\2\2\2\u0091\u0092"+
		"\7\25\2\2\u0092\35\3\2\2\2\u0093\u0094\7\25\2\2\u0094\u0095\7\b\2\2\u0095"+
		"\u0097\5 \21\2\u0096\u0098\5$\23\2\u0097\u0096\3\2\2\2\u0097\u0098\3\2"+
		"\2\2\u0098\u009a\3\2\2\2\u0099\u009b\5(\25\2\u009a\u0099\3\2\2\2\u009a"+
		"\u009b\3\2\2\2\u009b\37\3\2\2\2\u009c\u009f\5&\24\2\u009d\u009f\5\"\22"+
		"\2\u009e\u009c\3\2\2\2\u009e\u009d\3\2\2\2\u009f\u00a1\3\2\2\2\u00a0\u00a2"+
		"\5$\23\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2!\3\2\2\2\u00a3"+
		"\u00a4\7\13\2\2\u00a4\u00a5\5 \21\2\u00a5\u00a6\7\f\2\2\u00a6#\3\2\2\2"+
		"\u00a7\u00a8\7\r\2\2\u00a8%\3\2\2\2\u00a9\u00aa\7\25\2\2\u00aa\'\3\2\2"+
		"\2\u00ab\u00ac\7\6\2\2\u00ac\u00ad\5*\26\2\u00ad)\3\2\2\2\u00ae\u00b7"+
		"\7\31\2\2\u00af\u00b7\7\32\2\2\u00b0\u00b7\7 \2\2\u00b1\u00b7\7\26\2\2"+
		"\u00b2\u00b7\7\27\2\2\u00b3\u00b7\5,\27\2\u00b4\u00b7\5.\30\2\u00b5\u00b7"+
		"\5\60\31\2\u00b6\u00ae\3\2\2\2\u00b6\u00af\3\2\2\2\u00b6\u00b0\3\2\2\2"+
		"\u00b6\u00b1\3\2\2\2\u00b6\u00b2\3\2\2\2\u00b6\u00b3\3\2\2\2\u00b6\u00b4"+
		"\3\2\2\2\u00b6\u00b5\3\2\2\2\u00b7+\3\2\2\2\u00b8\u00b9\7\25\2\2\u00b9"+
		"-\3\2\2\2\u00ba\u00be\7\13\2\2\u00bb\u00bd\5*\26\2\u00bc\u00bb\3\2\2\2"+
		"\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2\2\2\u00bf\u00c1"+
		"\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\7\f\2\2\u00c2/\3\2\2\2\u00c3"+
		"\u00c7\7\3\2\2\u00c4\u00c6\5\62\32\2\u00c5\u00c4\3\2\2\2\u00c6\u00c9\3"+
		"\2\2\2\u00c7\u00c5\3\2\2\2\u00c7\u00c8\3\2\2\2\u00c8\u00ca\3\2\2\2\u00c9"+
		"\u00c7\3\2\2\2\u00ca\u00cb\7\4\2\2\u00cb\61\3\2\2\2\u00cc\u00cd\7\25\2"+
		"\2\u00cd\u00ce\7\b\2\2\u00ce\u00cf\5*\26\2\u00cf\63\3\2\2\2\248AEKSZc"+
		"r|\u0084\u008d\u0097\u009a\u009e\u00a1\u00b6\u00be\u00c7";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}