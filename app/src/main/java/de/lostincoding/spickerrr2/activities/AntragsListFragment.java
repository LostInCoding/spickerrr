package de.lostincoding.spickerrr2.activities;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

import de.lostincoding.spickerrr2.R;
import de.lostincoding.spickerrr2.model.Antrag;


public class AntragsListFragment extends Fragment {
    private ListView listView;
    ArrayList<Antrag> list;

    public AntragsListFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_antragslist, container, false);
        listView = (ListView) rootView.findViewById(R.id.listView);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                openNextActivity(position);
            }
        });
        // Inflate the layout for this fragment
        fillListView();
        return rootView;
    }

    private void openNextActivity(int position) {
        Intent intent = new Intent(getContext(), AntragsViewActivity.class);
        intent.putExtra("antrag", list.get(position));
        startActivity(intent);
    }

    private void fillListView() {
        list = null;
        Bundle bundle = getArguments();
        if (bundle != null) {
            list = bundle.getParcelableArrayList("antragslist");
        } else {
            list = new ArrayList<>();
        }

        //create a StringArrayList with the stuff which should be displayed
        ArrayList<String> displayedList = new ArrayList<>();
        for (Antrag antrag : list) {
            displayedList.add(antrag.getId() + " " + antrag.getTitle());
        }
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                getContext().getApplicationContext(),
                R.layout.antragslist_item_layout,
                displayedList);

        listView.setAdapter(arrayAdapter);
    }

}