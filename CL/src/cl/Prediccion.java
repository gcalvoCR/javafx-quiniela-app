/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

/**
 *
 * @author Gabriel
 */
public class Prediccion {

    private int codigo;
    private Mundial mundialPrediccion;
    private int codigoMundial; //Sergio
    private int golesEquipo1;
    private int golesEquipo2;
    private String codigoEquipoGanador; //Sergio
    private Equipo ganadorPrediccion;
    private String usuario; //Sergio

    public Prediccion() {
    }

    public Prediccion(int codigo, Mundial mundialPrediccion, int golesEquipo1, int golesEquipo2, Equipo ganadorPrediccion, String usuario) {
        this.codigo = codigo;
        this.mundialPrediccion = mundialPrediccion;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.ganadorPrediccion = ganadorPrediccion;
        this.usuario = usuario;
    }

    public Prediccion(int codigo, int codigoMundial, int golesEquipo1, int golesEquipo2, String codigoEquipoGanador, String usuario) {
        this.codigo = codigo;
        this.codigoMundial = codigoMundial;
        this.golesEquipo1 = golesEquipo1;
        this.golesEquipo2 = golesEquipo2;
        this.codigoEquipoGanador = codigoEquipoGanador;
        this.usuario = usuario;
    }

    public Equipo getGanadorPrediccion() {
        return ganadorPrediccion;
    }

    public Mundial getMundialPrediccion() {
        return mundialPrediccion;
    }

    public int getCodigo() {
        return codigo;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public int getGolesEquipo1() {
        return golesEquipo1;
    }

    public int getGolesEquipo2() {
        return golesEquipo2;
    }

    public String getCodigoEquipoGanador() {
        return codigoEquipoGanador;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setMundialPrediccion(Mundial mundialPrediccion) {
        this.mundialPrediccion = mundialPrediccion;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public void setGolesEquipo1(int golesEquipo1) {
        this.golesEquipo1 = golesEquipo1;
    }

    public void setGolesEquipo2(int golesEquipo2) {
        this.golesEquipo2 = golesEquipo2;
    }

    public void setGanadorPrediccion(Equipo ganadorPrediccion) {
        this.ganadorPrediccion = ganadorPrediccion;
    }

    public void setCodigoEquipoGanador(String codigoEquipoGanador) {
        this.codigoEquipoGanador = codigoEquipoGanador;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

}
