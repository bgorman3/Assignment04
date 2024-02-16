package edu.uncc.assignment04;

import edu.uncc.assignment04.fragments.IdentificationFragment;
import androidx.appcompat.app.AppCompatActivity;
import edu.uncc.assignment04.fragments.MainFragment;


import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity implements IdentificationFragment.OnDataPass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            MainFragment mainFragment = MainFragment.newInstance("param1", "param2");
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.fragment_container, mainFragment).commit();
        }
    }

    @Override
    public void onDataPass(String name, String email, String role) {
        // Create a Response object and set the values
        Response response = new Response();
        response.setName(name);
        response.setEmail(email);
        response.setRole(role);

        // Log the values
        Log.d("Response", "Name: " + response.getName());
        Log.d("Response", "Email: " + response.getEmail());
        Log.d("Response", "Role: " + response.getRole());
    }

}
