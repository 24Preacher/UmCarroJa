package Exceptions;

public class CarroInexistente extends Exception {
    public CarroInexistente(){
        super("Não existem carros");
    }
}