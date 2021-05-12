package com.example.proyecto_pdm_g10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class DiplomadoConsultarActivity extends Activity {
    ControlBDProyecto helper;
    EditText editIdDiplomado;
    EditText editTitulo;
    EditText editDescripcion;
    EditText editCapacidades;

    ControlBDProyecto BDhelper = new ControlBDProyecto(this);
    String idsesion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diplomado_consultar);
        helper = new ControlBDProyecto(this);
        editIdDiplomado = (EditText) findViewById(R.id.editIdDiplomado);
        editTitulo = (EditText) findViewById(R.id.editTitulo);
        editDescripcion = (EditText) findViewById(R.id.editDescripcion);
        editCapacidades = (EditText) findViewById(R.id.editCapacidades);
    }

    public void consultarDiplomado(View v) {
        helper.abrir();
        Diplomado diplomado = helper.consultarDiplomado(editIdDiplomado.getText().toString());
        helper.cerrar();
        if(diplomado == null)
            Toast.makeText(this, "Diplomado con codigo" + editIdDiplomado.getText().toString() +
                    " no encontrado", Toast.LENGTH_LONG).show();
        else{
            editCapacidades.setText(diplomado.getCapacidades());
            editDescripcion.setText(diplomado.getDescripcion());
            editTitulo.setText(diplomado.getTitulo());

        }
    }
    public void limpiarTexto(View v) {
        editIdDiplomado.setText("");
        editTitulo.setText("");
        editDescripcion.setText("");
        editCapacidades.setText("");
    }
}