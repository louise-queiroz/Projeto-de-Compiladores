package ast;

import java.util.ArrayList;

public class Prog {
    public Main main;                   // Atributo para o programa principal
    public ArrayList<Fun> fun;          // Lista de funções do programa

    public Prog(Main main, ArrayList<Fun> fun) {
        this.main = main;
        this.fun = fun;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        
        // Adiciona a representação do main
        sb.append(main.toString()).append("\n");
        
        // Adiciona a representação de cada função
        for (Fun func : fun) {
            sb.append(func.toString()).append("\n");
        }
        
        return sb.toString(); // Retorna a string formatada do programa
    }
}
