package gestores;

import cl.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import multis.*;

public class GestorPredicciones extends Gestor {

    private static MultiUsuario multiU = new MultiUsuario();
    private static MultiEquipo multiE = new MultiEquipo();
    private static MultiMundial multiM = new MultiMundial();
    private static MultiPrediccion multiP = new MultiPrediccion();
    private static MultiCronograma multiC = new MultiCronograma();

    public void registrarPrediccion(String nombreUsuario, int mundial, int codigoPartido, int codigoMundial, int goles1, int goles2, String equipo1, String equipo2) throws Exception {
        Usuario usuarioX = multiU.buscar(nombreUsuario);
        Mundial mundialX = multiM.buscar(mundial);
        String equipoGanadorPrediccion;
        String codigoEquipo;
        
        if (goles1 > goles2) {
            equipoGanadorPrediccion = equipo1;
            codigoEquipo = equipo1;
        } else {
            equipoGanadorPrediccion = equipo2;
            codigoEquipo = equipo2;
        }

        String llave = codigoMundial + nombreUsuario + codigoPartido;

        //Esta validacion permite saber si ya la prediccion se hizo
        if (multiP.existe(llave)) {
        } else {
            multiP.crear(codigoPartido, codigoMundial, goles1, goles2, codigoEquipo, nombreUsuario);

            // setear puntos
            setearPuntos(nombreUsuario, mundial);
        }

    }

    public ArrayList<String> getprediccionesRegistrada(String nombreUsuario, int mundial) throws Exception {
        Usuario usuarioX = multiU.buscar(nombreUsuario);
        Mundial mundialX = multiM.buscar(mundial);
        int codigoMundial = mundialX.getCodigoMundial();

        ArrayList<Prediccion> listaPredicciones = multiP.buscarListaPredicciones(nombreUsuario);
        ArrayList<String> listaInformacion = new ArrayList();
        for (Prediccion x : listaPredicciones) {
            if (x.getCodigoMundial() == (codigoMundial)) {
                String info = x.getCodigo() + "/" + x.getGolesEquipo1() + "//" + x.getGolesEquipo2();
                listaInformacion.add(info);
                System.out.println(info);
            }
        }
        return listaInformacion;
    }

    private void setearPuntos(String pUsuario, int mundial) {

        try {
            ArrayList<Cronograma> cronoX = multiC.listarCronograma(mundial);
            ArrayList<Prediccion> listaPredicciones = multiP.buscarListaPredicciones(pUsuario);
            int puntosJugador = 100;
            for (Cronograma x : cronoX) {
                if (x.getJugado() == true) {
                    for (Prediccion y : listaPredicciones) {
                        if (y.getCodigo() == x.getCodigo()) {
                            if (x.getCodigoEquipoGanador().equals(y.getGanadorPrediccion())) {
                                puntosJugador += 100;
                            } else {
                                puntosJugador += -45;
                            }
                            if (x.getGolesEquipo1() == y.getGolesEquipo1() && x.getGolesEquipo2() == y.getGolesEquipo1()) {
                                puntosJugador += 300;
                            }
                        }
                    }
                }
            }
            multiU.actualizarPuntos(pUsuario, puntosJugador);
        } catch (Exception ex) {
        }
    }

}
