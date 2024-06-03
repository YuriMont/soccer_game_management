package entities;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;

public abstract class Competicao implements Competidores{
    protected String nome;
    protected List<Time> times;
    protected Scanner pausa = new Scanner(System.in);
    
    public Competicao(){
        this.times = new ArrayList<>();
    }

    public Competicao(String nome){
        this.nome = nome;
    }

    public Competicao(String nome, List<Time> times){
        this.nome = nome;
        this.times = times;
    }

    public List<Time> getTimes(){
        return times;
    }

    public void setTimes(List<Time> times){
        this.times = times;
    }
    
    public String getNome(){
        return nome;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    
    @Override
    public void competidores(){}

    @Override
    public void competidoresFaseDeGrupos(){}

    public void campeao(){
        System.out.println(" ");
        System.out.println("> > CAMPEAO: " + times.get(0).getNome() + " < <");
    }
    
    ///////////////////////////////////////////////////// FUNCOES DE TABELA ///////////////////////////////////////////////////////////
    
    public void organizarTabela(){
        Collections.sort(times, (time1, time2) -> {
            // Compara primeiro por pontosLiga
            int compare = Integer.compare(time2.getPontosLiga(), time1.getPontosLiga());
            if (compare == 0) {
                // Se pontosLiga forem iguais, compara por saldoDeGols
                compare = Integer.compare(time2.getSaldoDeGols(), time1.getSaldoDeGols());
            }
            return compare;
        });
    }
    
    public void zonaDeClassificacao(){
        System.out.print("Classificados: ");
        for(int i = 0; i < 2; i++){
            System.out.print(getTimes().get(i).getNome());
            if(i != 1){ System.out.print(", "); }
        }
    }

    public void zonaDeRebaixamento(){
        System.out.println(" ");
        System.out.print("Rebaixados: ");
        for(int i = getTimes().size() - 1; i > getTimes().size() - 5; i--){
            System.out.print(times.get(i).getNome());
            if(i != getTimes().size() - 4){ System.out.print(", "); }
        }
    }

    public void tabela(){
        organizarTabela();
        System.out.println(" ");
        System.out.println("Pº |   TIM   |  PT  |  V+  |  E=  |  D-  |  GM  |  GS  |  SG  ");
        for(int i = 0; i < getTimes().size(); i++){
            System.out.println(String.format("%02d", (i+1)) + " |   " + times.get(i));
        }

    }
    
    //////////////////////////////////////////////////// FUNCOES DE PARTIDAS //////////////////////////////////////////////////////////

    public int gerarGolsEsperados(Time mandante, Time visitante){
        Random randomico = new Random();

        int diferenca = mandante.getNivel() - visitante.getNivel();
        int[][] matrizGolsEsperados = {
            {0, 0, 0, 0, 0, 0, 0, 1, 1, 2},
            {0, 0, 0, 0, 0, 0, 1, 1, 2, 2},
            {0, 0, 0, 0, 0, 1, 1, 2, 2, 2},
            {0, 0, 0, 0, 0, 1, 1, 2, 3, 3},
            {0, 0, 0, 0, 0, 1, 1, 2, 3, 4},
            {0, 0, 0, 0, 1, 1, 2, 2, 3, 4},
            {0, 0, 0, 1, 1, 2, 2, 2, 3, 4},
            {0, 0, 0, 1, 1, 2, 2, 3, 4, 5},
            {0, 0, 0, 1, 2, 2, 2, 3, 4, 5}
        };

        int[] golsEsperados;
        if (diferenca >= -4 && diferenca <= 4){
            golsEsperados = matrizGolsEsperados[diferenca + 4];
            return golsEsperados[randomico.nextInt(10)];
        }else{
            throw new IllegalArgumentException("Nível inválido.");
        }
    }

    public void turno(){
        for(int i = 0; i < times.size(); i++){
            for(int j = i+1; j < times.size(); j++){
                if(!times.get(i).equals(times.get(j))){
                    partida(times.get(i), times.get(j));
                }
            }
        }

        System.out.println(" ");
    }
    
    public void registrarVitoria(Time time){
        time.adicionarPontos(3);
        time.adicionarVitorias(1);
    }

    public void registrarDerrota(Time time){
        time.adicionarPontos(0);
        time.adicionarDerrotas(1);
    }

    public void registrarEmpate(Time time){
        time.adicionarPontos(1);
        time.adicionarEmpates(1);
    }

    public void registrarGols(Time time, int golsMarcados, int golsSofridos){
        time.adicionarGolsMarcados(golsMarcados);
        time.adicionarGolsSofridos(golsSofridos);
    }

    public void apresentarResultado(Time mandante, int gols_mandante, Time visitante, int gols_visitante){
        System.out.println(mandante.getAcronimo() + " " + gols_mandante + " x " + gols_visitante + " " + visitante.getAcronimo());
    }
    
    public void partida(Time mandante, Time visitante){
        int gols_mandante = gerarGolsEsperados(mandante, visitante);
        int gols_visitante = gerarGolsEsperados(visitante, mandante);
        apresentarResultado(mandante, gols_mandante, visitante, gols_visitante);
        
        registrarGols(mandante, gols_mandante, gols_visitante);
        registrarGols(visitante, gols_visitante, gols_mandante);

        if(gols_mandante > gols_visitante){
            registrarVitoria(mandante);
            registrarDerrota(visitante);
        }else if(gols_visitante > gols_mandante){
            registrarVitoria(visitante);
            registrarDerrota(mandante);
        }else{
            registrarEmpate(mandante);
            registrarEmpate(visitante);
        }
    }

    private boolean verificarTime(Time time, List<Time> lista){
        for(int i = 0; i < lista.size(); i++){
            if(time == lista.get(i))
                return true;
        }

        return false;
    }

    public void inserirTime(){
        List<Time> lista = new ArrayList<>();
        Time time = new Time();

        time.criarTime();
        lista.add(time);

        if(verificarTime(time, lista)){
            System.out.println("Time inserido. Inserir mais? s/n");
            String escolha = pausa.nextLine();
            while(!escolha.equalsIgnoreCase("n")){
                Time novoTime = new Time();
                novoTime.criarTime();
                lista.add(novoTime);
    
                if(verificarTime(time, lista)){
                System.out.println("Time inserido. Inserir mais? s/n");
                escolha = pausa.nextLine();
                }
            }
        }else
            throw new RuntimeException("Time não inserido.");

        setTimes(lista);
    }

    public void listarTimes(){
        Time time = new Time();
        List<Time> lista = new ArrayList<>();

        for(int i = 0; i < times.size(); i++){
            time = times.get(i);
            lista.add(time);
        }

        Collections.sort(lista, Comparator.comparing(Time::getAcronimo));

        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getAcronimo() + ": " + lista.get(i).getNome() + ", " + lista.get(i).getPais());
        }

        System.out.println(" ");
    }

    public void informacoesCompeticao(){
        System.out.println("[INFORMACÕES]");
        System.out.println("Nome: " + getNome());
        System.out.println("Nº de times: " + getTimes().size());
    }
}
