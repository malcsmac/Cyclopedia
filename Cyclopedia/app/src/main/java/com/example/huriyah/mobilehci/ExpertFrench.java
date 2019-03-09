package com.example.huriyah.mobilehci;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class ExpertFrench extends Fragment {


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view  = inflater.inflate(R.layout.fragment_expert_french, container, false);
        ListView listView = (ListView) view.findViewById(R.id.main_list);
        FloatingActionButton mapButton = (FloatingActionButton) view.findViewById(R.id.floatingActionButton);
        mapButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), MapsActivity.class);
                startActivity(intent);
            }
        });

        String [] menuItems = {"\nBonnybridge Cyclists \n\nDate: 21/03/2019 \nTemps: 15:00 \nLieu: Bonnybridge Gardens", "\nUniversity Cyclists \n\nDate: 21/03/2019 \nTemps: 11:00 \nLieu: Strathclyde Country Park",
                "\nForest Cyclists \n\nDate: 21/03/2019 \nTemps: 17:00 \nLieu: Loudoun Hill  ","\nLennoxtown Cyclists \n\nDate: 21/03/2019 \nTemps: 20:00 \nLieu: Station Road",
                "\nLoch Lomond Cyclists \n\nDate: 21/03/2019 \nTemps: 9:00 \nLieu: Loch Lomond Arms" ,};

        ArrayAdapter<String> listViewAdapter = new ArrayAdapter<String>(
                getActivity(), android.R.layout.simple_list_item_1, menuItems


        );

        listView.setAdapter(listViewAdapter);
        return view;
    }


}
