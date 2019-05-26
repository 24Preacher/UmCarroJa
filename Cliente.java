 

import java.time.LocalDate;
import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;
import java.util.HashMap;

/**
 * Classe que armazena a informacao de um Cliente.
 */
public class Cliente extends Utilizador {

        private float localizacaoX;
        private float localizacaoY;
        private Map<Integer, Aluguer> alugueresCliente;

    /**
     * Construtor sem argumentos
     */
    public Cliente() {
        super(1,"","","","",LocalDate.now());
        this.localizacaoX = 0;
        this.localizacaoY = 0;
        this.alugueresCliente = new TreeMap<Integer, Aluguer>();
    }

    /**
     * Construtor com argumentos
     */
    public Cliente(int id, String email, String nome, String password, String morada, LocalDate dataDeNascimento) {
        super(id, email, nome, password, morada, dataDeNascimento);
        this.localizacaoX = 0;
        this.localizacaoY = 0;
        this.alugueresCliente = new TreeMap<Integer, Aluguer>();
    }
    /**
     * Construtor com argumentos
     */
    public Cliente(int id, String email, String nome, String password, String morada, LocalDate dataDeNascimento, float localizacaoX, float localizacaoY, Map<Integer, Aluguer> alugueresCliente) {
        super(id, email, nome, password, morada, dataDeNascimento);
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.alugueresCliente = alugueresCliente;
    }
    /**
     * Atualizar a superclasse Utilizador com o valor u
     */
    public Cliente(Utilizador u, float localizacaoX, float localizacaoY, Map<Integer, Aluguer> alugueresCliente) {
        super(u);
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.alugueresCliente = alugueresCliente;
    }

    /**
     * Construtor com argumentos
     */
    public Cliente(float localizacaoX, float localizacaoY, Map<Integer, Aluguer> alugueresCliente) {
        this.localizacaoX = localizacaoX;
        this.localizacaoY = localizacaoY;
        this.alugueresCliente = alugueresCliente;
    }

    /**
     * Construtor com outro Cliente.
     * r    Cliente a copiar
     */
    public Cliente ( Cliente c ) {
        this.localizacaoX = c.localizacaoX;
        this.localizacaoY = c.localizacaoY;
        this.setAlugueresCliente(c.alugueresCliente);
    }

    /**
     * Retorna a localizaçãoX do cliente
     */
    public float getLocalizacaoX() {
        return this.localizacaoX;
    }

    /**
     * Retorna a localizaçãoY do cliente
     */
    public float getLocalizacaoY() {
        return this.localizacaoY;
    }

    /**
     * Retorna os alugueres dos clientes
     */
    public Map<Integer, Aluguer> getAlugueresClientes(){
    
        Map<Integer, Aluguer> aux = new TreeMap<>();
        
        for(Map.Entry<Integer, Aluguer> e: alugueresCliente.entrySet())
            aux.put(e.getKey(),e.getValue().clone());
            
            return aux;
    }

    /**
     * Método que altera a localizaçãoX de um cliente
     */
    public void setLocalizacaoX(float localizacaoX) {
        this.localizacaoX = localizacaoX;
    }

    /**
     * Método que altera a localizaçãoY de um cliente
     */
    public void setLocalizacaoY(float localizacaoY) {
        this.localizacaoY = localizacaoY;
    }

    /**
     * Método que altera os alugueres de clientes
     */
    public void setAlugueresCliente(Map<Integer, Aluguer> alugueresCliente) {
        
        Map aluguer_inserir = new TreeMap<Integer,Aluguer>();
        for( int id_aluguer : alugueresCliente.keySet()){
            aluguer_inserir.put(id_aluguer,alugueresCliente.get(id_aluguer).clone());
        }
        this.alugueresCliente = aluguer_inserir;
    }

    /**
     * Método equal do objeto.
     * Retorna o Booelan que verifica se o objeto é igual
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Cliente cliente = (Cliente) o;
        return Float.compare(cliente.localizacaoX, localizacaoX) == 0 &&
                Float.compare(cliente.localizacaoY, localizacaoY) == 0 &&
                Objects.equals(alugueresCliente, cliente.alugueresCliente);
    }

    /**
     * Método toString do objeto.
     * Retorna o objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder();
        sb.append("LocalizacaoX: ").append(localizacaoX).append("\n");
        sb.append("LocalizacaoY: ").append(localizacaoY).append("\n");
        sb.append("Alugueres do cliente: ").append(alugueresCliente).append("\n");
        return sb.toString();
    }

    /**
     * Método que clona este objeto.
     * Retorna o clone do objeto
     */
    public Cliente clone()  {
        return new Cliente(this);
    }
}


