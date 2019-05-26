import Exceptions.CarroExistente;
import Exceptions.CarroInexistente;
import Exceptions.DadosIncorretos;
import Exceptions.UtilizadorExistente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UmCarroJa {

    public Map<String, Carro> carros;
    public Map<Integer, Utilizador> utilizadores;
    private Utilizador utilizador;

    public UmCarroJa(){
        this.carros = new HashMap<String, Carro>();
        this.utilizadores = new HashMap<Integer, Utilizador>();
        this.utilizador = null;
    }

    public UmCarroJa(Map<Integer, Carro> c, Map<Integer, Utilizador> u){
        this.utilizador = null;
        this.carros = new HashMap<String, Carro>();
        this.utilizadores = new HashMap<Integer, Utilizador>();
        for (Carro a : c.values())
            this.carros.put(a.getMatricula(), a.clone());
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
            this.carros.put(c.getMatricula(),c);
            Proprietario p = (Proprietario) this.utilizador;
            List<Carro> aux = p.getCarros();
            aux.add(c.clone());
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
        ObjectOutputStream o = new ObjectOutputStream (new FileOutputStream("UmCarroJÁ.data"));
        o.writeObject(this);
        o.flush();
        o.close();
    }

    public List<Carro> getCarros() throws CarroInexistente {
        //if(this.utilizador instanceof Proprietario) {
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
       // }
        else throw new CarroInexistente();
    }

}
