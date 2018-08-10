package com.example.grigor.fivefriendsmile.dentiststype;

import android.app.ListFragment;


import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.grigor.fivefriendsmile.R;
import com.example.grigor.fivefriendsmile.stomatologylist.RowItem;

import java.util.ArrayList;
import java.util.List;


public class DoctorList extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    TypedArray menuIcons;

    DoctorListAdapter adapter;
    private List<Group> doctorImage;


    public DoctorList() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_stomatology_list, null, false);
//        Toolbar toolbar = (Toolbar) view.findViewById(R.id.doctor_list_toolbar);
//        toolbar.setTitle("Doctor List");


        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.doctors_name);
        menuIcons = getResources().obtainTypedArray(R.array.doctors_image);


        doctorImage = new ArrayList<>();

        for (int i = 0; i < menutitles.length; i++) {
            Group items = new Group(menutitles[i], menuIcons.getResourceId(i, -1));
            doctorImage.add(items);
        }

        adapter = new DoctorListAdapter(getActivity(), doctorImage);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getActivity(), Doctor.class);
        Group items = doctorImage.get(position);
        String str = items.getTitle();
        intent.putExtra("dentistName", str);
        startActivity(intent);
    }

}