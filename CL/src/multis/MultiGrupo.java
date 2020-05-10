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
 * @Nombre del programa: MultiGrupo
 * @Descripción: 
 * @Fecha de creación: Aug 12, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */

public class MultiGrupo {

    private static Conector miConector = new Conector();

    public void crear(String pCodigo, String pNombreGrupo, int pCodigoMundial, String pIsoEquipo1, String pIsoEquipo2, String pIsoEquipo3, String pIsoEquipo4) throws java.sql.SQLException,Exception {	

        String sql;
        sql = "INSERT INTO GRUPO " + "(codigoGrupo, nombreGrupo, codigoMundial, isoEquipo1, isoEquipo2, isoEquipo3, isoEquipo4) "+
        "VALUES ('"+pCodigo+"', '"+pNombreGrupo+"', '"+pCodigoMundial+"', '"+pIsoEquipo1+"', '"+pIsoEquipo2+"', '"+pIsoEquipo3+"', '"+pIsoEquipo4+"');";
        miConector.getConector().ejecutarSQL(sql);
    }
 
    public Grupo buscar(String pGrupo) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        Grupo miGrupo = null;
        String sql;
        sql = "SELECT codigoGrupo, nombreGrupo, codigoMundial, isoEquipo1, isoEquipo2, isoEquipo3, isoEquipo4 "+
        "FROM GRUPO "+
        "WHERE codigoGrupo = '"+ pGrupo +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            miGrupo = new Grupo(rs.getString("codigoGrupo"), rs.getString("nombregrupo"), rs.getInt("codigoMundial"), rs.getString("isoEquipo1"), rs.getString("isoEquipo2"), rs.getString("isoEquipo3"), rs.getString("isoEquipo4"));
        } else {
                throw new Exception ();
            }
        rs.close();

        return miGrupo;
    }
    
    public ArrayList<Grupo> buscarGrupos(int pMundial) throws java.sql.SQLException,Exception {
        
        ArrayList<Grupo> miLista = new ArrayList();
        
        ResultSet rs = null;
        Grupo miGrupo = null;
        String sql;
        sql = "SELECT codigoGrupo, nombreGrupo, codigoMundial, isoEquipo1, isoEquipo2, isoEquipo3, isoEquipo4 "+
        "FROM GRUPO "+
        "WHERE codigoMundial = '"+ pMundial +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
            miGrupo = new Grupo(rs.getString("codigoGrupo"), rs.getString("nombregrupo"), rs.getInt("codigoMundial"), rs.getString("isoEquipo1"), rs.getString("isoEquipo2"), rs.getString("isoEquipo3"), rs.getString("isoEquipo4"));
            miLista.add(miGrupo);
        } 
        rs.close();
        
        return miLista;
    }
//    
    public boolean existe(String pGrupo) throws java.sql.SQLException,Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT codigoGrupo "+
        "FROM GRUPO "+
        "WHERE codigoGrupo= '"+ pGrupo +"';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
                existe = true;
        } 
        rs.close();

        return existe;
    }
//    
    public ArrayList<Grupo> listar() throws java.sql.SQLException,Exception {
        
        ArrayList<Grupo> lista = new ArrayList();
        Grupo miGrupo = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoGrupo, nombreGrupo, codigoMundial, isoEquipo1, isoEquipo2, isoEquipo3, isoEquipo4 " +
        "FROM GRUPO";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while(rs.next()) {
            miGrupo = new Grupo(rs.getString("codigoGrupo"), rs.getString("nombregrupo"), rs.getInt("codigoMundial"), rs.getString("isoEquipo1"), rs.getString("isoEquipo2"), rs.getString("isoEquipo3"), rs.getString("isoEquipo4"));
            lista.add(miGrupo);
        } 
        rs.close();

        return lista;
    }
        
    public void actualizar(Grupo pGrupo) throws java.sql.SQLException,Exception {

        String sql;
        sql = "UPDATE GRUPO " +
        "SET nombreGrupo= '"+pGrupo.getNombreGrupo()+"', codigoMundial= '"+pGrupo.getCodigoMundial()+"', isoEquipo1= '"+ pGrupo.getIsoEquipo1()+"', isoEquipo2= '"+ pGrupo.getIsoEquipo2()+"', isoEquipo3= '"+ pGrupo.getIsoEquipo3()+"', isoEquipo4= '"+ pGrupo.getIsoEquipo4()+"'"+
        "WHERE codigoGrupo= '"+pGrupo.getCodigo()+"';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pGrupo) throws java.sql.SQLException,Exception {

        String sql;
        sql = "DELETE FROM GRUPO " +
        "WHERE codigoGrupo = '"+pGrupo+"';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        }
        catch (Exception e) {
                throw new Exception ();
        }
    }
}
