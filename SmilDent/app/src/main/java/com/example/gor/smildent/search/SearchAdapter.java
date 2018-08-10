package com.example.grigor.fivefriendsmile.search;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.grigor.fivefriendsmile.R;

import java.util.ArrayList;

public class SearchAdapter extends BaseAdapter {

    private Context myContext;
    private ArrayList<String> stomAndDoctorNames;
    private LayoutInflater layoutInflater;
    private boolean filterList;

    public SearchAdapter(Context context, ArrayList<String> stomdoctorsnames, boolean isFilterList) {
        this.myContext = context;
        this.stomAndDoctorNames = stomdoctorsnames;
        this.filterList = isFilterList;
    }


    public void updateList(ArrayList<String> filterList, boolean isFilterList) {
        this.stomAndDoctorNames = filterList;
        this.filterList = isFilterList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return stomAndDoctorNames.size();
    }

    @Override
    public String getItem(int position) {
        return stomAndDoctorNames.get(position);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        ViewHolder holder = null;
        if (view == null) {

            holder = new ViewHolder();

            layoutInflater = (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            view = layoutInflater.inflate(R.layout.list_item_search, parent, false);
            holder.textNames = (TextView) view.findViewById(R.id.txt_country);
            view.setTag(holder);
        } else {

            holder = (ViewHolder) view.getTag();
        }

        holder.textNames.setText(stomAndDoctorNames.get(position));

        Drawable searchDrawable, recentDrawable;

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            searchDrawable = myContext.getResources().getDrawable(R.drawable.search, null);
            recentDrawable = myContext.getResources().getDrawable(R.drawable.ic_backup_18pt, null);

        } else {
            searchDrawable = myContext.getResources().getDrawable(R.drawable.search);
            recentDrawable = myContext.getResources().getDrawable(R.drawable.ic_backup_18pt);
        }
        if (filterList) {
            holder.textNames.setCompoundDrawablesWithIntrinsicBounds(searchDrawable, null, null, null);
        } else {
            holder.textNames.setCompoundDrawablesWithIntrinsicBounds(recentDrawable, null, null, null);

        }
        return view;
    }

}

class ViewHolder {
    TextView textNames;
}