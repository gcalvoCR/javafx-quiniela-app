/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multis;

import CapaAccesoBD.Conector;
import cl.*;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * @Nombre del programa: MultiPredicciones
 * @Descripción:
 * @Fecha de creación: Aug 12, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */
public class MultiPrediccion {

    private static Conector miConector = new Conector();
    private static MultiMundial multiM = new MultiMundial();
    private static MultiEquipo multiE = new MultiEquipo();

    public void crear(int pCodigo, int pCodigoMundial, int pGolesEquipo1, int pGolesEquipo2, String pGanadorPrediccion, String pUsuario) throws java.sql.SQLException, Exception {
        String llave = pCodigoMundial + pUsuario + pCodigo;

        String sql;
        sql = "INSERT INTO PREDICCION2 "
                + "(llave, codigoPrediccion, codigoMundial, golesEquipo1, golesEquipo2, codigoEquipoGanador, usuario) "
                + "VALUES ('" + llave + "', '" + pCodigo + "', '" + pCodigoMundial + "', '" + pGolesEquipo1 + "', '" + pGolesEquipo2 + "', '" + pGanadorPrediccion + "', '" + pUsuario + "');";
        miConector.getConector().ejecutarSQL(sql);
    }

    public Prediccion buscar(String pPrediccion) throws java.sql.SQLException, Exception {

        ResultSet rs = null;
        Prediccion miPrediccion = null;
        String sql;
        sql = "SELECT codigoPrediccion "
                + "FROM PREDICCION2 "
                + "WHERE codigoPrediccion = '" + pPrediccion + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miPrediccion = getPrediccionDesdeResultSet(rs);

        } else {
            throw new Exception();
        }
        rs.close();

        return miPrediccion;
    }
//    

    public boolean existe(String pPrediccion) {
        boolean existe = false;
        try {
            ResultSet rs = null;

            String sql;
            sql = "SELECT codigoPrediccion "
                    + "FROM PREDICCION2 "
                    + "WHERE llave= '" + pPrediccion + "';";
            rs = miConector.getConector().ejecutarSQL(sql, true);

            if (rs.next()) {
                existe = true;
            }
            rs.close();

        } catch (Exception ex) {
        }
        return existe;
    }
//    

    public ArrayList<Prediccion> listar() throws java.sql.SQLException, Exception {

        ArrayList<Prediccion> lista = new ArrayList();
        Prediccion miPrediccion = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoPrediccion, codigoMundial, golesEquipo1, golesEquipo2, codigoEquipoGanador, usuario "
                + "FROM PREDICCION2";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            Mundial miMundial = new Mundial();
            miMundial = multiM.buscar(rs.getInt("codigoMundial"));
            Equipo miEquipo = new Equipo();
            miEquipo = multiE.buscar(rs.getString("codigoEquipoGanador"));
            miPrediccion = new Prediccion(rs.getInt("codigoPrediccion"), miMundial, rs.getInt("golesEquipo1"), rs.getInt("golesEquipo2"), miEquipo, rs.getString("usuario"));
            lista.add(miPrediccion);
        }
        rs.close();

        return lista;
    }

    public void actualizar(Prediccion pPrediccion) throws java.sql.SQLException, Exception {

        String sql;
        Mundial miMundial = new Mundial();
        miMundial = pPrediccion.getMundialPrediccion();
        int codigoMundial = miMundial.getCodigoMundial();
        Equipo miEquipo = new Equipo();
        miEquipo = pPrediccion.getGanadorPrediccion();
        String equipoGanador = miEquipo.getIso();
        sql = "UPDATE PREDICCION2 "
                + "SET codigoMundial= '" + codigoMundial + "', golesEquipo1= '" + pPrediccion.getGolesEquipo1() + "', golesEquipo2= '" + pPrediccion.getGolesEquipo2() + "', codigoEquipoGanador= '" + equipoGanador + "'"
                + "WHERE codigoPrediccion= '" + pPrediccion.getCodigo() + "';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pPrediccion) throws java.sql.SQLException, Exception {

        String sql;
        sql = "DELETE FROM PREDICCION2 "
                + "WHERE codigoPrediccion = '" + pPrediccion + "';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public ArrayList<Prediccion> buscarListaPredicciones(String pUsuario) throws java.sql.SQLException, Exception {

        ArrayList<Prediccion> lista = new ArrayList();
        Prediccion miPrediccion;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoPrediccion, codigoMundial, golesEquipo1, golesEquipo2, codigoEquipoGanador, usuario "
                + "FROM PREDICCION2 "
                + "WHERE usuario = '" + pUsuario + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            miPrediccion = new Prediccion(rs.getInt("codigoPrediccion"), rs.getInt("codigoMundial"), rs.getInt("golesEquipo1"), rs.getInt("golesEquipo2"), rs.getString("codigoEquipoGanador"), rs.getString("usuario"));
            lista.add(miPrediccion);
        }
        rs.close();

        return lista;
    }

    public Prediccion getPrediccionDesdeResultSet(ResultSet rs) throws SQLException, Exception {

        Prediccion nuevo = new Prediccion();
        nuevo.setCodigo(rs.getInt("codigoPrediccion"));
        nuevo.setMundialPrediccion((new MultiMundial()).getMundialDesdeResultSet(rs));
        nuevo.setGolesEquipo1(rs.getInt("golesEquipo1"));
        nuevo.setGolesEquipo2(rs.getInt("golesEquipo2"));
        nuevo.setGanadorPrediccion((new MultiEquipo()).getEquipoDesdeResultSet(rs));
        nuevo.setUsuario(rs.getString("usuario"));
        return nuevo;
    }

}
