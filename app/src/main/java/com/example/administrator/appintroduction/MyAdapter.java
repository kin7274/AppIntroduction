package com.example.administrator.appintroduction;

import android.content.Context;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class MyAdapter extends BaseExpandableListAdapter {

    private Context mContext;
    private ArrayList<Index> index;
    private LayoutInflater inflater;

    //class Constructor
    public MyAdapter (Context mContext, ArrayList<Index> index) {

        this.mContext = mContext;
        this.index = index;
        inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getGroupCount() {
        return index.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return index.get(groupPosition).contents.size();
    }

    //get position
    @Override
    public Object getGroup(int groupPosition) {
        return index.get(groupPosition);
    }

    //this is where we get the information of player
    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return index.get(groupPosition).contents.get(childPosition);
    }

    //position ID
    @Override
    public long getGroupId(int groupPosition) {
        return 0;
    }

    //where to get player's id
    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return 0;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    //get parent row
    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.parent_list, null);
        }

        //get position
        Index position = (Index) getGroup(groupPosition);

        //set positionName
        String positionName = position.index;

        TextView textView = (TextView) convertView.findViewById(R.id.position_tv);
        textView.setText(positionName);

        ImageView imageView = (ImageView) convertView.findViewById(R.id.indicator);
        if(isExpanded){
            imageView.setImageResource(R.drawable.ic_keyboard_arrow_down_black_24dp);
        } else {
            imageView.setImageResource(R.drawable.ic_keyboard_arrow_up_black_24dp);
        }
        return convertView;
    }

    //get child_list.xml (View)
    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {

        //inflate the layout
        if (convertView == null) {
            convertView = inflater.inflate(R.layout.child_list, null);
        }

        String child = (String) getChild(groupPosition, childPosition);

        //set the child name
        TextView name = (TextView) convertView.findViewById(R.id.name_tv);
        name.setText(child);

        //get position name
        String indexName = (String) getGroup(groupPosition).toString();
        if (indexName == "목차1.1은 무엇") {
            if (child == "1.1의 내용은1111111111111") {
            }
        } else if (indexName == "목차1.2은 무엇") {
            if (child == "1.2의 내용은1111111111111") {
            }
        } else if (indexName == "목차1.3은 무엇") {
            if (child == "1.3의 내용은1111111111111") {
            }
        } else if (indexName == "목차1.4은 무엇") {
            if (child == "1.4의 내용은1111111111111") {
            }
        }
        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }

}