package ast;

import java.util.ArrayList;

public class CChamadaFun extends Comando {
    public int linha;
    public String fun;
    public ArrayList<Exp> args;

    public CChamadaFun(int linha, String fun, ArrayList<Exp> args) {
        this.linha = linha;
        this.fun = fun;
        this.args = args;
    }

    public String getFun() {
        return fun;
    }

    public ArrayList<Exp> getArgs() {
        return args;
    }

    public int getLinha() {
        return linha;
    }

    @Override
    public String toString() {
        return "Linha " + linha + ": " + fun + "(" + args.toString() + ");\n";
    }
}
