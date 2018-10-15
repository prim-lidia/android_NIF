package pmdm.ieselcaminas.org.nif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EnterNifActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter_nif);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        String name = extras.getString("name");
        if(name!= null) {
            TextView textViewName = findViewById(R.id.greetingLabel);
            textViewName.setText(name);
        }
        final EditText ediTextNif = (EditText) findViewById(R.id.editTextNif);

        Button buttonOK = findViewById(R.id.buttonOk);
        buttonOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Dni dni = new Dni(ediTextNif.getText().toString());
                } catch (NIFException e) {
                    e.printStackTrace();
                }
                Intent intent =  new Intent();
                intent.putExtra("result", ediTextNif.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });

    }

}
