package lab1.sdmgap.edu.gallerytanvir.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;

import lab1.sdmgap.edu.gallerytanvir.Adapter.GalleryAdapter;
import lab1.sdmgap.edu.gallerytanvir.R;

public class GalleryFragment extends Fragment{

    private RecyclerView recycler_view;
    private RecyclerView.Adapter adapter;
    private GridLayoutManager layoutManager;
    private ProgressBar progress_circular;
    private Toolbar toolbar;

    private static String[] imageLinks = {
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Training-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Platepositive-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Outbound-Support-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/IT-Services-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Customer-Help-Desk-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Call-Center-service-1.pnghttps://wallpapercave.com/wp/wp2553957.jpg",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Billing-and-Coding-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Back-Office-Support-service-1.png"
    };

    public static String[] getImageLinks() {
        return imageLinks;
    }

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_gallery, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        toolbar = getView().findViewById(R.id.toolbar);
        progress_circular = getView().findViewById(R.id.progress_circular);
        recycler_view = getView().findViewById(R.id.recycler_view);

        layoutManager = new GridLayoutManager(getContext(), 2);
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
        adapter = new GalleryAdapter(getContext() , imageLinks);
        recycler_view.setAdapter(adapter);
        adapter.notifyDataSetChanged();
    }
}