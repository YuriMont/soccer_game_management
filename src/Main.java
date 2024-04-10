import entities.*;
import exceptions.*;
import infra.*;
import repositories.*;
import menus.*;
import java.util.Scanner;

public class Main {

    public static void main(String[] args){
        Menu menu = new Menu();
        System.out.println("SEJA BEM-VINDO AO MUNDO DO FUTEBOL!");
        System.out.println("- (um oferecimento leprechaun e yuri) -");
        System.out.println(" ");
        menu.menuInicial();

    }
}
