package com.example.demoexplicitintent;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    TextView tvBatman, tvSuperman;

    int requestCodeForSupermanStats = 1;
    int requestCodeForBatmanStats = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvBatman = findViewById(R.id.textViewBatman);
        tvSuperman = findViewById(R.id.textViewSuperman);

        tvSuperman.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View arg0) {
                Hero superman = new Hero("Superman", 100, 60);
                Intent intent = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                intent.putExtra("hero", superman);
                startActivityForResult(intent, requestCodeForSupermanStats);
            }});


        tvBatman.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Hero batman = new Hero("Batman", 60, 90);
                Intent intent = new Intent(MainActivity.this,
                        HeroStatsActivity.class);
                intent.putExtra("hero", batman);
                startActivityForResult(intent, requestCodeForBatmanStats);



            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(resultCode == RESULT_OK){
            if(data != null){
                String like = data.getStringExtra("like");
                String statement = "";

                if(requestCode == requestCodeForSupermanStats){
                    statement = "You " + like + " Superman";
                }else if(requestCode == requestCodeForBatmanStats){
                    statement = "You " + like + " Batman";
                }
                Toast.makeText(MainActivity.this, statement, Toast.LENGTH_LONG).show();
            }
        }
    }
}
