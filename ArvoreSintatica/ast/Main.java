package ast;

import java.util.ArrayList;

public class Main {
    public ArrayList<VarDecl> vars;
    public ArrayList<Comando> comandos;

    public Main(ArrayList<VarDecl> vars, ArrayList<Comando> comandos) {
        this.vars = vars;
        this.comandos = comandos;
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("int main() {\n");
        for (VarDecl var : vars) {
            sb.append(var.toString());
        }
        for (Comando com : comandos) {
            sb.append(com.toString());
        }
        sb.append("}\n");
        return sb.toString();
    }
}