import entities.*;
import menus.*;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Menu menu = new Menu();
        
        List<Time> ligaTimesPreDeterminados = new ArrayList<>();
        Liga ligaPreDeterminada = new Liga("Brasileirao");
        ligaTimesPreDeterminados = ligaPreDeterminada.timesLigaPreDeterminada();
        ligaPreDeterminada.setTimes(ligaTimesPreDeterminados);
        
        List<Time> copaTimesPreDeterminados = new ArrayList<>();
        Copa copaPreDeterminada = new Copa("Libertadores");
        copaTimesPreDeterminados = copaPreDeterminada.timesCopaPreDeterminada();
        copaPreDeterminada.setTimes(copaTimesPreDeterminados);


        List<Time> ligaTimes = new ArrayList<>();
        Liga liga = new Liga("Liga");
        liga.setTimes(ligaTimes);

        List<Time> copaTimes = new ArrayList<>();
        Copa copa = new Copa("Copa");
        copa.setTimes(copaTimes);


        System.out.println("SEJA BEM-VINDO AO MUNDO DO FUTEBOL!");
        System.out.println("- (um oferecimento leprechaun e yuri) -");
        System.out.println(" ");
        
        int escolha = menu.menuInicial();
        do{
            switch (escolha) {
                case 1:
                    Time time = new Time();
                    time.criarTime();
                    liga.inserirTimeLiga(time);
                    copa.inserirTimeCopa(time);

                    break;
                
                case 2:
                    switch(menu.escolhaCompeticao()) {
                        case 1:
                            switch(menu.menuGeralCompeticao()) {
                                case 1:
                                    liga.toString();
                                    break;
                                
                                case 2:
                                    liga.listarTimes();
                                    break;

                                case 3:
                                    ligaPreDeterminada.listarTimes();
                                    break;

                                case 4:
                                    liga.iniciarLiga();
                                    System.out.println("- CLASSIFICACAO FINAL -");
                                    liga.classificacao();
                                    break;
                                
                                case 5:
                                    ligaPreDeterminada.iniciarLiga();
                                    System.out.println("- CLASSIFICACAO FINAL -");
                                    ligaPreDeterminada.classificacao();
                                    break;
                            }
                
                        case 2:
                            switch(menu.menuGeralCompeticao()) {
                                case 1:
                                    copa.toString();
                                    break;
                            
                                case 2:
                                    copa.listarTimes();
                                    break;

                                case 3:
                                    copaPreDeterminada.listarTimes();
                                    break;

                                case 4:
                                    copa.iniciarCopa();
                                    break;

                                case 5:
                                    copaPreDeterminada.iniciarCopa();
                                    break;
                            }
                    }

                case 0:
                    break;

            };

            escolha = menu.menuInicial();

        }while(escolha != 0);
        

    }
}
