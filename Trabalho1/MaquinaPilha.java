import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Stack;

class MaquinaPilha {

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Uso: java MaquinaPilha <arquivoDeEntrada>");
            return;
        }

        String arquivoDeEntrada = args[0];

        try {
            BufferedReader reader = new BufferedReader(new FileReader(arquivoDeEntrada));
            Stack<Integer> pilha = new Stack<>();
            String linha;

            while ((linha = reader.readLine()) != null) {
                processaLinha(linha, pilha);
            }

            reader.close();
        } catch (IOException e) {
            System.out.println("Erro ao ler o arquivo: " + e.getMessage());
        } catch (Exception e) {
            System.out.println("Erro de execução: " + e.getMessage());
        }
    }

    private static void processaLinha(String linha, Stack<Integer> pilha) {
        String[] partes = linha.split(" ");
        String comando = partes[0];

        switch (comando) {
            case "PUSH":
                int valor = Integer.parseInt(partes[1]);
                pilha.push(valor);
                break;
            case "SUM":
                int b = pilha.pop();
                int a = pilha.pop();
                pilha.push(a + b);
                break;
            case "SUB":
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a - b);
                break;
            case "MULT":
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a * b);
                break;
            case "DIV":
                b = pilha.pop();
                a = pilha.pop();
                pilha.push(a / b);
                break;
            case "PRINT":
                System.out.println(pilha.pop());
                break;
            default:
                throw new RuntimeException("Comando desconhecido: " + comando);
        }
    }
}
