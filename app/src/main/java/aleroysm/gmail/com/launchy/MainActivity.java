package aleroysm.gmail.com.launchy;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Attempt to launch an activity within our app
        Button secondActivityButton = (Button) findViewById(R.id.secondActivityButton);
        secondActivityButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // create intent
                Intent firstIntent = new Intent(getApplicationContext(), SecondActivity.class);
                // show how to pass information to the other activity
                firstIntent.putExtra("aleroysm.quicklaunch.SOMETHING", "HELLO WORLD!");
                // run intent
                startActivity(firstIntent);

            }
        });


        // Attempt to launch an activity outside our app
        Button googleButton = (Button) findViewById(R.id.googleButton);
        googleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // fields
                String google = "http://www.google.com";
                Uri webaddress = Uri.parse (google);

                // create intent
                Intent goToGoogle = new Intent (Intent.ACTION_VIEW, webaddress);

                // show what happens if they cannot access Google.com
                if (goToGoogle.resolveActivity(getPackageManager()) != null) {
                    startActivity(goToGoogle);
                }


            }
        });

    }
}
