package id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Adapter.Source;
import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Model.Hasil;


/**
 * A simple {@link Fragment} subclass.
 */
public class Teratas extends Fragment {
    ArrayList<Hasil> mList = new ArrayList<>();
    Source mSource;

    public Teratas() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_teratas, container, false);
    }

}
