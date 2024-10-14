/* Generated By:JavaCC: Do not edit this line. Karloff.java */
import ast.*;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Karloff implements KarloffConstants {
    public static void main(String args[]) throws Exception {
        FileInputStream file = new FileInputStream(new File(args[0]));
        Karloff parser = new Karloff(file);
        Prog arvore = parser.Karloff();
        gerarCodigo(arvore, args[0]);
    }

    public static void gerarCodigo(Prog arvore, String caminho) {
        String arvoreString;
        File arquivo;
        FileOutputStream saida = null;

        arvoreString = arvore.toString();
        caminho = caminho.replace(".kar", ".c");

        System.out.println("Conte\u00fado gerado para o arquivo C: " + arvoreString);

        arquivo = new File("saida/" + caminho);
        try {
            arquivo.getParentFile().mkdirs();
            arquivo.createNewFile();
            saida = new FileOutputStream(arquivo);
            saida.write(arvoreString.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (saida != null) {
                try {
                    saida.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

// Nova regra para o programa principal
  static final public Prog Karloff() throws ParseException {
    ArrayList<VarDecl> vardecls;
    ArrayList<Comando> comandos;
    vardecls = Vardecl();
    comandos = SeqComandos();
       System.out.println("PROG N\u00famero de vari\u00e1veis: " + vardecls.size());
      System.out.println("PROG N\u00famero de comandos: " + comandos.size());

  // Debug para verificar as variáveis e comandos coletados
        for (VarDecl var : vardecls) {
            System.out.println("Vari\u00e1vel: " + var);
        }
        for (Comando cmd : comandos) {
            System.out.println("Comando: " + cmd);
        }
        {if (true) return new Prog(new Main(vardecls, comandos), new ArrayList<Fun>());}
    throw new Error("Missing return statement in function");
  }

  static final public Main Main() throws ParseException {
    ArrayList<VarDecl> vardecls;
    ArrayList<Comando> comandos;
    jj_consume_token(VOID);
    jj_consume_token(MAIN);
    jj_consume_token(APARENTESES);
    jj_consume_token(FPARENTESES);
    jj_consume_token(ACHAVES);
    vardecls = Vardecl();
    comandos = SeqComandos();
    jj_consume_token(FCHAVES);
        System.out.println("Dentro de Main - N\u00famero de vari\u00e1veis: " + vardecls.size());
        System.out.println("Dentro de Main - N\u00famero de comandos: " + comandos.size());
        {if (true) return new Main(vardecls, comandos);}
    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<Comando> SeqComandos() throws ParseException {
    ArrayList<Comando> comandos = new ArrayList<Comando>();
    Comando cmd;
    label_1:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case PRINTOUT:
      case IF:
      case WHILE:
      case READINPUT:
      case RETURN:
      case ID:
        ;
        break;
      default:
        jj_la1[0] = jj_gen;
        break label_1;
      }
      cmd = Comando();
        comandos.add(cmd);
    }
        {if (true) return comandos;}  // Retorna os comandos coletados

    throw new Error("Missing return statement in function");
  }

  static final public ArrayList<VarDecl> Vardecl() throws ParseException {
    ArrayList<VarDecl> decls = new ArrayList<VarDecl>();
    String tipo;
    Token id;
    label_2:
    while (true) {
      switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
      case NEWVAR:
        ;
        break;
      default:
        jj_la1[1] = jj_gen;
        break label_2;
      }
      jj_consume_token(NEWVAR);
      tipo = Tipo();
      id = jj_consume_token(ID);
      jj_consume_token(PONTOVIRGULA);
        System.out.println("Nova vari\u00e1vel declarada: tipo=" + tipo + ", id=" + id.image);

        decls.add(new VarDecl(tipo, id.image));
    }
        {if (true) return decls;}
    throw new Error("Missing return statement in function");
  }

  static final public String Tipo() throws ParseException {
    Token tipo;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case FLOAT:
      tipo = jj_consume_token(FLOAT);
                     {if (true) return "float";}
      break;
    case BOOLEAN:
      tipo = jj_consume_token(BOOLEAN);
                       {if (true) return "boolean";}
      break;
    case VOID:
      tipo = jj_consume_token(VOID);
                    {if (true) return "void";}
      break;
    default:
      jj_la1[2] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Comando Comando() throws ParseException {
    Comando cmd = null;
    Exp exp = null;
    Token id;
    ArrayList<Comando> seqComandos = new ArrayList<Comando>();
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case ID:
      // Atribuição
          id = jj_consume_token(ID);
      jj_consume_token(IGUAL);
      exp = Exp();
      jj_consume_token(PONTOVIRGULA);
        cmd = new CAtribuicao(0, id.image, exp); // Atribuição
        System.out.println("Comando de atribui\u00e7\u00e3o: id=" + id.image + ", exp=" + exp);
        {if (true) return cmd;}
      break;
    case IF:
      jj_consume_token(IF);
      jj_consume_token(APARENTESES);
      exp = Exp();
      jj_consume_token(FPARENTESES);
      jj_consume_token(THEN);
      jj_consume_token(ACHAVES);
        seqComandos = SeqComandos();

        cmd = new CIf(0, exp, seqComandos);
        {if (true) return cmd;}
      break;
    case WHILE:
      jj_consume_token(WHILE);
      jj_consume_token(APARENTESES);
      exp = Exp();
      jj_consume_token(FPARENTESES);
      jj_consume_token(ACHAVES);
        seqComandos = SeqComandos();
        System.out.println("Comando WHILE: exp=" + exp);
        cmd = new CWhile(0, exp, seqComandos);
        {if (true) return cmd;}
      break;
    case RETURN:
      jj_consume_token(RETURN);
      exp = Exp();
      jj_consume_token(PONTOVIRGULA);
        cmd = new CReturn(0, exp);
        System.out.println("Comando RETURN: exp=" + exp);
        {if (true) return cmd;}
      break;
    case PRINTOUT:
      jj_consume_token(PRINTOUT);
      jj_consume_token(APARENTESES);
      exp = Exp();
      jj_consume_token(FPARENTESES);
      jj_consume_token(PONTOVIRGULA);
        cmd = new CPrint(0, exp);
        System.out.println("Comando PRINTOUT: exp=" + exp);
        {if (true) return cmd;}
      break;
    case READINPUT:
      jj_consume_token(READINPUT);
      jj_consume_token(APARENTESES);
      jj_consume_token(FPARENTESES);
      jj_consume_token(PONTOVIRGULA);
        cmd = new CReadInput(0, "entrada");
        {if (true) return cmd;}
      break;
    default:
      jj_la1[3] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Comando ComandoLinha1() throws ParseException {
    Comando cmd = null;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case PONTOVIRGULA:
      jj_consume_token(PONTOVIRGULA);
                     {if (true) return cmd;}
      break;
    case PRINTOUT:
    case IF:
    case WHILE:
    case READINPUT:
    case RETURN:
    case ID:
      Comando();
                {if (true) return cmd;}
      break;
    default:
      jj_la1[4] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Exp() throws ParseException {
    Exp exp1, exp2;
    String op;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case APARENTESES:
      jj_consume_token(APARENTESES);
      exp1 = Exp();
      op = Op();
      exp2 = Exp();
      jj_consume_token(FPARENTESES);
        {if (true) return new EOpExp(op, exp1, exp2);}
      break;
    case ID:
    case NUM:
      exp1 = Fator();
        {if (true) return exp1;}
      break;
    default:
      jj_la1[5] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public String Op() throws ParseException {
    Token op;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case SOMA:
      op = jj_consume_token(SOMA);
                  {if (true) return "+";}
      break;
    case SUBTRACAO:
      op = jj_consume_token(SUBTRACAO);
                       {if (true) return "-";}
      break;
    case MULTIPLICACAO:
      op = jj_consume_token(MULTIPLICACAO);
                           {if (true) return "*";}
      break;
    case DIVISAO:
      op = jj_consume_token(DIVISAO);
                     {if (true) return "/";}
      break;
    case MENOR:
      op = jj_consume_token(MENOR);
                   {if (true) return "<";}
      break;
    case MAIOR:
      op = jj_consume_token(MAIOR);
                   {if (true) return ">";}
      break;
    case IGUALA:
      op = jj_consume_token(IGUALA);
                    {if (true) return "==";}
      break;
    default:
      jj_la1[6] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static final public Exp Fator() throws ParseException {
    Exp exp;
    Token num, id;
    switch ((jj_ntk==-1)?jj_ntk():jj_ntk) {
    case NUM:
      num = jj_consume_token(NUM);
                  {if (true) return new EFloat(Float.parseFloat(num.image));}
      break;
    case ID:
      id = jj_consume_token(ID);
                {if (true) return new EVar(id.image);}
      break;
    default:
      jj_la1[7] = jj_gen;
      jj_consume_token(-1);
      throw new ParseException();
    }
    throw new Error("Missing return statement in function");
  }

  static private boolean jj_initialized_once = false;
  /** Generated Token Manager. */
  static public KarloffTokenManager token_source;
  static SimpleCharStream jj_input_stream;
  /** Current token. */
  static public Token token;
  /** Next token. */
  static public Token jj_nt;
  static private int jj_ntk;
  static private int jj_gen;
  static final private int[] jj_la1 = new int[8];
  static private int[] jj_la1_0;
  static private int[] jj_la1_1;
  static {
      jj_la1_init_0();
      jj_la1_init_1();
   }
   private static void jj_la1_init_0() {
      jj_la1_0 = new int[] {0x3a8000,0x10000,0x6040,0x3a8000,0x3a8800,0x200,0xcf000000,0x0,};
   }
   private static void jj_la1_init_1() {
      jj_la1_1 = new int[] {0x8,0x0,0x0,0x8,0x8,0x18,0x1,0x18,};
   }

  /** Constructor with InputStream. */
  public Karloff(java.io.InputStream stream) {
     this(stream, null);
  }
  /** Constructor with InputStream and supplied encoding */
  public Karloff(java.io.InputStream stream, String encoding) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser.  ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    try { jj_input_stream = new SimpleCharStream(stream, encoding, 1, 1); } catch(java.io.UnsupportedEncodingException e) { throw new RuntimeException(e); }
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
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
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor. */
  public Karloff(java.io.Reader stream) {
    if (jj_initialized_once) {
      System.out.println("ERROR: Second call to constructor of static parser. ");
      System.out.println("       You must either use ReInit() or set the JavaCC option STATIC to false");
      System.out.println("       during parser generation.");
      throw new Error();
    }
    jj_initialized_once = true;
    jj_input_stream = new SimpleCharStream(stream, 1, 1);
    token_source = new KarloffTokenManager(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  static public void ReInit(java.io.Reader stream) {
    jj_input_stream.ReInit(stream, 1, 1);
    token_source.ReInit(jj_input_stream);
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Constructor with generated Token Manager. */
  public Karloff(KarloffTokenManager tm) {
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
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
  }

  /** Reinitialise. */
  public void ReInit(KarloffTokenManager tm) {
    token_source = tm;
    token = new Token();
    jj_ntk = -1;
    jj_gen = 0;
    for (int i = 0; i < 8; i++) jj_la1[i] = -1;
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
    boolean[] la1tokens = new boolean[37];
    if (jj_kind >= 0) {
      la1tokens[jj_kind] = true;
      jj_kind = -1;
    }
    for (int i = 0; i < 8; i++) {
      if (jj_la1[i] == jj_gen) {
        for (int j = 0; j < 32; j++) {
          if ((jj_la1_0[i] & (1<<j)) != 0) {
            la1tokens[j] = true;
          }
          if ((jj_la1_1[i] & (1<<j)) != 0) {
            la1tokens[32+j] = true;
          }
        }
      }
    }
    for (int i = 0; i < 37; i++) {
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
