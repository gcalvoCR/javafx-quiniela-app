package cl;

import java.util.ArrayList;
import java.util.Objects;

public class Usuario {

    private String correo;
    private String contrasenha;
    //private String rol;
    private int rol; //Sergio
    private String nombre;
    private String apellido;
    private String avatar;
    private String nombreUsuario;
    private int puntos;
    private String equipoFavorito;
    private String nombreLigaPrivada; //Sergio
    private String nombreLigaPublica; //Sergio
    private ArrayList<Prediccion> listaPredicciones;

    public Usuario() {
    }

    public Usuario(String correo, String contrasenha, int rol, String nombre, String apellido, String avatar, String nombreUsuario, int puntos, String equipoFavorito) {
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.avatar = avatar;
        this.nombreUsuario = nombreUsuario;
        this.puntos = puntos;
        this.equipoFavorito = equipoFavorito;
    }

    public Usuario(String correo, String contrasenha, int rol, String nombre, String apellido, String avatar, String nombreUsuario, int puntos, String equipoFavorito, String nombreLigaPrivada, String nombreLigaPublica) {
        this.correo = correo;
        this.contrasenha = contrasenha;
        this.rol = rol;
        this.nombre = nombre;
        this.apellido = apellido;
        this.avatar = avatar;
        this.nombreUsuario = nombreUsuario;
        this.puntos = puntos;
        this.equipoFavorito = equipoFavorito;
        this.nombreLigaPrivada = nombreLigaPrivada;
        this.nombreLigaPublica = nombreLigaPublica;
    }
 
    public ArrayList<Prediccion> getListaPredicciones() {

        if (listaPredicciones == null) {
            listaPredicciones = new ArrayList();
        }
        return listaPredicciones;
    }

    public void setListaPredicciones(Prediccion prediccionX) {
        if (listaPredicciones == null) {
            listaPredicciones = new ArrayList();
        }
        listaPredicciones.add(prediccionX);
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public void setContrasenha(String contrasenha) {
        this.contrasenha = contrasenha;
    }

    public void setRol(int rol) {
        this.rol = rol;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }
    
    public void setEquipoFavorito(String equipoFavorito) {
        this.equipoFavorito = equipoFavorito;
    }

    public void setNombreLigaPrivada(String nombreLigaPrivada) {
        this.nombreLigaPrivada = nombreLigaPrivada;
    }

    public void setNombreLigaPublica(String nombreLigaPublica) {
        this.nombreLigaPublica = nombreLigaPublica;
    }
    
    public String getCorreo() {
        return correo;
    }

    public String getContrasenha() {
        return contrasenha;
    }

    public int getRol() {
        return rol;
    }

    public String getNombre() {
        return nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public String getAvatar() {
        return avatar;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getEquipoFavorito() {
        return equipoFavorito;
    }

    public int getPuntos() {
        return puntos;
    }

    public String getNombreLigaPrivada() {
        return nombreLigaPrivada;
    }

    public String getNombreLigaPublica() {
        return nombreLigaPublica;
    }

    @Override
    public String toString() {
        return "Usuario{" + "avatar=" + avatar + '}';
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
        final Usuario other = (Usuario) obj;
        if (!Objects.equals(this.nombreUsuario, other.nombreUsuario)) {
            return false;
        }
        return true;
    }

}
