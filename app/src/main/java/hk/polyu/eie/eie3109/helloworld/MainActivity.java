package hk.polyu.eie.eie3109.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity
{
    public static int MODE = Context.MODE_PRIVATE;
    public static final String PREFERENCE_NAME = "MyProfile";
    private SharedPreferences sharedPreferences;
    private EditText ETName;
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btnOk = findViewById(R.id.btnOK);
        ETName = findViewById(R.id.nameTextField);
        titleTextView = findViewById(R.id.titleTextView);
        sharedPreferences = getSharedPreferences(PREFERENCE_NAME, MODE);

        if (btnOk != null)
        {
            btnOk.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View v)
                {
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("Name", ETName.getText().toString());
                    editor.apply();
                    startActivity(new Intent(MainActivity.this, Main2Activity.class));
                }
            });
        }

        String name = sharedPreferences.getString("Name", "Default Name");
        if (ETName != null)
        {
            ETName.setText(name);
        }

        if (titleTextView != null)
        {
            titleTextView.setText("Hi " + name);
        }
    }

    @Override
    protected void onResume()
    {
        super.onResume();
        String name = ETName.getText().toString();
        if (titleTextView != null)
        {
            titleTextView.setText("Hi " + name);
        }
    }
}
