package entities;

import java.util.List;

public class Competicao {

    private String nome;
    private Confederacao confederacao;
    private List<Time> times;

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

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
}
