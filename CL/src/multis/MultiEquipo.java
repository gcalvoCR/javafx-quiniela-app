/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package multis;

import CapaAccesoBD.Conector;
import cl.Equipo;
import cl.Prediccion;
import java.sql.*;
import java.util.*;

/**
 * @Nombre del programa: Equipos
 * @Descripción: 
 * @Fecha de creación: Jul 29, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */

public class MultiEquipo {
    
    private static Conector miConector = new Conector();
    private static MultiEquipo multiE = new MultiEquipo();

    public void crear(String pIso, String pNombre, int pRankingFIFA, String bandera) throws java.sql.SQLException,Exception {	

            String sql;
            sql = "INSERT INTO EQUIPO " + "(iso, nombre, rankingFIFA, bandera)"+
            "VALUES ('"+pIso+"', + '"+pNombre+"', '"+pRankingFIFA+"', '"+bandera+"');";
            miConector.getConector().ejecutarSQL(sql);
    }
 
    public Equipo buscar(String pIso) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        Equipo miEquipo;
        String sql;
        sql = "SELECT iso, nombre, rankingFIFA "+
        "FROM EQUIPO "+
        "WHERE iso = '"+ pIso +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                miEquipo = new Equipo(rs.getString("iso"), rs.getString("nombre"), rs.getInt("rankingFIFA"));
        } else {
                throw new Exception ();
            }
        rs.close();

        return miEquipo;
    }
    
    public boolean existe(String pIso) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT iso "+
        "FROM EQUIPO "+
        "WHERE iso = '"+ pIso +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                existe = true;
        } 
        rs.close();

        return existe;
    }
    
    public ArrayList<Equipo> listar() throws java.sql.SQLException,Exception {
        
        ArrayList<Equipo> lista = new ArrayList();
        Equipo miEquipo = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT iso, nombre, rankingFIFA, bandera " +
        "FROM EQUIPO";
        rs = rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
                miEquipo = new Equipo(rs.getString("iso"), rs.getString("nombre"), rs.getInt("rankingFIFA"));
                lista.add(miEquipo);
        } 
        rs.close();

        return lista;
    }
    
    public String[] listarArray() throws Exception {
        String[] lista = null;
        ArrayList<Equipo> misEquipos = new ArrayList();
        int i = 0;
        misEquipos = listar();
        for (Equipo dato : misEquipos) {
            lista[i] = dato.getNombre();
            i++;
        }
        return lista;
    }
        
    public void actualizar(Equipo pEquipo) throws java.sql.SQLException,Exception {

        String sql;
        sql = "UPDATE EQUIPO " +
        "SET nombre= '"+ pEquipo.getNombre() +"', rankingFIFA= '"+ pEquipo.getRankinFIFA() +"'"+
        "WHERE iso= '"+ pEquipo.getIso() +"';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pIso) throws java.sql.SQLException,Exception {

        String sql;
        sql = "DELETE FROM EQUIPO " +
        "WHERE iso = '"+pIso+"';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        }
        catch (Exception e) {
                throw new Exception ();
        }
    }
    
    public Equipo getEquipoDesdeResultSet(ResultSet rs) throws SQLException {
        
        Equipo nuevo= new Equipo();
        nuevo.setIso(rs.getString("iso"));
        nuevo.setNombre(rs.getString("nombre"));
        nuevo.setRankinFIFA(rs.getInt("rankingFIFA"));
        return nuevo;
    }
}
