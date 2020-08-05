package ru.setebe.fadicollection;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Main3Activity extends AppCompatActivity {
    public TextView soz;
    public Button telegram;
    public Button te;
    public WebView Websayt;
    public EditText ismga;
    public EditText telga;
    WebView web;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        telegram = findViewById(R.id.telegram);
        Websayt= findViewById(R.id.Websayt);
        soz = findViewById(R.id.soz);
        ismga = findViewById(R.id.ismga);
        telga = findViewById(R.id.telga);
        te = findViewById(R.id.te);






        Intent i = getIntent();

        String s1 = i.getStringExtra("ism");
        soz.setText(s1);

        telegram.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (soz.getText().toString().equals("Maxsulot turi: ")||telga.getText().toString().equals("")||ismga.getText().toString().equals("")){

                    Toast.makeText(Main3Activity.this, "Buyurtma tanlanmagan yoki Malumot to'ldirilmagan", Toast.LENGTH_SHORT).show();

                }


                else{
                Websayt.loadUrl("https://api.telegram.org/bot935819857:AAEmcZWFHgM6BX-u6eoHLl9BM2Tt0xW6h_0/sendMessage?chat_id=-326813780&text="
                        + soz.getText()+"\n"+" , "+ismga.getText()+" , "+"\n" + telga.getText());


                ismga.setText("+998");
                telga.getText().clear();
                soz.setText("Maxsulot turi: ");
                te.setVisibility(View.VISIBLE);



                    Toast.makeText(Main3Activity.this, "Buyurtmangiz qabul qilindi \n Location jo'nating  ", Toast.LENGTH_SHORT).show();


                }

            }
        });


        te.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                //if (soz.getText().toString().equals("Maxsulot turi: ")||telga.getText().toString().equals("")||ismga.getText().toString().equals("")){

                //    Toast.makeText(Main3Activity.this, "Avval buyurtma berishingiz kerak", Toast.LENGTH_SHORT).show();

               // }

               // else {

                    Intent intent = new Intent(getApplicationContext(), Main4Activity.class);
                    startActivity(intent);
               // }


            }
        });


    }
}
