/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.util.ArrayList;

/**
 *
 * @author Gabriel
 */
public class CL {

 public CL() {
    }

    private String usuarioActivo;

    public void guardarUsuarioActivo(String pUsuarioActivo) {
        usuarioActivo = pUsuarioActivo;
    }
    
    public String obtenerUsuarioActivo() {
        return usuarioActivo;
    }

}
