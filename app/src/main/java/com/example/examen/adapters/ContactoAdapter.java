package com.example.examen.adapters;

import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.examen.MainActivity2;
import com.example.examen.MainActivity3;
import com.example.examen.R;
import com.example.examen.models.Contacto;

import org.w3c.dom.Text;

import java.net.URI;
import java.util.List;

import kotlin.ranges.UIntRange;

public class ContactoAdapter extends RecyclerView.Adapter<ContactoAdapter.viewHolder> {
    List <Contacto> Lista_contactos;
    public ContactoAdapter(List<Contacto>Lista_contacto) {
        this.Lista_contactos=Lista_contacto;
    }
    @NonNull
    @Override
    public ContactoAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater ly = LayoutInflater.from(parent.getContext());
        View v = ly.inflate(R.layout.item,parent,false);
        return new viewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ContactoAdapter.viewHolder holder, int position) {
        Contacto contacto=Lista_contactos.get(position);
        holder.setData(contacto);
    }

    @Override
    public int getItemCount() {
        return Lista_contactos.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        Contacto c;
        TextView nombre,telefono;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            nombre=itemView.findViewById(R.id.nombre);
            telefono=itemView.findViewById(R.id.numero);

            nombre.setOnClickListener(this);
            telefono.setOnClickListener(this);
        }

        public void setData(Contacto contacto)
        {
            c=contacto;
            nombre.setText(c.getNombre());
            telefono.setText(c.getNumero());


        }


        @Override
        public void onClick(View view) {
            Contacto cc= Lista_contactos.get(getAdapterPosition());
            if(view.getId()==R.id.nombre)
            {
                Intent intent = new Intent(view.getContext(), MainActivity3.class);
                intent.putExtra("Contacto",cc);
                view.getContext().startActivity(intent);
            }
            else
            {
             // Intent intent2 = new Intent(view.getContext(),URI.create("tel:"+c.getNumero()));
                Intent intent2 = new Intent(Intent.ACTION_CALL, Uri.parse("tel:"+telefono.getText().toString()));
                view.getContext().startActivity(intent2);
            }
        }
    }
}
