package menus;
import java.util.Scanner;

public class Menu {
    private Scanner s = new Scanner(System.in);
    public Menu(){}

    public int menuInicial(){
        System.out.println("[1] - Criar novo time");
        System.out.println("[2] - Jogar competicao");
        int escolha = s.nextInt();
        if(escolha > 2 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            menuInicial();
        }
        return escolha;
    }

    public int escolhaCompeticao(){
        System.out.println("[1] - Adicionar na liga");
        System.out.println("[2] - Adicionar na copa");
        System.out.println("[3] - Adicionar em ambos");
        int escolha = s.nextInt();
        if(escolha > 3 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            escolhaCompeticao();
        }
        return escolha;
    }

    public int jogarCompeticao(){
        System.out.println("[1] - Simular liga");
        System.out.println("[2] - Simular copa");
        int escolha = s.nextInt();
        if(escolha > 2 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            jogarCompeticao();
        }
        return escolha;
    }

    
    
}
