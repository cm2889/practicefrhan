package lab1.sdmgap.edu.gallerytanvir.Adapter;

import android.content.Context;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lab1.sdmgap.edu.gallerytanvir.Activity.MainActivity;
import lab1.sdmgap.edu.gallerytanvir.Fragment.GalleryFragment;
import lab1.sdmgap.edu.gallerytanvir.ModelClass.AlbumVersion;
import lab1.sdmgap.edu.gallerytanvir.R;

public class GalleryAlbumAdapter extends  RecyclerView.Adapter<GalleryAlbumAdapter.ViewHolder> {

private ArrayList<AlbumVersion> android;
private Context context;

public GalleryAlbumAdapter(Context context, ArrayList<AlbumVersion>android){

        this.android = android;
        this.context = context;

}
@Override
public GalleryAlbumAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.galler_row_layout,parent,false);
        return new ViewHolder(view);
}

@Override
public void onBindViewHolder(ViewHolder holder, final int position) {
        holder.vText.setText(android.get(position).getAlbum_name());
        holder.vImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Begin the transaction
                FragmentTransaction fragmentTransaction = ((MainActivity) context).getSupportFragmentManager().beginTransaction();

                // Replace the contents of the container with the new fragment
                fragmentTransaction.replace(R.id.main_activity_placeholder, new GalleryFragment());

                // Complete the changes added above
                fragmentTransaction.commit();


            }
        });
        Picasso.get().load(android.get(position).getAlbum_images()).resize(440,120).into(holder.vImg);
        }

@Override
public int getItemCount() {
        return android.size();
        }

public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
    private TextView vText;
    private ImageView vImg;
    public ViewHolder(View view) {
        super(view);

        vText = (TextView)view.findViewById(R.id.text);
        vImg = (ImageView) view.findViewById(R.id.img);

        //to add onclick listener
        view.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        Toast.makeText(context, vText.getText()+" is clicked.",Toast.LENGTH_SHORT).show();
    }
}
}
