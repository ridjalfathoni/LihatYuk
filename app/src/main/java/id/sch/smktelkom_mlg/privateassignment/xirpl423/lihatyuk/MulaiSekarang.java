package id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;

import java.util.ArrayList;

import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Adapter.Source;
import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Model.Hasil;
import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Model.ResponCode;
import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Service.GsonGetReq;
import id.sch.smktelkom_mlg.privateassignment.xirpl423.lihatyuk.Service.Volley;


/**
 * A simple {@link Fragment} subclass.
 */
public class MulaiSekarang extends Fragment {
    ArrayList<Hasil> mList = new ArrayList<>();
    Source mSource;

    public MulaiSekarang() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_populer, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);


        RecyclerView recyclerView = (RecyclerView) getView().findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        mSource = new Source(this.getActivity(), mList);
        recyclerView.setAdapter(mSource);

        downloadDataSources();
    }

    private void downloadDataSources() {
        String url = "https://api.themoviedb.org/3/movie/now_playing?api_key=19ab05665da519d2289a688ae9921bdc&language=en-US&page=1";

        GsonGetReq<ResponCode> myRequest = new GsonGetReq<ResponCode>
                (url, ResponCode.class, null, new Response.Listener<ResponCode>() {

                    @Override
                    public void onResponse(ResponCode response) {
                        Log.d("FLOW", "onResponse: " + (new Gson().toJson(response)));

                        mList.addAll(response.results);
                        mSource.notifyDataSetChanged();

                    }

                }, new Response.ErrorListener() {

                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.e("FLOW", "onErrorResponse: ", error);
                    }
                });
        Volley.getInstance(this.getActivity()).addToRequestQueue(myRequest);
    }

}