package Exceptions;

public class CarroExistente extends Exception {

    public CarroExistente(){
        super("Carro já registado!");
    }

}