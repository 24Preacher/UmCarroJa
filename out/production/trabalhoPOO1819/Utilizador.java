 

import java.io.Serializable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Map;
import java.time.LocalDate;

/**
 * Classe que armazena a informacao de um Utilizador.
 */
public abstract class Utilizador implements Serializable{

    private int nif;
    private String email;
    private String nome;
    private String password;
    private String morada;
    private LocalDate dataDeNascimento;

    /**
     * Construtor sem argumentos
     */
    public Utilizador() {
        this.nif = 0;
        this.email = "";
        this.password = "";
        this.dataDeNascimento =  LocalDate.now();
        this.nome = "";
        this.morada = "";
    }

    /**
     * Construtor com argumentos
     */
    public Utilizador ( int nif, String email, String nome, String password, String morada, LocalDate dataDeNascimento ) {
        this.nif = nif;
        this.nome = nome;
        this.email = email;
        this.password = password;
        this.morada = morada;
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * Construtor com outro Utilizador.
     * u    Utilizador a copiar
     */
    public Utilizador ( Utilizador u) {
        this.nif = u.getNif();
        this.nome = u.getNome();
        this.email = u.getEmail();
        this.password = u.getPassword();
        this.morada = u.getMorada();
        this.dataDeNascimento = u.getDataDeNascimento();
    }

    /**
     * Retorna o id de um utilizador
     */
    public int getNif() {
        return this.nif;
    }

    /**
     * Retorna o nome de um utilizador
     */
    public String getNome() {
        return this.nome;
    }

    /**
     * Retorna a password de um utilizador
     */
    public String getPassword() {
        return this.password;
    }

    /**
     * Retorna a morada de um utilizador
     */
    public String getMorada() {
        return this.morada;
    }

    /**
     * Retorna a data de nascimento de um utilizador
     */
    public LocalDate getDataDeNascimento() {
        return this.dataDeNascimento;
    }

    /**
     * Retorna o email de um utilizador
     */
    public String getEmail() {
        return this.email;
    }

    /**
     * Método que altera o id de um utilizador
     */
    public void setNif(int nif) {
        this.nif = nif;
    }

    /**
     * Método que altera o email de um utilizador
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Método que altera o nome de um utilizador
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Método que altera o id de um utilizador
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * Método que altera a morada de um utilizador
     */
    public void setMorada(String morada) {
        this.morada = morada;
    }

    /**
     * Método que altera a data de nascimento de um utilizador
     */
    public void setDataDeNascimento(LocalDate dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    /**
     * Método equal do objeto
     * Retorna o Booelan que verifica se o objeto é igual
     */
    public boolean equals (Object o ) {
        if ( o == this) return true;
        if ( o == null || o.getClass() != this.getClass() ) return false;
        Utilizador u = (Utilizador) o;
        return this.nif == u.getNif() &&
                this.email.equals(u.getEmail()) &&
                this.morada.equals(u.getMorada()) &&
                this.dataDeNascimento.equals(u.getDataDeNascimento()) &&
                this.nome.equals(u.getNome()) &&
                this.password.equals(u.getPassword());
    }

    /**
     * Método toString do objeto
     * Retorna o objeto em modo string
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Utilizador : [");
        sb.append("Nif: ").append(this.nif);
        sb.append("Nome: ").append(this.nome);
        sb.append("Email: ").append(this.email);
        sb.append("Morada: ").append(this.morada);
        //SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        //String data = formatter.format(this.dataDeNascimento);
        sb.append("Data de Nascimento: ").append(this.dataDeNascimento);
        return sb.toString();
    }

    /**
     * Método que clona este objeto
     */
    public abstract Utilizador clone();
}

