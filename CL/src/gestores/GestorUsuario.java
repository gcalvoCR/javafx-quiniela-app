/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestores;

import cl.Liga;
import cl.Mundial;
import cl.Usuario;
import multis.*;
import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class GestorUsuario extends Gestor {
    
    private static MultiUsuario multiU = new MultiUsuario();
    private static MultiLiga multiL = new MultiLiga();
    private static MultiMundial multiM = new MultiMundial();
    private static GestorMundiales gestorM = new GestorMundiales(); 

    public boolean validarCredenciales(String pCorreo, String pPassword) throws Exception {
        
        boolean autorizado;
        
        autorizado = multiU.validarCredenciales(pCorreo, pPassword);
        
        return autorizado;
    }
    
    public int obtenerRol( String pCorreo) throws Exception {
        
        int rol = 0;
        
        rol = multiU.obtenerRol(pCorreo);
        
        return rol;
    }

    public boolean existe(String pUsuario) throws Exception {
        
        boolean existe = false;
        
        existe = multiU.existe(pUsuario);
        
        return existe;
    }
    
    public void registrarUsuario(String pCorreo, String pPassword, int pRol, String pNombre, String pApellido, String pAvatar, String pUsuario, int pPuntos, String pEquipoFavorito, String pLigaPrivada, String pLigaPublica) throws Exception {
      
        int mundialActivo = gestorM.getNombreMundialActivo();
        String ligaPublica = String.valueOf(mundialActivo);
        multiU.crear(pCorreo, pPassword, pRol, pNombre, pApellido, pAvatar, pUsuario, pPuntos, pEquipoFavorito, pLigaPrivada, ligaPublica);

    }

    public ArrayList<String> getUsuarios() throws Exception {
        return multiU.getUsuarios();
    }

    public ArrayList<String> getPuntosUsuarios() throws Exception {
        return multiU.getPuntosUsuarios();
    }

    public void setDatosUsuarioActivo(String pUsuarioActivo) throws Exception {
        
        cl.guardarUsuarioActivo(pUsuarioActivo);
    }
    
    public String getDatosUsuarioActivo() {
        
        String usuarioActivo;
        usuarioActivo = cl.obtenerUsuarioActivo();
        return usuarioActivo;
    }

    public ArrayList<String> getUsuariosNoRegistradosEnQuinielaPrivada() throws Exception {

        ArrayList<String> noRegistrados = multiU.getUsuariosNoRegistrados();

        return noRegistrados;

    }

    public ArrayList<String> getListaUsuariosLigaPrivadaPorPais(String usuario) throws Exception {
        
        String nombreLiga = multiU.obtenerNombreLigaPrivada(usuario);
        ArrayList<String> listaUsuariosEnLigaPrivada = new ArrayList();
        
        listaUsuariosEnLigaPrivada = multiU.obtenerDatosUsuariosLiga(nombreLiga);
        return listaUsuariosEnLigaPrivada;
    }

    public String[] buscarUsuario(String pUsuario) throws Exception {
        
        Usuario miUsuario = new Usuario();
        String[] lista = new String[2];
        String nombreUsuario;
        String apellidoUsuario;
        
        miUsuario = multiU.buscar(pUsuario);
        nombreUsuario = miUsuario.getNombre();
        apellidoUsuario = miUsuario.getApellido();
        lista[0] = nombreUsuario;
        lista[1] = apellidoUsuario;
        
        return lista;
    }
    
    public String buscarNombreMundial(int pCodigoMundial) throws Exception {
        
        String nombreMundial;
        Mundial miMundial = new Mundial();
        miMundial = multiM.buscar(pCodigoMundial);
        nombreMundial = miMundial.getPaisOrganizador();
        
        return nombreMundial;
        
    }
}
