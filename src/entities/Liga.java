package entities;

import java.util.List;
import entities.Competicao;

public class Liga extends Competicao {
    private List<Time> times;

    public void Classificacao(){
        // deve apresentar a classificacao em ordem de pontuacao.
        // em caso de empate nesse criterio, o criterio usado é o numero de vitorias.
        // sequencia de criterios: pontos, vitorias, saldo, gols marcados.
        
    }

    public void partida_Liga(Time mandante, Time visitante){
        int gols_m = esp_Gols(mandante);
        int gols_v = esp_Gols(visitante);

        System.out.println(mandante.getAcronimo() + " " + gols_m + " x " + gols_m + " " + visitante.getAcronimo());

        if(gols_m > gols_v){
            mandante.setPontos_liga(3);
            mandante.setVitorias(1);
            visitante.setPontos_liga(0);
            visitante.setDerrotas(1);
        }else if(gols_v > gols_m){
            visitante.setPontos_liga(3);
            visitante.setVitorias(1);
            mandante.setPontos_liga(0);
            mandante.setDerrotas(1);
        }else{
            mandante.setPontos_liga(1);
            mandante.setEmpates(1);
            visitante.setPontos_liga(1);
            visitante.setEmpates(1);
        }
        
        
    }
    
}
