import Exceptions.UtilizadorExistente;

import java.io.IOException;
import java.time.LocalDate;
import java.util.Scanner;

public class UmCarroJaApp {
    private UmCarroJaApp() {}
    private static UmCarroJa umCarroJa = new UmCarroJa();
    private static Menu menuInicial;

    public static void main(String[]args) {
        System.out.println("Bem Vindo!");

        carregaMenu();
        executaMenuInicial();
        try{
            umCarroJa.gravaEstado();
        }
        catch (IOException e){
            System.out.println("Erro ao guardar");
        }
    }

    private static void carregaMenu() {
        String[] inicial = {"Login", "Registar Utilizador"};

        menuInicial = new Menu(inicial);
    }

    private static void executaMenuInicial(){
        do{
            menuInicial.executaMenu();
            switch (menuInicial.getOp()){
                //case 1: login(); break;
                case 2: registaUtilizador();
            }
        } while (menuInicial.getOp() != 0);
    }

    private static void registaUtilizador() {

        Scanner sc = new Scanner(System.in);
        Utilizador u = null;
        int n, op;
        String nif, email, nome, password, morada;
        LocalDate dataDeNascimento;

        System.out.println("NIF: ");
        nif = sc.nextLine();

        System.out.println("Email: ");
        email = sc.nextLine();

        System.out.println("Nome: ");
        nome = sc.nextLine();

        System.out.println("Password: ");
        password = sc.nextLine();

        System.out.println("Morada: ");
        morada = sc.nextLine();

        System.out.println("Data de Nascimento (Neste formato AAAA-MM-DD)");
        dataDeNascimento = LocalDate.parse(sc.nextLine());

        System.out.println("1 -> Cliente");
        System.out.println("2 -> Proprietário");
        op = sc.nextInt();
        n = Integer.parseInt(nif);

        if (op == 1) {
            u = new Cliente(n, email, nome, password, morada, dataDeNascimento);
            try {
                umCarroJa.registaUtilizador(u);
            } catch (UtilizadorExistente utilizadorExistente) {
                utilizadorExistente.printStackTrace();
            } finally {
                sc.close();
            }
        } else if (op == 2){
            u = new Proprietario(n, email, nome, password, morada, dataDeNascimento);
            try {
                umCarroJa.registaUtilizador(u);
            } catch (UtilizadorExistente utilizadorExistente) {
                utilizadorExistente.printStackTrace();
            } finally {
                sc.close();
            }
        } else {
            System.out.println("Registo inválido");
        }
    }
}

