package com.example.grigor.fivefriendsmile.stomatologylist;

import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import com.example.grigor.fivefriendsmile.R;
import com.example.grigor.fivefriendsmile.dentiststype.TypesOfDantists;

import java.util.ArrayList;
import java.util.List;


public class StomatologyListFragment extends ListFragment implements AdapterView.OnItemClickListener {

    String[] menutitles;
    TypedArray menuIcons;

    StomatologyListAdapter adapter;
    private List<RowItem> rowItems;


    public StomatologyListFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_stomatology_list, null, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        menutitles = getResources().getStringArray(R.array.stomatology_name);
        menuIcons = getResources().obtainTypedArray(R.array.profile_logs);


        rowItems = new ArrayList<>();

        for (int i = 0; i < menutitles.length; i++) {
            RowItem items = new RowItem(menutitles[i], menuIcons.getResourceId(i, -1));
            rowItems.add(items);
        }

        adapter = new StomatologyListAdapter(getActivity(), rowItems);
        setListAdapter(adapter);
        getListView().setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Intent intent = new Intent(getContext(), TypesOfDantists.class);
        RowItem rowItem = rowItems.get(position);
        String str = rowItem.getTitle();
        intent.putExtra("stomName",str);
        startActivity(intent);
    }

}




