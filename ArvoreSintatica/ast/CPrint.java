package ast;

public class CPrint extends Comando {
    public int linha;
    public Exp exp;

    public CPrint(int linha, Exp exp) {
        this.linha = linha;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return "printf(\"%f\\n\", " + exp.toString() + ");\n"; // Para imprimir float
    }
}
