/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import CapaAccesoBD.Conector;
import cl.Usuario;
import java.sql.*;
import java.util.*;

/**
 * @Nombre del programa: MultiUsuario
 * @Descripción:
 * @Fecha de creación: Aug 1, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */
public class MultiUsuario {

    private static Conector miConector = new Conector();
    private static String usuarioActivo;

    public void crear(String pCorreo, String pPassword, int rol, String pNombreUsuario, String pApellidoUsuario, String pAvatar, String pUsuario, int pPuntos, String pEquipoFavorito, String pLigaPrivada, String pLigaPublica) throws java.sql.SQLException, Exception {

        String sql;
        sql = "INSERT INTO USUARIO " + "(correo, password, rol, nombreUsuario, apellidoUsuario, avatar, usuario, puntos, equipoFavorito, nombreLigaPrivada, nombreLigaPublica) "
                + "VALUES ('" + pCorreo + "', '" + pPassword + "', '" + rol + "', '" + pNombreUsuario + "', '" + pApellidoUsuario + "', '" + pAvatar + "', '" + pUsuario + "', '" + pPuntos + "', '" + pEquipoFavorito + "', '" + pLigaPrivada + "', '" + pLigaPublica + "');";
        miConector.getConector().ejecutarSQL(sql);
    }

    public Usuario buscar(String pUsuario) throws java.sql.SQLException, Exception {

        ResultSet rs = null;
        Usuario miUsuario = null;
        String sql;
        sql = "SELECT correo, password, rol, nombreUsuario, apellidoUsuario, avatar, usuario, puntos, equipoFavorito "
                + "FROM USUARIO "
                + "WHERE usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miUsuario = new Usuario(rs.getString("correo"), rs.getString("password"), rs.getInt("rol"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("avatar"), rs.getString("usuario"), rs.getInt("puntos"), rs.getString("equipoFavorito"));
        }
        rs.close();

        return miUsuario;
    }
//    

    public boolean existe(String pUsuario) throws java.sql.SQLException, Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT usuario "
                + "FROM USUARIO "
                + "WHERE usuario= '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            existe = true;
        }
        rs.close();

        return existe;
    }
