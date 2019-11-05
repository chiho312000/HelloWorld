package hk.polyu.eie.eie3109.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        TextView welcomeTextView = findViewById(R.id.welcomeTextView);

        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.PREFERENCE_NAME, MainActivity.MODE);
        String name = sharedPreferences.getString("Name", "Default Name");
        if (welcomeTextView != null) welcomeTextView.setText(name);
        Button btnBack = findViewById(R.id.btnBack);
        if (btnBack != null)
        {
            btnBack.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    finish();
                }
            });
        }
    }
}
