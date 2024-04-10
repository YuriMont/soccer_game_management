package entities;

import java.util.List;
import java.util.Random;

public class Copa extends Competicao {
    private List<Time> times;
    
    public void exibirMensagemDeErro(){
        final String[] MENSAGENS = {
                "Chutou pra fooooora!",
                "Defende o goleiro!",
                "Na traaaaave!!!",
                "Ele escorregou e perdeu!"
        };

        Random random = new Random();
        int indiceMensagem = random.nextInt(MENSAGENS.length);
        System.out.println(MENSAGENS[indiceMensagem]);
    }

    public Time decidirVencedorPenaltis(Time mandante, Time visitante) {
        Random random = new Random();
        int golsMandante = 0;
        int golsVisitante = 0;

        for (int i = 0; i < 5; i++) {
            golsMandante += marcarGol(mandante, random);
            golsVisitante += marcarGol(visitante, random);
        }

        if (golsMandante == golsVisitante) {
            System.out.println("Tudo empatado! Vamos para as cobranças alternadas!");
            while (golsMandante == golsVisitante) {
                golsMandante += marcarGol(mandante, random);
                golsVisitante += marcarGol(visitante, random);
            }
        }

        return (golsMandante > golsVisitante) ? mandante : visitante;
    }

    private int marcarGol(Time time, Random random) {
        if (random.nextBoolean()) {
            System.out.println("Gol do " + time.getNome() + "!");
            return 1;
        } else {
            exibirMensagemDeErro();
            return 0;
        }
    }

    public void partidaCopa(Time mandante, Time visitante){
        // jogos de ida e volta, quem fizer mais gols no agregado, continua na lista, o outro sai.
        // se der empate, decide em penaltis, quem ganhar, continua na lista, o outro sai.
        
        int gols_mandante_ida = gerarGolsEsperados(mandante);
        int gols_visitante_ida = gerarGolsEsperados(visitante);

        System.out.println("- Jogo de Ida -");
        System.out.println(visitante.getAcronimo() + " " + gols_visitante_ida + " x " + gols_mandante_ida + " " + mandante.getAcronimo());

        int gols_mandante_volta = gerarGolsEsperados(mandante);
        int gols_visitante_volta = gerarGolsEsperados(visitante);

        System.out.println("- Jogo da Volta -");
        System.out.println(mandante.getAcronimo() + " " + gols_mandante_volta + " x " + gols_visitante_volta + " " + visitante.getAcronimo());

        int gols_mandante_total = gols_mandante_ida + gols_mandante_volta;
        int gols_visitante_total = gols_visitante_ida + gols_visitante_volta;

        System.out.println("- Agregado -");
        System.out.println(mandante.getAcronimo() + " " + gols_mandante_total + " x " + gols_visitante_total + " " + visitante.getAcronimo());

        Time vencedor = new Time();
        vencedor = decidirVencedorPenaltis(mandante, visitante);

        int index_perdedor = 0;

        System.out.println("Vencedor: " + vencedor.getAcronimo());

        if(vencedor == mandante){
            index_perdedor = times.indexOf(visitante);
        }else{
            index_perdedor = times.indexOf(mandante);
        }

        times.remove(index_perdedor);

    }

    public void campeaoDaCopa(){
        if(times.size() == 1){
            System.out.println("O " + times.get(0) + " é o campeão da Copa nacional!");
        }else{
            System.out.println("A copa ainda está em andamento.");
        }
    }
    
}
