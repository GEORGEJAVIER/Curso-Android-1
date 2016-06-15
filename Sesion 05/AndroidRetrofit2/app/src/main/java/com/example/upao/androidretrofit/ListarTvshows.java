package com.example.upao.androidretrofit;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;

import java.util.ArrayList;
import java.util.List;
import com.example.upao.androidretrofit.apiservices.RestClient;
import com.example.upao.androidretrofit.apiservices.model.Tvshow;


public class ListarTvshows  extends Fragment {

    List<String> tvshowslist = new ArrayList<>();

    private ListAdapter mAdapter;

    RestClient restClient = RestClient.getInstance();

    RestClient.ResultReadyCallback callback = new RestClient.ResultReadyCallback() {
        @Override
        public void resultReady(List<Tvshow> tvlist) {
            for(Tvshow tv: tvlist) {
                tvshowslist.add(tv.getTitulo());
            }

            ((ArrayAdapter) mAdapter).notifyDataSetChanged();
        }
    };


    public static ListarTvshows newInstance() {
        ListarTvshows fragment = new ListarTvshows();
        return fragment;
    }

    public ListarTvshows() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        mAdapter = new ArrayAdapter<String>(getActivity(),
                android.R.layout.simple_list_item_1, android.R.id.text1, tvshowslist);

        restClient.setCallback(callback);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_item, container, false);

        AbsListView mListView = (AbsListView) view.findViewById(android.R.id.list);
        ((AdapterView<ListAdapter>) mListView).setAdapter(mAdapter);


        return view;
    }

    @Override
    public void onResume() {
        super.onResume();
        restClient.getTvshows();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }

}
