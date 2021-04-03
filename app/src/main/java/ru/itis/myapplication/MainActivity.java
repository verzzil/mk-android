package ru.itis.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import ru.itis.myapplication.models.User;

public class MainActivity extends AppCompatActivity {

    private List<User> users = new ArrayList<>();

    private User albert = new User("Albert", "Khannanov", "albert@email.ru", "qwertY1", R.drawable.albert);
    private User arsik = new User("Marat", "Мирзаевич", "arsik@email.ru", "asdfgH1", R.drawable.albert);

    private Button signIn;
    private EditText email;
    private EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signIn = findViewById(R.id.sign_in);
        email = findViewById(R.id.et_email);
        password = findViewById(R.id.et_password);

        users.add(albert);
        users.add(arsik);

        signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User currentUser = hasUser(email.getText().toString(), password.getText().toString());

                if (currentUser != null) {
                    Intent openAccount = new Intent(MainActivity.this, ProfileActivity.class);

                    openAccount.putExtra("fullName", currentUser.getFullName());
                    openAccount.putExtra("email", currentUser.getEmail());
                    openAccount.putExtra("photo", currentUser.getPhoto());

                    startActivity(openAccount);
                } else {
                    Toast.makeText(MainActivity.this, "Такого пользователя нет", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }

    private User hasUser(String email, String password) {
        for(User user : users) {
            if (email.equals(user.getEmail()) && password.equals(user.getPassword())) {
                return user;
            }
        }
        return null;
    }

}