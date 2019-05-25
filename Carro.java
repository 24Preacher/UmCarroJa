 


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe que armazena a informacao de um Carro.
 */
public class Carro {

    private String matricula;
    private float deposito;
    private int nifProprietario;
    private float localizacaoCX;
    private float localizacaoCY;
    private float precoKm;
    private float consumoKm;
    private boolean disponivel;
    private int tipo;
    private float velocidade;
    private float classificacao;
    private Map<Integer, Aluguer> alugueresCarro;

    /**
     * Construtor sem argumentos
     */
    public Carro(){
        this.matricula = "";
        this.deposito = 0;
        this.nifProprietario = 1;
        this.localizacaoCX = 0;
        this.localizacaoCY = 0;
        this.precoKm = 0;
        this.consumoKm = 0;
        this.disponivel = true;
        this.tipo = 0;
        this.velocidade = 0;
        this.classificacao = 0;
        this.alugueresCarro = new HashMap<Integer, Aluguer>();

    }

    /**
     * Construtor com argumentos
     */
    public Carro(String matricula, float deposito, int nifProprietario, float localizacaoCX, float localizacaoCY, float precoKm, float consumoKm, boolean disponivel, int tipo, float velocidade, float classificacao, Map<Integer, Aluguer> alugueresCarro) {
        this.matricula = matricula;
        this.deposito = deposito;
        this.nifProprietario = nifProprietario;
        this.localizacaoCX = localizacaoCX;
        this.localizacaoCY = localizacaoCY;
        this.precoKm = precoKm;
        this.consumoKm = consumoKm;
        this.disponivel = disponivel;
        this.tipo = tipo;
        this.velocidade = velocidade;
        this.classificacao = classificacao;
        this.alugueresCarro = alugueresCarro;

    }

    /**
     * Construtor com outro Carro.
     * r    Carro a copiar
     */
    public Carro (Carro r){
        this.matricula = r.matricula;
        this.deposito = r.deposito;
        this.nifProprietario = r.nifProprietario;
        this.localizacaoCX = r.localizacaoCX;
        this.localizacaoCY = r.localizacaoCY;
        this.precoKm = r.precoKm;
        this.consumoKm = r.consumoKm;
        this.disponivel = r.disponivel;
        this.tipo = r.tipo;
        this.velocidade = r.velocidade;
        this.classificacao = r.classificacao;
        this.setAlugueresCarro(r.alugueresCarro);

    }


    /**
     * Retorna o id de um carro
     */
    public String getMatricula() {
        return this.matricula;
    }


    /**
     * Retorna o depósito de um carro
     */
    public float getDeposito() {
        return this.deposito;
    }


    /**
     * Retorna o id de um proprietário
     */
    public int nifProprietario() {
        return this.nifProprietario;
    }


    /**
     * Retorna a localizaçãoCX de um carro
     */
    public float getLocalizacaoCX() {
        return this.localizacaoCX;
    }


    /**
     * Retorna a localizaçãoCY de um carro
     */
    public float getLocalizacaoCY() {
        return this.localizacaoCY;
    }


    /**
     * Retorna o preço/KM de um carro
     */
    public float getPrecoKm() {
        return this.precoKm;
    }


    /**
     * Retorna o consumo/KM  de um carro
     */
    public float getConsumoKm() {
        return this.consumoKm;
    }


    /**
     * Retorna a disponibilidade de um carro
     */
    public boolean isDisponivel() {
        return this.disponivel;
    }


    /**
     * Retorna o tipo de um carro
     */
    public int getTipo() {
        return this.tipo;
    }


    /**
     * Retorna a velocidade de um carro
     */
    public float getVelocidade() {
        return this.velocidade;
    }

    /**
     * Retorna a classificação de um carro
     */
    public float getClassificacao() {
        return this.classificacao;
    }


    /**
     * Retorna a os alugueres de carros
     */
    public Map<Integer, Aluguer> getAlugueresCarro() {
        Map<Integer, Aluguer> aux = new HashMap<>();
        
        for(Map.Entry<Integer, Aluguer> e: alugueresCarro.entrySet())
            aux.put(e.getKey(),e.getValue().clone());
            
            return aux;
    }

