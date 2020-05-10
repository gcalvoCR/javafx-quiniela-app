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
 * @Nombre del programa: MultiCronograma
 * @Descripción:
 * @Fecha de creación: Aug 12, 2018
 * @Autor Sergio Oviedo Seas
 * @Fecha de modificación:
 * @Modificado por:
 */
public class MultiCronograma {

    private static Conector miConector = new Conector();
    private static MultiEquipo multiE = new MultiEquipo();

    public void crearAlterno(int pCodigo, String pTeam1, String pTeam2, LocalDate pFecha, String pFase, int pCodigoMundial) throws java.sql.SQLException, Exception {

        java.sql.Date fechaPartido = java.sql.Date.valueOf(pFecha);
        String sql;
        sql = "INSERT INTO CRONOGRAMA " + "(codigoCronograma, isoEquipo1, isoEquipo2, fecha, fase, codigoMundial) "
                + "VALUES ('" + pCodigo + "', '" + pTeam1 + "', '" + pTeam2 + "', '" + fechaPartido + "', '" + pFase + "', '" + pCodigoMundial + "');";
        miConector.getConector().ejecutarSQL(sql);
    }

    public void crear(int pCodigo, String pTeam1, String pTeam2, int pGolesEquipo1, int pGolesEquipo2, LocalDate pFecha, String pFase, boolean pJugado, int pCodigoMundial, String pCodigoEquipoGanador) throws java.sql.SQLException, Exception {

        java.sql.Date fechaPartido = java.sql.Date.valueOf(pFecha);
        String sql;
        sql = "INSERT INTO CRONOGRAMA " + "(codigoCronograma, isoEquipo1, isoEquipo2, golesEquipo1, golesEquipo2, fecha, fase, jugado, codigoMundial, codigoEquiporGanador) "
                + "VALUES ('" + pCodigo + "', '" + pTeam1 + "', '" + pTeam2 + "', '" + pGolesEquipo1 + "', '" + pGolesEquipo2 + "', '" + fechaPartido + "', '" + pFase + "', '" + pJugado + "', '" + pCodigoMundial + "', '" + pCodigoEquipoGanador + "');";
        miConector.getConector().ejecutarSQL(sql);
    }

    public Cronograma buscar(String pCronograma) throws java.sql.SQLException, Exception {

        ResultSet rs = null;
        Cronograma miCronograma = null;
        String sql;
        sql = "SELECT codigoCronograma "
                + "FROM CRONOGRAMA "
                + "WHERE codigoCronograma = '" + pCronograma + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fecha").toLocalDate();
            miCronograma = new Cronograma(rs.getInt("codigoCronograma"), rs.getString("isoEquipo1"), rs.getString("isoEquipo2"), rs.getInt("golesEquipo1"), rs.getInt("golesEquipo2"), localDate, rs.getString("fase"), rs.getBoolean("jugado"), rs.getInt("codigoMundial"), rs.getString("codigoEquipoGanador"));
        } else {
            throw new Exception();
        }
        rs.close();

