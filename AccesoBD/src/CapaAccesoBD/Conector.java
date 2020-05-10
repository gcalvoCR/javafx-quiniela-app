package CapaAccesoBD;

import java.io.File;
import java.util.Scanner;

/**
 * Clase Conector
 *
 * @version 1.0
 * @author Laura Monge Izaguirre Clase que inicializa la conexi�n con los
 * valores correctos y permite manejar una �nica conexi�n para todo el proyecto
 */
public class Conector {

    private static AccesoBD conectorBD = null;

    /**
     * M�todo est�tico que devuelve el objeto AccesoBD para que sea utilizado
     * por las clases
     *
     * @return objeto del tipo AccesoBD del paquete CapaAccesoDatos
     */
    public static AccesoBD getConector() throws java.sql.SQLException, Exception {
        Scanner x;
        String driver = "", conexion = "";
        File file = new File("baseDatos.txt");
        if (file.exists() == false) {
            file.createNewFile();
        }

        x = new Scanner(file);
        while (x.hasNext()) {
            driver = x.next();
            conexion = x.next();
        }
        x.close();
        if (conectorBD == null) {
            conectorBD = new AccesoBD(driver, conexion);
        }
        return conectorBD;

    }
}
