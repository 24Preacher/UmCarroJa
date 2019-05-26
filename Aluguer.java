import java.time.LocalDate;
import java.util.Objects;

/**
 * Classe que armazena a informacao de um Aluguer.
 */
public class Aluguer {

    private int idAluguer;
    private int idProprietario;
    private int idCliente;
    private int idCarro;
    private LocalDate dataInicio;
    private LocalDate dataFinal;
    private float localInicio;
    private float destino;
    private float fatura;
    private float tempoViagem;
    private float meteorologia; //0 a 5 em termos de estar pessimo tempo até otimo tempo
    private float percurso; //classificacao vai ter estes 3 fatores acima, inclusive. 0 a 5 em termos de transito

    /**
     * Construtor sem argumentos
     */
    public Aluguer(){
        this.idAluguer = 1;
        this.idProprietario = 1;
        this.idCliente = 1;
        this.idCarro = 1;
        this.dataInicio = LocalDate.now();
        this.dataFinal = LocalDate.now();
        this.localInicio = 0;
        this.destino = 0;
        this.fatura = 0;
        this.tempoViagem = 0;
        this.meteorologia = 0;
        this.percurso = 0;
    }

    /**
     * Construtor com argumentos
     */
    public Aluguer(int idAluguer, int idProprietario, int idCliente, int idCarro, LocalDate dataInicio, LocalDate dataFinal, float localInicio, float destino, float fatura, float tempoViagem, float meteorologia, float percurso) {
        this.idAluguer = idAluguer;
        this.idProprietario = idProprietario;
        this.idCliente = idCliente;
        this.idCarro = idCarro;
        this.dataInicio = dataInicio;
        this.dataFinal = dataFinal;
        this.localInicio = localInicio;
        this.destino = destino;
        this.fatura = fatura;
        this.tempoViagem = tempoViagem;
        this.meteorologia = meteorologia;
        this.percurso = percurso;
    }
    /**
     * Construtor com outro Aluguer.
     * a    Fatura a copiar
     */
    public Aluguer (Aluguer a){
        this.idAluguer = a.idAluguer;
        this.idProprietario = a.idProprietario;
        this.idCliente = a.idCliente;
        this.idCarro = a.idCarro;
        this.dataInicio = a.dataInicio;
        this.dataFinal = a.dataFinal;
        this.localInicio = a.localInicio;
        this.destino = a.destino;
        this.fatura = a.fatura;
        this.tempoViagem = a.tempoViagem;
        this.meteorologia = a.meteorologia;
        this.percurso = a.percurso;
    }


    /**
     * Retorna  Id do aluger
     */
    public int getIdAluguer() {
        return this.idAluguer;
    }


    /**
     * Retorna  Id do proprietário
     */
    public int getIdProprietario() {
        return this.idProprietario;
    }


    /**
     * Retorna  Id do cliente
     */
    public int getIdCliente() {
        return this.idCliente;
    }

    /**
     * Retorna  Id do carro
     */
    public int getIdCarro() {
        return this.idCarro;
    }

    /**
     * Retorna  a data inicial do aluguer
     */
    public LocalDate getDataInicio() {
        return this.dataInicio;
    }

    /**
     * Retorna  a data final do aluguer
     */
    public LocalDate getDataFinal() {
        return this.dataFinal;
    }

    /**
     * Retorna  o local inicial do aluguer
     */
    public float getLocalInicio() {
        return this.localInicio;
    }

    /**
     * Retorna  o destino durante o aluguer
     */
    public float getDestino() {
        return this.destino;
    }

    /**
     * Retorna  a fatura do aluguer
     */
    public float getFatura() {
        return this.fatura;
    }

    /**
     * Retorna  tempo de viagem do aluguer
     */
    public float getTempoViagem() {
        return this.tempoViagem;
    }

    /**
     * Retorna a metereologia durante aluguer
     */
    public float getmeteorologia() {
        return this.meteorologia;
    }

