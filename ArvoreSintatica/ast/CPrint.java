package ast;

public class CPrint extends Comando {
    public int linha;
    public Exp exp;

    public CPrint(int linha, Exp exp) {
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
        return "Linha " + linha + ": System.output(" + exp.toString() + ");\n";
    }
}
