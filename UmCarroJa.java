import Exceptions.DadosIncorretos;
import Exceptions.UtilizadorExistente;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.HashMap;
import java.util.Map;

public class UmCarroJa {

    private Map<Integer, Carro> carros;
    private Map<Integer, Utilizador> utilizadores;
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
            this.carros.put(a.getIdCarro(), a.clone());
        for (Utilizador b : u.values())
            this.utilizadores.put(b.getNif(), b.clone());
    }

    public void registaUtilizador(Utilizador u) throws UtilizadorExistente {
        if(this.utilizadores.containsKey(u.getNif())){
            throw new UtilizadorExistente();
        }
        else this.utilizadores.put(u.getNif(),u);
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

}
