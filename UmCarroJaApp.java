import Exceptions.CarroExistente;
import Exceptions.CarroInexistente;
import Exceptions.DadosIncorretos;
import Exceptions.UtilizadorExistente;

import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.TreeMap;
import java.lang.Math;

public class UmCarroJaApp implements Serializable {
    private UmCarroJaApp() {
    }

    private static UmCarroJa umCarroJa = new UmCarroJa();
    private static Menu menuInicial, menuCliente, menuProprietario, menuAluguerTipo, menuAluguerCriterio;

    public static void main(String[] args) {
        Cliente c = new Cliente(2, "pedro98medeiros@gmail.com", "Preacher", "preacher", "Rua dos Peoes",LocalDate.parse("1998-09-18"), 0, 0, new TreeMap<Integer, Aluguer>());
        Proprietario p2 = new Proprietario(1,"zet", "Zet", "zet", "Rua dos Peoes",LocalDate.parse("1998-09-18"), 0, new ArrayList<Carro>(),new TreeMap<Integer, Aluguer>(),0,"Olá");


        Utilizador u = (Utilizador) c;
        Utilizador u2 = (Utilizador) p2;
        try {
            umCarroJa.registaUtilizador(u);
            umCarroJa.registaUtilizador(u2);
        } catch (UtilizadorExistente e){
            System.out.println("fail registar Preacher");
        }

        System.out.println("Bem Vindo!");
        carregaMenu();
        carregaFicheiro();
        //carregaEstado();

        executaMenuInicial();
/*
        try {
            umCarroJa.gravaEstado();
        } catch (IOException e) {
            System.out.println("Erro ao guardar");
        }*/
    }
    private static void carregaFicheiro(){
        try {
            FileReader fr = new FileReader("/home/preacher/UmCarroJa/UmCarroJa.data");

            int i;
            while ((i = fr.read()) != -1)
                System.out.print((char) i);
        } catch (IOException e) {
            System.out.println("Não encontrou ficheiro");
        }
    }
    private static void carregaEstado() {
        try {
            umCarroJa = UmCarroJa.initApp();
        }
        catch(IOException e) {
            umCarroJa = new UmCarroJa();
            System.out.println("Não foi possível ler os dados guardados!\nErro de leitura!");
        }
        catch(ClassNotFoundException e) {
            umCarroJa = new UmCarroJa();
            System.out.println("Não foi possível ler os dados guardados!\nFicheiro com formato desconhecido!");
        }
        catch(ClassCastException e) {
            umCarroJa = new UmCarroJa();
            System.out.println("Não foi possível ler os dados guardados!\nErro de formato!");
        }
    }
    
    private static void carregaMenu() {
        String[] inicial = {"Login", "Registar Utilizador"};
        String[] cliente = {"Consultar perfil", "Alterar perfil", "Alugar um carro", "Alterar localização", "Historial de Alugueres"};
        String[] proprietario = {"Consultar perfil", "Alterar perfil", "Registar um carro", "Alterar deposito de um carro", "Alterar preço/km de um carro", "Consultar classificação", "Historial de Alugueres"};
        String[] aluguertipo = {"Alugar um carro a gasolina", "Alugar um carro elétrico", "Alugar um carro híbrido"};
        String[] aluguercriterio = {"Alugar por distancia", "Alugar por preço", "Alugar por consumo"};
        menuInicial = new Menu(inicial);
        menuCliente = new Menu(cliente);
        menuProprietario = new Menu(proprietario);
        menuAluguerTipo = new Menu(aluguertipo);
        menuAluguerCriterio = new Menu(aluguercriterio);
    }

    private static void executaMenuInicial() {
        do {
            menuInicial.executaMenu();
            switch (menuInicial.getOp()) {
                case 1:
                    login();
                    break;
                case 2:
                    registaUtilizador();
            }
        } while (menuInicial.getOp() != 0);
    }

    private static void executaMenuCliente() {
        do {
            menuCliente.executaMenu();
            switch (menuCliente.getOp()) {
                case 1:
                    consultaPerfil();
                    break;
                case 2:
                    alteraPerfil();
                    break;
                case 3: alugarCarro(); break;
                //case 5: historialAlugueres(); break;
                case 0:
                    logout();
                    break;
            }
        } while (menuCliente.getOp() != 0);
    }

