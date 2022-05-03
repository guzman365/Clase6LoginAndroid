package com.example.clase6login;

import androidx.room.ColumnInfo; //Crear campos de la tabla
import androidx.room.Entity;  //Crear entidades (Tablas)
import androidx.room.PrimaryKey; //Crear llaves primarias

@Entity
public class Usuarios {
    //Agregar los campos (Atributos de la clase)
    @PrimaryKey(autoGenerate = true) //crea llave primary y autoincrementa por registro
    private int usuarioid;
    @ColumnInfo(name = "nombreusuario")
    private String nombreusuario;
    @ColumnInfo(name = "usuario")
    private String usuario;
    @ColumnInfo(name = "clave")
    private String clave;

    public Usuarios(String nombreusuario, String usuario, String clave) {
        this.nombreusuario = nombreusuario;
        this.usuario = usuario;
        this.clave = clave;
    }

    public int getUsuarioid(){
        return usuarioid;
    }

    public void setUsuarioid(int usuarioid) {
        this.usuarioid = usuarioid;
    }

    public String getNombreusuario() {
        return nombreusuario;
    }

    public void setNombreusuario(String nombreusuario) {
        this.nombreusuario = nombreusuario;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getClave() {
        return clave;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }
}
