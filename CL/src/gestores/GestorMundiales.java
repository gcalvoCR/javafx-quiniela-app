/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.*;
import java.time.LocalDate;
import java.util.ArrayList;
import multis.*;

/**
 *
 * @author Gabriel
 */
public class GestorMundiales extends Gestor {
    
    private static MultiMundial multiM = new MultiMundial();

    public void setMundial(int pCodigo, LocalDate pFecha, String pPaisOrganizador, boolean pEstado) throws Exception {

        Mundial mundialX = new Mundial();

        multiM.crear(pCodigo, pFecha, pPaisOrganizador, pEstado);
        mundialX = multiM.buscar(pCodigo);

    }

    public ArrayList<String> getNombreMundiales() throws Exception {
        ArrayList<String> mundiales = new ArrayList();
        ArrayList<Mundial> listaMundiales = multiM.listar();
        if (listaMundiales.isEmpty()) {
            mundiales.add("No hay mundiales");
        } else {
            for (Mundial x : listaMundiales) {
                mundiales.add(x.getPaisOrganizador());
            }
        }

        return mundiales;
    }

    public ArrayList<String> getInfoMundiales() throws Exception {
        ArrayList<String> mundiales = new ArrayList();
        ArrayList<Mundial> listaMundiales = multiM.listar();
        if (listaMundiales.isEmpty()) {
            mundiales.add("No hay mundiales");
        } else {
            for (Mundial x : listaMundiales) {
                mundiales.add(x.getPaisOrganizador() + ", fecha:" + x.getFecha().toString() + ", estatus:" + x.getEstado());
            }
        }

        return mundiales;
    }

    public int getNombreMundialActivo() throws Exception {
        int nombreMundial = 0;

        for (Mundial dato : multiM.listar()) {
            if (dato.getEstado()) {
                nombreMundial = dato.getCodigoMundial();
            }
        }
        return nombreMundial;
    }

    public boolean verificarExistenciaMundial(String pais) throws Exception {
        return multiM.existe(pais);
    }

    public boolean existenciaMundialActivo() throws Exception {
        boolean hayMundialActivo = false;
        ArrayList<Mundial> listaMundiales = multiM.listar();
        for (Mundial x : listaMundiales) {
            if (x.getEstado() == true) {
                hayMundialActivo = true;
            }
        }
        return hayMundialActivo;
    }

    public void actualizarEstatus(String pais, boolean estado) throws Exception {
        ArrayList<Mundial> listaMundiales = multiM.listar();
        for (Mundial x : listaMundiales) {
            if (x.getPaisOrganizador().equals(pais)) {
                multiM.actualizarEstado(pais, estado);
            }
        }
    }
    
    public int obtenerCodigo(String pMundial) throws Exception {
        
        int codigoMundial;
        codigoMundial = multiM.obtenerCodigo(pMundial);
        return codigoMundial;
    }

}
