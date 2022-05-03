package com.example.clase6login;

import androidx.appcompat.app.AppCompatActivity;
import androidx.room.Room;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    EditText edt_Nombre, edt_Usuario, edt_Clave;
    TextView txv_Consulta;
    Button btn_Guardar, btn_Consultar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_Nombre = findViewById(R.id.edtNombre);
        edt_Usuario = findViewById(R.id.edtUsuario);
        edt_Clave = findViewById(R.id.edtClave);
        txv_Consulta = findViewById(R.id.txvConsulta);

        btn_Consultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(
                        MainActivity.this,
                        AppDataBase.class,
                        "dbusuarios").allowMainThreadQueries().build(); //crea la BD

                //Insertar
                Usuarios usuarios = new Usuarios(
                        edt_Nombre.getText().toString(),
                        edt_Usuario.getText().toString(),
                        edt_Clave.getText().toString()
                );
                Long reg = db.usuariosDAO().insert(usuarios);
                Toast.makeText(
                        getApplicationContext(),
                        "Registro almacenado correctamente",
                        Toast.LENGTH_SHORT).show();
            }
        });

        btn_Consultar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                AppDataBase db = Room.databaseBuilder(
                        MainActivity.this,
                        AppDataBase.class,
                        "dbusuarios").allowMainThreadQueries().build();

                List<Usuarios> lista = db.usuariosDAO().getAll();

                String valores = "";

                for (int i=0; i<lista.size(); i++){
                    valores += lista.get(i).getNombreusuario()+"Usuario: "+lista.get(i).getUsuario() + "Clave: "+lista.get(i).getClave() + "\n";
                }
                txv_Consulta.setText(valores);
            }
        });
    }
}