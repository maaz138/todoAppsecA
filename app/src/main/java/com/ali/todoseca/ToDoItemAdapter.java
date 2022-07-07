package com.ali.todoseca;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ToDoItemAdapter extends BaseAdapter {

    public List<ToDoItem> list;

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {

        ToDoItem item = list.get(position);
        return item.getID();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ToDoItem item = list.get(position);

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View view = layoutInflater.inflate(R.layout.todoitem_layout,parent,false);

        ((TextView) view.findViewById(R.id.tvTitle)).setText(item.getTitle());
        ((TextView) view.findViewById(R.id.tvDesc)).setText(item.getDescription());

        view.findViewById(R.id.btnDel).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                list.remove(position);
                notifyDataSetChanged();
            }
        });

        return view;
    }
}
