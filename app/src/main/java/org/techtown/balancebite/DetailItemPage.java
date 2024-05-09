package org.techtown.balancebite;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class DetailItemPage extends AppCompatActivity {
    FloatingActionButton floatingActionButton;
    TextView title;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_item_page);

        title = findViewById(R.id.detailPageTitle);
        title.setText(((MainActivity)MainActivity.contextMain).selectedItemTitle);

        floatingActionButton = findViewById(R.id.mainActBackButton);
        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}