import java.util.List;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.InputMismatchException;

public class Menu{
    private List<String> opcoes;
    private int op;

    /**
     * Construtor para os objetos desta classe
     */
    public Menu(String[] opcoes) {
        this.opcoes = new ArrayList<String>();
        for(String op: opcoes)
            this.opcoes.add(op);
        this.op = 0;
    }

    /**
     * Ler uma opção do menu
     */
    private int lerOpcao() {
        int op;
        Scanner is = new Scanner(System.in);

        System.out.print("Opção: ");
        try {
            op = is.nextInt();
        }
        catch (InputMismatchException e) { // Não foi inscrito um int
            op = -1;
        }
        if (op<0 || op>this.opcoes.size()) {
            System.out.println("Opção Inválida!!!");
            op = -1;
        }
        return op;
    }

    /**
     * Aprensenta o menu a principal da aplicação e le uma opção
     */
    public void executaMenu() {
        do {
            showMenu();
            this.op = lerOpcao();
        } while (this.op == -1);
    }

    /**
     * Mostra o menu da principal da aplicação
     */
    private void showMenu() {
        for (int i=0; i<this.opcoes.size(); i++) {
            System.out.print((i+1));
            System.out.print(" - ");
            System.out.println(this.opcoes.get(i));
        }
        if(!opcoes.get(this.opcoes.size()-1).equals("Logout"))
            System.out.println("0 - Sair");
    }

    /**
     * Devolve a opção selecionada
     * @return opção
     */
    public int getOp() {
        return this.op;
    }
}