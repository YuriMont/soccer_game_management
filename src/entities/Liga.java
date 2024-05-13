package entities;
import java.util.List;

public class Liga extends Competicao {

    public Liga(){}

    public Liga(String nome){
        super(nome);
    }

    public Liga(String nome, List<Time> times){
        super(nome, times);
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
                if(i == 1){
                    campeao();
                    zonaDeClassificacao();
                    zonaDeRebaixamento();
                }
                pausa.nextLine();
            }
            System.out.println(" ");
        }
    }

}
