package com.example.todov1app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.todov1app.databinding.ActivityAddTaskBinding;

public class AddTaskActivity extends AppCompatActivity {

    ActivityAddTaskBinding binding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityAddTaskBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        binding.addNewButton.setOnClickListener(view -> {
            String name = binding.taskNameEditText.getText().toString();
            String desc = binding.taskDescEditText.getText().toString();
            String priority = "";
            switch (binding.PrioridadeRadioGroup.getCheckedRadioButtonId()) {
                case R.id.highPriorityRadioButton:
                    priority = "high";
                    break;
                case R.id.mediumPriorityRadioButton:
                    priority = "medium";
                    break;
                case R.id.lowPriorityRadioButton:
                    priority = "low";
                    break;
            }
            Task task = new Task(name, desc, priority);
            Intent i = new Intent();
            i.putExtra("taskAdded", task);
            setResult(RESULT_OK, i);
            AddTaskActivity.this.finish();
        });
    }
}