    /**
     * Retorna  o percurso durante o aluguer
     */
    public float getPercurso() {
        return this.percurso;
    }

    /**
     * Retorna  o local inicial do aluguer
     */
    public void setIdAluguer(int idAluguer) {
        this.idAluguer = idAluguer;
    }

    /**
     * Método que altera o id de um proprietario
     */
    public void setIdProprietario(int idProprietario) {
        this.idProprietario = idProprietario;
    }

    /**
     * Método que altera o id de um cliente
     */
    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    /**
     * Método que altera o id de um carro
     */
    public void setIdCarro(int idCarro) {
        this.idCarro = idCarro;
    }

    /**
     * Método que altera a data inicial do aluguer
     */
    public void setDataInicio(LocalDate dataInicio) {
        this.dataInicio = dataInicio;
    }

    /**
     * Método que altera a data final do aluguer
     */
    public void setDataFinal(LocalDate dataFinal) {
        this.dataFinal = dataFinal;
    }

    /**
     * Método que altera o local inicial do aluguer
     */
    public void setLocalInicio(float localInicio) {
        this.localInicio = localInicio;
    }

    /**
     * Método que altera ao destino durante o aluguer
     */
    public void setDestino(float destino) {
        this.destino = destino;
    }

    /**
     * Método que altera a fatura do aluguer
     */
    public void setFatura(float fatura) {
        this.fatura = fatura;
    }

    /**
     * Método que altera o tempo de viagem do aluguer
     */
    public void setTempoViagem(float tempoViagem) {
        this.tempoViagem = tempoViagem;
    }

    /**
     * Método que altera a metereologia durante o aluguer aluguer
     */
    public void setmeteorologia(float meteorologia) {
        this.meteorologia = meteorologia;
    }

    /**
     * Método que altera o percurso durante aluguer
     */
    public void setPercurso(float percurso) {
        this.percurso = percurso;
    }

    /**
     * Método equal do objeto.
     * Retorna o Booelan que verifica se o objeto é igual
     */
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Aluguer aluguer = (Aluguer) o;
        return idAluguer == aluguer.idAluguer &&
                idProprietario == aluguer.idProprietario &&
                idCliente == aluguer.idCliente &&
                idCarro == aluguer.idCarro &&
                Float.compare(aluguer.localInicio, localInicio) == 0 &&
                Float.compare(aluguer.destino, destino) == 0 &&
                Float.compare(aluguer.fatura, fatura) == 0 &&
                Float.compare(aluguer.tempoViagem, tempoViagem) == 0 &&
                Float.compare(aluguer.meteorologia, meteorologia) == 0 &&
                Float.compare(aluguer.percurso, percurso) == 0 &&
                Objects.equals(dataInicio, aluguer.dataInicio) &&
                Objects.equals(dataFinal, aluguer.dataFinal);
    }

    /**
     * Método toString do objeto.
     * Retorna o objeto em modo string
     */
    public String toString() {
        final StringBuilder sb = new StringBuilder("Aluguer{");
        sb.append("idAluguer=").append(idAluguer);
        sb.append(", idProprietario=").append(idProprietario);
        sb.append(", idCliente=").append(idCliente);
        sb.append(", idCarro=").append(idCarro);
        sb.append(", dataInicio=").append(dataInicio);
        sb.append(", dataFinal=").append(dataFinal);
        sb.append(", localInicio=").append(localInicio);
        sb.append(", destino=").append(destino);
        sb.append(", fatura=").append(fatura);
        sb.append(", tempoViagem=").append(tempoViagem);
        sb.append(", meteorologia=").append(meteorologia);
        sb.append(", percurso=").append(percurso);
        sb.append('}');
        return sb.toString();
    }

    /**
     * Método que clona este objeto.
     * Retorna o clone do objeto
     */
    public Aluguer clone(){
        return new Aluguer(this);
    }
}