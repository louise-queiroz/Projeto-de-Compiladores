package ast;

public class CReadInput extends Comando {
    public int linha;
    public String var;

    public CReadInput(int linha, String var) {
        this.linha = linha;
        this.var = var;
    }

    public String getVar() {
        return var;
    }

    public int getLinha() {
        return linha;
    }

    @Override
    public String toString() {
        return "Linha " + linha + ": " + var + " = System.readint();\n";
    }
}
