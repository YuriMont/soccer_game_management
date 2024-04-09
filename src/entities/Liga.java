package entities;

import java.util.List;

public class Liga extends Competicao {
    private List<Time> times;

    public void Classificacao(){
        // deve apresentar a classificacao em ordem de pontuacao.
        // em caso de empate nesse criterio, o criterio usado é o numero de vitorias.
        // sequencia de criterios: pontos, vitorias, saldo, gols marcados.
        
    }

    public void partidaLiga(Time mandante, Time visitante){
        int gols_mandante = gerarGolsEsperados(mandante);
        int gols_visitante = gerarGolsEsperados(visitante);

        System.out.println(mandante.getAcronimo() + " " + gols_mandante + " x " + gols_mandante + " " + visitante.getAcronimo());

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
    
}
