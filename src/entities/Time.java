package entities;

import java.util.Scanner;

public class Time{
    private String nome;
    private String acronimo;
    private String pais;
    private int nivel = 1;
    private int pontosLiga;
    private int golsMarcados;
    private int golsSofridos;
    private int vitorias;
    private int empates;
    private int derrotas;
    private boolean classificadoCopa = true;
    private boolean selecao = false;
    private Scanner scanner = new Scanner(System.in);
    private Scanner i = new Scanner(System.in);

    public Time(){}

    public Time(String nome, String acronimo, int nivel, boolean selecao){
        this.nome = nome;
        this.acronimo = acronimo;
        this.nivel = nivel;
        this.selecao = selecao;
    }

    public Time(String nome, String acronimo, String pais, int nivel){
        this.nome = nome;
        this.acronimo = acronimo;
        this.pais = pais;
        this.nivel = nivel;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getAcronimo() {
        return acronimo.toUpperCase();
    }

    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }

    public String getPais(){
        return pais;
    }

    public void setPais(String pais){
        if(selecao) { this.pais = getNome(); }
        this.pais = pais;
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

    public int getGolsMarcados() {
        return golsMarcados;
    }

    public int getGolsSofridos() {
        return golsSofridos;
    }

    public int getSaldoDeGols() {
        return golsMarcados - golsSofridos;
    }

    public int getVitorias() {
        return vitorias;
    }

    public int getEmpates() {
        return empates;
    }

    public int getDerrotas() {
        return derrotas;
    }

    public boolean getClassificadoCopa(){
        return classificadoCopa;
    }

    public void setClassificadoCopa(boolean classificadoCopa){
        this.classificadoCopa = classificadoCopa;
    }

    public void adicionarGolsMarcados(int golsMarcados) {
        this.golsMarcados = golsMarcados + getGolsMarcados();
    }

    public void adicionarGolsSofridos(int golsSofridos) {
        this.golsSofridos = golsSofridos + getGolsSofridos();
    }

    public void adicionarVitorias(int vitorias) {
        this.vitorias = vitorias + getVitorias();
    }

    public void adicionarDerrotas(int derrotas) {
        this.derrotas = derrotas + getDerrotas();
    }

    public void adicionarEmpates(int empates) {
        this.empates = empates + getEmpates();
    }

    public void adicionarPontos(int pontosLiga) {
        this.pontosLiga = pontosLiga + getPontosLiga();
    }

    public int informarNivelTime(){
        System.out.println("Nivel: ");
        System.out.println("[1] - Pessimo");
        System.out.println("[2] - Fraco");
        System.out.println("[3] - Mediano");
        System.out.println("[4] - Bom");
        System.out.println("[5] - Excelente");
        int nivel = i.nextInt();
        while(nivel < 1 || nivel > 5){
            System.out.println("Nivel invalido. Insira novamente.");
            informarNivelTime();
        }

        return nivel;
    }

    public Time criarTime(){
        System.out.print("Nome do time: ");
        String nomeTime = scanner.nextLine();

        System.out.print("Acronimo (3 letras): ");
        String acronimoTime = scanner.nextLine();

        System.out.print("Pais: ");
        String paisTime = scanner.nextLine();
        int nivelTime = informarNivelTime();

        Time time = new Time(nomeTime, acronimoTime.toUpperCase(), paisTime, nivelTime);

        System.out.println("Time criado!");

        return time;
    }

    private String editarNumero(int numero){
        if (numero < 0) {
            return "-" + editarNumero(Math.abs(numero));
        } else {
            return String.format("%02d", numero);
        }
    }

    @Override
    public String toString() {
        return acronimo + "   |  " + editarNumero(pontosLiga) + "  |  " +
                editarNumero(vitorias) + "  |  " + editarNumero(empates) + "  |  " + editarNumero(derrotas) + "  |  " +
                editarNumero(golsMarcados) + "  |  " + editarNumero(golsSofridos) + "  |  " + editarNumero(getSaldoDeGols());
    }
}