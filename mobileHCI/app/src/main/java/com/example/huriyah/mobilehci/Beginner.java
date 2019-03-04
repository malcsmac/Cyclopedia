package com.example.huriyah.mobilehci;


import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.util.AndroidRuntimeException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Beginner extends Fragment {
    private FloatingActionButton mapButton;


    public Beginner() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_beginner, container, false);
        String[] menuItems = {"\nBEGINNER CYCLING CLUB 1 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ", "\nBEGINNER CYCLING CLUB 2 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ",
                "\nBEGINNER CYCLING CLUB 3 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ", "\nBEGINNER CYCLING CLUB 4 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ",
                "\nBEGINNER CYCLING CLUB 5 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ",};


        ListView listView = (ListView) view.findViewById(R.id.main_list);
        FloatingActionButton mapButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });


        /*ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (getActivity(), android.R.layout.simple_list_item_1, menuItems){
            @Override
            public View getView(int position, View convertView, ViewGroup parent){
                // Get the Item from ListView
                View view = super.getView(position, convertView, parent);

                // Initialize a TextView for ListView each Item
                TextView tv = (TextView) view.findViewById(android.R.id.text1);

                // Set the text color of TextView (ListView Item)
                tv.setTextColor(Color.BLACK);

                // Generate ListView Item using TextView
                return view;
            }
        };*/

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, menuItems


        );

        listView.setAdapter(listViewAdapter);
        return view;

    }
}