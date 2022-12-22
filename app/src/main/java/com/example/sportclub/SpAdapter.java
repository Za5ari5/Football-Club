package com.example.sportclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class SpAdapter extends RecyclerView.Adapter<SpAdapter.MyviewHolder> {
    private ModelS[] listdata;
    private ItemClick click;

    public SpAdapter(ModelS[] listdata) {
        this.listdata = listdata;
    }

    public void setClick(ItemClick click) {
        this.click = click;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView img;
        public TextView txt;
        public TextView txt1;



        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            this.img= itemView.findViewById(R.id.imageViewrec3);
            this.txt= itemView.findViewById(R.id.textViewrec3);
            this.txt1 = itemView.findViewById(R.id.textView2rec3);


            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            if(click != null){
                click.onClick(view,getAdapterPosition());
            }

        }
    }

    @NonNull
    @Override
    public MyviewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View listItem = inflater.inflate(R.layout.recycler_shoppinglay,parent,false);
        MyviewHolder mv = new MyviewHolder(listItem);
        return mv;

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        final ModelS mld = listdata[position];
        holder.txt.setText(listdata[position].getTitle());
        holder.txt1.setText(listdata[position].getTitle2());
        holder.img.setImageResource(listdata[position].getImage());



    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

}