    private static void executaMenuProprietario() {
        do {
            menuProprietario.executaMenu();
            switch (menuProprietario.getOp()) {
                case 1:
                    consultaPerfil();
                    break;
                case 2:
                    alteraPerfil();
                    break;
                case 3:
                    registaCarro();
                    break;
                case 4:
                    alteraDeposito();
                    break;
                case 5:
                    alteraPrecoKm();
                    break;
                case 6: consultarClassificacao(); break;
                //case 7: historialAlugueres(); break;
                case 0:
                    logout();
                    break;
            }
        } while (menuProprietario.getOp() != 0);
    }

    private static void executaMenuAluguerTipo() {
        do {
            menuAluguerTipo.executaMenu();
            switch (menuAluguerTipo.getOp()) {
                //case 1: alugaGasolina(); break;
                //case 2: alugaEletrico(); break;
                //case 3: alugaHibrido(); break;
            }
        } while (menuAluguerTipo.getOp() != 0);
    }

    private static void login() {
        Scanner sc = new Scanner(System.in);
        String nif, password;
        System.out.println("NIF: ");
        nif = sc.nextLine();
        System.out.println("Password: ");
        password = sc.nextLine();
        int n = Integer.parseInt(nif);
        try {
            umCarroJa.login(n, password);
        } catch (DadosIncorretos d) {
            System.out.println(d.getMessage());
        }
        switch (umCarroJa.getTipoUtilizador()) {
            case 0:
                executaMenuCliente();
                break;
            case 1:
                executaMenuProprietario();
                break;
        }
    }

    private static void logout() {
        umCarroJa.logout();
    }

