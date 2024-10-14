package ast;

import java.util.ArrayList;

public class Prog {
    public Main main; // Programa principal
    public ArrayList<Fun> fun; // Lista de definições de funções

    public Prog(Main main, ArrayList<Fun> fun) {
        this.main = main;
        this.fun = fun;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(main.toString());
        for (Fun func : fun) {
            sb.append(func.toString());
        }
        return sb.toString();
    }
}