    /**
     * Método que altera o id de um carro
     */
    public void setMatricula(String matricula) { this.matricula = matricula;
    }

    /**
     * Método que altera o valor do deposito de um carro
     */
    public void setDeposito(float deposito) {
        this.deposito = deposito;
    }

    /**
     * Método que altera o id de um proprietario
     */
    public void setNifProprietario(int nifProprietario) {
        this.nifProprietario = nifProprietario;
    }

    /**
     *Método que altera a localizacaoCX de um carro
     */
    public void setLocalizacaoCX(float localizacaoCX) {
        this.localizacaoCX = localizacaoCX;
    }

    /**
     *Método que altera a localizacaoCY de um carro
     */
    public void setLocalizacaoCY(float localizacaoCY) {
        this.localizacaoCY = localizacaoCY;
    }

    /**
     *Método que altera o Preço/KM de um carro
     */
    public void setPrecoKm(float precoKm) {
        this.precoKm = precoKm;
    }

    /**
     *Método que altera o Consumo/KM de um carro
     */
    public void setConsumoKm(float consumoKm) {
        this.consumoKm = consumoKm;
    }

    /**
     *Método que altera a disponibilidade de um carro
     */
    public void setDisponivel(boolean disponivel) {
        this.disponivel = disponivel;
    }

    /**
     *Método que altera o tipo de um carro
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     *Método que altera a velocidade de um carro
     */
    public void setVelocidade(float velocidade) {
        this.velocidade = velocidade;
    }

    /**
     *Método que altera a classificação de um carro
     */
    public void setClassificacao(float classificacao) {
        this.classificacao = classificacao;
    }

    /**
     *Método que altera os alugueres de carros
     */
    public void setAlugueresCarro(Map<Integer, Aluguer> alugueresCarro) {
        Map aluguer_inserir = new HashMap<Integer,Aluguer>();
        for( int id_aluguer : alugueresCarro.keySet()){
            aluguer_inserir.put(id_aluguer,alugueresCarro.get(id_aluguer).clone());
        }
        this.alugueresCarro = aluguer_inserir;
    }

    /**
     * Método toString do objeto.
     * Retorna o objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro{");
        sb.append("matricula=").append(matricula);
        sb.append(", deposito=").append(deposito);
        sb.append(", nifProprietario=").append(nifProprietario);
        sb.append(", localizacaoCX=").append(localizacaoCX);
        sb.append(", localizacaoCY=").append(localizacaoCY);
        sb.append(", precoKm=").append(precoKm);
        sb.append(", consumoKm=").append(consumoKm);
        sb.append(", disponivel=").append(disponivel);
        sb.append(", tipo=").append(tipo);
        sb.append(", velocidade=").append(velocidade);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", alugueresCarro=").append(alugueresCarro);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método equal do objeto.
     * Retorna o Booelan que verifica se o objeto é igual
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carro carro = (Carro) o;
        return Objects.equals(matricula, carro.matricula) &&
                Float.compare(carro.deposito, deposito) == 0 &&
                nifProprietario == carro.nifProprietario &&
                Float.compare(carro.localizacaoCX, localizacaoCX) == 0 &&
                Float.compare(carro.localizacaoCY, localizacaoCY) == 0 &&
                Float.compare(carro.precoKm, precoKm) == 0 &&
                Float.compare(carro.consumoKm, consumoKm) == 0 &&
                disponivel == carro.disponivel &&
                tipo == carro.tipo &&
                Float.compare(carro.velocidade, velocidade) == 0 &&
                Float.compare(carro.classificacao, classificacao) == 0 &&
                Objects.equals(alugueresCarro, carro.alugueresCarro);
    }

    /**
     * Método que clona este objeto.
     * Retorna o clone do objeto
     */
    public Carro clone(){
        return new Carro(this);
    }
}

