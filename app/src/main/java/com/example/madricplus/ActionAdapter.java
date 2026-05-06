package com.example.madricplus;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ActionAdapter extends RecyclerView.Adapter<ActionAdapter.ViewHolder> {

    List<ActionData> list;

    public ActionAdapter(List<ActionData> list) {
        this.list = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_action, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        ActionData item = list.get(position);

        holder.name.setText(item.getName());
        holder.subject.setText("נושא: " + item.getSubject());
        holder.age.setText("גיל: " + item.getAge());
        holder.content.setText(item.getContent());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        TextView name, subject, age, content;

        public ViewHolder(View itemView) {
            super(itemView);

            name = itemView.findViewById(R.id.tvName);
            subject = itemView.findViewById(R.id.tvSubject);
            age = itemView.findViewById(R.id.tvAge);
            content = itemView.findViewById(R.id.tvContent);
        }
    }
}
