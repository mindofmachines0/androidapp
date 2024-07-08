package com.mindofmachines.vegme.ui.tasks;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mindofmachines.vegme.R;

import java.util.List;

public class TasksAdapter extends RecyclerView.Adapter<TasksAdapter.TasksViewHolder> {

    private List<Task> taskList;

    public static class TasksViewHolder extends RecyclerView.ViewHolder {

        public TextView taskTitle, taskYear, taskMonth, taskDate, taskTime, taskDescription;

        public TasksViewHolder(@NonNull View itemView) {
            super(itemView);
            taskTitle = itemView.findViewById(R.id.taskTitle);
            taskTime = itemView.findViewById(R.id.taskTime);
            taskDate = itemView.findViewById(R.id.taskDate);
            taskYear = itemView.findViewById(R.id.taskYear);
            taskMonth = itemView.findViewById(R.id.taskMonth);
            taskDescription = itemView.findViewById(R.id.taskDescription);
        }
    }

    public TasksAdapter(List<Task> taskList) {
        this.taskList = taskList;
    }

    @NonNull
    @Override
    public TasksViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_task, parent, false);
        return new TasksViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull TasksViewHolder holder, int position) {
        Task task = taskList.get(position);
        holder.taskYear.setText(task.getYear());
        holder.taskMonth.setText(task.getMonth());
        holder.taskDate.setText(task.getDate());
        holder.taskTime.setText(task.getTime());
        holder.taskTitle.setText(task.getTitle());
        holder.taskDescription.setText(task.getDescription());
    }

    @Override
    public int getItemCount() {
        return taskList.size();
    }

}
