import Exceptions.CarroExistente;
import Exceptions.CarroInexistente;
import Exceptions.DadosIncorretos;
import Exceptions.UtilizadorExistente;

import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UmCarroJa {

    public Map<Integer, Carro> carros;
    public Map<Integer, Utilizador> utilizadores;
    private Utilizador utilizador;

    public UmCarroJa(){
        this.carros = new HashMap<Integer, Carro>();
        this.utilizadores = new HashMap<Integer, Utilizador>();
        this.utilizador = null;
    }

    public UmCarroJa(Map<Integer, Carro> c, Map<Integer, Utilizador> u){
        this.utilizador = null;
        this.carros = new HashMap<Integer, Carro>();
        this.utilizadores = new HashMap<Integer, Utilizador>();
        for (Carro a : c.values())
            this.carros.put(a.getTipo(), a.clone());
        for (Utilizador b : u.values())
            this.utilizadores.put(b.getNif(), b.clone());
    }

    public Utilizador getUtilizador() {
        return this.utilizador;
    }

    public void setCarros(List<Carro> carros) {
        Proprietario p = (Proprietario) this.utilizador;
        p.setCarros(carros);
        this.utilizador = p;
    }

    public void registaUtilizador(Utilizador u) throws UtilizadorExistente {
        if(this.utilizadores.containsKey(u.getNif())){
            throw new UtilizadorExistente();
        }
        else {
            this.utilizadores.put(u.getNif(), u);
        }
    }

    public void registaCarro(Carro c) throws CarroExistente {
        if(this.carros.containsKey(c.getMatricula())){
            throw new CarroExistente();
        }
        else {
            this.carros.put(c.getTipo(),c);
            Proprietario p = (Proprietario) this.utilizador;
            p.addCarro(c);
            System.out.println(carros);
        }
    }

    public void login(int nif, String password) throws DadosIncorretos {
        if(this.utilizadores.containsKey(nif)){
            Utilizador u = utilizadores.get(nif);
            if (password.equals(u.getPassword()))
                this.utilizador = u;
        }
        else throw new DadosIncorretos();
    }

    public void logout(){
        this.utilizador = null;
    }

    public int getTipoUtilizador(){
        if(utilizador instanceof Cliente)
            return 0;
        if(utilizador instanceof Proprietario)
            return 1;
        return 2;
    }
    public void gravaEstado() throws IOException {
        ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("UmCarroJa.data"));
        o.writeObject(this);
        o.flush();
        o.close();
    }
    
    public static UmCarroJa initApp() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("UmCarroJa.data"));
        UmCarroJa ucj = (UmCarroJa) ois.readObject();

        ois.close();
        return ucj;
    }

    public List<Carro> getCarros() throws CarroInexistente {
        Proprietario p = (Proprietario) this.utilizador;
        if (p.getCarros().size() != 0) {
             List<Carro> c = new ArrayList<Carro>();
                for (Carro i : p.getCarros()) {
                    Carro novo = (Carro) i;
                    c.add(novo.clone());
                }
             this.utilizador = p;
             return c;
        }
        else throw new CarroInexistente();
    }

    public void alteraDeposito(int n, float deposito){
        Proprietario p = (Proprietario) this.utilizador;
        p.altDeposito(n,deposito);
    }
    
    public void alteraPrecoKm(int n, float precoKm){
        Proprietario p = (Proprietario) this.utilizador;
        p.altPrecoKm(n,precoKm);
    }

    public void consultarClassificacao(){
        Proprietario p = (Proprietario) this.utilizador;
        System.out.println(p.calClassificacao());
    }

    public Carro carroTipo(int n){
        return this.carros.get(n);
    }
}