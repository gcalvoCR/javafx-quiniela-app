/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class Grupo {

    private String codigo;
    private String nombreGrupo;
    private int codigoMundial; //Sergio
    private String isoEquipo1; //Sergio
    private String isoEquipo2; //Sergio
    private String isoEquipo3; //Sergio
    private String isoEquipo4; //Sergio
    private ArrayList<Equipo> listaEquipos;

    public Grupo() {
    }

    public Grupo(String codigo, String nombreGrupo, ArrayList<Equipo> listaEquipos) {
        this.codigo = codigo;
        this.nombreGrupo = nombreGrupo;
        this.listaEquipos = listaEquipos;
    }

    public Grupo(String codigo, String nombreGrupo, int codigoMundial, String isoEquipo1, String isoEquipo2, String isoEquipo3, String isoEquipo4, ArrayList<Equipo> listaEquipos) {
        this.codigo = codigo;
        this.nombreGrupo = nombreGrupo;
        this.codigoMundial = codigoMundial;
        this.isoEquipo1 = isoEquipo1;
        this.isoEquipo2 = isoEquipo2;
        this.isoEquipo3 = isoEquipo3;
        this.isoEquipo4 = isoEquipo4;
        this.listaEquipos = listaEquipos;
    }

    public Grupo(String codigo, String nombreGrupo, int codigoMundial, String isoEquipo1, String isoEquipo2, String isoEquipo3, String isoEquipo4) {
        this.codigo = codigo;
        this.nombreGrupo = nombreGrupo;
        this.codigoMundial = codigoMundial;
        this.isoEquipo1 = isoEquipo1;
        this.isoEquipo2 = isoEquipo2;
        this.isoEquipo3 = isoEquipo3;
        this.isoEquipo4 = isoEquipo4;
    }

    public void setListaEquipos(ArrayList<Equipo> equiposAsociados) {
        if (listaEquipos == null) {
            listaEquipos = new ArrayList();
        }
        for (int i = 0; i < equiposAsociados.size(); i++) {
            listaEquipos.add(equiposAsociados.get(i));
        }
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreGrupo() {
        return nombreGrupo;
    }
    
    public ArrayList<Equipo> getEquipos() {
    return listaEquipos;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public String getIsoEquipo1() {
        return isoEquipo1;
    }

    public String getIsoEquipo2() {
        return isoEquipo2;
    }

    public String getIsoEquipo3() {
        return isoEquipo3;
    }

    public String getIsoEquipo4() {
        return isoEquipo4;
    }

    public ArrayList<String> getListaEquipos() {
        ArrayList<String> lista = new ArrayList();
        for (Equipo x : listaEquipos) {
            lista.add(x.toString());

        }
        return lista;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public void setNombreGrupo(String nombreGrupo) {
        this.nombreGrupo = nombreGrupo;
    }

    public void setIsoEquipo1(String isoEquipo1) {
        this.isoEquipo1 = isoEquipo1;
    }

    public void setIsoEquipo2(String isoEquipo2) {
        this.isoEquipo2 = isoEquipo2;
    }

    public void setIsoEquipo3(String isoEquipo3) {
        this.isoEquipo3 = isoEquipo3;
    }

    public void setIsoEquipo4(String isoEquipo4) {
        this.isoEquipo4 = isoEquipo4;
    }

    public String getListaEquiposAsociados() {
        String log = "";
        for (Equipo x : listaEquipos) {
            log += x.getNombre() +"\n";
        }
        return log;
    }

    @Override
    public String toString() {
        return "Grupo{" + "codigo=" + codigo + ", nombreGrupo=" + nombreGrupo + ", codigoMundial=" + codigoMundial + ", listaEquipos=" + listaEquipos + '}';
    }

}
