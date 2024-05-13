import menus.*;

public class Main {
    public static void main(String[] args){
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
                        menu.menuEscolhaLigas();
                        break;
                    case 2:
                        menu.menuEscolhaCopas();
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
