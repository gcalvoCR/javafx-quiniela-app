/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.Equipo;
import cl.Grupo;
import cl.Mundial;
import java.util.ArrayList;
import multis.*;

/**
 *
 * @author Gabriel
 */
public class GestorGrupos extends Gestor{
    
    private static MultiMundial multiM = new MultiMundial();
    private static MultiEquipo multiE = new MultiEquipo();
    private static MultiGrupo multiG = new MultiGrupo();
    
    public void setGrupoMundial(int mundial, String codGrupo, String nombreGrupo, ArrayList<String> pequipos) throws Exception {
        ArrayList<Mundial> mundiales = multiM.listar();
        ArrayList<Equipo> equipos = multiE.listar();
        ArrayList<Equipo> equiposGrupo = new ArrayList();
        String equipo1 = null;
        String equipo2 = null;
        String equipo3 = null;
        String equipo4 = null;
        
        for (Equipo e : equipos) {
            if (e.getNombre().equals(pequipos.get(0))) {
                equipo1 = e.getIso();
            }
            if (e.getNombre().equals(pequipos.get(1))) {
                equipo2 = e.getIso();
            }
            if (e.getNombre().equals(pequipos.get(2))) {
                equipo3 = e.getIso();
            }
            if (e.getNombre().equals(pequipos.get(3))) {
                equipo4 = e.getIso();
            }

        }
        
        multiG.crear(codGrupo, nombreGrupo, mundial, equipo1, equipo2, equipo3, equipo4);
        }
    
}
