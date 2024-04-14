package entities;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Liga extends Competicao {
    private List<Time> times;
    
    public List<Time> getTimes() {
        return times;
    }

    public void setTimes(List<Time> times) {
        this.times = times;
    }

    public void organizarTabela(){
        //organizar o array do maior para o menor pelos pontos.
        Collections.sort(times, Comparator.comparingInt(Time::getPontosLiga).reversed());
    }

    public void classificacao(){
        System.out.println("º |   TIM   |  P  |  V  |  E  |  D  |  GM  |  GS  |  SG  ");
        for(int i = 0; i < getTimes().size(); i++){
            System.out.println((i+1) + " |   " + getTimes().get(i).getAcronimo() + "   |  " + getTimes().get(i).getPontosLiga() + "  |  " + 
            getTimes().get(i).getVitorias() + "  |  " + getTimes().get(i).getEmpates() + "  |  " + getTimes().get(i).getDerrotas() + "  |  "
            + getTimes().get(i).getGolsMarcados() + "  |  " + getTimes().get(i).getGolsSofridos() + "  |  " + getTimes().get(i).getSaldoDeGols());
        }
        
    }

    private void turno(){
        for(int i = 0; i < getTimes().size(); i++){
            for(int j = i+1; j < getTimes().size(); j++){
                if(!getTimes().get(i).equals(getTimes().get(j))){
                    partidaLiga(getTimes().get(i), getTimes().get(j));
                }
            }
        }
    }

    public void iniciarLiga(){
        if(getTimes().size() < 4){
            System.out.println("Quantidade insuficiente de times.");
        }else{
            System.out.println("- 1º turno -");
            turno();
            System.out.println("- 2º turno -");
            turno();
        }
    }

    public void inserirTimeLiga(Time time){
        times.add(time);
        System.out.println("Time inserido na liga.");
    }
    
    private void registrarVitoria(Time time) {
        time.setPontosLiga(3);
        time.setVitorias(1);
    }

    private void registrarDerrota(Time time) {
        time.setPontosLiga(0);
        time.setDerrotas(1);
    }

    private void registrarEmpate(Time time) {
        time.setPontosLiga(1);
        time.setEmpates(1);
    }

    private void registrarGols(Time time, int golsMarcados, int golsSofridos){
        time.setGolsMarcados(golsMarcados);
        time.setGolsSofridos(golsSofridos);
    }

    public void partidaLiga(Time mandante, Time visitante){
        int gols_mandante = gerarGolsEsperados(mandante);
        int gols_visitante = gerarGolsEsperados(visitante);

        System.out.println(mandante.getAcronimo() + " " + gols_mandante + " x " + gols_visitante + " " + visitante.getAcronimo());

        registrarGols(mandante, gols_mandante, gols_visitante);
        registrarGols(visitante, gols_visitante, gols_mandante);

        if (gols_mandante > gols_visitante) {
            registrarVitoria(mandante);
            registrarDerrota(visitante);
        } else if (gols_visitante > gols_mandante) {
            registrarVitoria(visitante);
            registrarDerrota(mandante);
        } else {
            registrarEmpate(mandante);
            registrarEmpate(visitante);
        }
    }
}
