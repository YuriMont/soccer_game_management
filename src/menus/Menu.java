package menus;
import entities.*;
import entities.Copas.*;
import entities.Ligas.*;

import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public Menu(){}

    public int menuInicial(){
        System.out.println("[MENU INICIAL]");
        System.out.println("[1] - Acessar ligas");
        System.out.println("[2] - Acessar copas");
        System.out.println("[0] - Sair");
        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 2 || escolha < 0){
            System.out.println("Escolha inválida. Insira novamente.");
            menuInicial();
        }
        return escolha;
    }

    public int menuEscolhaInicial(int opcao){
        System.out.println(" ");
        if(opcao == 1){
            System.out.println("[MENU DE LIGAS]");
            System.out.println("[1] - Nova liga");
            System.out.println("[2] - Brasileirão Betano");
            System.out.println("[3] - Premier League");
            System.out.println("[4] - LaLiga");
            System.out.println("[5] - Campeonato Paraibano");
            System.out.println("[0] - Retornar");
        }else{
            System.out.println("[MENU DE COPAS]");
            System.out.println("[1] - Nova copa");
            System.out.println("[2] - Copa Betano do Brasil");
            System.out.println("[3] - CONMEBOL Libertadores");
            System.out.println("[4] - UEFA Champions League");
            System.out.println("[5] - Copa do Mundo da FIFA");
            System.out.println("[0] - Retornar");
        }

        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 5 || escolha < 0){
            System.out.println("Escolha inválida. Insira novamente.");
            menuEscolhaInicial(opcao);
        }
        return escolha;
    }

    public int menuOpcaoCompeticao(){
        System.out.println("[OPÇÕES DA COMPETIÇÃO]");
        System.out.println("[1] - Simular competição");
        System.out.println("[2] - Listar equipes");
        System.out.println("[3] - Informações da competição");
        System.out.println("[0] - Retornar");
        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 3 || escolha < 0){
            System.out.println("Escolha invalida. Insira novamente.");
            menuOpcaoCompeticao();
        }
        return escolha;
    }

    public void menuEscolhaLigas(){
        Liga liga = new Liga();
        Brasileirao brasileirao = new Brasileirao("Brasileirão");
        Premier premier = new Premier("Premier League");
        LaLiga laliga = new LaLiga("LaLiga");
        Paraibano paraibano = new Paraibano("Campeonato Paraibano");
        
        int escolha; 
        int opcao = 0;
        do{    
            escolha = menuEscolhaInicial(1);
            if(escolha > 1){ opcao = menuOpcaoCompeticao(); };
            switch(escolha){
                case 1:
                    liga.inserirTime();
                    opcao = menuOpcaoCompeticao();
                    if(opcao==1){ liga.iniciarLiga(); }
                    else if(opcao==2){ liga.listarTimes(); }
                    else{ liga.informacoesCompeticao(); }
                    break;
    
                case 2:
                    brasileirao.timesBrasileirao();
                    if(opcao==1){ brasileirao.iniciarLiga(); }
                    else if(opcao==2){ brasileirao.listarTimes(); }
                    else { brasileirao.informacoesCompeticao(); }
                    break;
    
                case 3:
                    premier.timesPremier();
                    if(opcao==1){ premier.iniciarLiga(); }
                    else if(opcao==2){ premier.listarTimes(); }
                    else{ premier.informacoesCompeticao(); }
                    break;
    
                case 4:
                    laliga.timesLaLiga();
                    if(opcao==1){ laliga.iniciarLiga(); }
                    else if(opcao==2){ laliga.listarTimes(); }
                    else{ laliga.informacoesCompeticao(); }
                    break;
    
                case 5:
                    paraibano.timesParaibano();
                    if(opcao==1){ paraibano.iniciarLiga(); }
                    else if(opcao==2){ paraibano.listarTimes(); }
                    else{ paraibano.informacoesCompeticao(); }
                    break;

                case 0:
                    break;
                
                default:
                    throw new RuntimeException("Escolha inválida.");
                }
            }while(escolha != 0);
        }
        
    public void menuEscolhaCopas(){
        Copa copa = new Copa();
        CdB copaDoBrasil = new CdB("Copa do Brasil");
        Libertadores libertadores = new Libertadores("Libertadores");
        UCL champions = new UCL("Champions League");
        CWC copaDoMundo = new CWC("Copa do Mundo da FIFA");

        int escolha;
        int opcao = 0;
        do{    
            escolha = menuEscolhaInicial(2);
            if(escolha > 1){ opcao = menuOpcaoCompeticao(); }
            switch(escolha){
                case 1:
                    copa.inserirTime();
                    opcao = menuOpcaoCompeticao();
                    if(opcao==1){ copa.iniciarCopa(); }
                    else if(opcao==2){ copa.listarTimes(); }
                    else{ copa.informacoesCompeticao(); }
                    break;
    
                case 2:
                    copaDoBrasil.timesCopaDoBrasil();
                    if(opcao==1){ copaDoBrasil.iniciarCopa(); }
                    else if(opcao==2){ copaDoBrasil.listarTimes(); }
                    else { copaDoBrasil.informacoesCompeticao(); }
                    break;
    
                case 3:
                    libertadores.timesFaseDeGrupos();
                    if(opcao==1){ libertadores.faseDeGrupos(); libertadores.iniciarCopa(); }
                    else if(opcao==2){ libertadores.listarTimes(); }
                    else{ libertadores.informacoesCompeticao(); }
                    break;
    
                case 4:
                    champions.timesFaseDeGrupos();
                    if(opcao==1){ champions.faseDeGrupos(); champions.iniciarCopa(); }
                    else if(opcao==2){ champions.listarTimes(); }
                    else{ champions.informacoesCompeticao(); }
                    break;
    
                case 5:
                    copaDoMundo.timesFaseDeGrupos();
                    if(opcao==1){ copaDoMundo.faseDeGrupos(); copaDoMundo.iniciarCopa(); }
                    else if(opcao==2){ copaDoMundo.listarSelecoes(); }
                    else{ copaDoMundo.informacoesCompeticao(); }
                    break;
                
                case 0:
                    break;
    
                default:
                    throw new RuntimeException("Escolha inválida.");
            }
        }while(escolha != 0);
    }
}