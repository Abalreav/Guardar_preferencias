package com.example.alumnos.guardar_preferencias;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText edtUsuario;
    EditText edtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        edtUsuario=findViewById(R.id.edtUsuario);
        edtContra=findViewById(R.id.edtContra);
        cargarPreferencias();
    }
    public void onClick(View v){guardarPreferencias();}
    public void onClickEntrar(View V)
    {
        SharedPreferences preferences =getSharedPreferences("credencial",Context.MODE_PRIVATE);
        String Usuario=preferences.getString("usuario","No existe usuario registrado");
        String Contraseña= preferences.getString("contraseña","No existe contraseña registrada");
        String Usuariotxt=edtUsuario.getText().toString();
        String Contraseñatxt=edtContra.getText().toString();
        if(Usuario.equals(Usuariotxt)&&Contraseña.equals(Contraseñatxt))
        {
            Toast.makeText(this,"Contraseña y Usuario Correctos",Toast.LENGTH_LONG).show();
        }
        else
        {
            Toast.makeText(this,"Contraseña y Usuario Incorrectos",Toast.LENGTH_LONG).show();
        }

    }
    private void guardarPreferencias(){
        SharedPreferences preferences=getSharedPreferences("credencial", Context.MODE_PRIVATE);
        String Usuario=edtUsuario.getText().toString();
        String Contraseña=edtContra.getText().toString();
        SharedPreferences.Editor editor=preferences.edit();
        editor.putString("usuario",Usuario);
        editor.putString("contraseña",Contraseña);
        Toast.makeText(this,"Datos guardados\n"+ Usuario +"\n"+ Contraseña,Toast.LENGTH_LONG).show();
        //commit cierra la etiqueta de contenido
        editor.commit();

    }

    public void cargarPreferencias()
    {
        SharedPreferences preferences =getSharedPreferences("credencial",Context.MODE_PRIVATE);
        String Usuario=preferences.getString("usuario","No existe usuario registrado");
        String Contraseña= preferences.getString("contraseña","No existe contraseña registrada");
        edtUsuario.setText(Usuario);
        edtContra.setText(Contraseña);
    }
}