//    

    public ArrayList<Usuario> listar() throws java.sql.SQLException, Exception {

        ArrayList<Usuario> lista = new ArrayList();
        Usuario miUsuario = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT correo, password, rol, nombreUsuario, apellidoUsuario, avatar, usuario, puntos, equipoFavorito "
                + "FROM USUARIO";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            miUsuario = new Usuario(rs.getString("correo"), rs.getString("password"), rs.getInt("rol"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("avatar"), rs.getString("usuario"), rs.getInt("puntos"), rs.getString("equipoFavorito"));
            lista.add(miUsuario);
        }
        rs.close();

        return lista;
    }

    public void actualizar(Usuario pUsuario) throws java.sql.SQLException, Exception {

        String sql;
        sql = "UPDATE USUARIO "
                + "SET correo= '" + pUsuario.getCorreo() + "', password= '" + pUsuario.getContrasenha() + "', rol= '" + pUsuario.getRol() + "', nombreUsuario= '" + pUsuario.getNombre() + "', apellidoUsuario= '" + pUsuario.getApellido() + "', avatar= '" + pUsuario.getAvatar() + "', puntos= '" + pUsuario.getPuntos() + "', equipoFavorito= '" + pUsuario.getEquipoFavorito() + "'"
                + "WHERE usuario= '" + pUsuario.getNombreUsuario() + "';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pUsuario) throws java.sql.SQLException, Exception {

        String sql;
        sql = "DELETE FROM USUARIO "
                + "WHERE usuario = '" + pUsuario + "';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public boolean validarCredenciales(String pUsuario, String pPassword) throws Exception {

        boolean autorizado = false;
        ResultSet rs = null;
        String sql;
        sql = "SELECT usuario, password "
                + "FROM USUARIO "
                + "WHERE usuario= '" + pUsuario + "'"
                + "AND password = '" + pPassword + "'";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            autorizado = true;
        }
        rs.close();
        usuarioActivo = pUsuario;

        return autorizado;
    }

    public int obtenerRol(String pUsuario) throws Exception {

        int rol = 0;
        ResultSet rs = null;
        String sql;
        sql = "SELECT rol "
                + "FROM USUARIO "
                + "WHERE usuario= '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            rol = rs.getInt("rol");
        }
        rs.close();
        return rol;
    }

    public String[] getDatosUsuarioActivo() throws Exception {

        ResultSet rs = null;
        Usuario miUsuario = null;
        String sql;
        sql = "SELECT usuario "
                + "FROM USUARIO "
                + "WHERE usuario = '" + usuarioActivo + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miUsuario = new Usuario(rs.getString("correo"), rs.getString("password"), rs.getInt("rol"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("avatar"), rs.getString("usuario"), rs.getInt("puntos"), rs.getString("equipoFavorito"));
        } else {
            throw new Exception();
        }
        rs.close();

        String[] usuario = new String[5];
        String rol = Integer.toString(miUsuario.getRol());

        usuario[0] = rol;
        usuario[1] = miUsuario.getCorreo();
        usuario[2] = miUsuario.getNombreUsuario();
        usuario[3] = miUsuario.getNombre();
        usuario[4] = miUsuario.getApellido();

        return usuario;
    }

    public ArrayList<String> getPuntosUsuarios() throws Exception {

        ArrayList<String> lista = new ArrayList();
        ResultSet rs = null;
        Usuario miUsuario = null;
        int rol = 2;
        String sql;
        sql = "SELECT usuario, puntos "
                + "FROM USUARIO "
                + "WHERE rol = '" + rol + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            String nombreUsuario = (rs.getString("usuario") + "," + String.valueOf(rs.getInt("puntos")));
            lista.add(nombreUsuario);
        }
        rs.close();

        return lista;
    }

    public ArrayList<String> getUsuarios() throws Exception {

        ArrayList<String> usuarios = new ArrayList();
        ResultSet rs = null;
        Usuario miUsuario = null;
        String sql;
        sql = "SELECT correo, password, rol, nombreUsuario, apellidoUsuario, avatar, usuario, puntos, equipoFavorito "
                + "FROM USUARIO";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            miUsuario = new Usuario(rs.getString("correo"), rs.getString("password"), rs.getInt("rol"), rs.getString("nombreUsuario"), rs.getString("apellidoUsuario"), rs.getString("avatar"), rs.getString("usuario"), rs.getInt("puntos"), rs.getString("equipoFavorito"));
            String nombreUsuario = miUsuario.getNombreUsuario();
            usuarios.add(nombreUsuario);
        }
        rs.close();

        return usuarios;
    }

    public ArrayList<String> getUsuariosNoRegistrados() throws Exception {

        ArrayList<String> usuarios = new ArrayList();
        ResultSet rs = null;
        Usuario miUsuario = null;
        String vacio = "noExiste";
        int rol = 2;
        String sql;
        sql = "SELECT usuario "
                + "FROM USUARIO "
                + "WHERE nombreLigaPrivada = '" + vacio + "'"
                + "AND rol = '" + rol + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            usuarios.add(rs.getString("usuario"));
        }
        rs.close();

        return usuarios;
    }

    public void actualizarPuntos(String pUsuario, int pPuntos) throws java.sql.SQLException, Exception {

        String sql;
        sql = "UPDATE USUARIO "
                + "SET puntos= '" + pPuntos + "'"
                + "WHERE usuario= '" + pUsuario + "';";
        miConector.getConector().ejecutarSQL(sql);

    }

    public void agregarLiga(String pUsuario, String pLiga) throws Exception {

        String sql;
        sql = "UPDATE USUARIO "
                + "SET nombreLigaPrivada= '" + pLiga + "'"
                + "WHERE usuario= '" + pUsuario + "';";
        miConector.getConector().ejecutarSQL(sql);
    }

    public boolean usuarioLigaPrivada(int pPais, String pUsuario) throws Exception {

        ResultSet rs = null;
        boolean existe = false;
        String lleno = "noExiste";
        String sql;
        sql = "SELECT usuario "
                + "FROM USUARIO "
                + "WHERE nombreLigaPrivada <> '" + lleno + "'"
                + "AND usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            existe = true;
        }
        rs.close();

        return existe;
    }

    public String obtenerNombreLigaPrivada(String pUsuario) throws Exception {

        ResultSet rs = null;
        String miLiga = null;
        String sql;
        sql = "SELECT nombreLigaPrivada "
                + "FROM USUARIO "
                + "WHERE usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miLiga = rs.getString("nombreLigaPrivada");
        }
        rs.close();

        return miLiga;
    }

    public String obtenerNombreLigaPublica(String pUsuario) throws Exception {

        ResultSet rs = null;
        String miLiga = null;
        String sql;
        sql = "SELECT nombreLigaPublica "
                + "FROM USUARIO "
                + "WHERE usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miLiga = rs.getString("nombreLigaPublica");
        }
        rs.close();

        return miLiga;
    }

    public int obtenerPuntosUsuario(String pUsuario) throws Exception {

        ResultSet rs = null;
        int puntosUsuario = 0;
        String sql;
        sql = "SELECT puntos "
                + "FROM USUARIO "
                + "WHERE usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            puntosUsuario = rs.getInt("puntos");
        }
        rs.close();

        return puntosUsuario;
    }

    public ArrayList<String> obtenerDatosUsuariosLiga(String pNombreLiga) throws Exception {

        ArrayList<String> miLista = new ArrayList();
        String usuario = null;
        String nombreUsuario = null;
        int puntosUsuario = 0;
        int rol = 2;
        ResultSet rs = null;
        String sql;
        sql = "SELECT usuario, puntos "
                + "FROM USUARIO "
                + "WHERE nombreLigaPrivada = '" + pNombreLiga + "'"
                + "AND rol = '" + rol + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            nombreUsuario = rs.getString("usuario");
            puntosUsuario = rs.getInt("puntos");
            usuario = nombreUsuario + "/" + puntosUsuario;
            miLista.add(usuario);
        }
        rs.close();

        return miLista;
    }
}
