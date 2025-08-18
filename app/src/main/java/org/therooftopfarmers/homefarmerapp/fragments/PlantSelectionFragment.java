package org.therooftopfarmers.homefarmerapp.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import org.therooftopfarmers.homefarmerapp.R;

public class PlantSelectionFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_plant_selection, container, false);

        // Find the buttons by their ID
        Button selectBasilButton = view.findViewById(R.id.button_select_basil);
        Button selectLettuceButton = view.findViewById(R.id.button_select_lettuce);
        Button selectTomatoButton = view.findViewById(R.id.button_select_tomato);

        // Set a click listener for the Basil button
        selectBasilButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Show a toast message
                Toast.makeText(getActivity(), "Basil profile selected!", Toast.LENGTH_SHORT).show();
                // Here you would add the logic to actually change the plant profile
            }
        });

        // Set a click listener for the Lettuce button
        selectLettuceButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Lettuce profile selected!", Toast.LENGTH_SHORT).show();
            }
        });

        // Set a click listener for the Tomato button
        selectTomatoButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getActivity(), "Tomato profile selected!", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }
}