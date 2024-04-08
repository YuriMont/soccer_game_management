package entities;

import java.util.List;
import java.util.Random;

public class Competicao {

    protected String nome;
    protected Confederacao confederacao;
    

    Competicao(){}
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Confederacao getConfederacao() {
        return confederacao;
    }
    public void setConfederacao(Confederacao confederacao) {
        this.confederacao = confederacao;
    }

    public int esp_Gols(Time time){
        int gols = 0;
        Random g = new Random();
        switch (time.getNivel()) {
            case 1:
                gols = g.nextInt(3);
                break;

            case 2:
                gols = g.nextInt(3);
                break;

            case 3:
                gols = g.nextInt(4);
                break;

            case 4:
                gols = g.nextInt(5);
                break;

            case 5:
                gols = g.nextInt(7);
                break;
            }
            return gols;
    }
}
