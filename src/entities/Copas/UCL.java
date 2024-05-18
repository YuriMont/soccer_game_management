package entities.Copas;
import java.util.ArrayList;
import java.util.List;
import entities.*;

public class UCL extends Copa{

    public UCL(){}
    
    public UCL(String nome){ super(nome); }
    
    @Override
    public void competidoresFaseDeGrupos(){
        List<List<Time>> gruposGeral = new ArrayList<>();
        
        List<Time> gA = new ArrayList<>();
        gA.add(new Time("Bayern de Munique", "BAY", "Alemanha", 5));
        gA.add(new Time("Copenhague", "COP", "Dinamarca", 2));
        gA.add(new Time("Galatasaray", "GAL", "Turquia", 2));
        gA.add(new Time("Manchester United", "MUN", "Inglaterra", 3));
        setGrupoA(gA);
        gruposGeral.add(getGrupoA());

        List<Time> gB = new ArrayList<>();
        gB.add(new Time("Arsenal", "ARS", "Inglaterra", 4));
        gB.add(new Time("PSV Eidhoven", "PSV", "Holanda", 4));
        gB.add(new Time("RC Lens", "RCL", "França", 3));
        gB.add(new Time("Sevilla", "SEV", "Espanha", 1));
        setGrupoB(gB);
        gruposGeral.add(getGrupoB());
        
        List<Time> gC = new ArrayList<>();
        gC.add(new Time("Real Madrid", "RMA", "Espanha", 5));
        gC.add(new Time("Napoli", "NAP", "Itália", 3));
        gC.add(new Time("Braga", "BRA", "Braga", 2));
        gC.add(new Time("Union Berlim", "UNI", "Alemanha", 1));
        setGrupoC(gC);
        gruposGeral.add(getGrupoC());
        
        List<Time> gD = new ArrayList<>();
        gD.add(new Time("Real Sociedad", "RSO", "Espanha", 3));
        gD.add(new Time("Inter de Milão", "INT", "Itália", 4));
        gD.add(new Time("Benfica", "BEN", "Portugal", 3));
        gD.add(new Time("Red Bull Salzburg", "RBS", "Áustria", 2));
        setGrupoD(gD);
        gruposGeral.add(getGrupoD());

        List<Time> gE = new ArrayList<>();
        gE.add(new Time("Atlético de Madrid", "ATM", "Espanha", 4));
        gE.add(new Time("Lazio", "LAZ", "Itália", 2));
        gE.add(new Time("Feyenoord", "FEY", "Holanda", 2));
        gE.add(new Time("Celtic", "CEL", "Escócia", 1));
        setGrupoE(gE);
        gruposGeral.add(getGrupoE());
        
        List<Time> gF = new ArrayList<>();
        gF.add(new Time("Borussia Dortmund", "BOR", "Alemanha", 4));
        gF.add(new Time("Paris Saint-Germain", "PSG", "França", 5));
        gF.add(new Time("Milan", "MIL", "Itália", 4));
        gF.add(new Time("Newcastle United", "NEW", "Inglaterra", 3));
        setGrupoF(gF);
        gruposGeral.add(getGrupoF());
        
        List<Time> gG = new ArrayList<>();
        gG.add(new Time("Manchester City", "MCI", "Inglaterra", 5));
        gG.add(new Time("RB Leipzig", "LEI", "Alemanha", 3));
        gG.add(new Time("Young Boys", "YGB", "Suiça", 1));
        gG.add(new Time("Estrela Vermelha", "ZVE", "Sérvia", 1));
        setGrupoG(gG);
        gruposGeral.add(getGrupoG());

        List<Time> gH = new ArrayList<>();
        gH.add(new Time("Barcelona", "BAR", "Argentina", 5));
        gH.add(new Time("Porto", "POR", "Portugal", 3));
        gH.add(new Time("Shakhtar Donetsk", "SHA", "Ucrânia", 2));
        gH.add(new Time("Royal Antwerp", "ANT", "Bélgica", 1));
        setGrupoH(gH);
        gruposGeral.add(getGrupoH());

        setGrupos(gruposGeral);
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
            System.out.println("CHEGOU O GRANDE DIA!");
            System.out.println(eliminatoria.get(0).getNome() + " e " + eliminatoria.get(1).getNome() + " decidem quem será o CAMPEÃO DA CHAMPIONS!");
            pausa.nextLine();
            partidaEliminatoria(eliminatoria.get(0), eliminatoria.get(1));
        }

        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getClassificadoCopa()){
                System.out.println(">> CAMPEAO: " + times.get(i).getAcronimo() + " <<");
            }
        }
    }
}