package com.example.clase6login;

import androidx.room.Dao; //Para representar el DAO (Data Access Object)
import androidx.room.Insert; //para realizar los insert
//import androidx.room.Update;
import androidx.room.Query; //para realizar los query

import java.util.List;

@Dao //Convierte la interfaz en DAO
public interface UsuariosDAO {
    //consulta general
    @Query("SELECT * FROM usuarios")
    List<Usuarios> getAll();

    //Consulta con parametro
    @Query("SELECT * FROM usuarios WHERE usuario LIKE :usuario LIMIT 1")
    Usuarios findByName(String usuario);

    //insercion de datos
    @Insert
    Long insert(Usuarios usuarios);
}
