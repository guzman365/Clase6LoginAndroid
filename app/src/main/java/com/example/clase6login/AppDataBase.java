package com.example.clase6login;

import  androidx.room.Database; //Para prefijo @Database
import androidx.room.RoomDatabase; //Para herencia

@Database(entities = {Usuarios.class}, version = 1)
public abstract class AppDataBase extends RoomDatabase{
    public abstract UsuariosDAO usuariosDAO(); //Se crea metodo sin parametros
}
