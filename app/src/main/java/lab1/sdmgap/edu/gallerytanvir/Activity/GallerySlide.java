package lab1.sdmgap.edu.gallerytanvir.Activity;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageButton;
import android.widget.TextView;
import com.squareup.picasso.Picasso;

import lab1.sdmgap.edu.gallerytanvir.R;
import lab1.sdmgap.edu.gallerytanvir.ImageUiv.TouchImageView;

public class GallerySlide extends AppCompatActivity {
    private static final String TAG = GallerySlide.class.getSimpleName();

    private String[] imageLinks;
    private int position;
    private ViewPager viewpager;
    private GallerySlide.ViewPagerAdapter pagerAdapter;
    private TextView lbl_count, tagsTV, userTV;
    private ImageButton leftArrow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        getWindow().requestFeature(Window.FEATURE_ACTIVITY_TRANSITIONS);
        if (Build.VERSION.SDK_INT < 16)
        {
            getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                    WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else
        {
            View decorView = getWindow().getDecorView();
            // Hide the status bar.
            int uiOptions = View.SYSTEM_UI_FLAG_FULLSCREEN;
            decorView.setSystemUiVisibility(uiOptions);
        }
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery_slide);

        position = getIntent().getIntExtra("position", 0);
        imageLinks = GalleryActivity.getImageLinks();


        leftArrow = findViewById(R.id.leftArrow);
        viewpager = findViewById(R.id.viewpager);
        lbl_count = findViewById(R.id.lbl_count);


        pagerAdapter = new ViewPagerAdapter(this, imageLinks);
        viewpager.setAdapter(pagerAdapter);
        viewpager.setCurrentItem(position);

        displayCurrnetItemPostion(position);

        viewpager.addOnPageChangeListener(viewPagerChangeListener);

        leftArrow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(GallerySlide.this, GalleryActivity.class));
                finish();
            }
        });
    }

    ViewPager.OnPageChangeListener viewPagerChangeListener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int i, float v, int i1) {
        }

        @Override
        public void onPageSelected(int i) {
            displayCurrnetItemPostion(i);
        }

        @Override
        public void onPageScrollStateChanged(int i) {

        }
    };


    private void displayCurrnetItemPostion(int position){
        try {
            lbl_count.setText((position + 1) + "/" + imageLinks.length);

        }catch (Exception e){
            Log.d(TAG, "displayCurrnetItemPostion: "+e.getMessage());
        }

    }


    private class ViewPagerAdapter extends PagerAdapter {

        private LayoutInflater layoutInflater;
        private Context context;
        private String[] imageLinks;

        public ViewPagerAdapter(Context context, String[] imageLinks) {
            this.context = context;
            this.imageLinks = imageLinks;
        }

        @NonNull
        @Override
        public Object instantiateItem(@NonNull ViewGroup container, int position) {

            layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            View view = layoutInflater.inflate(R.layout.image_fullscreen_preview, container, false);
            TouchImageView imagePreview = view.findViewById(R.id.image_preview);

            Picasso.get().load(imageLinks[position])
                    .placeholder(R.drawable.picture)
                    .error(R.drawable.picture)
                    .into(imagePreview);

            container.addView(view);

            return view;
        }

        @Override
        public int getCount() {
            return imageLinks.length;
        }

        @Override
        public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
            return view == ((View) o);
        }

        @Override
        public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
            container.removeView((View) object);
        }
    }

}