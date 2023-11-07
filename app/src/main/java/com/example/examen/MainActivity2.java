package com.example.examen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.examen.adapters.ContactoAdapter;
import com.example.examen.models.Contacto;

import java.util.ArrayList;
import java.util.List;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        List<Contacto>Lista_Contactos = new ArrayList<>();

        Lista_Contactos.add(new Contacto("Arturo","8713267638","Arturo es una amigo que lo conoci en la escuela","20"));
        Lista_Contactos.add(new Contacto("Javier Vielma","8713267980","Javier es una amigo que lo conoci en la escuela","50"));
        Lista_Contactos.add(new Contacto("Juan","8713267765","Juan es una amigo menso","30"));
        Lista_Contactos.add(new Contacto("Albertano","8713267890","Albertano es una amigo que esta en el anexo","50"));
        Lista_Contactos.add(new Contacto("Adrian ","8713267654","Adrian lo conoci en la escuela cuando llego","15"));

        RecyclerView rc = findViewById(R.id.recycler);
        rc.setAdapter(new ContactoAdapter(Lista_Contactos));
        rc.setLayoutManager(new LinearLayoutManager(this));
        rc.setHasFixedSize(true);


    }
}