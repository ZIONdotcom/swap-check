package com.example.swapperchecket;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    EditText text1;
    EditText text2;
    Button check;
    Button swap;

    TextView message;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        check = findViewById(R.id.check);
        swap = findViewById(R.id.swap);
        message = findViewById(R.id.message);

        swap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1Value = text1.getText().toString();
                text1.setText(text2.getText().toString());
                text2.setText(text1Value);
            }
        });

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text1ulit= text1.getText().toString();
                if( text1ulit.equals(text2.getText().toString())){
                    message.setText("Same");
                }else{
                    message.setText("Not the same");
                }
            }
        });
    }
}