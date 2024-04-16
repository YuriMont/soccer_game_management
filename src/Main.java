import entities.*;
import menus.*;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        List<Time> ligaTimesPreDeterminados = new ArrayList<>();
        Liga ligaPreDeterminada = new Liga("Brasileirao");
        ligaTimesPreDeterminados = ligaPreDeterminada.timesLigaPreDeterminada();
        ligaPreDeterminada.setTimes(ligaTimesPreDeterminados);
        
        List<Time> copaTimesPreDeterminados = new ArrayList<>();
        Copa copaPreDeterminada = new Copa("Libertadores");
        copaTimesPreDeterminados = copaPreDeterminada.timesCopaPreDeterminada();
        copaPreDeterminada.setTimes(copaTimesPreDeterminados);

        Liga liga = new Liga("Liga");

        Copa copa = new Copa("Copa");

        Menu menu = new Menu();


        System.out.println("SEJA BEM-VINDO AO MUNDO DO FUTEBOL!");
        System.out.println("- (um oferecimento leprechaun e yuri) -");
        System.out.println(" ");

        int escolha;
        do {
            escolha = menu.menuInicial();
            try {
                switch (escolha) {
                    case 1:
                        menu.adicionarTime(liga, copa);
                        break;
                    case 2:
                        menu.escolherCompeticao(liga, copa, ligaPreDeterminada, copaPreDeterminada);
                        break;
                    case 0:
                        System.out.println("Saindo do programa...");
                        break;
                    default:
                        System.out.println("Escolha inválida.");
                        break;
                }
            } catch (RuntimeException exception) {
                System.out.println(exception.getMessage());
            }
        } while (escolha != 0);

    }
}
