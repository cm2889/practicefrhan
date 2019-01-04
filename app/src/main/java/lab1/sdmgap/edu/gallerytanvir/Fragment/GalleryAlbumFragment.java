package lab1.sdmgap.edu.gallerytanvir.Fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lab1.sdmgap.edu.gallerytanvir.Adapter.GalleryAlbumAdapter;
import lab1.sdmgap.edu.gallerytanvir.ModelClass.AlbumVersion;
import lab1.sdmgap.edu.gallerytanvir.R;

public class GalleryAlbumFragment extends Fragment {


    private final String album_names[] = {
            "Album 1",
            "Album 2"

    };
    // album image
    private final String album_images[] = {
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Outbound-Support-service-1.png",
            "http://www.digicontechnologies.com/wp-content/uploads/2017/07/Platepositive-service-1.png"

    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_gallery_album, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        GalleryinitViews();
    }

    private void GalleryinitViews() {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.gridRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());
        recyclerView.setLayoutManager(layoutManager);

        ArrayList album_version = AlbumprepareData();
        GalleryAlbumAdapter adapter = new GalleryAlbumAdapter(getContext(),album_version);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList AlbumprepareData(){
        ArrayList album_version = new ArrayList<>();
        for(int i=0;i<album_names.length;i++){
            AlbumVersion androidVersion = new AlbumVersion();
            androidVersion.setAlbum_name(album_names[i]);
            androidVersion.setAlbum_images(album_images[i]);
            album_version.add(androidVersion);
        }
        return album_version;
    }
}
