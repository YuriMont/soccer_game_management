package menus;
import entities.Copa;
import entities.Liga;
import entities.Time;
import java.util.Scanner;

public class Menu {
    private Scanner scanner = new Scanner(System.in);

    public Menu(){}

    public void escolherCompeticao(Liga liga, Copa copa, Liga ligaPreDeterminada, Copa copaPreDeterminada){
        int escolhaCompeticao = escolhaCompeticao();

        switch (escolhaCompeticao) {
            case 1:
                menuGeralCompeticaoLiga(liga, ligaPreDeterminada);
                break;
            case 2:
                menuGeralCompeticaoCopa(copa, copaPreDeterminada);
                break;
            default:
                System.out.println("Escolha inválida.");
        }
    }

    public void menuGeralCompeticaoCopa(Copa copa, Copa copaPreDeterminada) {
        int opcao;
        do {
            opcao = menuGeralCompeticao();

            switch (opcao) {
                case 1:
                    System.out.println(copa.toString());
                    System.out.println(" ");
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
                case 0:
                    break;
                default:
                    System.out.println("Escolha inválida.");
            }
        } while (opcao != 0);
    }

    public void menuGeralCompeticaoLiga(Liga liga, Liga ligaPreDeterminada) {
        int opcao;

        do {
            opcao = menuGeralCompeticao();

            switch (opcao) {
                case 1:
                    System.out.println(liga.toString());
                    System.out.println(" ");
                    break;
                case 2:
                    liga.listarTimes();
                    break;
                case 3:
                    ligaPreDeterminada.listarTimes();
                    break;
                case 4:
                    liga.iniciarLiga();
                    System.out.println("- CLASSIFICAÇÃO FINAL -");
                    System.out.println(" ");
                    liga.classificacao();
                    break;
                case 5:
                    ligaPreDeterminada.iniciarLiga();
                    System.out.println(" ");
                    System.out.println("- CLASSIFICAÇÃO FINAL -");
                    ligaPreDeterminada.classificacao();
                    break;
                case 0:
                    break;
                default:
                    throw new RuntimeException("Escolha inválida.");
            }
        } while (opcao != 0);
    }

    public void adicionarTime(Liga liga, Copa copa){
        Time time = new Time();
        time.criarTime();
        liga.inserirTimeLiga(time);
        copa.inserirTimeCopa(time);
        System.out.println(" ");
    }

    public int menuInicial(){
        System.out.println("[MENU INICIAL]");
        System.out.println("[1] - Criar novo time");
        System.out.println("[2] - Ver competicao");
        System.out.println("[0] - Sair");
        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 2 || escolha < 0){
            throw new RuntimeException("Escolha invalida. Insira novamente.");
        }
        return escolha;
    }

    public int menuGeralCompeticao(){
        System.out.println("[MENU DE COMPETICAO]");
        System.out.println("[1] - Listar informacoes");
        System.out.println("[2] - Listar times");
        System.out.println("[3] - Listar times pré-determinados");
        System.out.println("[4] - Jogar competicao com times criados");
        System.out.println("[5] - Jogar competicao com times pré-determinados");
        System.out.println("[0] - Voltar ao menu incial");
        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 5 || escolha < 0){
            System.out.println("Escolha invalida. Insira novamente.");
            menuGeralCompeticao();
        }
        return escolha;
    }

    public int escolhaCompeticao(){
        System.out.println("[ESCOLHA DE COMPETICAO]");
        System.out.println("[1] - Liga");
        System.out.println("[2] - Copa");
        int escolha = scanner.nextInt();
        System.out.println(" ");
        if(escolha > 2 || escolha < 1){
            System.out.println("Escolha invalida. Insira novamente.");
            escolhaCompeticao();
        }
        return escolha;
    }


}