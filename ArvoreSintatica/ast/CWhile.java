package ast;

import java.util.ArrayList;

public class CWhile extends Comando {
    public int linha;
    public Exp exp;
    public ArrayList<Comando> bloco;

    public CWhile(int linha, Exp exp, ArrayList<Comando> bloco) {
        this.linha = linha;
        this.exp = exp;
        this.bloco = bloco;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("while (" + exp.toString() + ") {\n");
        for (Comando cmd : bloco) {
            sb.append(cmd.toString());
        }
        sb.append("}\n");
        return sb.toString();
    }
}