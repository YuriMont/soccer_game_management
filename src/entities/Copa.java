package entities;

import java.util.List;
import java.util.Random;
import entities.Competicao;

public class Copa extends Competicao {
    private List<Time> times;
    
    public void tgp(){
        // so pra exibir mensagens diferentes em caso de erro na disputa.

        Random m = new Random();
        int mensagem = m.nextInt(3);
        switch (mensagem) {
            case 0:
                System.out.println("Chutou pra fooooora!");
                break;

            case 1:
                System.out.println("Defende o goleiro!");
                break;

            case 2:
                System.out.println("Na traaaaave!!!");
                break;

            case 3:
                System.out.println("Ele escorregou e perdeu!");
                break;
        }

    }

    public Time decisao_Penaltis(Time mandante, Time visitante){
        // decidir quem ganha nos penaltis. 5 cobrancas sao obrigatorias, apos isso sao alternadas.
        // cada true conta como gol. Nao pode terminar empatado.
        // quando desempatar, retorna o vencedor.

        Random disputa = new Random();
        boolean m = true;
        boolean v = true;
        int gm = 0;
        int gv = 0;
        for(int i = 1; i < 6; i++){
            m = disputa.nextBoolean();
            v = disputa.nextBoolean();

            if(m){
                System.out.println("Gol do " + mandante.getNome() + "!");
                gm++;
            }else{
                tgp();
            }
            if(v){
                System.out.println("Gol do " + visitante.getNome() + "!");
                gv++;
            }else{
                tgp();
            }
        }

        if(gm == gv){
            System.out.println("Tudo empatado! Vamos para as alternadas!");
            while(gm == gv){
                m = disputa.nextBoolean();
                v = disputa.nextBoolean();

                if(m){
                    System.out.println("Gol do " + mandante.getNome() + "!");
                    gm++;
                }else{
                    tgp();
                }
                if(v){
                    System.out.println("Gol do " + visitante.getNome() + "!");
                    gv++;
                }else{
                    tgp();
                }   
            }
        }
        
        if(gm > gv){
            return mandante;
        }else{
            return visitante;
        }

    }

    public void partida_Copa(Time mandante, Time visitante){
        // jogos de ida e volta, quem fizer mais gols no agregado, continua na lista, o outro sai.
        // se der empate, decide em penaltis, quem ganhar, continua na lista, o outro sai.
        
        int gols_m_ida = esp_Gols(mandante);
        int gols_v_ida = esp_Gols(visitante);

        System.out.println("- Jogo de Ida -");
        System.out.println(visitante.getAcronimo() + " " + gols_v_ida + " x " + gols_m_ida + " " + mandante.getAcronimo());

        int gols_m_volta = esp_Gols(mandante);
        int gols_v_volta = esp_Gols(visitante);

        System.out.println("- Jogo da Volta -");
        System.out.println(mandante.getAcronimo() + " " + gols_m_volta + " x " + gols_v_volta + " " + visitante.getAcronimo());

        int m_total = gols_m_ida + gols_m_volta;
        int v_total = gols_v_ida + gols_v_volta;

        System.out.println("- Agregado -");
        System.out.println(mandante.getAcronimo() + " " + m_total + " x " + v_total + " " + visitante.getAcronimo());

        Time vencedor = new Time();
        vencedor = decisao_Penaltis(mandante, visitante);

        int index_perdedor = 0;

        if(vencedor == mandante){
            index_perdedor = times.indexOf(visitante);
            times.remove(index_perdedor);
        }else{
            index_perdedor = times.indexOf(mandante);
            times.remove(index_perdedor);
        }

    }
    
}
