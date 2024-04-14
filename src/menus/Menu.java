package menus;
import java.util.Scanner;

public class Menu {
    private Scanner s = new Scanner(System.in);
    private Scanner i = new Scanner(System.in);
    public Menu(){}

    public int menuInicial(){
        System.out.println("[1] - Criar novo time");
        System.out.println("[2] - Ver competicao");
        int escolha = s.nextInt();
        if(escolha > 2 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            menuInicial();
        }
        return escolha;
    }

    public int menuGeralCompeticao(){
        System.out.println("[1] - Listar informacoes");
        System.out.println("[2] - Listar times");
        System.out.println("[3] - Listar times pré-determinados");
        System.out.println("[4] - Jogar competicao com times criados");
        System.out.println("[5] - Jogar competicao com times pré-determinados");
        int escolha = s.nextInt();
        if(escolha > 5 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            menuGeralCompeticao();
        }
        return escolha;
    }

    public int escolhaCompeticao(){
        System.out.println("[1] - Liga");
        System.out.println("[2] - Copa");
        int escolha = s.nextInt();
        if(escolha > 2 || escolha < 1){
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
