package entities;
import java.util.Random;
import java.util.List;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Copa extends Competicao{
    public Random random = new Random();
    protected List<Time> grupoA;
    protected List<Time> grupoB;
    protected List<Time> grupoC;
    protected List<Time> grupoD;
    protected List<Time> grupoE;
    protected List<Time> grupoF;
    protected List<Time> grupoG;
    protected List<Time> grupoH;
    protected List<List<Time>> grupos;

    public List<Time> getGrupoA(){
        return grupoA;
    }

    public void setGrupoA(List<Time> grupoA){
        this.grupoA = grupoA;
    }

    public List<Time> getGrupoB(){
        return grupoB;
    }

    public void setGrupoB(List<Time> grupoB){
        this.grupoB = grupoB;
    }

    public List<Time> getGrupoC(){
        return grupoC;
    }

    public void setGrupoC(List<Time> grupoC){
        this.grupoC = grupoC;
    }

    public List<Time> getGrupoD(){
        return grupoD;
    }

    public void setGrupoD(List<Time> grupoD){
        this.grupoD = grupoD;
    }

    public List<Time> getGrupoE(){
        return grupoE;
    }

    public void setGrupoE(List<Time> grupoE){
        this.grupoE = grupoE;
    }

    public List<Time> getGrupoF(){
        return grupoF;
    }

    public void setGrupoF(List<Time> grupoF){
        this.grupoF = grupoF;
    }

    public List<Time> getGrupoG(){
        return grupoG;
    }

    public void setGrupoG(List<Time> grupoG){
        this.grupoG = grupoG;
    }

    public List<Time> getGrupoH(){
        return grupoH;
    }

    public void setGrupoH(List<Time> grupoH){
        this.grupoH = grupoH;
    }

    public List<List<Time>> getGrupos(){
        return grupos;
    }

    public void setGrupos(List<List<Time>> grupos){
        this.grupos = grupos;
    }

    public Copa(){}

    public Copa(String nome){
       super(nome);
    }

    @Override
    public void competidores(){
        super.competidores();
    }

    @Override
    public void competidoresFaseDeGrupos(){
        super.competidoresFaseDeGrupos();
    }

    public void iniciarCopa(){
        if(getTimes().size() % 4 != 0){
            throw new RuntimeException("Quantidade insuficiente de times.");
        }else{
            faseDaCopa();
            campeao();
            redefinirSituacao();
            pausa.nextLine();
        }
    }
    
    ///////////////////////////// FUNCOES DE FASE DE GRUPOS ////////////////////////////////////////////////
    
    @Override
    public void listarTimes(){
        Time time = new Time();
        List<Time> lista = new ArrayList<>();
        for(int i = 0; i < grupos.size(); i++){
            for(int j = 0; j < grupos.get(i).size(); j++){
                time = grupos.get(i).get(j);
                lista.add(time);
            }
        }
        
        Collections.sort(lista, Comparator.comparing(Time::getAcronimo));

        for(int i = 0; i < lista.size(); i++){
            System.out.println(lista.get(i).getAcronimo() + ": " +
            lista.get(i).getNome() + ", " + lista.get(i).getPais());
        }
    }

    private int contarTimes(){
        int numeroTimes = 0;
        for(int i = 0; i < grupos.size(); i++){
            for(int j = 0; j < grupos.get(i).size(); j++){
                numeroTimes++;
            }
        }
        return numeroTimes;
    }

    @Override
    public void informacoesCompeticao(){
        int numeroTimes = contarTimes();
        System.out.println("[INFORMAÇÕES]");
        System.out.println("Nome: " + getNome());
        System.out.println("Nº de times: " + numeroTimes);
    }

    public void organizarTabela(List<Time> grupo){
        Collections.sort(grupo, Comparator.comparingInt(Time::getPontosLiga).reversed());
    }

    public void turno(List<Time> grupo){
        for(int i = 0; i < grupo.size(); i++){
            for(int j = i+1; j < grupo.size(); j++){
                if(!grupo.get(i).equals(grupo.get(j))){
                    partida(grupo.get(i), grupo.get(j));
                }
            }
        }
    }

    public void tabela(List<Time> grupo){
        organizarTabela(grupo);
        System.out.println("Pº |   TIM   |  PT  |  V+  |  E=  |  D-  |  GM  |  GS  |  SG  ");
        for(int i = 0; i < grupo.size(); i++){
            System.out.println(String.format("%02d", (i+1)) + " |   " + grupo.get(i));
        }
    }
    
    public void zonaDeClassificacao(List<Time> grupo){
        System.out.print("Classificados: ");
        for(int i = 0; i < 2; i++){
            System.out.print(grupo.get(i).getNome());
            if(i != 1){ System.out.print(", "); }
        }
        System.out.println(" ");
    }

    public int posicaoAleatoria(List<Time> grupo){
        return random.nextInt(grupo.size() + 1);
    }

    public void faseDeGrupos(){
        List<Time> equipes = new ArrayList<>();
        String[] identificador = {"A", "B", "C", "D", "E", "F", "G", "H"};

        System.out.println("| FASE DE GRUPOS |");
        for(int i = 0; i < grupos.size(); i++){
            System.out.println("{ JOGOS - GRUPO " + identificador[i] + " }");
            turno(grupos.get(i));
            turno(grupos.get(i));
            System.out.println(" ");
            System.out.println("{ TABELA - GRUPO " + identificador[i] + " }");
            tabela(grupos.get(i));
            zonaDeClassificacao(grupos.get(i));
            System.out.println(" ");
            equipes.add(posicaoAleatoria(equipes), grupos.get(i).get(0));
            equipes.add(posicaoAleatoria(equipes), grupos.get(i).get(1));
        }

        setTimes(equipes);
    }

    //////////////////////////// FUNCOES DE FASE DE MATA MATA //////////////////////////////////////////////

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
                    partidaEliminatoriaDupla(eliminatoria.get(i), eliminatoria.get(j));
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
            throw new RuntimeException("Quantidade incorreta de times.");
        }else{
            System.out.println(" ");
            System.out.println("CHEGOU O MOMENTO DA GRANDE FINAL!");
            System.out.println(eliminatoria.get(0).getNome() + " e " + eliminatoria.get(1).getNome() + " se enfrentam nesse embate insano!");
            pausa.nextLine();
            partidaEliminatoriaDupla(eliminatoria.get(0), eliminatoria.get(1));
        }

        for(int i = 0; i < times.size(); i++){
            if(times.get(i).getClassificadoCopa()){
                System.out.println(">> CAMPEAO: " + times.get(i).getAcronimo() + " <<");
            }
        }
    }
    
    public void redefinirSituacao(){
        for(int i = 0; i < times.size(); i++){
            times.get(i).setClassificadoCopa(true);
        }
    }
    
    private int marcarGol(Time time, Random random){
        if(random.nextBoolean()){
            System.out.println(time.getAcronimo() + ": O");
            return 1;
        }else{
            System.out.println(time.getAcronimo() + ": X");;
            return 0;
        }
    }

    public void decidirVencedorPenaltis(Time mandante, Time visitante){
        int gols_mandante = 0;
        int gols_visitante = 0;

        for(int i = 0; i < 5; i++){
            gols_mandante += marcarGol(mandante, random);
            gols_visitante += marcarGol(visitante, random);
        }

        if(gols_mandante == gols_visitante){
            System.out.println("Tudo empatado! Vamos para as cobranças alternadas!");
            while(gols_mandante == gols_visitante){
                gols_mandante += marcarGol(mandante, random);
                gols_visitante += marcarGol(visitante, random);
            }
        }

        System.out.print("Resultado: ");
        apresentarResultado(mandante, gols_mandante, visitante, gols_visitante);
        
        if(gols_mandante > gols_visitante)
            visitante.setClassificadoCopa(false);
        else
            mandante.setClassificadoCopa(false);
    }


    public void mataMata(Time mandante, Time visitante){
        if(mandante.getClassificadoCopa() == visitante.getClassificadoCopa()){
            throw new RuntimeException("Os times precisam se enfrentar.");
        }else{
            if(mandante.getClassificadoCopa() && !visitante.getClassificadoCopa()){
                System.out.println("Vencedor: " + mandante.getNome());
            }else{
                System.out.println("Vencedor: " + visitante.getNome());
            }
        }
    }
    
    public void partidaEliminatoria(Time mandante, Time visitante){
        System.out.println("- - - - - - - - - -");
        
        int gols_mandante = gerarGolsEsperados(mandante, visitante);
        int gols_visitante = gerarGolsEsperados(visitante, mandante);
        System.out.print("Partida: ");
        apresentarResultado(mandante, gols_mandante, visitante, gols_visitante);
        
        if(gols_mandante == gols_visitante){
            System.out.println("damas e cavalheiros, es de mi agrado informar que hay decision por penales");
            System.out.println("Penalidades: ");
            decidirVencedorPenaltis(mandante, visitante);
        }else if(gols_mandante > gols_visitante){
            visitante.setClassificadoCopa(false);
        }else{
            mandante.setClassificadoCopa(false);
        }
        
        mataMata(mandante, visitante);
    }

    public void partidaEliminatoriaDupla(Time mandante, Time visitante){
        System.out.println("- - - - - - - - - -");
        
        int gols_mandante_ida = gerarGolsEsperados(mandante, visitante);
        int gols_visitante_ida = gerarGolsEsperados(visitante, mandante);
        System.out.print("1ª Mão: ");
        apresentarResultado(mandante, gols_mandante_ida, visitante, gols_visitante_ida);

        int gols_mandante_volta = gerarGolsEsperados(mandante, visitante);
        int gols_visitante_volta = gerarGolsEsperados(visitante, mandante);
        System.out.print("2ª Mão: ");
        apresentarResultado(visitante, gols_visitante_volta, mandante, gols_mandante_volta);
        
        int gols_mandante_total = gols_mandante_ida + gols_mandante_volta;
        int gols_visitante_total = gols_visitante_ida + gols_visitante_volta;
        System.out.print("Agregado: ");
        apresentarResultado(mandante, gols_mandante_total, visitante, gols_visitante_total);
        
        if(gols_mandante_total == gols_visitante_total){
            System.out.println("damas e cavalheiros, es de mi agrado informar que hay decision por penales");
            System.out.println("Penalidades: ");
            decidirVencedorPenaltis(mandante, visitante);
        }else if(gols_mandante_total > gols_visitante_total){
            visitante.setClassificadoCopa(false);
        }else{
            mandante.setClassificadoCopa(false);
        }
        
        mataMata(mandante, visitante);
    }

}
