package com.example.madricplus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ActionsFragment extends Fragment {

    RecyclerView recyclerView;
    ActionAdapter adapter;
    ArrayList<ActionData> list;
    Button btnAdd;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actions, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        btnAdd = view.findViewById(R.id.btnAdd);

        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        list = new ArrayList<>();

        adapter = new ActionAdapter(list);
        recyclerView.setAdapter(adapter);

        btnAdd.setOnClickListener(v -> {

            View dialogView = LayoutInflater.from(getContext())
                    .inflate(R.layout.dialog_add_action, null);

            EditText etName = dialogView.findViewById(R.id.etName);
            EditText etSubject = dialogView.findViewById(R.id.etSubject);
            EditText etAge = dialogView.findViewById(R.id.etAge);
            EditText etContent = dialogView.findViewById(R.id.etContent);

            new androidx.appcompat.app.AlertDialog.Builder(requireContext())
                    .setTitle("הוספת פעולה חדשה")
                    .setView(dialogView)
                    .setPositiveButton("שמירה", (dialog, which) -> {

                        String name = etName.getText().toString();
                        String subject = etSubject.getText().toString();
                        String age = etAge.getText().toString();
                        String content = etContent.getText().toString();

                        list.add(new ActionData(name, subject, age, content));
                        adapter.notifyItemInserted(list.size() - 1);
                    })
                    .setNegativeButton("ביטול", null)
                    .show();
        });

        return view;
    }
}