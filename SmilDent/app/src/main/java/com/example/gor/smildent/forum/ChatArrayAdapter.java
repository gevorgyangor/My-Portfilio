package com.example.grigor.fivefriendsmile.forum;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.grigor.fivefriendsmile.R;

import java.util.ArrayList;
import java.util.List;

class ChatArrayAdapter extends ArrayAdapter<ChatMessage> {

    private TextView chatText;
    private List<ChatMessage> chatMessageList = new ArrayList<ChatMessage>();
    private Context context;

    @Override
    public void add(ChatMessage object) {
        chatMessageList.add(object);
        super.add(object);
    }

    public ChatArrayAdapter(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
        this.context = context;
    }
//   TODO: nael tun@
//    @Override
//    public int getItemViewType(int position) {
//        return super.getItemViewType(position);
//    }
//
//    @Override
//    public int getViewTypeCount() {
//        return super.getViewTypeCount();
//    }

    public int getCount() {
        return this.chatMessageList.size();
    }

    public ChatMessage getItem(int index) {
        return this.chatMessageList.get(index);
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        ChatMessage chatMessageObj = getItem(position);
        View row = convertView;
        LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        if (chatMessageObj.message.length()==5) {
            row = inflater.inflate(R.layout.forum_message_right, parent, false);
        }else{
            row = inflater.inflate(R.layout.forum_message_left, parent, false);
        }
        chatText = (TextView) row.findViewById(R.id.msgr);
        chatText.setText(chatMessageObj.message);
        return row;
    }
}