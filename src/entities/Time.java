package entities;

import java.util.Scanner;

public class Time extends Confederacao {

    private String nome;
    private String acronimo;
    private String estado;
    private int nivel = 1;
    private int pontosLiga;
    private int golsMarcados;
    private int golsSofridos;
    private int saldoDeGols;
    private int vitorias;
    private int empates;
    private int derrotas;


    Time(){}

    public Time(String pais, Liga liga, Copa copa, String nome, String acronimo, String estado, int nivel){
        super(pais, liga, copa);
        this.nome = nome;
        this.acronimo = acronimo;
        this.estado = estado;
        this.nivel = nivel;
    }

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
    public int getPontosLiga() {
        return pontosLiga;
    }
    public void setPontosLiga(int pontosLiga) {
        this.pontosLiga = pontosLiga + getPontosLiga();
    }
    public int getGolsMarcados() {
        return golsMarcados;
    }
    public void setGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados + getGolsMarcados();
    }
    public int getGolsSofridos() {
        return golsSofridos;
    }
    public void setGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos + getGolsSofridos();
    }
    public int getSaldoDeGols() {
        return saldoDeGols;
    }
    public void setSaldoDeGols(int saldoDeGols) {
        this.saldoDeGols = saldoDeGols;
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

    //explicar melhor
    public int obter_Saldo(int golsMarcados, int golsSofridos){
        int saldo = golsMarcados - golsSofridos;
        return saldo;
    }

    public int nivel_Time(){
        // so decide o nivel do time e retorna.

        Scanner i = new Scanner(System.in);

        System.out.println("Nivel: ");
        System.out.println("[1] - Pessimo");
        System.out.println("[2] - Fraco");
        System.out.println("[3] - Mediano");
        System.out.println("[4] - Bom");
        System.out.println("[5] - Excelente");
        int nivel = i.nextInt();
        while(nivel < 1 || nivel > 5){
            System.out.println("Nivel invalido. Insira novamente.");
            System.out.println("Nivel: ");
            nivel = i.nextInt();
        }

        return nivel;
    }

    //modificar
    public void preencher_Time(){
        // preenche as informacoes do time
        Scanner s = new Scanner(System.in);
        Scanner i = new Scanner(System.in);

        preeencher_Conf();
        System.out.print("Nome do time: ");
        String n = s.nextLine();
        setNome(n);
        System.out.print("Acronimo (3 letras): ");
        String ac = s.nextLine();
        ac.toUpperCase();
        setAcronimo(ac);
        System.out.print("Estado (sigla): ");
        String estd = s.nextLine();
        estd.toUpperCase();
        setEstado(estd);
        int nv = nivel_Time();
        setNivel(nv);

    }

}