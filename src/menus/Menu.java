package menus;
import java.util.Scanner;

public class Menu {

    public int menuInicial(){
        Scanner s = new Scanner(System.in);
        System.out.println("[1] - Criar novas competicoes");
        System.out.println("[2] - Usar competicoes do banco");
        System.out.println("[0] - Encerrar programa");
        int escolha = s.nextInt();
        if(escolha > 2 || escolha < 0){
            System.out.println("Escolha invalida. Insira novamente.");
            menuInicial();
        }
        return escolha;
    }

    
    
}
