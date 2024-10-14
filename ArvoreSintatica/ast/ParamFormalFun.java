package ast;

public class ParamFormalFun {
    public String tipo; // Tipo do parâmetro
    public String nome; // Nome do parâmetro

    public ParamFormalFun(String tipo, String nome) {
        this.tipo = tipo; // Inicializa o tipo
        this.nome = nome; // Inicializa o nome
    }

    @Override
    public String toString() {
        return tipo + " " + nome;
    }
}