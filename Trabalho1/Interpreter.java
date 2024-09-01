import java.io.*;

class Interpreter {
    public static void main(String[] args) {
        ArvoreSintatica arv = null;

        try {
            AnaliseLexica al = new AnaliseLexica(args[0]);
            Parser as = new Parser(al);

            arv = as.parseProg();

            Interpreter interpreter = new Interpreter();
            int codigo = interpreter.interpreta(arv);
            System.out.println("Resultado do interpretador: \n" + codigo);

        } catch (Exception e) {
            System.out.println("Erro no interpretador:\n" + e);
        }
    }

    int interpreta(ArvoreSintatica arv) {
        return interpretaAux(arv);
    }

    int interpretaAux(ArvoreSintatica arv) {
        if (arv instanceof Mult) {
            return interpretaAux(((Mult) arv).arg1) * interpretaAux(((Mult) arv).arg2);
        }

        if (arv instanceof Soma) {
            return interpretaAux(((Soma) arv).arg1) + interpretaAux(((Soma) arv).arg2);
        }

        if (arv instanceof Div) {
            return interpretaAux(((Div) arv).arg1) / interpretaAux(((Div) arv).arg2);
        }

        if (arv instanceof Sub) {
            return interpretaAux(((Sub) arv).arg1) - interpretaAux(((Sub) arv).arg2);
        }

        if (arv instanceof Num) {
            return ((Num) arv).num;
        }

        throw new RuntimeException("Tipo de nó desconhecido na árvore sintática.");
    }
}