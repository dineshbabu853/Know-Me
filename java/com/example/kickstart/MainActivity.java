package com.example.kickstart;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private EditText Name;
    private EditText Password;
    private TextView Info;
    private Button login;
private int counter=5;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Name=(EditText)findViewById(R.id.etname);
        Password =(EditText)findViewById((R.id.etpassword));
        Info =(TextView)findViewById(R.id.tvinfo);
        login =(Button)findViewById(R.id.btnlogin);

        Info.setText("no of attemps remaining is 5");

login.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        validate(Name.getText().toString(),Password.getText().toString());
    }
});


    }

    private void validate(String username,String userpassword)
    {
        if((username.equals("dinesh"))&&(userpassword.equals("babu")))
        {
            Intent intent=new Intent(MainActivity.this,SecondActivity.class);
            startActivity(intent);
        }
        else
        {
           counter--;
           Info.setText("No. of attempts remaining: "+String.valueOf(counter));
            if(counter==0)
            login.setEnabled(false);

        }
    }
}
