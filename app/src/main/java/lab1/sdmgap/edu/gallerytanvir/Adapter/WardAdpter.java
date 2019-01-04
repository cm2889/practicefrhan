package lab1.sdmgap.edu.gallerytanvir.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import lab1.sdmgap.edu.gallerytanvir.Activity.ward_details;
import lab1.sdmgap.edu.gallerytanvir.ModelClass.wardversion;
import lab1.sdmgap.edu.gallerytanvir.R;

public class WardAdpter extends RecyclerView.Adapter<WardAdpter.ViewHolder> {

    private ArrayList<wardversion> android;
    private Context context;

    public WardAdpter(Context context, ArrayList<wardversion> android){
        this.android = android;
        this.context = context;
    }
    @Override
    public WardAdpter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.ward_row_layout,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {

        holder.vText.setText(android.get(position).getWard_name());

        holder.vImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context,ward_details.class);
                intent.putExtra("about_names",android.get(position).getWard_name());
                intent.putExtra("image",android.get(position).getWard_images());
                intent.putExtra("details",android.get(position).getWard_description());

                intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);

            }
        });


        Picasso.get().load(android.get(position).getWard_images()).resize(440,120).into(holder.vImg);
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
            Toast.makeText(context, vText.getText()+" is clicked.", Toast.LENGTH_SHORT).show();

        }
    }
}

