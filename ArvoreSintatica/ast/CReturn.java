package ast;

public class CReturn extends Comando {
    public Exp exp;

    public CReturn(int linha, Exp exp) {
        super(linha);
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "return " + exp.toString() + ";\n";
    }
}
