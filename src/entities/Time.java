package entities;


import infra.DBConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Time extends Confederacao {

    private String nome;
    private String acronimo;
    private String estado;
    private int nivel = 1;
    private int pontos_liga = 0;
    private int gols_marcados = 0;
    private int gols_sofridos = 0;
    private int saldo_de_gols = 0;
    private int vitorias = 0;
    private int empates = 0;
    private int derrotas = 0;

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