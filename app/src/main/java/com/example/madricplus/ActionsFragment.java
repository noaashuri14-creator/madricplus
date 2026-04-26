package com.example.madricplus;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.*;

import androidx.appcompat.app.AlertDialog;
import androidx.fragment.app.Fragment;

import java.util.ArrayList;

public class ActionsFragment extends Fragment {

    ListView listView;
    Button btnAdd;

    ArrayList<String> currentList;
    ArrayAdapter<String> adapter;

    String selectedCategory = null;

    boolean inActionsMode = false;

    public ActionsFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_actions, container, false);

        listView = view.findViewById(R.id.listCategories);
        btnAdd = view.findViewById(R.id.btnAdd);

        showCategories();

        // לחיצה על פריט
        listView.setOnItemClickListener((parent, v, position, id) -> {

            if (!inActionsMode) {
                // כניסה לקטגוריה
                selectedCategory = currentList.get(position);
                showActions(selectedCategory);
            } else {
                // חזרה לקטגוריות
                showCategories();
            }
        });

        btnAdd.setOnClickListener(v -> showAddDialog());

        return view;
    }

    // 🟢 מצב קטגוריות
    private void showCategories() {

        inActionsMode = false;
        btnAdd.setVisibility(View.GONE);

        currentList = new ArrayList<>(ActionData.categories.keySet());

        adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                currentList
        );

        listView.setAdapter(adapter);
    }

    // 🟡 מצב פעולות של קטגוריה
    private void showActions(String category) {

        inActionsMode = true;
        btnAdd.setVisibility(View.VISIBLE);

        currentList = ActionData.categories.get(category);

        adapter = new ArrayAdapter<>(
                getContext(),
                android.R.layout.simple_list_item_1,
                currentList
        );

        listView.setAdapter(adapter);
    }

    // ➕ הוספת פעולה
    private void showAddDialog() {

        EditText input = new EditText(getContext());
        input.setHint("כותרת | גיל | תוכן");

        new AlertDialog.Builder(getContext())
                .setTitle("הוספה ל-" + selectedCategory)
                .setView(input)
                .setPositiveButton("הוסף", (d, w) -> {

                    String text = input.getText().toString();

                    if (selectedCategory != null && !text.isEmpty()) {
                        ActionData.categories.get(selectedCategory).add(text);
                        adapter.notifyDataSetChanged();
                    }
                })
                .setNegativeButton("ביטול", null)
                .show();
    }
}