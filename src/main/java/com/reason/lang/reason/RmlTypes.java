package com.reason.lang.reason;

import com.reason.lang.MlTypes;
import com.reason.lang.core.stub.type.ModuleStubElementType;
import com.reason.lang.core.stub.type.PsiLetStubElementType;
import com.reason.lang.core.stub.type.PsiTypeElementType;

public class RmlTypes extends MlTypes {

    public static final RmlTypes INSTANCE = new RmlTypes();

    private RmlTypes() {
        FILE_MODULE = new ModuleStubElementType("FILE_MODULE", RmlLanguage.INSTANCE);

        ANNOTATION_EXPRESSION = new RmlElementType("ANNOTATION_EXPRESSION");
        EXTERNAL_EXPRESSION = new RmlElementType("EXTERNAL_EXPRESSION");
        EXCEPTION_EXPRESSION = new RmlElementType("EXCEPTION_EXPRESSION");
        EXCEPTION_NAME = new RmlElementType("EXCEPTION_NAME");
        INCLUDE_EXPRESSION = new RmlElementType("INCLUDE_EXPRESSION");
        LET_EXPRESSION = new PsiLetStubElementType("LET_EXPRESSION", RmlLanguage.INSTANCE);
        MACRO_EXPRESSION = new RmlElementType("MACRO_EXPRESSION");
        MACRO_NAME = new RmlElementType("MACRO_NAME");
        MODULE_EXPRESSION = new ModuleStubElementType("MODULE_EXPRESSION", RmlLanguage.INSTANCE);
        UPPER_SYMBOL = new RmlElementType("UPPER_SYMBOL");
        MODULE_PATH = new RmlElementType("MODULE_PATH");
        OPEN_EXPRESSION = new RmlElementType("OPEN_EXPRESSION");
        TYPE_EXPRESSION = new PsiTypeElementType("TYPE_EXPRESSION", RmlLanguage.INSTANCE);
        VAL_EXPRESSION = new RmlElementType("VAL_EXPRESSION");

        BOOL = new RmlElementType("BOOL");
        STRING = new RmlElementType("STRING");
        FLOAT = new RmlElementType("FLOAT");
        CHAR = new RmlElementType("CHAR");
        INT = new RmlElementType("INT");

        BOOL_VALUE = new RmlElementType("BOOL_VALUE");
        STRING_VALUE = new RmlElementType("STRING_VALUE");
        FLOAT_VALUE = new RmlElementType("FLOAT_VALUE");
        CHAR_VALUE = new RmlElementType("CHAR_VALUE");
        INT_VALUE = new RmlElementType("INT_VALUE");

        FUN = new RmlElementType("FUN");
        FUNCTION = new RmlElementType("FUNCTION");
        FUN_PARAMS = new RmlElementType("FUN_PARAMS");
        FUN_BODY = new RmlElementType("FUN_PARAMS");

        FUNCTOR = new RmlElementType("FUNCTOR");
        FUNCTOR_PARAMS = new RmlElementType("FUNCTOR_PARAMS");

        LET_BINDING = new RmlElementType("LET_BINDING");
        TYPE_CONSTR_NAME = new RmlElementType("TYPE_CONSTR_NAME");
        TYPE_BINDING = new RmlElementType("TYPE_BINDING");
        PATTERN_MATCH_EXPR = new RmlElementType("PATTERN_MATCH_EXPR");
        SCOPED_EXPR = new RmlElementType("SCOPED_EXPR");
        LOCAL_OPEN = new RmlElementType("LOCAL_OPEN");
        SIG_SCOPE = new RmlElementType("SIG_SCOPE");
        PROPERTY_NAME = new RmlElementType("PROPERTY_NAME");
        NAMED_SYMBOL = new RmlElementType("NAMED_SYMBOL");

        AND = new RmlElementType("AND");
        ANDAND = new RmlElementType("ANDAND");
        ARROBASE = new RmlElementType("ARROBASE");
        ARROW = new RmlElementType("ARROW");
        ASSERT = new RmlElementType("ASSERT");
        AS = new RmlElementType("AS");
        BACKTICK = new RmlElementType("BACKTICK");
        BEGIN = new RmlElementType("BEGIN");
        CARRET = new RmlElementType("CARRET");
        COLON = new RmlElementType("COLON");
        COMMA = new RmlElementType("COMMA");
        COMMENT = new RmlElementType("COMMENT");
        DIFF = new RmlElementType("DIFF");
        DOLLAR = new RmlElementType("DOLLAR");
        DOT = new RmlElementType("DOT");
        DOTDOTDOT = new RmlElementType("DOTDOTDOT");
        DO = new RmlElementType("DO");
        DONE = new RmlElementType("DONE");
        ELSE = new RmlElementType("ELSE");
        END = new RmlElementType("END");
        NOT_EQ = new RmlElementType("EQ");
        NOT_EQEQ = new RmlElementType("EQEQ");
        EQ = new RmlElementType("EQ");
        EQEQ = new RmlElementType("EQEQ");
        EQEQEQ = new RmlElementType("EQEQEQ");
        EXCEPTION = new RmlElementType("EXCEPTION");
        EXCLAMATION_MARK = new RmlElementType("EXCLAMATION_MARK");
        EXTERNAL = new RmlElementType("EXTERNAL");
        FALSE = new RmlElementType("FALSE");
        FOR = new RmlElementType("FOR");
        TYPE_ARGUMENT = new RmlElementType("TYPE_ARGUMENT");
        GT = new RmlElementType("GT");
        IF = new RmlElementType("IF");
        BIN_CONDITION = new RmlElementType("BIN_CONDITION");
        IN = new RmlElementType("IN");
        LAZY = new RmlElementType("LAZY");
        INCLUDE = new RmlElementType("INCLUDE");
        LARRAY = new RmlElementType("LARRAY");
        LBRACE = new RmlElementType("LBRACE");
        LBRACKET = new RmlElementType("LBRACKET");
        LET = new RmlElementType("LET");
        LIDENT = new RmlElementType("LIDENT");
        LIST = new RmlElementType("LIST");
        LPAREN = new RmlElementType("LPAREN");
        LT = new RmlElementType("LT");
        MATCH = new RmlElementType("MATCH");
        MINUS = new RmlElementType("MINUS");
        MINUSDOT = new RmlElementType("MINUSDOT");
        MODULE = new RmlElementType("MODULE");
        MUTABLE = new RmlElementType("MUTABLE");
        NONE = new RmlElementType("NONE");
        OF = new RmlElementType("OF");
        OPEN = new RmlElementType("OPEN");
        OPTION = new RmlElementType("OPTION");
        POLY_VARIANT = new RmlElementType("POLY_VARIANT");
        VARIANT = new RmlElementType("VARIANT");
        VARIANT_NAME = new RmlElementType("VARIANT_NAME");
        PIPE = new RmlElementType("PIPE");
        PIPE_FORWARD = new RmlElementType("PIPE_FORWARD");
        PIPE_FIRST = new RmlElementType("PIPE_FIRST");
        PLUS = new RmlElementType("PLUS");
        PERCENT = new RmlElementType("PERCENT");
        PLUSDOT = new RmlElementType("PLUSDOT");
        QUESTION_MARK = new RmlElementType("QUESTION_MARK");
        QUOTE = new RmlElementType("QUOTE");
        RAISE = new RmlElementType("RAISE");
        RARRAY = new RmlElementType("RARRAY");
        RBRACE = new RmlElementType("RBRACE");
        RBRACKET = new RmlElementType("RBRACKET");
        REC = new RmlElementType("REC");
        REF = new RmlElementType("REF");
        RPAREN = new RmlElementType("RPAREN");
        SEMI = new RmlElementType("SEMI");
        SIG = new RmlElementType("SIG");
        SHARP = new RmlElementType("SHARP");
        SHARPSHARP = new RmlElementType("SHARPSHARP");
        SHORTCUT = new RmlElementType("SHORTCUT");
        SLASH = new RmlElementType("SLASH");
        SLASHDOT = new RmlElementType("SLASHDOT");
        SOME = new RmlElementType("SOME");
        STAR = new RmlElementType("STAR");
        STARDOT = new RmlElementType("STARDOT");
        STRUCT = new RmlElementType("STRUCT");
        SWITCH = new RmlElementType("SWITCH");
        TAG_AUTO_CLOSE = new RmlElementType("TAG_AUTO_CLOSE");
        TAG_START = new RmlElementType("TAG_START");
        TAG_CLOSE = new RmlElementType("TAG_CLOSE");
        TAG_NAME = new RmlElementType("TAG_NAME");
        TAG_PROPERTY = new RmlElementType("TAG_PROPERTY");
        TAG_LT = new RmlElementType("TAG_LT");
        TAG_LT_SLASH = new RmlElementType("TAG_LT_SLASH");
        TAG_GT = new RmlElementType("TAG_GT");
        TILDE = new RmlElementType("TILDE");
        TO = new RmlElementType("TO");
        THEN = new RmlElementType("THEN");
        TRUE = new RmlElementType("TRUE");
        TRY = new RmlElementType("TRY");
        TYPE = new RmlElementType("TYPE");
        UIDENT = new RmlElementType("UIDENT");
        UNIT = new RmlElementType("UNIT");
        VAL = new RmlElementType("VAL");
        PUB = new RmlElementType("PUB");
        LOWER_SYMBOL = new RmlElementType("LOWER_SYMBOL");
        WHEN = new RmlElementType("WHEN");
        WHILE = new RmlElementType("WHILE");
        WITH = new RmlElementType("WITH");

        ASR = new RmlElementType("ASR");
        CLASS = new RmlElementType("CLASS");
        CONSTRAINT = new RmlElementType("CONSTRAINT");
        DOWNTO = new RmlElementType("DOWNTO");
        INHERIT = new RmlElementType("INHERIT");
        INITIALIZER = new RmlElementType("INITIALIZER");
        LAND = new RmlElementType("LAND");
        LOR = new RmlElementType("LOR");
        LSL = new RmlElementType("LSL");
        LSR = new RmlElementType("LSR");
        LXOR = new RmlElementType("LXOR");
        METHOD = new RmlElementType("METHOD");
        MOD = new RmlElementType("MOD");
        NEW = new RmlElementType("NEW");
        NONREC = new RmlElementType("NONREC");
        OR = new RmlElementType("OR");
        PRIVATE = new RmlElementType("PRIVATE");
        VIRTUAL = new RmlElementType("VIRTUAL");

        COLON_EQ = new RmlElementType("COLON_EQ");
        COLON_GT = new RmlElementType("COLON_GT");
        DOTDOT = new RmlElementType("DOTDOT");
        SEMISEMI = new RmlElementType("SEMISEMI");
        GT_BRACKET = new RmlElementType("GT_BRACKET");
        GT_BRACE = new RmlElementType("GT_BRACE");
        LEFT_ARROW = new RmlElementType("LEFT_ARROW");
        RIGHT_ARROW = new RmlElementType("RIGHT_ARROW");

        OBJECT = new RmlElementType("OBJECT");
        OBJECT_FIELD = new RmlElementType("OBJECT_FIELD");

        AMPERSAND = new RmlElementType("AMPERSAND");
        BRACKET_GT = new RmlElementType("BRACKET_GT");
        BRACKET_LT = new RmlElementType("BRACKET_LT");
        BRACE_LT = new RmlElementType("BRACE_LT");

        ML_STRING_OPEN = new RmlElementType("ML_STRING_OPEN");
        ML_STRING_CLOSE = new RmlElementType("ML_STRING_CLOSE");
        JS_STRING_OPEN = new RmlElementType("JS_STRING_OPEN");
        JS_STRING_CLOSE = new RmlElementType("JS_STRING_CLOSE");
        INTERPOLATION = new RmlElementType("INTERPOLATION");
    }
}