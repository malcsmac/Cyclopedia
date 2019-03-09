package com.example.huriyah.mobilehci;


import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class Intermediate extends Fragment {


    public Intermediate() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_intermediate, container, false);

        ListView listView = (ListView) view.findViewById(R.id.main_list);
        FloatingActionButton mapButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });



        String [] menuItems = {"\nLanark Cyclists \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: Woodside Road ", "\nLoch Cyclists \n\nDate: 21/03/2019 \nTime: 10:00 \nVenue: Seven Lochs Wetland Park ",
                "\nClyde Cyclists \n\nDate: 21/03/2019 \nTime: 16:00 \nVenue: Clydebank Station","\nCountry Park Cyclists \n\nDate: 21/03/2019 \nTime: 19:00 \nVenue: Mugdock Country Park",
                "\nWoodland Cyclists \n\nDate: 21/03/2019 \nTime: 22:00 \nVenue: Woodland Experiences " ,};

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, menuItems


        );

        listView.setAdapter(listViewAdapter);
        return view;
    }

}