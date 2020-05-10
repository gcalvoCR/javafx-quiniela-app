package cl;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Objects;

public class Liga {

    private String nombre;
    private LocalDate FechaCreacion;
    private boolean estatus;
    private boolean privada;
    private int codigoMundial; //Sergio
    ArrayList<Usuario> listaUsuarios;
    private Mundial mundialAsociado;

    public Liga() {
    }

    public Liga(String nombre, LocalDate FechaCreacion, boolean estatus, boolean privada, ArrayList<Usuario> listaUsuarios, Mundial mundialAsociado) {
        this.nombre = nombre;
        this.FechaCreacion = FechaCreacion;
        this.estatus = estatus;
        this.privada = privada;
        this.listaUsuarios = listaUsuarios;
        this.mundialAsociado = mundialAsociado;
    }

    public Liga(String nombre, LocalDate FechaCreacion, boolean estatus, boolean privada, int codigoMundial) {
        this.nombre = nombre;
        this.FechaCreacion = FechaCreacion;
        this.estatus = estatus;
        this.privada = privada;
        this.codigoMundial = codigoMundial;
    }

    public Liga(String nombre, LocalDate FechaCreacion, boolean estatus, boolean privada, int codigoMundial, ArrayList<Usuario> listaUsuarios, Mundial mundialAsociado) {
        this.nombre = nombre;
        this.FechaCreacion = FechaCreacion;
        this.estatus = estatus;
        this.privada = privada;
        this.codigoMundial = codigoMundial;
        this.listaUsuarios = listaUsuarios;
        this.mundialAsociado = mundialAsociado;
    }

    public void setListaUsuarios(ArrayList<Usuario> listaUsuarios) {
        this.listaUsuarios = listaUsuarios;
    }

    public ArrayList<Usuario> getListaUsuarios() {
        return listaUsuarios;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreacion(LocalDate FechaCreacion) {
        this.FechaCreacion = FechaCreacion;
    }

    public void setEstatus(boolean estatus) {
        this.estatus = estatus;
    }

    public void setPrivada(boolean privada) {
        this.privada = privada;
    }

    public void setMundialAsociado(Mundial mundialAsociado) {
        this.mundialAsociado = mundialAsociado;
    }
    
    public void setCodigoMundial(int codigoMundial) {
        this.codigoMundial = codigoMundial;
    }
    
    public String getNombre() {
        return nombre;
    }

    public LocalDate getFechaCreacion() {
        return FechaCreacion;
    }

    
    public boolean getEstatus() {
        return estatus;
    }

    public boolean getPrivada() {
        return privada;
    }

    public int getCodigoMundial() {
        return codigoMundial;
    }

    
    public Mundial getMundialAsociado() {
        return mundialAsociado;
    }
    

    @Override
    public String toString() {
        return "Liga{" + "nombre=" + nombre + ", FechaCreacion=" + FechaCreacion + ", estatus=" + estatus + ", privada=" + privada + '}';
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
        final Liga other = (Liga) obj;
        if (!Objects.equals(this.nombre, other.nombre)) {
            return false;
        }
        return true;
    }

}
