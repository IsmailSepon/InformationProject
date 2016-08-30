package com.project.sepon.informationproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by SEPOn on 8/30/2016.
 */
public class PersonAdapter extends ArrayAdapter<Personinformation>{

    private Context context;
    private ArrayList<Personinformation> allperson;


    public PersonAdapter(Context context, ArrayList<Personinformation> allperson) {
        super(context, R.layout.customlayout, allperson);
        this.context = context;
        this.allperson = allperson;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null){
            String personname = allperson.get(position).getPersonName();
//            String fathername = allperson.get(position).getFatherName();
            String ocupation = allperson.get(position).getOcupation();
//            String education = allperson.get(position).getEducation();
//            String location = allperson.get(position).getLocation();
            String mobile = allperson.get(position).getMobile();
//            String email = allperson.get(position).getEmail();


            convertView = LayoutInflater.from(context).inflate(R.layout.customlayout, parent, false);


            TextView name = (TextView) convertView.findViewById(R.id.personName);
            TextView pocupation = (TextView) convertView.findViewById(R.id.ocupation);
            TextView mNumber = (TextView) convertView.findViewById(R.id.personNumber);



            name.setText(""+personname);
            pocupation.setText(""+ocupation);
            mNumber.setText(""+mobile);


        }
        return convertView;
    }
}
