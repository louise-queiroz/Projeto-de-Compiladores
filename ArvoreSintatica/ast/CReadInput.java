package ast;

public class CReadInput extends Comando {
    public String var;

    public CReadInput(int linha, String var) {
        super(linha);
        this.var = var;
    }

    @Override
    public String toString() {
        return "scanf(\"%f\", &" + var + ");\n"; 
    }
}