        return miCronograma;
    }  

    public boolean existe(String pCronograma) throws java.sql.SQLException, Exception {

        ResultSet rs = null;
        boolean existe = false;
        String sql;
        sql = "SELECT codigoCronograma "
                + "FROM CRONOGRAMA "
                + "WHERE codigoCronograma= '" + pCronograma + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        if (rs.next()) {
            existe = true;
        }
        rs.close();

        return existe;
    }

    public ArrayList<Cronograma> listar() throws java.sql.SQLException, Exception {

        ArrayList<Cronograma> lista = new ArrayList();
        Cronograma miCronograma = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoCronograma, isoEquipo1, isoEquipo2, golesEquipo1, golesEquipo2, fecha, fase, jugado, codigoMundial, codigoEquipoGanador "
                + "FROM CRONOGRAMA";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fecha").toLocalDate();
            miCronograma = new Cronograma(rs.getInt("codigoCronograma"), rs.getString("isoEquipo1"), rs.getString("isoEquipo2"), rs.getInt("golesEquipo1"), rs.getInt("golesEquipo2"), localDate, rs.getString("fase"), rs.getBoolean("jugado"), rs.getInt("codigoMundial"), rs.getString("codigoEquipoGanador"));
            lista.add(miCronograma);
        }
        rs.close();

        return lista;
    }

    public void actualizar(Cronograma pCronograma) throws java.sql.SQLException, Exception {

        String sql;
        sql = "UPDATE CRONOGRAMA "
                + "SET isoEquipo1= '" + pCronograma.getTeam1() + "', isoEquipo2= '" + pCronograma.getTeam2() + "', golesEquipo1= '" + pCronograma.getGolesEquipo1() + "', golesEquipo2= '" + pCronograma.getGolesEquipo2() + "', fecha= '" + pCronograma.getFecha() + "', fase= '" + pCronograma.getFase() + "', jugado= '" + pCronograma.getJugado() + "', codigoMundial= '" + pCronograma.getCodigoMundial() + "', codigoEquipoGanador= '" + pCronograma.getCodigoEquipoGanador() + "'"
                + "WHERE codigoCronograma= '" + pCronograma.getCodigo() + "';";
        miConector.getConector().ejecutarSQL(sql, true);

    }

    public void borrar(String pCronograma) throws java.sql.SQLException, Exception {

        String sql;
        sql = "DELETE FROM CRONOGRAMA "
                + "WHERE codigoCronograma = '" + pCronograma + "';";
        try {
            miConector.getConector().ejecutarSQL(sql, true);
        } catch (Exception e) {
            throw new Exception();
        }
    }

    public ArrayList<String> listarArrayCronograma(int mundial) throws Exception {

        ArrayList<String> miLista = new ArrayList();
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoCronograma, isoEquipo1, isoEquipo2, fecha, fase, codigoMundial "
                + "FROM CRONOGRAMA "
                + "WHERE codigoMundial = '" + mundial + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fecha").toLocalDate();
            miLista.add(localDate + ": " + rs.getString("isoEquipo1") + " - " + rs.getString("isoEquipo2"));
        }
        rs.close();

        return miLista;
    }

    public ArrayList<Cronograma> listarCronograma(int pMundial) throws Exception {

        ArrayList<Cronograma> lista = new ArrayList();
        Equipo equipo1 = new Equipo();
        Equipo equipo2 = new Equipo();
        Cronograma miCronograma = null;
        ResultSet rs = null;
        String sql;
        sql = "SELECT codigoCronograma, isoEquipo1, isoEquipo2, golesEquipo1, golesEquipo2, fecha, fase, jugado, codigoMundial, codigoEquipoGanador "
                + "FROM CRONOGRAMA "
                + "WHERE codigoMundial = '" + pMundial + "';";
        rs = miConector.getConector().ejecutarSQL(sql, true);

        while (rs.next()) {
            java.time.LocalDate localDate = rs.getDate("fecha").toLocalDate();
            miCronograma = new Cronograma(rs.getInt("codigoCronograma"), 
                    rs.getString("isoEquipo1"), 
                    rs.getString("isoEquipo2"), 
                    rs.getInt("golesEquipo1"), 
                    rs.getInt("golesEquipo2"), 
                    localDate, rs.getString("fase"), 
                    rs.getBoolean("jugado"),
                    rs.getInt("codigoMundial"),
                    rs.getString("codigoEquipoGanador"));
            lista.add(miCronograma);
        }
        rs.close();

        return lista;
    }

    public void guardarGolesEquipo1(int pCodigo, int pGoles) throws Exception {

        String sql;
        sql = "UPDATE CRONOGRAMA "
                + "SET golesEquipo1= '" + pGoles + "'"
                + "WHERE codigoCronograma= '" + pCodigo + "';";
        miConector.getConector().ejecutarSQL(sql);
    }

    public void guardarGolesEquipo2(int pCodigo, int pGoles) throws Exception {

        String sql;
        sql = "UPDATE CRONOGRAMA "
                + "SET golesEquipo2= '" + pGoles + "'"
                + "WHERE codigoCronograma= '" + pCodigo + "';";
        miConector.getConector().ejecutarSQL(sql);
    }

    public void guardarGanador(int pCodigo, String pGanador) throws Exception {

        String sql;
        sql = "UPDATE CRONOGRAMA "
                + "SET codigoEquipoGanador= '" + pGanador + "'"
                + "WHERE codigoCronograma= '" + pCodigo + "';";
        miConector.getConector().ejecutarSQL(sql);
    }

    public void guardarJugado(int pCodigo, boolean pJugado) throws Exception {

        String sql;
        sql = "UPDATE CRONOGRAMA "
                + "SET jugado= '" + pJugado + "'"
                + "WHERE codigoCronograma= '" + pCodigo + "';";
        miConector.getConector().ejecutarSQL(sql);
    }
}
