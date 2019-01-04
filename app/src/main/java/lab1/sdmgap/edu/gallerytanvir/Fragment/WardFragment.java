package lab1.sdmgap.edu.gallerytanvir.Fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import lab1.sdmgap.edu.gallerytanvir.Adapter.WardAdpter;
import lab1.sdmgap.edu.gallerytanvir.ModelClass.AlbumVersion;
import lab1.sdmgap.edu.gallerytanvir.ModelClass.wardversion;
import lab1.sdmgap.edu.gallerytanvir.R;

public class WardFragment extends Fragment {


    private final String ward_names[] = {
            "গুলশান ১",
            "গুলশান ২",
            "বনানী",
            "মহাখালী"
    };
    // album image
    private final String ward_images[] = {
            "https://lh3.googleusercontent.com/p/AF1QipM9a9XPcpTXfTA35eYXGTj2XzfEK54kXzSSYnJ4=s1600-w400",
            "https://lh3.googleusercontent.com/p/AF1QipM9a9XPcpTXfTA35eYXGTj2XzfEK54kXzSSYnJ4=s1600-w400",
            "https://lh3.googleusercontent.com/p/AF1QipM9a9XPcpTXfTA35eYXGTj2XzfEK54kXzSSYnJ4=s1600-w400",
            "https://lh3.googleusercontent.com/p/AF1QipM9a9XPcpTXfTA35eYXGTj2XzfEK54kXzSSYnJ4=s1600-w400"

    };
    // word details

    private  final String word_details []={

            "fdjfkl",
            "ksdfljsdklf",
            "ajkdlfkl",
            "sfjjsdlkf"
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_ward, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        WardinitViews();
    }

    private void WardinitViews() {
        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.gridRecyclerView);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getActivity().getApplicationContext(),2);
        recyclerView.setLayoutManager(layoutManager);

        ArrayList ward_version = AlbumprepareData();
        WardAdpter adapter = new WardAdpter(getContext(),ward_version);
        recyclerView.setAdapter(adapter);
    }

    private ArrayList AlbumprepareData(){
        ArrayList ward_version = new ArrayList<>();
        for(int i=0;i<ward_names.length;i++){
          wardversion androidVersion = new wardversion();
            androidVersion.setWard_name(ward_names[i]);
            androidVersion.setWard_images(ward_images[i]);
            androidVersion.setWard_description(word_details[i]);
            ward_version.add(androidVersion);
        }
        return ward_version;
    }
}
