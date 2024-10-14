package ast;

// Classe abstrata que serve como base para todos os tipos de comando
public abstract class Comando {
    protected int linha; // Número da linha no código fonte (para depuração)

    // Construtor padrão, recebe o número da linha
    public Comando(int linha) {
        this.linha = linha;
    }

    // Método abstrato que deve ser implementado pelas subclasses para gerar código
    public abstract String toString();  // Gera o código correspondente ao comando
}
