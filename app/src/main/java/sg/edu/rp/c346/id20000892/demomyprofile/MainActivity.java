package sg.edu.rp.c346.id20000892.demomyprofile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    EditText etName;
    EditText etGPA;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etGPA = findViewById(R.id.editTextGPA);


    }

    @Override
    protected void onPause() {
        super.onPause();

        String GPA = etGPA.getText().toString();
        float fGPA = 0f;
        //so it does not crash
        if (GPA.length() > 0){
            fGPA = Float.parseFloat(GPA);
        }

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        SharedPreferences.Editor prefseditor = prefs.edit();
        prefseditor.putString("name", etName.getText().toString());
        prefseditor.putFloat("gpa", fGPA);
        prefseditor.commit();
    }

    @Override
    protected void onResume() {
        super.onResume();

        SharedPreferences prefs = getPreferences(MODE_PRIVATE);
        String name = prefs.getString("name", "");
        float gpa = prefs.getFloat("gpa", 0f);

        etName.setText(name);
        etGPA.setText(gpa + "");
    }
}