package entities;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;
import java.util.Comparator;

public class Liga extends Competicao {

    public Liga(){}

    public Liga(String nome){
        super(nome);
    }

    public Liga(String nome, List<Time> times){
        super(nome, times);
    }

    public void organizarTabela(){
        Collections.sort(times, Comparator.comparingInt(Time::getPontosLiga).reversed());
    }

    public void classificacao(){
        organizarTabela();
        System.out.println("Pº |   TIM   |  PT  |  VI  |  EM  |  DE  |  GM  |  GS  |  SG  ");
        for(int i = 0; i < getTimes().size(); i++){
            System.out.println(String.format("%02d", (i+1)) + " |   " + times.get(i));
        }
        campeao();
        System.out.println(" ");
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
            throw new RuntimeException("Quantidade insuficiente de times.");
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
        time.adicionarPontos(3);
        time.adicionarVitorias(1);
    }

    private void registrarDerrota(Time time) {
        time.adicionarPontos(0);
        time.adicionarDerrotas(1);
    }

    private void registrarEmpate(Time time) {
        time.adicionarPontos(1);
        time.adicionarEmpates(1);
    }

    private void registrarGols(Time time, int golsMarcados, int golsSofridos){
        time.adicionarGolsMarcados(golsMarcados);
        time.adicionarGolsSofridos(golsSofridos);
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

    public List<Time> timesLigaPreDeterminada(){
        List<Time> timesPreDeterminados = new ArrayList<>();

        timesPreDeterminados.add(new Time("Atletico Goianiense", "ACG", "Brasil", "GO", 1));
        timesPreDeterminados.add(new Time("Atletico Mineiro", "CAM", "Brasil", "MG", 5));
        timesPreDeterminados.add(new Time("Athletico", "CAP", "Brasil", "PR", 3));
        timesPreDeterminados.add(new Time("Bahia", "BAH", "Brasil", "BA", 3));
        timesPreDeterminados.add(new Time("Botafogo", "BOT", "Brasil", "RJ", 3));
        timesPreDeterminados.add(new Time("Corinthians", "COR", "Brasil", "SP", 3));
        timesPreDeterminados.add(new Time("Cuiaba", "CUI", "Brasil", "MT", 2));
        timesPreDeterminados.add(new Time("Criciuma", "CRI", "Brasil", "SC", 1));
        timesPreDeterminados.add(new Time("Cruzeiro", "CRU", "Brasil", "MG", 2));
        timesPreDeterminados.add(new Time("Fortaleza", "FOR", "Brasil", "CE", 3));
        timesPreDeterminados.add(new Time("Flamengo", "FLA", "Brasil", "RJ", 5));
        timesPreDeterminados.add(new Time("Fluminense", "FLU", "Brasil", "RJ", 4));
        timesPreDeterminados.add(new Time("Gremio", "GRE", "Brasil", "RS", 4));
        timesPreDeterminados.add(new Time("Internacional", "INT", "Brasil", "RS", 4));
        timesPreDeterminados.add(new Time("Juventude", "JUV", "Brasil", "RS", 1));
        timesPreDeterminados.add(new Time("Palmeiras", "PAL", "Brasil", "SP", 5));
        timesPreDeterminados.add(new Time("Red Bull Bragantino", "RBB", "Brasil", "SP", 3));
        timesPreDeterminados.add(new Time("Sao Paulo", "SAO", "Brasil", "SP", 4));
        timesPreDeterminados.add(new Time("Vasco", "VAS", "Brasil", "RJ", 2));
        timesPreDeterminados.add(new Time("Vitoria", "VIT", "Brasil", "BAH", 1));

        return timesPreDeterminados;
    }

    @Override
    public String toString() {
        return "A liga chama-se " + getNome() + " e possui " + getTimes().size() + " times participando.";
    }
}
