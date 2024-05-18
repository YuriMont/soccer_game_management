package entities.Copas;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import entities.*;

public class CdB extends Copa{
    
    public CdB(){}

    public CdB(String nome){ super(nome); }
    
    @Override
    public void competidores(){
        List<Time> timesCdB = new ArrayList<>();

        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Bahia", "BAH", "Brasil", 3));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Grêmio", "GRE", "Brasil", 4));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Atlético Mineiro", "CAM", "Brasil", 5));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Fluminense", "FLU", "Brasil", 4));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Atlético Goianiense", "ACG", "Brasil", 1));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Sousa", "SOU", "Brasil", 1));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Athletico", "CAP", "Brasil", 3));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Fortaleza", "FOR", "Brasil", 3));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Botafogo", "BOT", "Brasil", 3));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("São Paulo", "SAO", "Brasil", 4));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Flamengo", "FLA", "Brasil", 5));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Corinthians", "COR", "Brasil", 3));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Goiás", "GOI", "Brasil", 1));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Internacional", "INT", "Brasil", 4));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("CRB", "CRB", "Brasil", 1));
        timesCdB.add(posicaoAleatoria(timesCdB), new Time("Palmeiras", "PAL", "Brasil", 5));

        setTimes(timesCdB);
    }

    @Override
    public void campeao(){
        int finalistas = 0;
        List<Time> eliminatoria = new ArrayList<>();
            
        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getClassificadoCopa()){
                eliminatoria.add(times.get(i));
                finalistas++;
            }
        }
        
        if(finalistas != 2){
            throw new RuntimeException("Ação inválida.");
        }else{
            pausa.nextLine();
            System.out.println(" ");
            System.out.println("É HOJE! O DIA QUE TODOS ESPERAMOS!");
            System.out.println(eliminatoria.get(0).getNome() + " e " + eliminatoria.get(1).getNome() + " se enfrentam para decidir quem leva a COPA DO BRASIL!");
            pausa.nextLine();
            partidaEliminatoriaDupla(eliminatoria.get(0), eliminatoria.get(1));
        }

        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getClassificadoCopa()){
                System.out.println(">> CAMPEAO: " + times.get(i).getAcronimo() + " <<");
            }
        }
    }

    @Override
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

    @Override
    public void informacoesCompeticao(){
        System.out.println("[INFORMACÕES]");
        System.out.println("Nome: " + getNome());
        System.out.println("Nº de times: " + getTimes().size());
    }
}
