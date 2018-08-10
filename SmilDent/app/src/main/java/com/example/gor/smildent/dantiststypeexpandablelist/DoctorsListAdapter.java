package com.example.grigor.fivefriendsmile.dantiststypeexpandablelist;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.grigor.fivefriendsmile.R;
import java.util.List;

/**
 * Created by Gor on 27.06.2016.
 */
public class DoctorsListAdapter  extends BaseAdapter{
    Context context;
    List<Group> groups;

    DoctorsListAdapter(Context context, List<Group> groups) {
        this.context = context;
        this.groups = groups;

    }

    @Override
    public int getCount() {

        return groups.size();
    }

    @Override
    public Object getItem(int position) {

        return groups.get(position);
    }

    @Override
    public long getItemId(int position) {

        return groups.indexOf(getItem(position));
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater mInflater = (LayoutInflater) context
                    .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView = mInflater.inflate(R.layout.doctors_item, null);
        }

        ImageView doctor_image = (ImageView) convertView.findViewById(R.id.doctors_image);
        TextView doctor_surname = (TextView) convertView.findViewById(R.id.doctor_surname);

        Group group = groups.get(position);
        doctor_image.setImageResource(group.getDoctorimage());
        doctor_surname.setText(group.getTitle());

        return convertView;

    }

}
