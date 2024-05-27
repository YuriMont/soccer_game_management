package entities.Copas;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import entities.*;

public class CWC extends Copa{
    
    public CWC(){}

    public CWC(String nome){ super(nome); }

    @Override
    public void competidoresFaseDeGrupos(){
        List<List<Time>> gruposGeral = new ArrayList<>();

        List<Time> gA = new ArrayList<>();
        gA.add(new Time("Holanda", "HOL", 4, true));
        gA.add(new Time("Senegal", "SEN", 3, true));
        gA.add(new Time("Equador", "EQU", 3, true));
        gA.add(new Time("Catar", "CAT", 1, true));
        setGrupoA(gA);
        gruposGeral.add(getGrupoA());

        List<Time> gB = new ArrayList<>();
        gB.add(new Time("Inglaterra", "ING", 5, true));
        gB.add(new Time("Estados Unidos", "EUA", 2, true));
        gB.add(new Time("Irã", "IRA", 1, true));
        gB.add(new Time("País de Gales", "GAL", 1, true));
        setGrupoB(gB);
        gruposGeral.add(getGrupoB());

        List<Time> gC = new ArrayList<>();
        gC.add(new Time("Argentina", "ARG", 5, true));
        gC.add(new Time("Polônia", "POL", 2, true));
        gC.add(new Time("México", "MEX", 2, true));
        gC.add(new Time("Arábia Saudita", "SAU", 1, true));
        setGrupoC(gC);
        gruposGeral.add(getGrupoC());

        List<Time> gD = new ArrayList<>();
        gD.add(new Time("França", "FRA", 5, true));
        gD.add(new Time("Austrália", "AUS", 2, true));
        gD.add(new Time("Tunísia", "TUN", 1, true));
        gD.add(new Time("Dinamarca", "DIN", 3, true));
        setGrupoD(gD);
        gruposGeral.add(getGrupoD());

        List<Time> gE = new ArrayList<>();
        gE.add(new Time("Japão", "JAP", 3, true));
        gE.add(new Time("Espanha", "ESP", 5, true));
        gE.add(new Time("Alemanha", "ALE", 5, true));
        gE.add(new Time("Costa Rica", "RIC", 1, true));
        setGrupoE(gE);
        gruposGeral.add(getGrupoE());
        
        List<Time> gF = new ArrayList<>();
        gF.add(new Time("Marrocos", "MAR", 2, true));
        gF.add(new Time("Croácia", "CRO", 4, true));
        gF.add(new Time("Bélgica", "BEL", 5, true));
        gF.add(new Time("Canadá", "CAN", 1, true));
        setGrupoF(gF);
        gruposGeral.add(getGrupoF());

        List<Time> gG = new ArrayList<>();
        gG.add(new Time("Brasil", "BRA", 5, true));
        gG.add(new Time("Suíça", "SUI", 3, true));
        gG.add(new Time("Camarões", "CAM", 2, true));
        gG.add(new Time("Sérvia", "SER", 2, true));
        setGrupoG(gG);
        gruposGeral.add(getGrupoG());

        List<Time> gH = new ArrayList<>();
        gH.add(new Time("Portugal", "POR", 5, true));
        gH.add(new Time("Coréia do Sul", "COR", 2, true));
        gH.add(new Time("Uruguai", "URU", 4, true));
        gH.add(new Time("Gana", "GAN", 2, true));
        setGrupoH(gH);
        gruposGeral.add(getGrupoH());

        setGrupos(gruposGeral);
    }

    public void listarSelecoes(){
        Time time = new Time();
        List<Time> lista = new ArrayList<>();
        for(int i = 0; i < grupos.size(); i++){
            for(int j = 0; j < grupos.get(i).size(); j++){
                time = grupos.get(i).get(j);
                lista.add(time);
            }
        }
        
        Collections.sort(lista, Comparator.comparing(Time::getAcronimo));

        for(int i = 0; i < lista.size(); i++)
            System.out.println(lista.get(i).getAcronimo() + ": " + lista.get(i).getNome());
    }

    @Override
    public void faseDeGrupos(){
        List<Time> equipes = new ArrayList<>();
        String[] identificador = {"A", "B", "C", "D", "E", "F", "G", "H"};

        System.out.println("| FASE DE GRUPOS |");
        for(int i = 0; i < grupos.size(); i++){
            System.out.println("{ JOGOS - GRUPO " + identificador[i] + " }");
            turno(grupos.get(i));
            System.out.println(" ");
            System.out.println("{ TABELA - GRUPO " + identificador[i] + " }");
            tabela(grupos.get(i));
            zonaDeClassificacao(grupos.get(i));
            System.out.println(" ");
            equipes.add(0, grupos.get(i).get(0));
            equipes.add(equipes.size()-1, grupos.get(i).get(1));
        }

        setTimes(equipes);
    }

    @Override
    public void faseDaCopa(){
        List<Time> eliminatoria = new ArrayList<>();
        int classificados;
        
        do{
            classificados = 0;
            for(int i = 0; i < times.size(); i++){
                if(times.get(i).getClassificadoCopa()){
                    classificados++;
                    eliminatoria.add(times.get(i));
                }
            }
            
            if(classificados != 2){
                System.out.println("Pressione Enter para continuar...");
                pausa.nextLine();
                if(classificados == 16){
                    System.out.println(" ");
                    System.out.println("| OITAVAS DE FINAL |");
                }else if(classificados == 8){
                    System.out.println(" ");
                    System.out.println("| QUARTAS DE FINAL |");
                }else if(classificados == 4){
                    System.out.println(" ");
                    System.out.println("| SEMIFINAL |");
                }
        
                for(int i = 0; i < eliminatoria.size() - 1; i+=2){
                    int j = i + 1;
                    partidaEliminatoria(eliminatoria.get(i), eliminatoria.get(j));
                }
    
                eliminatoria.clear();
    
            }
        }while(classificados != 2);     
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
            System.out.println("É A FINAL DA COPA DO MUNDO!");
            System.out.println(eliminatoria.get(0).getNome() + " e " + eliminatoria.get(1).getNome() + " se enfrentam nesse embate insano!");
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
