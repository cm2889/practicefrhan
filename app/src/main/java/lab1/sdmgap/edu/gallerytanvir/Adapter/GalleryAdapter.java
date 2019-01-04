package lab1.sdmgap.edu.gallerytanvir.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;


import com.squareup.picasso.Picasso;

import lab1.sdmgap.edu.gallerytanvir.Activity.GallerySlide;
import lab1.sdmgap.edu.gallerytanvir.R;


public class GalleryAdapter extends RecyclerView.Adapter<GalleryAdapter.ViewHolder> {

    private Context context;
    private String[] imageLinks;

    public GalleryAdapter(Context context, String[] imageLinks) {
        this.context = context;
        this.imageLinks = imageLinks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(context).inflate(R.layout.gallery_row, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {

        try {

            Picasso.get().load(imageLinks[i]).placeholder(R.drawable.picture)
                    .error(R.drawable.picture)
                    .into(viewHolder.galleryImage);

        }catch (Exception e){
            e.printStackTrace();
        }
        viewHolder.galleryImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, GallerySlide.class);
                intent.putExtra("position", i);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return imageLinks.length;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        ImageView galleryImage;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            galleryImage = itemView.findViewById(R.id.galleryImage);
        }
    }


}