    private static void registaUtilizador() {
        Scanner sc = new Scanner(System.in);
        Utilizador u;
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
            }
        } else if (op == 2) {
            u = new Proprietario(n, email, nome, password, morada, dataDeNascimento);
            try {
                umCarroJa.registaUtilizador(u);
            } catch (UtilizadorExistente utilizadorExistente) {
                utilizadorExistente.printStackTrace();
            }
        } else {
            System.out.println("Registo inválido");
        }
    }

    private static void consultaPerfil() {
        System.out.print("NIF: ");
        System.out.println(umCarroJa.getUtilizador().getNif());
        System.out.print("Email: ");
        System.out.println(umCarroJa.getUtilizador().getEmail());
        System.out.print("Nome: ");
        System.out.println(umCarroJa.getUtilizador().getNome());
        System.out.print("Password: ");
        System.out.println(umCarroJa.getUtilizador().getPassword());
        System.out.print("Morada: ");
        System.out.println(umCarroJa.getUtilizador().getMorada());
        System.out.print("Data de nascimento: ");
        System.out.println(umCarroJa.getUtilizador().getDataDeNascimento());
        System.out.println(umCarroJa.getUtilizador());
        //System.out.println(umCarroJa.getUtilizador().getCarro());
    }

    private static void alteraPerfil() {
        Scanner sc = new Scanner(System.in);
        Utilizador u = umCarroJa.getUtilizador();
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

        n = Integer.parseInt(nif);
        u.setNif(n);
        u.setEmail(email);
        u.setNome(nome);
        u.setPassword(password);
        u.setMorada(morada);
        u.setDataDeNascimento(dataDeNascimento);

    }

    private static void registaCarro() {
        Scanner sc = new Scanner(System.in);
        Carro c;
        String matricula;
        float deposito, localizacaoCX, localizacaoCY, precoKm, consumoKm, velocidade;
        int n, tipo, classificacao;
        boolean disponivel;

        System.out.println("Matrícula: (No formato #######) ");
        matricula = sc.nextLine();

        System.out.println("Depósito atual: ");
        deposito = sc.nextFloat();

        System.out.println("Localizacão em X: ");
        localizacaoCX = sc.nextFloat();

        System.out.println("Localizacão em Y: ");
        localizacaoCY = sc.nextFloat();

        System.out.println("Preço por km: ");
        precoKm = sc.nextFloat();

        System.out.println("Consumo por km: ");
        consumoKm = sc.nextFloat();

        System.out.println("Disponível? (true/false) ");
        disponivel = sc.nextBoolean();

        System.out.println("Tipo de carro: ");
        System.out.println("1 - Gasolina | 2 - Elétrico | 3 - Híbrido");
        tipo = sc.nextInt();

        System.out.println("Velocidade média: ");
        velocidade = sc.nextFloat();

        n = umCarroJa.getUtilizador().getNif();
        c = new Carro(matricula, deposito, n, localizacaoCX, localizacaoCY, precoKm, consumoKm, disponivel, tipo, velocidade);
        try {
            umCarroJa.registaCarro(c);
        } catch (CarroExistente carroExistente) {
            carroExistente.printStackTrace();
        }


    }

    private static void alteraDeposito() {
        Scanner sc = new Scanner(System.in);
        Carro c = new Carro();
        List<Carro> carros = new ArrayList<Carro>();
        int i = 1;
        try {
            carros = umCarroJa.getCarros();
            for (Carro a : carros) {
                System.out.println(i + " " + a.getMatricula());
                i++;
            }
        } catch (CarroInexistente e) {
            System.out.println(e.getMessage());
        }

        String escolha;
        float deposito;

        System.out.println("Que carro deseja alterar?");
        escolha = sc.nextLine();
        int e = Integer.parseInt(escolha);

        System.out.println("Depósito atual: ");
        deposito = sc.nextFloat();

        umCarroJa.alteraDeposito(e-1, deposito);
    }
    
    private static void alteraPrecoKm() {
        Scanner sc = new Scanner(System.in);
        Carro c = new Carro();
        List<Carro> carros = new ArrayList<Carro>();
        int i = 1;
        try {
            carros = umCarroJa.getCarros();
            for (Carro a : carros) {
                System.out.println(i + " " + a.getMatricula());
                i++;
            }
        } catch (CarroInexistente e) {
            System.out.println(e.getMessage());
        }

        String escolha;
        float precoKm;

        System.out.println("Que carro deseja alterar?");
        escolha = sc.nextLine();
        int e = Integer.parseInt(escolha);

        System.out.println("Preco/km atual: ");
        precoKm = sc.nextFloat();

        umCarroJa.alteraPrecoKm(e-1, precoKm);
    }

    public static void consultarClassificacao(){
        umCarroJa.consultarClassificacao();
    }

    public static void alugarCarro(){
        Scanner sc = new Scanner(System.in);
        float x1, y1, x2, y2;
        int tipo, criterio;
        double dist;
        String matricula;

        System.out.println("Onde está?");
        System.out.println("X");
        x1 = sc.nextFloat();
        System.out.println("Y");
        y1 = sc.nextFloat();

        System.out.println("Onde deseja ir?");
        System.out.println("X");
        x2 = sc.nextFloat();
        System.out.println("Y");
        y2 = sc.nextFloat();
        
        dist = calcDist(x2,x1,y2,y1);
        System.out.println("Esta a " + dist + " kms do destino.");

        System.out.println("Que tipo de carro quer?");
        System.out.println("1 - Gasolina");
        System.out.println("2 - Elétrico");
        System.out.println("3 - Híbrido");
        tipo = sc.nextInt();
        
        if (tipo == 1) {
            umCarroJa.carros.get(1);
        } 
        else if (tipo == 2) {
            umCarroJa.carros.get(2);
        }
        else if (tipo == 3) {
            umCarroJa.carros.get(3);
        }
        
        System.out.println("Criterio do aluguer?");
        System.out.println("1 - Alugar em funçao da distancia");
        System.out.println("2 - Alugar em funçao do preço");
        System.out.println("3 - Alugar pela matricula");
        criterio = sc.nextInt();
        
        if (tipo == 1) {
            umCarroJa.carros.get(1);
        } 
        else if (tipo == 2) {
            umCarroJa.carros.get(2);
        }
        else if (tipo == 3) {
            System.out.println("Matricula do carro desejado: ");
            matricula = sc.nextLine();
            umCarroJa.carros.get(matricula);
        }
    }
    
    public static double calcDist(float a,float b, float c, float d){
        double dist = Math.sqrt((a-b)*(a-b) + (c-d)*(c-d));
        return dist;
    }
    public static TreeMap<Integer,Carro> ordenaDCarros(TreeMap<Integer, Carro> carros){
        
        return carros;
    }
    public static TreeMap<Integer,Carro> ordenaPCarros(TreeMap<Integer, Carro> carros){
        
        return carros;
    }
}

