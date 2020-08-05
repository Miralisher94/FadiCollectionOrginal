package ru.setebe.fadicollection;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

public class Main4Activity extends AppCompatActivity {

    public WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);
        web = findViewById(R.id.web);
        web.getSettings().setJavaScriptEnabled(true);
        web.loadUrl("http://setebe.ru/map.php");




    }
}
