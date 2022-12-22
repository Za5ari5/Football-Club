package com.example.sportclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class Myadabter extends RecyclerView.Adapter<Myadabter.MyviewHolder> {
    //declarer les class qu on a besoin
    private Modelc[] listdata;
    private ItemClick click;

    public Myadabter(Modelc[] listdata) {
        this.listdata = listdata;
    }

    public void setClick(ItemClick click) {
        this.click = click;
    }
//la class ViewHolder pour connecter notre Views par notre recycler
    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView img;
        public TextView txt;

        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            this.img= itemView.findViewById(R.id.imageViewrec);
            this.txt= itemView.findViewById(R.id.textViewrec);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(click != null){
                click.onClick(view,getAdapterPosition());
            }

        }
    }
//la class MyViewHolder pour connecter connecter les elements de recycler_viewlay avec notre recyclerView

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recycler_viewlay,parent,false);
        MyviewHolder mv = new MyviewHolder(listItem);
        return mv;

    }
//pour implementer larray et afficher
    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        final Modelc mld = listdata[position];
        holder.txt.setText(listdata[position].getTitle());
        holder.img.setImageResource(listdata[position].getImage());



    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

}
