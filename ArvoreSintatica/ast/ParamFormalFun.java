package ast;

public class ParamFormalFun {
    public String tipo;
    public String nome;

    public ParamFormalFun(String tipo, String nome) {
        this.tipo = tipo;
        this.nome = nome;
    }

    @Override
    public String toString() {
        return tipo + " " + nome;
    }
}
