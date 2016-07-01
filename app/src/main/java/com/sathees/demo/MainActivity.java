package com.sathees.demo;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private EditText inputName, inputPassword;
    private Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DatabaseHandler db = new DatabaseHandler(this);
        SQLiteDatabase sq  = new DatabaseHandler(this).getWritableDatabase();
        db.onUpgrade(sq,1,1);
        Log.d("Insert: ", "Inserting ..");
        db.addUser(new User("Sathees", "8000"));
        db.addUser(new User("Kumar", "7850"));
        db.addUser(new User("Tommy", "12500"));
        db.addUser(new User("Karthik", "6700"));

        Log.d("Reading: ", "Reading all users..");
        List<User> users = db.getAllUsers();
        for (User u : users) {
            String log = "Id: " + u.getID() + " ,Name: " + u.getName() + " ,Salary: " + u.getSalary();
            Log.d("Name: ", log);
        }
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                inputName = (EditText) findViewById(R.id.input_name);
                String userName = inputName.getText().toString();
                if (TextUtils.isEmpty(userName)) {
                    Toast.makeText(MainActivity.this, "Enter a username", Toast.LENGTH_SHORT).show();
                    return;
                }
                inputPassword = (EditText) findViewById(R.id.input_password);
                String pass = inputPassword.getText().toString();
                if (TextUtils.isEmpty(pass)) {
                    Toast.makeText(MainActivity.this, "Enter your password", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent i = new Intent(MainActivity.this, HomeActivity.class);
                i.putExtra("username", userName);

                startActivity(i);
            }
        });
    }
    public void onBackPressed(){
        Intent a = new Intent(Intent.ACTION_MAIN);
        a.addCategory(Intent.CATEGORY_HOME);
        a.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(a);
    }
}
