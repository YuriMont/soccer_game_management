package entities.Ligas;
import java.util.ArrayList;
import java.util.List;
import entities.*;

public class LaLiga extends Liga{

    public LaLiga(){}

    public LaLiga(String nome){ super(nome); }
    
    @Override
    public void lista(){
        List<Time> timesLL = new ArrayList<>();
    
        timesLL.add(new Time("Alavés", "DPA", "Espanha", 2));
        timesLL.add(new Time("Almería", "ALM", "Espanha", 1));
        timesLL.add(new Time("Atlético de Madrid", "ATM", "Espanha", 5));
        timesLL.add(new Time("Athletic Bilbao", "BIL", "Espanha", 3));
        timesLL.add(new Time("Barcelona", "BAR", "Espanha", 5));
        timesLL.add(new Time("Cádiz", "CAD", "Espanha", 1));
        timesLL.add(new Time("Celta de Vigo", "CEL", "Espanha", 3));
        timesLL.add(new Time("Deportivo Las Palmas", "DLP", "Espanha", 2));
        timesLL.add(new Time("Getafe", "GET", "Espanha", 3));
        timesLL.add(new Time("Girona", "GIR", "Espanha", 4));
        timesLL.add(new Time("Granada", "GRA", "Espanha", 1));
        timesLL.add(new Time("Mallorca", "MAL", "Espanha", 1));
        timesLL.add(new Time("Osasuna", "OSA", "Espanha", 2));
        timesLL.add(new Time("Rayo Vallecano", "RAY", "Espanha", 2));
        timesLL.add(new Time("Real Betis", "BET", "Espanha", 4));
        timesLL.add(new Time("Real Madrid", "RMA", "Espanha", 5));
        timesLL.add(new Time("Real Sociedad", "RSO", "Espanha", 4));
        timesLL.add(new Time("Sevilla", "SEV", "Espanha", 4));
        timesLL.add(new Time("Valencia", "VAL", "Espanha", 3));
        timesLL.add(new Time("Villareal", "VIL", "Espanha", 4));
    
        setTimes(timesLL);
}

    @Override
    public void zonaDeClassificacao(){
        System.out.print("Champions League: ");
        for(int i = 0; i < 3; i++){
            System.out.print(getTimes().get(i).getNome());
            if(i != 2){ System.out.print(", "); }
        }
    }
    
    @Override
    public void zonaDeRebaixamento(){
        System.out.println(" ");
        System.out.print("Rebaixados: ");
        for(int i = getTimes().size() - 1; i > getTimes().size() - 4; i--){
            System.out.print(times.get(i).getNome());
            if(i != getTimes().size() - 3){ System.out.print(", "); }
        }
    }
}
