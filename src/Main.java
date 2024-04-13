import entities.*;
import exceptions.*;
import infra.*;
import repositories.*;
import menus.*;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public List<Time> criarLista(){
        List<Time> lista = new ArrayList<>();
        return lista;
    }

    public static void main(String[] args){
        Menu menu = new Menu();
        Liga liga = new Liga();
        Copa copa = new Copa();

        System.out.println("SEJA BEM-VINDO AO MUNDO DO FUTEBOL!");
        System.out.println("- (um oferecimento leprechaun e yuri) -");
        System.out.println(" ");
        switch (menu.menuInicial()) {
            case 1:
                Time time = new Time();
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
                        
                        break;
                
                    case 2:
                    
                        break;
                }
            case 0:
                break;
        };
        

    }
}
