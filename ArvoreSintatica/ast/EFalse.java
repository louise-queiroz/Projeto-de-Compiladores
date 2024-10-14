package ast;

class EFalse extends Exp {
    @Override
    public String toString() {
        return "0"; // Em C, false é representado como 0
    }
}
