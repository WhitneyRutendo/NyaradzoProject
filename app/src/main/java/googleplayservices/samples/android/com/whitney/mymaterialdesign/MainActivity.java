package googleplayservices.samples.android.com.whitney.mymaterialdesign;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    private ImageView foteImageView;
    private EditText nameEditText;
    private EditText surnameEditText;
    private TextView genderTextView;
    private Spinner genderSpinner;
    private TextView tshirtsizeTextView;
    private Spinner tshirtsizeSpinner;
    private Button registerButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        foteImageView = (ImageView) findViewById(R.id.foteImageView);
        nameEditText = (EditText) findViewById(R.id.nameEditText);
        surnameEditText = (EditText) findViewById(R.id.surnameEditText);
        genderTextView = (TextView) findViewById(R.id.genderTextView);

        genderSpinner = (Spinner) findViewById(R.id.genderSpinner);
        genderSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this, R.array.gender_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        genderSpinner.setAdapter(adapter);

        tshirtsizeTextView = (TextView) findViewById(R.id.tshirtsizeTextView);
        tshirtsizeSpinner = (Spinner) findViewById(R.id.tshirtsizeSpinner);
        tshirtsizeSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);
        adapter = ArrayAdapter.createFromResource(this, R.array.tshirtsize_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        tshirtsizeSpinner.setAdapter(adapter);

        registerButton = (Button) findViewById(R.id.registerButton);
        registerButton.setOnClickListener(new View.OnClickListener(){

                                              @Override
                                              public void onClick(View v) {
                                                  Register();
                                              }

                                              private void Register() {
                                                  Intent intent = new Intent (MainActivity.this, RegistrationForm.class);
                                                  startActivity(intent);
                                              }
                                          }

        );

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
        Toast.makeText(parent.getContext(), text, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
