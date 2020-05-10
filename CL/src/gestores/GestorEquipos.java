/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.*;
import java.util.ArrayList;
import multis.MultiEquipo;

/**
 *
 * @author Gabriel
 */
public class GestorEquipos extends Gestor {
    
    private static MultiEquipo multiE = new MultiEquipo();

    public GestorEquipos() {
    }

    public String setEquipo(String iso, String nombre, int rankinFIFA) throws Exception {
        String log = "";
        String bandera = null;
        boolean existe = true;
        existe = multiE.existe(iso);
        if(existe == false) {
            multiE.crear(iso, nombre, rankinFIFA, bandera);
            log = "Registro exitoso";
        } else {
            log = "El equipo ya se encuentra registrado";
        }
        return log;
    }

    public String[] listarEquipos() throws Exception {
        
        return multiE.listarArray();
    }

    public ArrayList<String> getListaEquipos() throws Exception {
        ArrayList<Equipo> lista = multiE.listar();
        ArrayList<String> listaString = new ArrayList();
        for (Equipo x : lista) {
            String renglon = x.getIso()+"/"+x.getNombre()+"//"+x.getRankinFIFA();
            listaString.add(renglon);
        }
        return listaString;
    }
    
    public void borrarEquipo(String pIso) throws Exception {
        multiE.borrar(pIso);
    }
    
    public void actualizar(String pIso, String pNombre, int pRankingFIFA) throws Exception {
        
        Equipo miEquipo = new Equipo(pIso, pNombre, pRankingFIFA);
        multiE.actualizar(miEquipo);
    }

}
