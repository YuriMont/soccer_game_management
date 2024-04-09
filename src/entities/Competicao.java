package entities;

import java.util.Random;

public class Competicao {

    protected String nome;
    protected Confederacao confederacao;
    

    Competicao(){}
    
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public Confederacao getConfederacao() {
        return confederacao;
    }
    public void setConfederacao(Confederacao confederacao) {
        this.confederacao = confederacao;
    }

    public int gerarGolsEsperados(Time time) {
        int maxGols = getMaxGolsPorNivel(time.getNivel());
        return new Random().nextInt(maxGols + 1);
    }

    private int getMaxGolsPorNivel(int nivel) {
        final int[] MAX_GOLS_POR_NIVEL = {0, 3, 3, 4, 5, 7};
        if (nivel >= 1 && nivel <= 5) {
            return MAX_GOLS_POR_NIVEL[nivel];
        } else {
            throw new IllegalArgumentException("Nível inválido: " + nivel);
        }
    }
}
