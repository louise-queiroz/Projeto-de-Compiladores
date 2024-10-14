package ast;

public class CAtribuicao extends Comando {
    public String var;
    public Exp exp;

    public CAtribuicao(int linha, String var, Exp exp) {
        super(linha);
        this.var = var;
        this.exp = exp;
    }

    @Override
    public String toString() {
        return var + " = " + exp.toString() + ";\n";
    }
}


