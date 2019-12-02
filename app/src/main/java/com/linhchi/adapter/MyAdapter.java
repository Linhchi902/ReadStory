package com.linhchi.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.readstory.R;
import com.linhchi.object.GenresName;
import com.linhchi.interf.IGenres;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class MyAdapter extends RecyclerView.Adapter<MyAdapter.ViewHolder> {

    private List<GenresName> arrGenres;
    private IGenres inter;
    private Context mContext;

    private ArrayList<String> listImages2;

    public MyAdapter(Context mContext, List<GenresName> arr, IGenres inter) {
        this.arrGenres = arr;
        this.inter = inter;
        this.mContext = mContext;

        //lấy ảnh từ assets ra
        try {
            String[] images = mContext.getAssets().list("image");
             listImages2 = new ArrayList<String>(Arrays.asList(images));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    @NonNull
    @Override
    public MyAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.activity_list_item_genres, viewGroup, false);
        return new ViewHolder(itemView, inter);
    }

    @Override
    public void onBindViewHolder(@NonNull MyAdapter.ViewHolder viewHolder, int position) {
        final GenresName genresName = inter.getData(position);
        //load ảnh vào view
        if (listImages2 != null && listImages2.size() > position) {
            InputStream inputstream = null;
            try {
                inputstream = mContext.getAssets().open("image/"
                        + listImages2.get(position));
                Drawable drawable = Drawable.createFromStream(inputstream, null);

                viewHolder.img_genres.setImageDrawable(drawable);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        viewHolder.tvName.setText(genresName.getName());
    }

    @Override
    public int getItemCount() {
        return inter.getCount();
    }


    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        TextView tvName;
        IGenres iGenres;
        ImageView img_genres;

        public ViewHolder(@NonNull View itemView, IGenres genres) {
            super(itemView);
            this.iGenres = genres;
            tvName = itemView.findViewById(R.id.tv_namegenres);
            img_genres = itemView.findViewById(R.id.img_genres);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            iGenres.onclick(getAdapterPosition());
        }
    }
}
