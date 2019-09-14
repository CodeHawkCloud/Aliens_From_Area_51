package com.example.foxfirekeep.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.foxfirekeep.activities.R;
import com.example.foxfirekeep.models.Forums;

import java.util.List;

public class forumsAdapter extends ArrayAdapter<Forums> {

    private static final String TAG = "forumListAdapter";
    private Context fContext;
    int faResource;

    public forumsAdapter(Context context, int resource, List<Forums> objects) {
        super(context, resource, objects);
        this.fContext = context;
        this.faResource = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        int id = getItem(position).getForums_id();
        String userName = getItem(position).getForumsName();
        String role = getItem(position).getForumsRole();
        String comment = getItem(position).getForumsComment();

        Forums forums = new Forums(id,userName,role,comment);

        LayoutInflater layoutInflater = LayoutInflater.from(fContext);
        convertView = layoutInflater.inflate(faResource,parent,false);

        TextView tvId = (TextView)convertView.findViewById(R.id.adapter_forum_view_id);
        TextView tvUserName = (TextView)convertView.findViewById(R.id.adapter_forum_view_name);
        TextView tvRole = (TextView)convertView.findViewById(R.id.adapter_forum_view_role);
        TextView tvComment = (TextView)convertView.findViewById(R.id.adapter_forum_view_comment);


        tvId.setText(String.valueOf(id));
        tvUserName.setText(userName);
        tvRole.setText(role);
        tvComment.setText(comment);

        return convertView;
    }
}
