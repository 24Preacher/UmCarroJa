 


import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

/**
 * Classe que armazena a informacao de um Carro.
 */
public class Carro {

    private int idCarro;
    private float deposito;
    private int idProprietario;
    private float localizacaoCX;
    private float localizacaoCY;
    private float precoKm;
    private float consumoKm;
    private float autonomia;
    private String informacao;
    private boolean disponivel;
    private int tipo;
    private float velocidade;
    private float classificacao;
    private Map<Integer, Aluguer> alugueresCarro;
    private float kmPercorridos;
    private int tempoUso;

    /**
     * Construtor sem argumentos
     */
    public Carro(){
        this.idCarro = 1;
        this.deposito = 0;
        this.idProprietario = 1;
        this.localizacaoCX = 0;
        this.localizacaoCY = 0;
        this.precoKm = 0;
        this.consumoKm = 0;
        this.autonomia = 0;
        this.informacao = "";
        this.disponivel = true;
        this.tipo = 0;
        this.velocidade = 0;
        this.classificacao = 0;
        this.alugueresCarro = new HashMap<Integer, Aluguer>();
        this.kmPercorridos = 0;
        this.tempoUso = 0;
    }

    /**
     * Construtor com argumentos
     */
    public Carro(int idCarro, float deposito, int idProprietario, float localizacaoCX, float localizacaoCY, float precoKm, float consumoKm, float autonomia, String informacao, boolean disponivel, int tipo, float velocidade, float classificacao, Map<Integer, Aluguer> alugueresCarro, float faturado, float kmPercorridos, int tempoUso) {
        this.idCarro = idCarro;
        this.deposito = deposito;
        this.idProprietario = idProprietario;
        this.localizacaoCX = localizacaoCX;
        this.localizacaoCY = localizacaoCY;
        this.precoKm = precoKm;
        this.consumoKm = consumoKm;
        this.autonomia = autonomia;
        this.informacao = informacao;
        this.disponivel = disponivel;
        this.tipo = tipo;
        this.velocidade = velocidade;
        this.classificacao = classificacao;
        this.alugueresCarro = alugueresCarro;
        this.kmPercorridos = kmPercorridos;
        this.tempoUso = tempoUso;
    }

    /**
     * Construtor com outro Carro.
     * r    Carro a copiar
     */
    public Carro (Carro r){
        this.idCarro = r.idCarro;
        this.deposito = r.deposito;
        this.idProprietario = r.idProprietario;
        this.localizacaoCX = r.localizacaoCX;
        this.localizacaoCY = r.localizacaoCY;
        this.precoKm = r.precoKm;
        this.consumoKm = r.consumoKm;
        this.autonomia = r.autonomia;
        this.informacao = r.informacao;
        this.disponivel = r.disponivel;
        this.tipo = r.tipo;
        this.velocidade = r.velocidade;
        this.classificacao = r.classificacao;
        this.setAlugueresCarro(r.alugueresCarro);
        this.kmPercorridos = r.kmPercorridos;
        this.tempoUso = r.tempoUso;
    }


    /**
     * Retorna o id de um carro
     */
    public int getIdCarro() {
        return this.idCarro;
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
    public int getIdProprietario() {
        return this.idProprietario;
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
     * Retorna a autonomia de um carro
     */
    public float getAutonomia() {
        return this.autonomia;
    }

    /**
     * Retorna a informação de um carro
     */
    public String getInformacao() {
        return this.informacao;
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
     * Retorna os  de um carro
     */
    public float getKmPercorridos() {
        return this.kmPercorridos;
    }

    /**
     * Retorna a o tempo de uso de um carro
     */
    public int getTempoUso() {
        return this.tempoUso;
    }

    /**
     * Método que altera o id de um carro
     */
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
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
    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
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
     *Método que altera a autonomia de um carro
     */
    public void setAutonomia(float autonomia) {
        this.autonomia = autonomia;
    }

    /**
     *Método que altera a informação de um carro
     */
    public void setInformacao(String informacao) {
        this.informacao = informacao;
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
     *Método que altera os KMs percorridos de um carro
     */
    public void setKmPercorridos(float kmPercorridos) {
        this.kmPercorridos = kmPercorridos;
    }

    /**
     *Método que altera o tempo de uso de um carro
     */
    public void setTempoUso(int tempoUso) {
        this.tempoUso = tempoUso;
    }

    /**
     * Método toString do objeto.
     * Retorna o objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Carro{");
        sb.append("idCarro=").append(idCarro);
        sb.append(", deposito=").append(deposito);
        sb.append(", idProprietario=").append(idProprietario);
        sb.append(", localizacaoCX=").append(localizacaoCX);
        sb.append(", localizacaoCY=").append(localizacaoCY);
        sb.append(", precoKm=").append(precoKm);
        sb.append(", consumoKm=").append(consumoKm);
        sb.append(", autonomia=").append(autonomia);
        sb.append(", informacao='").append(informacao).append('\'');
        sb.append(", disponivel=").append(disponivel);
        sb.append(", tipo=").append(tipo);
        sb.append(", velocidade=").append(velocidade);
        sb.append(", classificacao=").append(classificacao);
        sb.append(", alugueresCarro=").append(alugueresCarro);
        sb.append(", kmPercorridos=").append(kmPercorridos);
        sb.append(", tempoUso=").append(tempoUso);
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
        return idCarro == carro.idCarro &&
                Float.compare(carro.deposito, deposito) == 0 &&
                idProprietario == carro.idProprietario &&
                Float.compare(carro.localizacaoCX, localizacaoCX) == 0 &&
                Float.compare(carro.localizacaoCY, localizacaoCY) == 0 &&
                Float.compare(carro.precoKm, precoKm) == 0 &&
                Float.compare(carro.consumoKm, consumoKm) == 0 &&
                Float.compare(carro.autonomia, autonomia) == 0 &&
                disponivel == carro.disponivel &&
                tipo == carro.tipo &&
                Float.compare(carro.velocidade, velocidade) == 0 &&
                Float.compare(carro.classificacao, classificacao) == 0 &&
                Float.compare(carro.kmPercorridos, kmPercorridos) == 0 &&
                Objects.equals(informacao, carro.informacao) &&
                Objects.equals(alugueresCarro, carro.alugueresCarro) &&
                Objects.equals(tempoUso, carro.tempoUso);
    }

    /**
     * Método que clona este objeto.
     * Retorna o clone do objeto
     */
    public Carro clone(){
        return new Carro(this);
    }
}

