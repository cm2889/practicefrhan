package lab1.sdmgap.edu.gallerytanvir.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ProgressBar;

import lab1.sdmgap.edu.gallerytanvir.Adapter.GalleryAdapter;
import lab1.sdmgap.edu.gallerytanvir.R;

public class GalleryActivity extends AppCompatActivity {
    private RecyclerView recycler_view;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager layoutManager;
    private ProgressBar progress_circular;
    private Toolbar toolbar;

    private static String[] imageLinks = {
            "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQo3KkVFbbKYbuLkDbZwQmhcEwD1nNau8ycQy8f_xQ1GarxVNk8",
            "https://assetsds.cdnedge.bluemix.net/sites/default/files/styles/big_5/public/news/images/faruk2.jpg?itok=CJSRJmLZ",
            "https://i.ytimg.com/vi/6iIGxLotrzI/hqdefault.jpg",
            "https://assetsds.cdnedge.bluemix.net/sites/default/files/styles/very_big_1/public/feature/images/farooque_4.jpg?itok=HcqAj9if",
            "https://uepv.ru/go.php?https://i.ytimg.com/vi/WATK0VqV8I0/hqdefault.jpg",
            "https://i.ytimg.com/vi/YfC9b-v7V6w/maxresdefault.jpg",
            "http://www.newagebd.com/files/records/news/201710/26513_12.jpg"

    };

    public static String[] getImageLinks() {
        return imageLinks;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gallery);

        toolbar = findViewById(R.id.toolbar);
        progress_circular = findViewById(R.id.progress_circular);
        recycler_view = findViewById(R.id.recycler_view);
        layoutManager = new GridLayoutManager(this, 2);
        recycler_view.setLayoutManager(layoutManager);
        recycler_view.setItemAnimator(new DefaultItemAnimator());

        progress_circular.setVisibility(View.VISIBLE);
        recycler_view.setVisibility(View.GONE);

        if (imageLinks.length <= 0){
            progress_circular.setVisibility(View.VISIBLE);
            recycler_view.setVisibility(View.GONE);
        }else {
            progress_circular.setVisibility(View.GONE);
            recycler_view.setVisibility(View.VISIBLE);
        }
        adapter = new GalleryAdapter(GalleryActivity.this , imageLinks);
        recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }

}
