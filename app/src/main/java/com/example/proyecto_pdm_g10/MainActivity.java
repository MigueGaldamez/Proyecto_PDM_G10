package com.example.proyecto_pdm_g10;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ListActivity {

    //Agregen las tablas y las activities de las tablas
    String[] menu={"Tabla AreaInteres","Tabla EntidadCapacitadora","Tabla Capacitador","Tabla Diplomado","Tabla Area Diplomado"};
    String[] activities={"AreaInteresMenuActivity","EntidadCapacitadoraMenuActivity","CapacitadorMenuActivity","DiplomadoMenuActivity","AreaDiplomadoMenuActivity"};


    ControlBDProyecto BDhelper;
    //variable de la sesion de usuario
    String idsesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setListAdapter(new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, menu));
        BDhelper=new ControlBDProyecto(this);

        //sirve para manejar el id de la sesion del usuario
        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            idsesion = extras.getString("idsesion");
            //The key argument here must match that used in the other activity
        }
    }
    @Override
    protected void onListItemClick(ListView l, View v, int position, long id){
        super.onListItemClick(l, v, position, id);
            String idopcionS = "000";
            switch(position) {
                case 0:  idopcionS = "010";
                    break;
                case 1:idopcionS = "020";
                    break;
                case 2:idopcionS = "030";
                    break;
                case 3:idopcionS = "040";
                    break;
                //case 4:idopcionS = "050";
                    //break;
                default:
                    //temporal
                    String nombreValue = activities[position];

                    try {
                        Class<?> clase = Class.forName("com.example.proyecto_pdm_g10." + nombreValue);

                        Intent inte = new Intent(this, clase);

                        inte.putExtra("idsesion", idsesion);
                        this.startActivity(inte);
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    }
                    break;
            }
            //Verificacion usuario
            BDhelper.abrir();
            Usuario usuario = BDhelper.consultarUsuario(idsesion);
            //AQUI SE AGREGA EL CODIGO DE ACCESO, SOLO CAMBIAR EL idopcion al numero que sea
            AccesoUsuario accesoUsuario = BDhelper.consultarAccesoUsuario(usuario.getIdUsuario(),idopcionS);
            BDhelper.cerrar();
            //fin verificacion

            if(accesoUsuario == null)
            {
                Toast.makeText(this, "Disculpe Usted no tiene permisos para acceder a esa seccion", Toast.LENGTH_SHORT).show();
            }
            else {

                String nombreValue = activities[position];

                try {
                    Class<?> clase = Class.forName("com.example.proyecto_pdm_g10." + nombreValue);

                    Intent inte = new Intent(this, clase);

                    inte.putExtra("idsesion", idsesion);
                    this.startActivity(inte);
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }

    }


}