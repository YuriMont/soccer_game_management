package entities;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Competicao {

    protected String nome;
    protected List<Time> times;
    
    public Competicao(){
        this.times = new ArrayList<>();
    }

    public Competicao(String nome){
        this.nome = nome;
        this.times = new ArrayList<>();
    }

    public Competicao(String nome, List<Time> times){
        this.times = times;
    }

    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public void campeao(){
        System.out.println(" ");
        System.out.println("> > CAMPEAO: " + times.get(0).getNome() + " < <");
    }

    public int gerarGolsEsperados(Time time) {
        int maxGols = getMaxGolsPorNivel(time.getNivel());
        return new Random().nextInt(maxGols + 1);
    }

    private int getMaxGolsPorNivel(int nivel) {
        final int[] MAX_GOLS_POR_NIVEL = { 2, 3, 4, 4, 4};
        if (nivel >= 1 && nivel <= 5) {
            return MAX_GOLS_POR_NIVEL[nivel-1];
        } else {
            throw new IllegalArgumentException("Nível inválido: " + nivel);
        }
    }

    public void listarTimes(){
        for(int i = 0; i < getTimes().size(); i++){
            System.out.println(getTimes().get(i).getAcronimo() + ": " + getTimes().get(i).getNome() + ", " + getTimes().get(i).getPais());
        }
        System.out.println(" ");
    }
    
}
