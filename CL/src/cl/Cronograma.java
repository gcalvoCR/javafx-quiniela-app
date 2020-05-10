/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.time.LocalDate;

/**
 *
 * @author Gabriel
 */
public class Cronograma {

    private int codigo;
    private Equipo equipo1;
    private Equipo equipo2;
    private String team1; //Sergio
    private String team2; //Sergio
    private int golesEquipo1;
    private int golesEquipo2;
    private LocalDate fecha;
    private String fase;
    private boolean jugado;
    private int codigoMundial; //Sergio
    private String codigoEquipoGanador; //Sergio
    private Equipo ganador;

    public Cronograma() {
    }

    public Cronograma(Equipo equipo1, Equipo equipo2) {
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
    }

    public Cronograma(int codigo, Equipo equipo1, Equipo equipo2, LocalDate fecha, String fase, int codigoMundial) {
        this.codigo = codigo;
        this.equipo1 = equipo1;
        this.equipo2 = equipo2;
        this.fecha = fecha;
        this.fase = fase;
        this.codigoMundial = codigoMundial;
    }

    public Cronograma(int codigo, String team1, String team2, int golesEquipo1, int golesEquipo2, LocalDate fecha, String fase, boolean jugado, int codigoMundial, String codigoEquipoGanador) {
        this.codigo = codigo;
        this.team1 = team1;
        this.team2 = team2;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.fecha = fecha;
        this.fase = fase;
        this.jugado = jugado;
        this.codigoMundial = codigoMundial;
        this.codigoEquipoGanador = codigoEquipoGanador;
    }

    public Equipo getGanador() {
        return ganador;
    }
    
    public boolean getJugado() {
        return jugado;
    }

    public int getCodigo() {
        return codigo;
    }

    
    public String getFase() {
        return fase;
    }
    

    public Equipo getEquipo1() {
        return equipo1;
    }

    public Equipo getEquipo2() {
        return equipo2;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public LocalDate getFecha() {
        return fecha;
    }

    public String getTeam1() {
        return team1;
    }

    public String getTeam2() {
        return team2;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public String getCodigoEquipoGanador() {
        return codigoEquipoGanador;
    }

    public void setEquipo1(Equipo equipo1) {
        this.equipo1 = equipo1;
    }

    public void setGanador(Equipo ganador) {
        this.ganador = ganador;
    }

    public void setEquipo2(Equipo equipo2) {
        this.equipo2 = equipo2;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setFase(String fase) {
        this.fase = fase;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setJugado(boolean jugado) {
        this.jugado = jugado;
    }

    public void setTeam1(String team1) {
        this.team1 = team1;
    }

    public void setTeam2(String team2) {
        this.team2 = team2;
    }

    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public void setCodigoEquipoGanador(String codigoEquipoGanador) {
        this.codigoEquipoGanador = codigoEquipoGanador;
    }
    
    @Override
    public String toString() {
        return "Partido{" + "equipo1=" + team1 + ", equipo2=" + team2 + ", golesEquipo1=" + golesEquipo1 + ", golesEquipo2=" + golesEquipo2 + ", fecha=" + fecha + '}';
    }
    
    

}
