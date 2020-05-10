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

/**
 * @Nombre del programa: MultiMundial
 * @Descripción: 
 * @Fecha de creación: Aug 12, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */

public class MultiMundial {

    private static Conector miConector = new Conector();

    public void crear(int pCodigoMundial, LocalDate pFecha, String pPaisOrganizador, boolean pEstado) throws java.sql.SQLException,Exception {	

        java.sql.Date fechaMundial = java.sql.Date.valueOf(pFecha);
        String sql;
        sql = "INSERT INTO MUNDIAL " + "(codigoMundial, fecha, paisOrganizador, estado) "+
        "VALUES ('"+pCodigoMundial+"', '"+fechaMundial+"', '"+pPaisOrganizador+"', '"+pEstado+"');";
        miConector.getConector().ejecutarSQL(sql);
    }
 
    public Mundial buscar(int pMundial) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        Mundial miMundial = null;
        String sql;
        ArrayList<Grupo> gruposMundial = new ArrayList();
        sql = "SELECT codigoMundial, fecha, paisOrganizador, estado "+
        "FROM MUNDIAL "+
        "WHERE codigoMundial = '"+ pMundial +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miMundial = new Mundial(rs.getInt("codigoMundial"), rs.getDate("fecha").toLocalDate(), rs.getString("paisOrganizador"), rs.getBoolean("estado"), gruposMundial);
        } else {
                throw new Exception ();
            }
        rs.close();

        return miMundial;
    }
   
    public boolean existe(String pMundial) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT codigoMundial "+
        "FROM MUNDIAL "+
        "WHERE codigoMundial= '"+ pMundial +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                existe = true;
        } 
        rs.close();

        return existe;
    }
   
    public ArrayList<Mundial> listar() throws java.sql.SQLException,Exception {
        
        ArrayList<Mundial> lista = new ArrayList();
        Mundial miMundial = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoMundial, fecha, paisOrganizador, estado " +
        "FROM MUNDIAL";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fecha").toLocalDate();
            miMundial = new Mundial(rs.getInt("codigoMundial"), localDate, rs.getString("paisOrganizador"), rs.getBoolean("estado"));
            lista.add(miMundial);
        } 
        rs.close();

        return lista;
    }
        
    public void actualizar(Mundial pMundial) throws java.sql.SQLException,Exception {

        String sql;
        sql = "UPDATE MUNDIAL " +
        "SET fecha= '"+pMundial.getFecha()+"', paisOrganizador= '"+pMundial.getPaisOrganizador()+"', estado= '"+ pMundial.getEstado()+"'"+
        "WHERE codigoMundial= '"+pMundial.getCodigoMundial()+"';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pMundial) throws java.sql.SQLException,Exception {

        String sql;
        sql = "DELETE FROM MUNDIAL " +
        "WHERE codigoMundial = '"+pMundial+"';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        }
        catch (Exception e) {
                throw new Exception ();
        }
    }
    public void actualizarEstado(String pPais, boolean pEstado) throws Exception {
        
        String sql;
        sql = "UPDATE MUNDIAL " +
        "SET estado= '"+ pEstado +"'"+
        "WHERE paisOrganizador= '"+pPais+"';";
        miConector.getConector().ejecutarSQL(sql);
    }
    
    public int obtenerCodigo(String pPais) throws Exception {
        
        ResultSet rs = null;
        int codigo = 0;
        String sql;
        sql = "SELECT codigoMundial "+
        "FROM MUNDIAL "+
        "WHERE paisOrganizador = '"+ pPais +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                codigo = rs.getInt("codigoMundial");
        } 
        rs.close();

        return codigo;
    }
    
    public Mundial getMundialDesdeResultSet(ResultSet rs) throws SQLException, Exception {

        int codigo = rs.getInt("codigoMundial");

        Mundial miMundial = null;
        String sql;
        ArrayList<Grupo> gruposMundial = new ArrayList();
        sql = "SELECT codigoMundial, fecha, paisOrganizador, estado "+
        "FROM MUNDIAL "+
        "WHERE codigoMundial = '"+ codigo +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miMundial = new Mundial(rs.getInt("codigoMundial"), rs.getDate("fecha").toLocalDate(), rs.getString("paisOrganizador"), rs.getBoolean("estado"), gruposMundial);
        } else {
                throw new Exception ();
            }
        rs.close();

        return miMundial;
    }
}
