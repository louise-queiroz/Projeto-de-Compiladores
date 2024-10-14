package ast;

public class VarDecl {
    public String tipo;
    public String nome;

    public VarDecl(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }
    @Override
    public String toString() {
        return tipo + " " + nome + ";\n";
    }
}