package com.example.marya.events;
import android.app.LauncherActivity;
import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<ListItem> listitems;
    private Context context;

    public MyAdapter(List List, Context context) {
        this.listitems = List;
        this.context = context;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int position) {

       final ListItem ListItem= listitems.get(position);
        viewHolder.textViewHead.setText(ListItem.getHead());
        viewHolder.textViewDesc.setText(ListItem.getDesc());

        Picasso.with(context)
                .load(ListItem.getImageUrl())
                .into(viewHolder.imageView);


        viewHolder.LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Toast.makeText(context, "You clicked"+ListItem.getHead(), Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public int getItemCount() {
            return this.listitems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textViewHead;
        public TextView textViewDesc;
        public ImageView imageView;
        public LinearLayout LinearLayout;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewHead = (TextView) itemView.findViewById(R.id.Events);
            textViewDesc = (TextView) itemView.findViewById(R.id.Description);
            imageView = (ImageView) itemView.findViewById(R.id.imageView);
            LinearLayout = (LinearLayout) itemView.findViewById(R.id.LinearLayout);

        }
    }
}
