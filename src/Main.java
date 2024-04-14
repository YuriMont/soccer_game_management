import entities.*;
import exceptions.*;
import infra.*;
import menus.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args){
        Menu menu = new Menu();
        List<Time> times = new ArrayList<>();

        times.add(new Time("Brasil", new Liga(), new Copa(), "Flamengo", "FLA", "RJ", 2));
        times.add(new Time("Brasil", new Liga(), new Copa(), "Palmeiras", "PAL", "SP", 2));
        times.add(new Time("Brasil", new Liga(), new Copa(), "Corinthians", "COR", "SP", 2));
        times.add(new Time("Brasil", new Liga(), new Copa(), "Santos", "SAN", "SP", 2));

        Liga liga = new Liga();
        liga.setTimes(times);
        Copa copa = new Copa();
        copa.setTimes(times);


        System.out.println("SEJA BEM-VINDO AO MUNDO DO FUTEBOL!");
        System.out.println("- (um oferecimento leprechaun e yuri) -");
        System.out.println(" ");

        int escolha = menu.menuInicial();
        do{
            switch (escolha) {
                case 1:
                    Time time = new Time("Brasil", liga, copa);
                    time.criarTime();
                    switch (menu.escolhaCompeticao()) {
                        case 1:
                            liga.inserirTimeLiga(time);
                            break;
                        case 2:
                            copa.inserirTimeCopa(time);
                            break;
                        case 3:
                            liga.inserirTimeLiga(time);
                            copa.inserirTimeCopa(time);
                            break;
                    }
                    break;
                
                case 2:
                    switch (menu.jogarCompeticao()) {
                        case 1:
                            liga.iniciarLiga();
                            System.out.println("- CLASSIFICACAO FINAL -");
                            liga.classificacao();
                            break;
                        case 2:
                            copa.iniciarCopa();
                            copa.campeaoDaCopa();;
                            break;
                    }

                case 0:
                    break;

            };

            escolha = menu.menuInicial();

        }while(escolha != 0);
        

    }
}
