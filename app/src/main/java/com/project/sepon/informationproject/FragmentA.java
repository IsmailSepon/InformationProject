package com.project.sepon.informationproject;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

/**
 * Created by Nazrulcse on 6/13/2016.
 */
public class FragmentA extends Fragment implements View.OnClickListener {

    private EditText name,father,ocupation,education,location,mobile,email;
    private Button date,camera, export, submite;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_layout, container, false);

        name = (EditText) view.findViewById(R.id.name);
        father = (EditText) view.findViewById(R.id.fathername);
        ocupation = (EditText) view.findViewById(R.id.ocupation);
        education = (EditText) view.findViewById(R.id.education);
        location = (EditText) view.findViewById(R.id.location);
        mobile = (EditText) view.findViewById(R.id.mobile);
        email = (EditText) view.findViewById(R.id.email);
        export = (Button) view.findViewById(R.id.exportButton);

        date = (Button) view.findViewById(R.id.datebutton);
        camera = (Button) view.findViewById(R.id.camera);
        submite = (Button) view.findViewById(R.id.submitebutton);

        date.setOnClickListener(this);
        camera.setOnClickListener(this);
        submite.setOnClickListener(this);
        export.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View v) {

        switch (v.getId()){
            case R.id.datebutton:
                break;
            case R.id.camera:
                break;
            case R.id.submitebutton:
                submition();
                break;
            case R.id.exportButton:
                break;
        }
    }

    private void submition() {
        Personinformation personinformation = new Personinformation(name.getText().toString(),
                father.getText().toString(),ocupation.getText().toString(),education.getText().toString(),
                location.getText().toString(),mobile.getText().toString(),email.getText().toString());


        if (name.length() == 0 && ocupation.length() == 0 && mobile.length() == 0){
            Toast.makeText(getContext(), "Plese give your information", Toast.LENGTH_SHORT).show();

        }

        Database instance = Database.getinstance(getContext());
        long insertdata = instance.insertData(personinformation);
        Log.e("onClick", "" + insertdata);

        Toast.makeText(getContext(), "Successaly Saved", Toast.LENGTH_SHORT).show();

    }


}
