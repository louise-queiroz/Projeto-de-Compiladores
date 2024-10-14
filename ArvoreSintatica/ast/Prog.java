package ast;

import java.util.ArrayList;

public class Prog {
    public ArrayList<Fun> funcoes;
    public Main main;

    public Prog(ArrayList<Fun> funcoes, Main main) {
        this.funcoes = funcoes;
        this.main = main;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (Fun fun : funcoes) {
            sb.append(fun.toString());
        }
        sb.append(main.toString());
        return sb.toString();
    }
}
