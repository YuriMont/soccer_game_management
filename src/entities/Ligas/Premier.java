package entities.Ligas;
import java.util.ArrayList;
import java.util.List;
import entities.*;


public class Premier extends Liga{
    
    public Premier(){}
    
    public Premier(String nome){ super(nome); }
    
    public void timesPremier(){
        List<Time> timesPL = new ArrayList<>();
        
        timesPL.add(new Time("Arsenal", "ARS", "Inglaterra", 5));
        timesPL.add(new Time("Aston Villa", "AVL", "Inglaterra", 3));
        timesPL.add(new Time("Bournemouth", "BOU", "Inglaterra", 3));
        timesPL.add(new Time("Burnley", "BUR", "Inglaterra", 2));
        timesPL.add(new Time("Brighton", "BHA", "Inglaterra", 3));
        timesPL.add(new Time("Brentford", "BRE", "Inglaterra", 1));
        timesPL.add(new Time("Chelsea", "CHE", "Inglaterra", 4));
        timesPL.add(new Time("Crystal Palace", "CRY", "Inglaterra", 3));
        timesPL.add(new Time("Fulham", "FUL", "Inglaterra", 3));
        timesPL.add(new Time("Everton", "EVE", "Inglaterra", 3));
        timesPL.add(new Time("Nottingham", "NFO", "Inglaterra", 2));
        timesPL.add(new Time("Luton Town", "LTO", "Inglaterra", 1));
        timesPL.add(new Time("Manchester City", "MCI", "Inglaterra", 5));
        timesPL.add(new Time("Manchester United", "MUN", "Inglaterra", 4));
        timesPL.add(new Time("Wolverhampton", "WOL", "Inglaterra", 3));
        timesPL.add(new Time("Sheffield United", "SHU", "Inglaterra", 1));
        timesPL.add(new Time("Liverpool", "LIV", "Inglaterra", 5));
        timesPL.add(new Time("Newcastle United", "NEW", "Inglaterra", 4));
        timesPL.add(new Time("Tottenham", "TOT", "Inglaterra", 4));
        timesPL.add(new Time("West Ham", "WHU", "Inglaterra", 3));
        
        setTimes(timesPL);
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
