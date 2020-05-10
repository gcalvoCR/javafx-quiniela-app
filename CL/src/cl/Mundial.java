/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

/**
 *
 * @author Gabriel
 */
public class Mundial {

    private int codigoMundial; //Sergio
    private LocalDate fecha;
    private String paisOrganizador;
    private boolean estado;
    private ArrayList<Grupo> listaGrupos;
    private ArrayList<Cronograma> listaPartidos;
//    private ArrayList<Liga> listaLigas;

    public Mundial() {
    }

    public Mundial(LocalDate fecha, String paisOrganizador, boolean estado, ArrayList<Grupo> listaGrupos) {
        this.fecha = fecha;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
        this.listaGrupos = listaGrupos;
    }
    
    public Mundial(int codigoMundial, LocalDate fecha, String paisOrganizador, boolean estado, ArrayList<Grupo> plistaGrupos) {
        this.codigoMundial = codigoMundial;
        this.fecha = fecha;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
        this.listaGrupos = plistaGrupos;
    }

    public Mundial(int codigoMundial, LocalDate fecha, String paisOrganizador, boolean estado) {
        this.codigoMundial = codigoMundial;
        this.fecha = fecha;
        this.paisOrganizador = paisOrganizador;
        this.estado = estado;
    }

    
    public void setListaPartidos(ArrayList<Cronograma> listaPartidos) {
        if (listaPartidos == null) {
            listaPartidos = new ArrayList();
        }
        this.listaPartidos = listaPartidos;
    }

//    public ArrayList<Liga> getListaLigas() {
//        if (listaLigas == null) {
//            listaLigas = new ArrayList();
//        }
//        return listaLigas;
//    }
//
//    public ArrayList<String> getListaLigasString() {
//        if (listaLigas == null) {
//            listaLigas = new ArrayList();
//        }
//        ArrayList<String> lista = new ArrayList();
//        for (Liga x : listaLigas) {
//            String estatus;
//            String activa;
//            if (x.isPrivada()) {
//                estatus = "liga privada";
//            } else {
//                estatus = "liga publica";
//            }
//            if (x.isEstatus()) {
//                activa = "activa";
//            } else {
//                activa = "inactiva";
//            }
//
//            lista.add("- " + x.getNombre() + ", " + estatus + ", " + activa);
//        }
//        return lista;
//    }
//
//    public void setListaLigas(Liga pLigaX) {
//        if (listaLigas == null) {
//            listaLigas = new ArrayList();
//        }
//        listaLigas.add(pLigaX);
//    }
//
    public LocalDate getFecha() {
        return fecha;
    }

    public String getPaisOrganizador() {
        return paisOrganizador;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    public boolean getEstado() {
        return estado;
    }

    public ArrayList<Grupo> getListaGrupos() {
        return listaGrupos;
    }

    
    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }

    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }

    public void setPaisOrganizador(String paisOrganizador) {
        this.paisOrganizador = paisOrganizador;
    }

    public void setEstado(boolean estado) {
        this.estado = estado;
    }

    public void anhadirGrupo(Grupo grupoX) {
        if (listaGrupos == null) {
            listaGrupos = new ArrayList();
        }
        listaGrupos.add(grupoX);

    }

    public ArrayList<Cronograma> getCronograma() {
        return listaPartidos;
    }

    public ArrayList<String> getListaPartidos() {
        ArrayList<String> lista = new ArrayList();
        for (Cronograma x : listaPartidos) {
            lista.add(x.getFecha().toString()+": "+x.getEquipo1().getNombre() + " - " + x.getEquipo2().getNombre());
        }
        return lista;
    }

    public ArrayList<String> getListaPartidosCompleto() {
        if (listaPartidos == null) {
            listaPartidos = new ArrayList();
        }
        ArrayList<String> lista = new ArrayList();
        for (Cronograma x : listaPartidos) {
            
            lista.add(x.getCodigo()
                    + "/" + x.getEquipo1().getNombre()
                    + "//" + x.getEquipo2().getNombre()
                    + "///" + x.getFecha().toString()
                    + "////" + x.getFase()
                    + "/////" + x.getGolesEquipo1()
                    + "//////" + x.getGolesEquipo2()
                    + "///////" + x.getJugado());
        }
        return lista;
    }
    
        public ArrayList<String> getListaPartidosparaCronograma() {
        if (listaPartidos == null) {
            listaPartidos = new ArrayList();
        }
        ArrayList<String> lista = new ArrayList();
        for (Cronograma x : listaPartidos) {
            
            lista.add(x.getFecha().toString()
                    + ": "+ x.getEquipo1().getNombre()
                    + " / " +x.getEquipo2().getNombre());
    
        }
        return lista;
    }

    @Override
    public String toString() {
        return "Mundial{" + "fecha=" + fecha + ", paisOrganizador=" + paisOrganizador + ", estado=" + estado + '}';
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Mundial other = (Mundial) obj;
        if (!Objects.equals(this.paisOrganizador, other.paisOrganizador)) {
            return false;
        }
        return true;
    }

}
