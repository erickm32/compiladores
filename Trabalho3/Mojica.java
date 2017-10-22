/* Generated By:JavaCC: Do not edit this line. Mojica.java */
import java.io.*;
public class Mojica implements MojicaConstants {

  public static void main(String args[]) throws ParseException,IOException {

    Mojica mojica = new Mojica(new FileInputStream(args[0]));
    mojica.Prog();
  }

  static final public void Prog() throws ParseException {
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(LBRACE);
    jj_consume_token(RBRACE);
    jj_consume_token(LCURLY);
    VarDecl();
    SeqComandos();
    jj_consume_token(RCURLY);
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case BOOL:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      Func();
    }
    jj_consume_token(0);
  }

  static final public void VarDecl() throws ParseException {
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case BOOL:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      Tipo();
      jj_consume_token(TOKEN_id);
      jj_consume_token(PEV);
    }
  }

  static final public void Tipo() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
      jj_consume_token(INT);
      break;
    case BOOL:
      jj_consume_token(BOOL);
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void SeqComandos() throws ParseException {
    label_3:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case IF:
      case WHILE:
      case RETURN:
      case TOKEN_skip:
      case TOKEN_id:
        ;
        break;
      default:
        jj_la1[3] = jj_gen;
        break label_3;
      }
      Comando();
    }
  }

  static final public void Comando() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TOKEN_skip:
      jj_consume_token(TOKEN_skip);
      jj_consume_token(LBRACE);
      jj_consume_token(RBRACE);
      jj_consume_token(PEV);
      break;
    case TOKEN_id:
      jj_consume_token(TOKEN_id);
      Comando2();
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      jj_consume_token(LCURLY);
      SeqComandos();
      jj_consume_token(RCURLY);
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      jj_consume_token(DO);
      jj_consume_token(LCURLY);
      SeqComandos();
      jj_consume_token(RCURLY);
      break;
    case RETURN:
      jj_consume_token(RETURN);
      TipoReturn();
      jj_consume_token(PEV);
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Comando2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OP_ATRB:
      jj_consume_token(OP_ATRB);
      Exps();
      jj_consume_token(PEV);
      break;
    case LBRACE:
      jj_consume_token(LBRACE);
      label_4:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case LBRACE:
        case TOKEN_id:
        case TOKEN_numliteral:
          ;
          break;
        default:
          jj_la1[5] = jj_gen;
          break label_4;
        }
        ListaExp();
      }
      jj_consume_token(RBRACE);
      jj_consume_token(PEV);
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void BoolExp() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TRUE:
      jj_consume_token(TRUE);
      break;
    case FALSE:
      jj_consume_token(FALSE);
      break;
    case NOT:
      jj_consume_token(NOT);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      break;
    case AND:
      jj_consume_token(AND);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      break;
    case OR:
      jj_consume_token(OR);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      jj_consume_token(LBRACE);
      BoolExp();
      jj_consume_token(RBRACE);
      break;
    case LEQ:
      jj_consume_token(LEQ);
      jj_consume_token(LBRACE);
      Exps();
      jj_consume_token(RBRACE);
      jj_consume_token(LBRACE);
      Exps();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void TipoReturn() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case LBRACE:
    case TOKEN_id:
    case TOKEN_numliteral:
      Exps();
      break;
    case TRUE:
    case FALSE:
    case NOT:
    case AND:
    case OR:
    case LEQ:
      BoolExp();
      break;
    default:
      jj_la1[8] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void Exps() throws ParseException {
    Termo();
    Exps2();
  }

  static final public void Exps2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPA:
      jj_consume_token(OPA);
      Termo();
      Exps2();
      break;
    default:
      jj_la1[9] = jj_gen;
      ;
    }
  }

  static final public void Termo() throws ParseException {
    Fator();
    Termo2();
  }

  static final public void Termo2() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case OPM:
      jj_consume_token(OPM);
      Fator();
      Termo2();
      break;
    default:
      jj_la1[10] = jj_gen;
      ;
    }
  }

  static final public void Fator() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case TOKEN_id:
      jj_consume_token(TOKEN_id);
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case LBRACE:
        jj_consume_token(LBRACE);
        ListaExp();
        jj_consume_token(RBRACE);
        break;
      default:
        jj_la1[11] = jj_gen;
        ;
      }
      break;
    case TOKEN_numliteral:
      jj_consume_token(TOKEN_numliteral);
      break;
    case LBRACE:
      jj_consume_token(LBRACE);
      Exps();
      jj_consume_token(RBRACE);
      break;
    default:
      jj_la1[12] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
  }

  static final public void ListaExp() throws ParseException {
    Exps();
    ListaExp2();
  }

  static final public void ListaExp2() throws ParseException {
    label_5:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case V:
        ;
        break;
      default:
        jj_la1[13] = jj_gen;
        break label_5;
      }
      jj_consume_token(V);
      Exps();
    }
  }

  static final public void LFunc() throws ParseException {
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case INT:
    case BOOL:
      Func();
      LFunc();
      break;
    default:
      jj_la1[14] = jj_gen;
      ;
    }
  }

  static final public void Func() throws ParseException {
    Tipo();
    jj_consume_token(TOKEN_id);
    jj_consume_token(LBRACE);
    ListaArg();
    jj_consume_token(RBRACE);
    jj_consume_token(LCURLY);
    VarDecl();
    SeqComandos();
    jj_consume_token(RCURLY);
  }

  static final public void ListaArg() throws ParseException {
    label_6:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case INT:
      case BOOL:
        ;
        break;
      default:
        jj_la1[15] = jj_gen;
        break label_6;
      }
      Tipo();
      jj_consume_token(TOKEN_id);
      label_7:
      while (true) {
        switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
        case V:
          ;
          break;
        default:
          jj_la1[16] = jj_gen;
          break label_7;
        }
        ListaArg2();
      }
    }
  }

  static final public void ListaArg2() throws ParseException {
    jj_consume_token(V);
    Tipo();
    jj_consume_token(TOKEN_id);
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public MojicaTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[17];
  static private int[] jj_la1_0;
  static {
      jj_la1_init_0();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x300,0x300,0x300,0x181a000,0x181a000,0x3000010,0x410,0x7e0000,0x37e0010,0x4000000,0x8000000,0x10,0x3000010,0x1000,0x300,0x300,0x1000,};
   }

  /** Constructor with InputStream. */
  public Mojica(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Mojica(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new MojicaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream) {
     ReInit(stream, null);
  }
  /** Reinitialise. */
  static public void ReInit(java.io.InputStream stream, String encoding) {
    try { jj_input_stream.ReInit(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Mojica(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new MojicaTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Mojica(MojicaTokenManager tm) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(MojicaTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 17; i++) jj_la1[i] = -1;
  }

  static private Token jj_consume_token(int kind) throws ParseException {
    Token oldToken;
    if ((oldToken = token).next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    if (token.kind == kind) {
      jj_gen++;
      return token;
    }
    token = oldToken;
    jj_kind = kind;
    throw generateParseException();
  }


/** Get the next Token. */
  static final public Token getNextToken() {
    if (token.next != null) token = token.next;
    else token = token.next = token_source.getNextToken();
    jj_ntk = -1;
    jj_gen++;
    return token;
  }

/** Get the specific Token. */
  static final public Token getToken(int index) {
    Token t = token;
    for (int i = 0; i < index; i++) {
      if (t.next != null) t = t.next;
      else t = t.next = token_source.getNextToken();
    }
    return t;
  }

  static private int jj_ntk() {
    if ((jj_nt=token.next) == null)
      return (jj_ntk = (token.next=token_source.getNextToken()).kind);
    else
      return (jj_ntk = jj_nt.kind);
  }

  static private java.util.List<int[]> jj_expentries = new java.util.ArrayList<int[]>();
  static private int[] jj_expentry;
  static private int jj_kind = -1;

  /** Generate ParseException. */
  static public ParseException generateParseException() {
    jj_expentries.clear();
    boolean[] la1tokens = new boolean[28];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 17; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 28; i++) {
      if (la1tokens[i]) {
        jj_expentry = new int[1];
        jj_expentry[0] = i;
        jj_expentries.add(jj_expentry);
      }
    }
    int[][] exptokseq = new int[jj_expentries.size()][];
    for (int i = 0; i < jj_expentries.size(); i++) {
      exptokseq[i] = jj_expentries.get(i);
    }
    return new ParseException(token, exptokseq, tokenImage);
  }

  /** Enable tracing. */
  static final public void enable_tracing() {
  }

  /** Disable tracing. */
  static final public void disable_tracing() {
  }

}
