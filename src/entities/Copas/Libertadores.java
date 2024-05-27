package entities.Copas;
import java.util.List;
import java.util.ArrayList;
import entities.*;

public class Libertadores extends Copa{

    public Libertadores(){}

    public Libertadores(String nome){ super(nome); }

    @Override
    public void competidoresFaseDeGrupos(){
        List<List<Time>> gruposGeral = new ArrayList<>();

        List<Time> gA = new ArrayList<>();
        gA.add(new Time("Fluminense", "FLU", "Brasil", 4));
        gA.add(new Time("Cerro Porteño", "CER", "Paraguai", 2));
        gA.add(new Time("Colo-Colo", "COL", "Chile", 2));
        gA.add(new Time("Alianza Lima", "ALI", "Peru", 1));
        setGrupoA(gA);
        gruposGeral.add(getGrupoA());


        List<Time> gB = new ArrayList<>(); 
        gB.add(new Time("Talleres", "TAL", "Argentina", 3));
        gB.add(new Time("São Paulo", "SAO", "Brasil", 4));
        gB.add(new Time("Barcelona SC", "BSC", "Equador", 3));
        gB.add(new Time("Cobresal", "COB", "Chile", 1));
        setGrupoB(gB);
        gruposGeral.add(getGrupoB());
        
        List<Time> gC = new ArrayList<>();
        gC.add(new Time("The Strongest", "STR", "Bolívia", 2));
        gC.add(new Time("Huachipato", "HUA", "Chile", 1));
        gC.add(new Time("Estudiantes", "EST", "Argentina", 3));
        gC.add(new Time("Grêmio", "GRE", "Brasil", 4));
        setGrupoC(gC);
        gruposGeral.add(getGrupoC());
        
        List<Time> gD = new ArrayList<>();
        gD.add(new Time("Junior Barranquilla", "JUN", "Colômbia", 3));
        gD.add(new Time("Botafogo", "BOT", "Brasil", 3));
        gD.add(new Time("Universitario", "UNI", "Peru", 1));
        gD.add(new Time("LDU Quito", "LDU", "Equador", 3));
        setGrupoD(gD);
        gruposGeral.add(getGrupoD());

        List<Time> gE = new ArrayList<>();
        gE.add(new Time("Bolívar", "BOL", "Bolívia", 3));
        gE.add(new Time("Palestino", "CDP", "Chile", 1));
        gE.add(new Time("Flamengo", "FLA", "Brasil", 5));
        gE.add(new Time("Millionarios", "MIL", "Colômbia", 2));
        setGrupoE(gE);
        gruposGeral.add(getGrupoE());
        
        List<Time> gF = new ArrayList<>();
        gF.add(new Time("Palmeiras", "PAL", "Brasil", 5));
        gF.add(new Time("Independiente del Valle", "IDV", "Equador", 4));
        gF.add(new Time("San Lorenzo", "SLO", "Argentina", 3));
        gF.add(new Time("Liverpool", "LIV", "Uruguai", 1));
        setGrupoF(gF);
        gruposGeral.add(getGrupoF());
        
        List<Time> gG = new ArrayList<>();
        gG.add(new Time("Atlético Mineiro", "CAM", "Brasil", 5));
        gG.add(new Time("Peñarol", "PEÑ", "Uruguai", 3));
        gG.add(new Time("Rosario Central", "CEN", "Argentina", 2));
        gG.add(new Time("Caracas", "CAR", "Venezuela", 1));
        setGrupoG(gG);
        gruposGeral.add(getGrupoG());
        
        List<Time> gH = new ArrayList<>();        
        gH.add(new Time("River Plate", "RIV", "Argentina", 5));
        gH.add(new Time("Nacional", "NAC", "Uruguai", 3));
        gH.add(new Time("Libertad", "LIB", "Paraguai", 2));
        gH.add(new Time("Deportivo Táchira", "TAC", "Venezuela", 1));
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
            System.out.println("Pressione Enter para continuar...");
            pausa.nextLine();
            System.out.println(" ");
            System.out.println("É O MOMENTO!");
            System.out.println(eliminatoria.get(0).getNome() + " e " + eliminatoria.get(1).getNome() + " vão em busca da GLÓRIA ETERNA!");
            System.out.println("Pressione Enter para continuar...");
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
