package lab1.sdmgap.edu.gallerytanvir.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import lab1.sdmgap.edu.gallerytanvir.R;

public class ward_details extends AppCompatActivity {
    private ImageView imageView;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ward_details);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        imageView = findViewById(R.id.Imagedetils);
        textView= findViewById(R.id.text_Details);

        Intent intent=getIntent();

        //String about_names=intent.getExtras().getString("about_names");
        String image=intent.getExtras().getString("image");
        String details=intent.getExtras().getString("details");

        textView.setText(details);

        Picasso.get().load(image).into(imageView);

    }
}
