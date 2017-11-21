grammar GraphQLSchema;

graphqlSchema
  : (TypeDeclaration definition)*
  ;

definition
  : (typeDef|inputTypeDef|unionDef|enumDef|interfaceDef|scalarDef)
  ;

typeDef
  : typeName implementationDefs? '{' fieldDef+ '}'
  ;

implementationDefs
  : 'implements' typeName+
  ;

inputTypeDef
  : typeName '{' fieldDef+ '}'
  ;

interfaceDef
  : typeName '{' fieldDef+ '}'
  ;

scalarDef
  : typeName
  ;

unionDef
  : typeName '=' unionTypes
  ;

unionTypes
  : (typeName '|')* typeName
  ;

enumDef
  : typeName '{' scalarName+ '}'
  ;

scalarName
  : Name
  ;

fieldDef
  : fieldName fieldArgs? ':' typeSpec
  ;

fieldArgs
  : '(' argument+ ')'
  ;

fieldName
  : Name
  ;

argument
  : Name ':' typeSpec nullable? defaultValue?
  ;


typeSpec
  : (typeName|listType) nullable?
  ;

listType
  : '[' typeSpec ']'
  ;

nullable
  : '!'
  ;

typeName
  : Name
  ;

defaultValue
  : '=' value
  ;

TypeDeclaration
   : (TYPE|INTERFACE|UNION|ENUM|SCALAR|INPUT)
   ;

TYPE
   : 'input' Whitespace*
   ;
INTERFACE
   : 'interface' Whitespace*
   ;
UNION
   : 'union' Whitespace*
   ;
ENUM
   : 'enum' Whitespace*
   ;
 SCALAR
   : 'scalar' Whitespace*
   ;
INPUT
   : 'input' Whitespace*
   ;

Name
  : [a-zA-Z][_0-9A-Za-z]*
  ;

value
    : IntValue
    | FloatValue
    | StringValue
    | BooleanValue
    | NullValue
    | enumValue
    | arrayValue
    | objectValue
    ;

enumValue
    : Name
    ;

arrayValue
    : '[' value* ']'
    ;

objectValue
    : '{' objectField* '}'
    ;

objectField
    : Name ':' value
    ;

BooleanValue
    : 'true'
    | 'false'
    ;

NullValue
    : Null
    ;

Null
    : 'null'
    ;

IntValue
    : Sign? IntegerPart
    ;

FloatValue
    : Sign? IntegerPart ('.' Digit+)? ExponentPart?
    ;

Sign
    : '-'
    ;

IntegerPart
    : '0'
    | NonZeroDigit
    | NonZeroDigit Digit+
    ;

NonZeroDigit
    : '1'.. '9'
    ;

ExponentPart
    : ('e'|'E') Sign? Digit+
    ;

Digit
    : '0'..'9'
    ;

StringValue
    : DoubleQuote (~(["\\\n\r\u2028\u2029])|EscapedChar)* DoubleQuote
    ;

fragment EscapedChar
    :  '\\' (["\\/bfnrt] | Unicode)
    ;

fragment Unicode
   : 'u' Hex Hex Hex Hex
   ;

fragment DoubleQuote
   : '"'
   ;

fragment Hex
   : [0-9a-fA-F]
   ;
Ignored
   : (Whitespace|Comma|LineTerminator|Comment) -> skip
   ;

fragment Comment
   : '#' ~[\n\r\u2028\u2029]*
   ;

fragment LineTerminator
   : [\n\r\u2028\u2029]
   ;

fragment Whitespace
   : [\t\u000b\f\u0020\u00a0]
   ;

fragment Comma
   : ','
   ;


