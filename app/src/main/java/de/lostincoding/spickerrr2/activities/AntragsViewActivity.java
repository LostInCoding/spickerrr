package de.lostincoding.spickerrr2.activities;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import de.lostincoding.spickerrr2.R;
import de.lostincoding.spickerrr2.model.Antrag;

public class AntragsViewActivity extends AppCompatActivity {
    private Antrag antrag;
private WebView description;
    private WebView motivation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_antrags_view);

        antrag = getIntent().getParcelableExtra("antrag");
        initalizeUI();
    }


    private void initalizeUI() {
        description = (WebView) findViewById(R.id.description);
        motivation = (WebView) findViewById(R.id.motivation);
        setTitle(antrag.getId() + " " + antrag.getTitle());

        description.getSettings();
        description.setBackgroundColor(Color.TRANSPARENT);


        motivation.getSettings();
        motivation.setBackgroundColor(Color.TRANSPARENT);

        description. loadData(antrag.getDescription(), "text/html; charset=UTF-8", null);
        motivation. loadData(antrag.getMotivation(), "text/html; charset=UTF-8", null);


    }
}
