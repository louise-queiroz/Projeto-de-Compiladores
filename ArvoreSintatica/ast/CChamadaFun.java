package ast;

import java.util.ArrayList;

public class CChamadaFun extends Comando {
    public String fun;
    public ArrayList<Exp> args;

    public CChamadaFun(int linha, String fun, ArrayList<Exp> args) {
        super(linha);
        this.fun = fun;
        this.args = args;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(fun + "(");
        for (int i = 0; i < args.size(); i++) {
            sb.append(args.get(i).toString());
            if (i < args.size() - 1) {
                sb.append(", ");
            }
        }
        sb.append(");\n");
        return sb.toString();
    }
}