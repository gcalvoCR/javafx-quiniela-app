/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.Equipo;
import cl.Grupo;
import cl.Mundial;
import cl.Cronograma;
import static gestores.Gestor.cl;
import java.util.ArrayList;
import multis.*;

/**
 *
 * @author Gabriel
 */
public class GestorCronogramas extends Gestor {
    
    private static MultiMundial multiM = new MultiMundial();
    private static MultiGrupo multiG = new MultiGrupo();
    private static MultiEquipo multiE = new MultiEquipo();
    private static MultiCronograma multiC = new MultiCronograma();

    public ArrayList<String> getCronograma(String pais) throws Exception {
        ArrayList<String> lista = new ArrayList();

        int codigoMundial = multiM.obtenerCodigo(pais);
        
        lista = multiC.listarArrayCronograma(codigoMundial);

        return lista;

    }

    public ArrayList<String> getCronogramaCompleto(int pMundial) throws Exception {
        
        ArrayList<String> lista = new ArrayList();
        ArrayList<Cronograma> miCronograma = new ArrayList();
        //miCronograma = multiC.listarCronograma(codigoMundial);
        
        miCronograma = multiC.listarCronograma(pMundial);
        
        for (Cronograma x : miCronograma) {
            
            lista.add(x.getCodigo()
                    + "/" + x.getTeam1()
                    + "//" + x.getTeam2()
                    + "///" + x.getFecha().toString()
                    + "////" + x.getFase()
                    + "/////" + x.getGolesEquipo1()
                    + "//////" + x.getGolesEquipo2()
                    + "///////" + x.getJugado());
        }
        return lista;
    }

    public void setCronograma(int mundial) throws Exception {
        ArrayList<Cronograma> listaPartidos = new ArrayList();
        Mundial x = multiM.buscar(mundial);
        ArrayList<Grupo> gruposMundial = multiG.buscarGrupos(mundial);
        int i = 0;
        
        for (Grupo y : gruposMundial) {
            String team1 = y.getIsoEquipo1();
            Equipo equipo1 = multiE.buscar(team1);
            String team2 = y.getIsoEquipo2();
            Equipo equipo2 = multiE.buscar(team2);
            String team3 = y.getIsoEquipo3();
            Equipo equipo3 = multiE.buscar(team3);
            String team4 = y.getIsoEquipo4();
            Equipo equipo4 = multiE.buscar(team4);

            multiC.crearAlterno((i * (6) + 1), team1, team2, x.getFecha().plusDays(1 + i), y.getNombreGrupo(), mundial);
            multiC.crearAlterno((i * (6) + 2), team3, team4, x.getFecha().plusDays(1 + i), y.getNombreGrupo(), mundial);
            multiC.crearAlterno((i * (6) + 3), team1, team3, x.getFecha().plusDays(5 + i), y.getNombreGrupo(), mundial);
            multiC.crearAlterno((i * (6) + 4), team2, team4, x.getFecha().plusDays(5 + i), y.getNombreGrupo(), mundial);
            multiC.crearAlterno((i * (6) + 5), team1, team4, x.getFecha().plusDays(10 + i), y.getNombreGrupo(), mundial);
            multiC.crearAlterno((i * (6) + 6), team2, team3, x.getFecha().plusDays(10 + i), y.getNombreGrupo(), mundial);
            i++;
        }
    }

    public void actualizarResultadosCronograma(String pais, int codigo, int goles1, int goles2) throws Exception {
        
        int codigoMundial = multiM.obtenerCodigo(pais);
        ArrayList<Cronograma> miArrayCronograma = new ArrayList();
        miArrayCronograma = multiC.listarCronograma(codigoMundial);
        
        for(Cronograma miCronograma: miArrayCronograma) {
            
            if (miCronograma.getCodigo() == codigo) {
                
                multiC.guardarGolesEquipo1(codigo, goles1);
                multiC.guardarGolesEquipo2(codigo, goles2);
                String ganador;
                if (goles1 > goles2) {
                    ganador = miCronograma.getTeam1();
                    
                } else {
                    ganador = miCronograma.getTeam2();
                }
                multiC.guardarGanador(codigo, ganador);
                boolean jugado = true;
                multiC.guardarJugado(codigo, jugado);
            }
        }
        
    }

    public ArrayList<String> getCronogramaCompletoMundialActivo() throws Exception {
        ArrayList<String> cronogramaMundial = new ArrayList();
        ArrayList<Mundial> miMundial = new ArrayList();
        miMundial = multiM.listar();

        for (Mundial dato : miMundial) {
            if (dato.getEstado()) {
                int codigoMundial = dato.getCodigoMundial();
                cronogramaMundial = multiC.listarArrayCronograma(codigoMundial);
            }
        }
        return cronogramaMundial;
    }
    
    public ArrayList<String> getCronogramaMundialActivo() throws Exception {
        
        ArrayList<String> lista = new ArrayList();
        ArrayList<Mundial> miMundial = new ArrayList();
        miMundial = multiM.listar();
        ArrayList<Cronograma> miCronograma = new ArrayList();
        int codigoMundial = 0;
        
        for (Mundial dato : miMundial) {
            if (dato.getEstado()) {
                codigoMundial = dato.getCodigoMundial();
            }
        }
        
        miCronograma = multiC.listarCronograma(codigoMundial);
        
        for (Cronograma x : miCronograma) {
            
            lista.add(x.getFecha().toString()
                    + ": "+ x.getTeam1()
                    + " / " +x.getTeam2());
    
        }
        return lista;
        
    }
    
    

}
