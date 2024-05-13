package entities.Ligas;
import java.util.ArrayList;
import java.util.List;
import entities.*;


public class Brasileirao extends Liga{

    public Brasileirao(){}

    public Brasileirao(String nome){ super(nome); }

    public void timesBrasileirao(){
        List<Time> timesBR = new ArrayList<>();
        
        timesBR.add(new Time("Atlético Goianiense", "ACG", "Brasil", 1));
        timesBR.add(new Time("Atlético Mineiro", "CAM", "Brasil", 5));
        timesBR.add(new Time("Athletico", "CAP", "Brasil", 3));
        timesBR.add(new Time("Bahia", "BAH", "Brasil", 3));
        timesBR.add(new Time("Botafogo", "BOT", "Brasil", 3));
        timesBR.add(new Time("Corinthians", "COR", "Brasil", 3));
        timesBR.add(new Time("Cuiabá", "CUI", "Brasil", 2));
        timesBR.add(new Time("Criciúma", "CRI", "Brasil", 1));
        timesBR.add(new Time("Cruzeiro", "CRU", "Brasil", 2));
        timesBR.add(new Time("Fortaleza", "FOR", "Brasil", 3));
        timesBR.add(new Time("Flamengo", "FLA", "Brasil", 5));
        timesBR.add(new Time("Fluminense", "FLU", "Brasil", 4));
        timesBR.add(new Time("Grêmio", "GRE", "Brasil", 4));
        timesBR.add(new Time("Internacional", "INT", "Brasil", 4));
        timesBR.add(new Time("Juventude", "JUV", "Brasil", 1));
        timesBR.add(new Time("Palmeiras", "PAL", "Brasil", 5));
        timesBR.add(new Time("Red Bull Bragantino", "RBB", "Brasil", 3));
        timesBR.add(new Time("São Paulo", "SAO", "Brasil", 4));
        timesBR.add(new Time("Vasco", "VAS", "Brasil", 2));
        timesBR.add(new Time("Vitória", "VIT", "Brasil", 1));
    
        setTimes(timesBR);
    }

    @Override
    public void zonaDeClassificacao(){
        System.out.print("Libertadores: ");
        for(int i = 0; i < 6; i++){
            System.out.print(getTimes().get(i).getNome());
            if(i != 5){ System.out.print(", "); }
        }
    }
}
