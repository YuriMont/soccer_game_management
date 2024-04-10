package entities;

import infra.DBConnection;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Confederacao {
    protected String pais;
    protected Liga liga;
    protected Copa copa;

    Confederacao(){}

    public Confederacao(String pais, Liga liga, Copa copa){
        this.pais = pais;
        this.liga = liga;
        this.copa = copa;
    }
    
    public String getPais() {
        return pais;
    }
    public void setPais(String pais) {
        this.pais = pais;
    }
    public Liga getLiga() {
        return liga;
    }
    public void setLiga(Liga liga) {
        this.liga = liga;
    }
    public Copa getCopa() {
        return copa;
    }
    public void setCopa(Copa copa) {
        this.copa = copa;
    }

    //Vamos mudar isso
    public void preeencher_Conf(){
        Scanner s = new Scanner(System.in);

        System.out.print("Pais: ");
        String p = s.nextLine();
        setPais(p);
        System.out.print("Nome da liga: ");
        Liga l = new Liga();
        String nl = s.nextLine();
        setLiga(l);
        l.setNome(nl);
        System.out.print("Nome da copa: ");
        Copa c = new Copa();
        setCopa(c);
        String nc = s.nextLine();
        c.setNome(nc);
    }

}
