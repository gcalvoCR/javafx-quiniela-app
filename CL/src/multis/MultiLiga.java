/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multis;

import CapaAccesoBD.Conector;
import cl.*;
import java.sql.ResultSet;
import java.time.LocalDate;
import java.util.ArrayList;

/**
 * @Nombre del programa: MultiLiga
 * @Descripción: 
 * @Fecha de creación: Aug 12, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */

public class MultiLiga {

    private static Conector miConector = new Conector();

    public void crear(String pNombreLiga, LocalDate pFechaCreacion, boolean pPrivada, boolean pEstatus, int pCodigoMundial) throws java.sql.SQLException,Exception {	

        java.sql.Date fecha = java.sql.Date.valueOf(pFechaCreacion);
        String sql;
        sql = "INSERT INTO LIGA " + "(nombreLiga, fechaCreacion, estatus, privada, codigoMundial) "+
        "VALUES ('"+pNombreLiga+"', '"+fecha+"', '"+pPrivada+"', '"+pEstatus+"', '"+pCodigoMundial+"');";
        miConector.getConector().ejecutarSQL(sql);
    }
 
    public Liga buscar(String pLiga) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        Liga miLiga = null;
        String sql;
        sql = "SELECT nombreLiga "+
        "FROM LIGA "+
        "WHERE nombreLiga = '"+ pLiga +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fechaCreacion").toLocalDate();
            miLiga = new Liga(rs.getString("nombreLiga"), localDate, rs.getBoolean("estatus"), rs.getBoolean("privada"), rs.getInt("codigoMundial"));
        } else {
                throw new Exception ();
            }
        rs.close();

        return miLiga;
    }
//    
    public boolean existe(String pLiga) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT nombreLiga "+
        "FROM LIGA "+
        "WHERE nombreLiga= '"+ pLiga +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                existe = true;
        } 
        rs.close();

        return existe;
    }
//    
    public ArrayList<Liga> listar() throws java.sql.SQLException,Exception {
        
        ArrayList<Liga> lista = new ArrayList();
        Liga miLiga = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT nombreLiga, fechaCreacion, estatus, privada, codigoMundial " +
        "FROM LIGA";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fechaCreacion").toLocalDate();
            miLiga = new Liga(rs.getString("nombreLiga"), localDate, rs.getBoolean("estatus"), rs.getBoolean("privada"), rs.getInt("codigoMundial"));
            lista.add(miLiga);
        } 
        rs.close();

        return lista;
    }
        
    public void actualizar(Liga pLiga) throws java.sql.SQLException,Exception {

        String sql;
        sql = "UPDATE LIGA " +
        "SET fechaCreacion= '"+pLiga.getFechaCreacion()+"', estatus= '"+pLiga.getEstatus()+"', privada= '"+ pLiga.getPrivada()+"', codigoMundial= '"+ pLiga.getCodigoMundial()+"'"+
        "WHERE nombreLiga= '"+pLiga.getNombre()+"';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pLiga) throws java.sql.SQLException,Exception {

        String sql;
        sql = "DELETE FROM LIGA " +
        "WHERE nombreLiga = '"+pLiga+"';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        }
        catch (Exception e) {
                throw new Exception ();
        }
    }
    
    public boolean buscarLigaPublica() throws Exception {
        
        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT nombreLiga "+
        "FROM LIGA "+
        "WHERE privada= '"+ "false" +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                existe = true;
        } 
        rs.close();

        return existe; 
    }
    
    public ArrayList<Liga> listarLigaPrivada() throws java.sql.SQLException,Exception {
        
        ArrayList<Liga> lista = new ArrayList();
        Liga miLiga = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT nombreLiga, fechaCreacion, estatus, privada, codigoMundial " +
        "FROM LIGA " +
        "WHERE privada = '"+ true +"'";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fechaCreacion").toLocalDate();
            miLiga = new Liga(rs.getString("nombreLiga"), localDate, rs.getBoolean("estatus"), rs.getBoolean("privada"), rs.getInt("codigoMundial"));
            lista.add(miLiga);
        } 
        rs.close();

        return lista;
    }
    
}
