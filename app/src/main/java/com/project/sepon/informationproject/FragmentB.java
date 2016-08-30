package com.project.sepon.informationproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import java.util.ArrayList;

/**
 * Created by Nazrulcse on 6/14/2016.
 */
public class FragmentB extends Fragment {

    private ListView listView;
    private PersonAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.alldatalist, container, false);

        listView = (ListView) view.findViewById(R.id.listView);
        Database instance = Database.getinstance(getContext());
        ArrayList<Personinformation> allperson = instance.getallinformation();

        for (int i = 0; i < allperson.size(); i++){
            Log.e("data", allperson.get(i).toString());
        }


        adapter = new PersonAdapter(getContext(), allperson);
        listView.setAdapter(adapter);


        return view;
    }


}
