public class Time extends Confederacao{

    private String nome;
    private String acronimo;
    private String estado;
    private int nivel;
    private int pontos_liga;
    private int gols_marcados;
    private int gols_sofridos;
    private int saldo_de_gols;
    private int vitorias;
    private int empates;
    private int derrotas;

    Time(){}

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getAcronimo() {
        return acronimo;
    }
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }
    public String getEstado() {
        return estado;
    }
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public int getNivel() {
        return nivel;
    }
    public void setNivel(int nivel) {
        this.nivel = nivel;
    }
    public int getPontos_liga() {
        return pontos_liga;
    }
    public void setPontos_liga(int pontos_liga) {
        this.pontos_liga = pontos_liga + getPontos_liga();
    }
    public int getGols_marcados() {
        return gols_marcados;
    }
    public void setGols_marcados(int gols_marcados) {
        this.gols_marcados = gols_marcados + getGols_marcados();
    }
    public int getGols_sofridos() {
        return gols_sofridos;
    }
    public void setGols_sofridos(int gols_sofridos) {
        this.gols_sofridos = gols_sofridos + getGols_sofridos();
    }
    public int getSaldo_de_gols() {
        return saldo_de_gols;
    }
    public void setSaldo_de_gols(int saldo_de_gols) {
        this.saldo_de_gols = saldo_de_gols;
    }
    public int getVitorias() {
        return vitorias;
    }
    public void setVitorias(int vitorias) {
        this.vitorias = vitorias + getVitorias();
    }
    public int getEmpates() {
        return empates;
    }
    public void setEmpates(int empates) {
        this.empates = empates + getEmpates();
    }
    public int getDerrotas() {
        return derrotas;
    }
    public void setDerrotas(int derrotas) {
        this.derrotas = derrotas + getDerrotas();
    }

    public int obter_Saldo(int gm, int gs){
        int s = gm - gs;
        return s;
    }

    
    
}
