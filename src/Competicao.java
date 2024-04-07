public class Competicao {

    private String nome;
    private Confederacao confederacao;
    private Time times[];

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
    public Time[] getTimes() {
        return times;
    }
    public void setTimes(Time[] times) {
        this.times = times;
    }

    

    
}
