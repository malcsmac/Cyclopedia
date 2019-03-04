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



        String [] menuItems = {"\nINTERMEDIATE CYCLING CLUB 1 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ", "\nINTERMEDIATE CYCLING CLUB 2 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ",
                "\nINTERMEDIATE CYCLING CLUB 3 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ","\nINTERMEDIATE CYCLING CLUB 4 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: ",
                "\nINTERMEDIATE CYCLING CLUB 5 \n\nDate: 21/03/2019 \nTime: 15:00 \nVenue: " ,};

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, menuItems


        );

        listView.setAdapter(listViewAdapter);
        return view;
    }

}