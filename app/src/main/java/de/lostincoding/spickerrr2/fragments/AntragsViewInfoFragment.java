package de.lostincoding.spickerrr2.fragments;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;

import de.lostincoding.spickerrr2.R;
import de.lostincoding.spickerrr2.activities.AntragsViewActivity;
import de.lostincoding.spickerrr2.model.Antrag;
import de.lostincoding.spickerrr2.model.DataHolder;

/**
 * A simple {@link Fragment} subclass.
 */
public class AntragsViewInfoFragment extends Fragment implements AntragsViewActivity.InfoFragmentUpdateListener {
    private Antrag antrag;
    private WebView author;
    private WebView topic;


    public AntragsViewInfoFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //get Antrag from Arguments
        antrag = null;
        int position = -1;
        Bundle bundle = getArguments();
        if (bundle != null) {
            position = bundle.getInt("position");
        }
        antrag = DataHolder.getInstance().getAntragslist().get(position);

        //fill View
        View rootView = inflater.inflate(R.layout.fragment_antrags_view_info, container, false);
        author = (WebView) rootView.findViewById(R.id.author);
        topic = (WebView) rootView.findViewById(R.id.topic);


        author.getSettings();
        author.setBackgroundColor(Color.TRANSPARENT);

        topic.getSettings();
        topic.setBackgroundColor(Color.TRANSPARENT);




        author.loadData(antrag.getOwner(), "text/html; charset=UTF-8", "UTF-8");
        topic.loadData(antrag.getTopic(), "text/html; charset=UTF-8", "UTF-8");


        return rootView;
    }




    @Override
    public void onFragmentUpdate() {

    }
}
