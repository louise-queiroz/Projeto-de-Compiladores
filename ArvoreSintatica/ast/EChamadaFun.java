package ast;

import java.util.ArrayList;

class EChamadaFun extends Exp {
    private String fun;
    private ArrayList<Exp> args;

    public EChamadaFun(String fun, ArrayList<Exp> args) {
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
        sb.append(")");
        return sb.toString();
    }
}