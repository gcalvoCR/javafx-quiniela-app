/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl;

import java.util.Objects;
import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleStringProperty;

/**
 *
 * @author Gabriel
 */
public class Equipo {
    private String iso;
    private String nombre;
    private int rankinFIFA;
    // Bandera;

    public Equipo() {
    }

    public Equipo(String iso, String nombre, int rankinFIFA) {
        this.iso = iso;
        this.nombre = nombre;
        this.rankinFIFA = rankinFIFA;
    }

    public void setIso(String iso) {
        this.iso = iso;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setRankinFIFA(int rankinFIFA) {
        this.rankinFIFA = rankinFIFA;
    }

    public String getIso() {
        return iso;
    }

    public String getNombre() {
        return nombre;
    }

    public int getRankinFIFA() {
        return rankinFIFA;
    }

    @Override
    public String toString() {
        return "Equipo{" + "iso=" + iso + ", nombre=" + nombre + ", rankinFIFA=" + rankinFIFA + '}';
    }

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Equipo other = (Equipo) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
