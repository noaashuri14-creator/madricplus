package com.example.madricplus; // תוודאי שהחבילה נכונה

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class HomeFragment extends Fragment {

    public HomeFragment() {}

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // טוען את ה-XML של המסך
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        // כפתורים קיימים
        Button btnLogin = view.findViewById(R.id.btnLogin);
        Button btnActions = view.findViewById(R.id.btnActions);
        Button btnRooms = view.findViewById(R.id.btnRooms);

        // לחיצות על הכפתורים
        btnLogin.setOnClickListener(v ->
                ((MainActivity)getActivity()).loadFragment(new LoginFragment()));

        btnActions.setOnClickListener(v ->
                ((MainActivity)getActivity()).loadFragment(new ActionsFragment()));

        btnRooms.setOnClickListener(v ->
                ((MainActivity)getActivity()).loadFragment(new RoomsFragment()));

        return view;
    }
}

