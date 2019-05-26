package Exceptions;

public class UtilizadorExistente extends Exception {

    public UtilizadorExistente(){
        super("Utilizador já existe!");
    }

}