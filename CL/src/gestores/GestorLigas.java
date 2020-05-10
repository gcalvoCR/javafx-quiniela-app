/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.Liga;
import cl.Mundial;
import cl.Usuario;
import java.time.LocalDate;
import java.util.ArrayList;
import multis.*;

/**
 *
 * @author Gabriel
 */
public class GestorLigas extends Gestor {
    
    private static MultiMundial multiM = new MultiMundial();
    private static MultiUsuario multiU = new MultiUsuario();
    private static MultiEquipo multiE = new MultiEquipo();
    private static MultiLiga multiL = new MultiLiga();

    public void setLiga(int mundial, String nombre, LocalDate FechaCreacion, boolean privada, boolean estatus, ArrayList<String> nombreUsuarios) throws Exception {
        ArrayList<Usuario> listaUsuarios = new ArrayList();
        for (String usuarioX : nombreUsuarios) {

            multiU.agregarLiga(usuarioX, nombre);
        }

        ArrayList<Mundial> listaMundiales = new ArrayList();
        int iso = 0;
        listaMundiales = multiM.listar();

            multiL.crear(nombre, FechaCreacion, estatus, privada, mundial);
    }

    public ArrayList<String> getLigasPorPais(String pais) throws Exception {
        ArrayList<Liga> listaLigas = new ArrayList();
        ArrayList<String> lista = new ArrayList();
        listaLigas = multiL.listar();
        for (Liga x : listaLigas) {
            if (x.getMundialAsociado().getPaisOrganizador().equals(pais)) {
                lista.add(x.getNombre() + "/" + x.getFechaCreacion() + "//" + x.getMundialAsociado().getPaisOrganizador() + "///" + x.getPrivada() + "////" + x.getEstatus());
            }
        }
        return lista;
    }

    public ArrayList<String> getLigasTotal() throws Exception {
        ArrayList<Liga> listaLigas = new ArrayList();
        ArrayList<String> lista = new ArrayList();
        listaLigas = multiL.listar();
        for (Liga x : listaLigas) {

            lista.add(x.getNombre() + "/" + x.getFechaCreacion() + "//" + x.getCodigoMundial() + "///" + x.getPrivada() + "////" + x.getEstatus());
        }
        
        return lista;
    }

    public boolean verificarSiLigaPublicaRegistrada(String pais) throws Exception {
        return multiL.buscarLigaPublica();
    }

    public boolean verificarSiUsuarioEnQuinielaPrivada(int pais, String usuario) throws Exception {

        boolean registrado = false;
        registrado = multiU.usuarioLigaPrivada(pais, usuario);

        return registrado;
    }

    public String getNombreLigaPublicaPorPais(String pUsuario) throws Exception {
        String nombreLigaPublica = multiU.obtenerNombreLigaPublica(pUsuario);
        String nombre;
        if((nombreLigaPublica) == null) {
            nombre ="No hay Ligas publicas registradas";
        } else {
            nombre = nombreLigaPublica;
        }
        return nombre;
    }
    
    public String getNombreLigaPrivadaPorUsuario(String pUsuario) throws Exception {
        String nombreLigaPrivada = multiU.obtenerNombreLigaPrivada(pUsuario);
        String nombre;
        if((nombreLigaPrivada) == null) {
            nombre ="No hay Ligas publicas registradas";
        } else {
            nombre = nombreLigaPrivada;
        }
        return nombre;
    }
    
}
