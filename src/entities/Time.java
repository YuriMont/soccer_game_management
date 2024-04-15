package entities;

import java.util.Scanner;

public class Time{

    private String nome;
    private String acronimo;
    private String pais;
    private String estado;
    private int nivel = 1;
    private int pontosLiga;
    private int golsMarcados;
    private int golsSofridos;
    private int vitorias;
    private int empates;
    private int derrotas;

    public Time(){}

    public Time(String nome, String acronimo, String pais, String estado, int nivel){
        this.nome = nome;
        this.acronimo = acronimo;
        this.pais = pais;
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
        return acronimo.toUpperCase();
    }
    public void setAcronimo(String acronimo) {
        this.acronimo = acronimo;
    }
    public String getPais(){
        return pais;
    }
    public void setPais(String pais){
        this.pais = pais;
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

    public int nivelTime(){
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
            nivelTime();
        }
        return nivel;
    }

    public void criarTime(){
        Scanner scanString = new Scanner(System.in);
    
        System.out.print("Nome do time: ");
        String nomeTime = scanString.nextLine();
        setNome(nomeTime);
        System.out.print("Acronimo (3 letras): ");
        String acronimoTime = scanString.nextLine();
        acronimoTime.toUpperCase();
        setAcronimo(acronimoTime);
        System.out.print("Pais: ");
        String paisTime = scanString.nextLine();
        setPais(paisTime);
        System.out.print("Estado (sigla): ");
        String estadoTime = scanString.nextLine();
        estadoTime.toUpperCase();
        setEstado(estadoTime);
        int nivel = nivelTime();
        setNivel(nivel);

        System.out.println("Time criado!");

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