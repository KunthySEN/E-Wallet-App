package com.example.welcome;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class ThankYouActivity extends AppCompatActivity {
    TextView text;
    Button btn_let_go;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().hide();//use to hides the action bar
        setContentView(R.layout.activity_thank_you);
        text = (TextView)findViewById(R.id.text);
        btn_let_go = findViewById(R.id.btn_let_go);

        Intent intent = getIntent();
        String email = intent.getStringExtra("email");
        String password = intent.getStringExtra("password");
        text.setText("You email is : "+email+"\n"+"You password is :"+password);

        btn_let_go.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent btn_let_go_intent = new Intent(getBaseContext(), ShowActivity.class);
                startActivity(btn_let_go_intent);
            }
        });

    }
}