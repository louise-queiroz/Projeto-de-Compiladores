package ast;

public class CReturn extends Comando {
    public int linha;
    public Exp exp;

    public CReturn(int linha, Exp exp) {
        this.linha = linha;
        this.exp = exp;
    }

    public Exp getExp() {
        return exp;
    }

    public int getLinha() {
        return linha;
    }

    @Override
    public String toString() {
        return "Linha " + linha + ": return " + exp.toString() + ";\n";
    }
}
