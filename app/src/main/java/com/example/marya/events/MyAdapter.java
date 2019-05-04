package com.example.marya.events;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.provider.MediaStore;
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
    private Dialog dialog;

    public MyAdapter(List List, Context context) {
        this.listitems = List;
        this.context = context;
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list, parent, false);
        final MyAdapter.ViewHolder viewHold = new MyAdapter.ViewHolder(v);
        dialog = new Dialog(context);
        dialog.setContentView(R.layout.activity_gallery_pop_up);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder viewHolder, final int position) {

       final ListItem ListItem= listitems.get(position);
        viewHolder.textViewHead.setText(ListItem.getHead());
        viewHolder.textViewDesc.setText(ListItem.getDesc());

        Picasso.with(context)
                .load(ListItem.getImageUrl())
                .into(viewHolder.imageView);


        viewHolder.LinearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(context, GalleryActivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                intent.putExtra("Title", ListItem.getHead());
                intent.putExtra("Description", ListItem.getDesc());
                intent.putExtra("image_URL", ListItem.getImageUrl());

                context.startActivity(intent);
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
