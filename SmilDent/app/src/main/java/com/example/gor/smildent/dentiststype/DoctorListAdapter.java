package com.example.grigor.fivefriendsmile.dentiststype;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grigor.fivefriendsmile.R;
import com.example.grigor.fivefriendsmile.dentiststype.Group;

import java.util.List;



public class DoctorListAdapter extends BaseAdapter {
    Context context;
    List<Group> rowItem;

    public DoctorListAdapter(Context context, List<Group> rowItem) {
        this.context = context;
        this.rowItem= rowItem;

    }

    @Override
    public int getCount() {

        return rowItem.size();
    }

    @Override
    public Object getItem(int position) {

        return rowItem.get(position);
    }

    @Override
    public long getItemId(int position) {

        return rowItem.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.stomatology_logo, null);
            convertView.setBackgroundColor(Color.WHITE);
        }

        ImageView imgIcon = (ImageView) convertView.findViewById(R.id.icon);
        TextView txtTitle = (TextView) convertView.findViewById(R.id.title);



        Group row_pos = rowItem.get(position);
        imgIcon.setImageResource(row_pos.getDoctorimage());
        txtTitle.setText(row_pos.getTitle());

        return convertView;

    }
}
