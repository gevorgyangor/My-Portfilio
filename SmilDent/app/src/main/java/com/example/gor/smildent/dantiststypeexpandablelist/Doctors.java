package com.example.grigor.fivefriendsmile.dantiststypeexpandablelist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.grigor.fivefriendsmile.R;
import com.example.grigor.fivefriendsmile.doctorpage.Doctor;

import java.util.ArrayList;
import java.util.List;


public class Doctors extends ListFragment implements AdapterView.OnItemClickListener {

    String[] doctors;
    TypedArray doctorsicon;

    DoctorsListAdapter adapter;
    private List<Group> groups;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.doctors_fragment, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);



        doctors = getResources().getStringArray(R.array.doctors_name);
        doctorsicon = getResources().obtainTypedArray(R.array.doctors_image);

        groups = new ArrayList<>();

        for (int i = 0; i < doctors.length; i++) {
            Group items = new Group(doctors[i], doctorsicon.getResourceId(i, -1));
            groups.add(items);
        }


        adapter = new DoctorsListAdapter(getActivity(),groups);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(),Doctor.class);
        Group group = groups.get(position);
        String str = group.getTitle();
        intent.putExtra("DoctorsName",str);
        startActivity(intent);
    }

}


