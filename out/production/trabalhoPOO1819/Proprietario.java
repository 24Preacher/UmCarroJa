 

import java.time.LocalDate;
import java.util.*;
import java.lang.Cloneable;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

/**
 * Classe que armazena a informacao de um Proprietario.
 */
public class Proprietario extends Utilizador {


    private int numeroAutomovel;
    private List<Carro> carros;
    private Map<Integer, Aluguer> alugueresP;
    private float classificacao;
    private String informacao;

    /**
     * Construtor sem argumentos
     */
    public Proprietario(){
        super(1,"","","","",LocalDate.now());
        this.numeroAutomovel = 0;
        this.carros = new ArrayList<Carro>();
        this.alugueresP = new TreeMap<Integer, Aluguer>();
        this.classificacao = 0;
        this.informacao = "";
    }

    /**
     * Construtor com argumentos
     */
    public Proprietario(int id, String email, String nome, String password, String morada, LocalDate dataDeNascimento) {
        super(id, email, nome, password, morada, dataDeNascimento);
        this.numeroAutomovel = 0;
        this.carros = null;
        this.alugueresP = null;
        this.classificacao = 0;
        this.informacao = "";
    }

    /**
     * Construtor com argumentos
     */
    public Proprietario(int id, String email, String nome, String password, String morada, LocalDate dataDeNascimento, int numeroAutomovel, List<Carro> carros, Map<Integer, Aluguer> alugueresP, float classificacao, String informacao) {
        super(id, email, nome, password, morada, dataDeNascimento);
        this.numeroAutomovel = numeroAutomovel;
        this.carros = carros;
        this.alugueresP = alugueresP;
        this.classificacao = classificacao;
        this.informacao = informacao;
    }

    /**
     * Atualizar a superclasse Utilizador com o valor u
     */
    public Proprietario(Utilizador u, int numeroAutomovel, List<Carro> carros, Map<Integer, Aluguer> alugueresP, float classificacao, String informacao) {
        super(u);
        this.numeroAutomovel = numeroAutomovel;
        this.carros = carros;
        this.alugueresP = alugueresP;
        this.classificacao = classificacao;
        this.informacao = informacao;
    }

    /**
     * Construtor com argumentos
     */
    public Proprietario(int numeroAutomovel, List<Carro> carros, Map<Integer, Aluguer> alugueresP, float classificacao, String informacao) {
        this.numeroAutomovel = numeroAutomovel;
        this.carros = carros;
        this.alugueresP = alugueresP;
        this.classificacao = classificacao;
        this.informacao = informacao;
    }

    /**
     * Construtor com outro Proprietário.
     * p    Proprietário a copiar
     */
    public Proprietario ( Proprietario p ) {
        this.numeroAutomovel = p.numeroAutomovel;
        ArrayList carros = new ArrayList<Carro>();
        for( Carro carro : p.carros)
            carros.add(carro.clone());
        this.carros =carros;
        this.setAlugueresP(p.alugueresP);
        this.classificacao = p.classificacao;
        this.informacao = p.informacao;
    }

    /**
     * Retorna o número do automóvel
     */
    public int getNumeroAutomovel() {
        return this.numeroAutomovel;}

    /**
     * Retorna a lista de carros
     */
    public List<Carro> getCarros() {
        return carros;
    }

    /**
     * Retorna os alugueres
     */
    public Map<Integer, Aluguer> getAluguer(){
        Map<Integer, Aluguer> aux = new HashMap<>();
        for(Map.Entry<Integer, Aluguer> e: alugueresP.entrySet())
            aux.put(e.getKey(),e.getValue().clone());
            return aux;
        }

    /**
     * Retorna a classificação do proprietário
     */
    public float getClassificacao() {
        return this.classificacao;
    }

    /**
     * Retorna a informação do proprietário
     */
    public String getInformacao() {
        return this.informacao;
    }

    /**
     * Método que altera o número de um automóvel
     */
    public void setNumeroAutomovel(int numeroAutomovel) {
        this.numeroAutomovel = numeroAutomovel;
    }

    /**
     * Método que altera os alugueres
     */
    public void setAlugueresP(Map<Integer, Aluguer> alugueresP) {
        Map aluguer_inserir = new HashMap<Integer,Aluguer>();
        for( int id_aluguer : alugueresP.keySet()){
            aluguer_inserir.put(id_aluguer,alugueresP.get(id_aluguer).clone());
        }
        this.alugueresP = aluguer_inserir;
    }

    /**
     * Método que altera os carros
     */
    public void setCarros(List<Carro> carros) {
        this.carros = carros;
    }

    /**
     * Método que altera a classificação de um proprietário
     */
    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
    }

    /**
     * Método que altera a informação de um proprietário
     */
    public void setInformacao(String informacao) {
        this.informacao = informacao;
    }


    /**
     * Método equal do objeto.
     * Retorna o Booelan que verifica se o objeto é igual
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Proprietario that = (Proprietario) o;
        return numeroAutomovel == that.numeroAutomovel &&
                Float.compare(that.classificacao, classificacao) == 0 &&
                Objects.equals(carros, that.carros) &&
                Objects.equals(alugueresP, that.alugueresP) &&
                Objects.equals(informacao, that.informacao);
    }

    /**
     * Método toString do objeto.
     * Retorna o objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Proprietario{");
        sb.append("numeroAutomovel=").append(numeroAutomovel);
        sb.append(", carros=").append(carros);
        sb.append(", alugueresP=").append(alugueresP);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", informacao='").append(informacao).append('\'');
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que clona este objeto.
     * Retorna o clone do objeto
     */
    public Proprietario clone()  {
        return new Proprietario(this);
    }
}
