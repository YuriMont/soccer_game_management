package entities.Ligas;
import java.util.ArrayList;
import java.util.List;

import entities.*;

public class Paraibano extends Liga{
    
    public Paraibano(){}

    public Paraibano(String nome){ super(nome); }

    public void timesParaibano(){
        List<Time> timesPB = new ArrayList<>();
    
        timesPB.add(new Time("Atletico Cajazeiras", "ACD", "Brasil", 1));
        timesPB.add(new Time("Serra Branca", "SBR", "Brasil", 4));
        timesPB.add(new Time("Treze", "TRE", "Brasil", 4));
        timesPB.add(new Time("Nacional de Patos", "NAC", "Brasil", 3));
        timesPB.add(new Time("Botafogo-PB", "BOT", "Brasil", 4));
        timesPB.add(new Time("Esporte de Patos", "ESP", "Brasil", 1));
        timesPB.add(new Time("Campinense", "CPN", "Brasil", 3));
        timesPB.add(new Time("Sousa", "SOU", "Brasil", 4));
        timesPB.add(new Time("CSP", "CSP", "Brasil", 2));
        timesPB.add(new Time("Pombal", "POM", "Brasil", 1));
        timesPB.add(new Time("São Paulo Crystal", "SPC", "Brasil", 1));
        timesPB.add(new Time("Confiança de Sapé", "CON", "Brasil", 1));
            
        setTimes(timesPB);
    }
    
    @Override
    public void zonaDeClassificacao(){
        System.out.print("Copa do Brasil: ");
        for(int i = 0; i < 6; i++){
            System.out.print(getTimes().get(i).getNome());
            if(i != 5){ System.out.print(", "); }
        }
    }
    
    @Override
    public void zonaDeRebaixamento(){
        System.out.println(" ");
        System.out.print("Rebaixados: ");
        for(int i = getTimes().size() - 1; i > getTimes().size() - 3; i--){
            System.out.print(times.get(i).getNome());
            if(i != getTimes().size() - 2){ System.out.print(", "); }
        }
    }  
}
