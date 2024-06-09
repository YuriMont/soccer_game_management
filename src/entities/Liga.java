package entities;
import java.util.List;


public class Liga extends Competicao{

    public Liga(){}

    public Liga(String nome){
        super(nome);
    }

    public Liga(String nome, List<Time> times){
        super(nome, times);
    }

    @Override
    public void lista(){
        super.lista();
    }
    
    public void iniciarLiga(){
        if(getTimes().size() < 4){
            throw new RuntimeException("Quantidade insuficiente de times.");
        }else{
            for(int i = 0; i < 2; i++){
                System.out.println("| " + (i+1) + "º turno |");
                turno();
                if(i == 1) System.out.println("- TABELA FINAL -");
                tabela();
                System.out.println("Pressione Enter para continuar...");
                pausa.nextLine();
                if(i == 1){
                    campeao();
                    zonaDeClassificacao();
                    zonaDeRebaixamento();
                }
            }
        }
    }

}
