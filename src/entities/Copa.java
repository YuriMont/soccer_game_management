package entities;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;

public class Copa extends Competicao {
    
    public Copa(){}

    public Copa(String nome){
        this.nome = nome;
    }
    
    public void iniciarCopa(){
        if(getTimes().size() % 4 != 0){
            System.out.println("Quantidade insuficiente de times.");
        }else{
            while(getTimes().size() != 1){
                System.out.println(faseDaCopa());
                for(int i = 0; i < getTimes().size() / 2; i++){
                    for(int j = getTimes().size() - 1; j > getTimes().size() - 2; j--){
                        if(!getTimes().get(i).equals(getTimes().get(j))){
                            partidaCopa(getTimes().get(i), getTimes().get(j));
                        }
                    }
                }
            }
            campeao();
        }
    }

    public String faseDaCopa(){
        int participantes = getTimes().size();
        switch (participantes) {
            case 16:
                return "- Oitavas de final -";
            case 8:
                return "- Quartas de final -";
            case 4:
                return "- Semifinal -";
            case 2:
                return "- Final -";
            default:
                return "- Fases preliminares -";
        }
    }

    public void inserirTimeCopa(Time time){
        times.add(time);
        System.out.println("Time inserido na copa.");
    }
    
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

        System.out.print("Resultado final: ");
        System.out.println(mandante.getAcronimo() + " " + golsMandante + " x " + golsVisitante + " " + visitante.getAcronimo());


        return (golsMandante > golsVisitante) ? mandante : visitante;
    }

    private int marcarGol(Time time, Random random) {
        if (random.nextBoolean()) {
            System.out.println(time.getAcronimo() + ": O");
            return 1;
        } else {
            System.out.println(time.getAcronimo() + ": X");;
            return 0;
        }
    }

    public void partidaCopa(Time mandante, Time visitante){
        // jogos de ida e volta, quem fizer mais gols no agregado, continua na lista, o outro sai.
        // se der empate, decide em penaltis, quem ganhar, continua na lista, o outro sai.
        
        int gols_mandante_ida = gerarGolsEsperados(mandante);
        int gols_visitante_ida = gerarGolsEsperados(visitante);
        System.out.println("- - - - - - - - - -");
        System.out.print("Jogo de Ida: ");
        System.out.println(visitante.getAcronimo() + " " + gols_visitante_ida + " x " + gols_mandante_ida + " " + mandante.getAcronimo());

        int gols_mandante_volta = gerarGolsEsperados(mandante);
        int gols_visitante_volta = gerarGolsEsperados(visitante);

        System.out.print("Jogo da Volta: ");
        System.out.println(mandante.getAcronimo() + " " + gols_mandante_volta + " x " + gols_visitante_volta + " " + visitante.getAcronimo());

        int gols_mandante_total = gols_mandante_ida + gols_mandante_volta;
        int gols_visitante_total = gols_visitante_ida + gols_visitante_volta;

        System.out.print("Agregado: ");
        System.out.println(mandante.getAcronimo() + " " + gols_mandante_total + " x " + gols_visitante_total + " " + visitante.getAcronimo());

        Time vencedor = new Time();
        int index_perdedor = 0;

        if(gols_mandante_total == gols_visitante_total){
            System.out.println("es de mi agrado decir que hay decision por penales");
            System.out.println("Penalidades: ");
            vencedor = decidirVencedorPenaltis(mandante, visitante);
        }else if(gols_mandante_total > gols_visitante_total){
            vencedor = mandante;
            index_perdedor = times.indexOf(visitante);
        }else{
            vencedor = visitante;
            index_perdedor = times.indexOf(mandante);
        }


        System.out.println("Vencedor: " + vencedor.getAcronimo());
        times.remove(index_perdedor);

    }

    public void campeaoDaCopa(){
        if(times.size() == 1){
            System.out.println("O " + times.get(0).getNome() + " é o campeão da Copa nacional!");
        }else{
            System.out.println("A copa ainda está em andamento.");
        }
    }

    public List<Time> timesCopaPreDeterminada(){
        List<Time> timesPreDeterminados = new ArrayList<>();

        timesPreDeterminados.add(new Time("Atletico Mineiro", "CAM", "Brasil", "MG", 5));
        timesPreDeterminados.add(new Time("Athletico", "CAP", "Brasil", "PR", 3));
        timesPreDeterminados.add(new Time("Flamengo", "FLA", "Brasil", "RJ", 5));
        timesPreDeterminados.add(new Time("Fluminense", "FLU", "Brasil", "RJ", 4));
        timesPreDeterminados.add(new Time("Internacional", "INT", "Brasil", "RS", 4));
        timesPreDeterminados.add(new Time("Boca Jrs", "BOC", "Argentina", "AR", 4));
        timesPreDeterminados.add(new Time("Racing", "RAC", "Argentina", "AR", 3));
        timesPreDeterminados.add(new Time("Deportivo Pereira", "DPE", "Equador", "EQ", 1));
        timesPreDeterminados.add(new Time("Independiente del Valle", "IDV", "Equador", "EQ", 2));
        timesPreDeterminados.add(new Time("Atletico Nacional", "ANM", "Colombia", "CO", 2));
        timesPreDeterminados.add(new Time("Nacional", "NAC", "Uruguai", "UY", 2));
        timesPreDeterminados.add(new Time("River Plate", "RIV", "Argentina", "AR", 5));
        timesPreDeterminados.add(new Time("Argentinos Jrs", "ARG", "Argentina", "AR", 2));
        timesPreDeterminados.add(new Time("Olimpia", "OLI", "Paraguai", "PY", 2));
        timesPreDeterminados.add(new Time("Bolivar", "BOL", "Bolivia", "BO", 3));
        timesPreDeterminados.add(new Time("Palmeiras", "PAL", "Brasil", "SP", 5));

        return timesPreDeterminados;
    }

    @Override
    public String toString() {
        return "A copa chama-se " + getNome() + " e possui " + getTimes().size() + " times participando.";
    }

    
}
