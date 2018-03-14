package com.digipodium.proexamples;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by digipodium on 12/3/18.
 */

class StackerAdapter extends BaseAdapter {

    private final List<String> stackData;
    private final Context context;

    public StackerAdapter(Context context, List<String> stackData) {
        this.stackData = stackData;
        this.context = context;
    }

    @Override
    public int getCount() {
        return stackData.size();
    }

    @Override
    public Object getItem(int position) {
        return stackData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(context).inflate(R.layout.stack_card, parent, false);
            convertView.setTag(new Holder(convertView));
        }
        Holder holder = (Holder) convertView.getTag();
        holder.tvName.setText(stackData.get(position));

        return convertView;
    }

    class Holder {
        TextView tvName;

        public Holder(View view) {
            tvName = view.findViewById(R.id.tvName);
        }
    }
}
