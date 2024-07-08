package com.mindofmachines.vegme.ui.tasks;

import android.app.AlertDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.mindofmachines.vegme.R;
import com.mindofmachines.vegme.databinding.FragmentTasksBinding;

public class TasksFragment extends Fragment{

    private List<Task> taskList;
    private RecyclerView tasksRecyclerView;
    private TasksAdapter tasksAdapter;
    private FloatingActionButton tasksAddButton;
    private FragmentTasksBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TasksViewModel tasksViewModel =
                new ViewModelProvider(this).get(TasksViewModel.class);

        binding = FragmentTasksBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        tasksRecyclerView = binding.tasksRecyclerView;
        tasksAddButton = binding.tasksAddButton;

        taskList = new ArrayList<>();

        Task newTask = new Task("test", "2024", "Sept", "08", "18:00", "Buy vegan food at Costco");
        taskList.add(newTask);

        newTask = new Task("test 2", "2024", "Sept", "09", "18:00", "Tofu can be yummy too!");
        taskList.add(newTask);

        tasksAdapter = new TasksAdapter(taskList);

        tasksRecyclerView.setLayoutManager(new LinearLayoutManager(requireActivity()));
        tasksRecyclerView.setAdapter(tasksAdapter);
        tasksAddButton.setOnClickListener(v -> showAddTaskDialog());

        return root;
    }

    private void showAddTaskDialog() {

        View dialogView = LayoutInflater.from(getContext()).inflate(R.layout.view_addtask, null);

        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setView(dialogView)
                .setTitle("Add Task")
                .setPositiveButton("Add", (dialog, which) -> {
                    EditText etTitle = dialogView.findViewById(R.id.etTitle);
                    EditText etYear = dialogView.findViewById(R.id.etYear);
                    EditText etMonth = dialogView.findViewById(R.id.etMonth);
                    EditText etDate = dialogView.findViewById(R.id.etDate);
                    EditText etTime = dialogView.findViewById(R.id.etTime);
                    EditText etDescription = dialogView.findViewById(R.id.etDescription);

                    String title = etTitle.getText().toString();
                    String year = etYear.getText().toString();
                    String month = etMonth.getText().toString();
                    String date = etDate.getText().toString();
                    String time = etTime.getText().toString();
                    String description = etDescription.getText().toString();
                    taskList.add(new Task(title, year, month, date, time, description));
                    tasksAdapter.notifyDataSetChanged();
                })
                .setNegativeButton("Cancel", null)
                .show();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}