package com.example.sportclub;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.zip.Inflater;

public class BrAdapter extends RecyclerView.Adapter<BrAdapter.MyviewHolder> {
    private ModelT[] listdata;
    private ItemClick click;

    public BrAdapter(ModelT[] listdata) {
        this.listdata = listdata;
    }

    public void setClick(ItemClick click) {
        this.click = click;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public ImageView img;
        public TextView txt;
        public TextView txt1;
        public TextView txt2;


        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            this.img= itemView.findViewById(R.id.imageViewrec2);
            this.txt= itemView.findViewById(R.id.textViewrec2);
            this.txt1 = itemView.findViewById(R.id.textView2rec2);
            this.txt2 = itemView.findViewById(R.id.textView3rec2);

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
        View listItem = inflater.inflate(R.layout.recycler_trainingschlay,parent,false);
        MyviewHolder mv = new MyviewHolder(listItem);
        return mv;

    }

    @Override
    public void onBindViewHolder(@NonNull MyviewHolder holder, int position) {
        final ModelT mld = listdata[position];
        holder.txt.setText(listdata[position].getTitle());
        holder.txt1.setText(listdata[position].getTitle2());
        holder.txt2.setText(listdata[position].getTitle3());
        holder.img.setImageResource(listdata[position].getImage());



    }

    @Override
    public int getItemCount() {
        return listdata.length;
    }

}

