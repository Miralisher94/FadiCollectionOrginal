package ru.setebe.fadicollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Main5Activity extends AppCompatActivity {

    public Button ok;
    public EditText parol;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main5);

    ok = findViewById(R.id.ok);
    parol = findViewById(R.id.parol);

    ok.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (parol.getText().toString().equals("parol.uz.fadi.uz")){

                Intent intent = new Intent(getApplicationContext(), Main2Activity.class);
                startActivity(intent);

            }
            else{
                Toast.makeText(Main5Activity.this, "parol xato", Toast.LENGTH_SHORT).show();

            }


        }
    });

    }
}
