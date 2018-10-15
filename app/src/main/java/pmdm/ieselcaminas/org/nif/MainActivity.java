package pmdm.ieselcaminas.org.nif;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private String name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editTextName = (EditText) findViewById(R.id.editTextName);

        Button buttonNIF = (Button) findViewById(R.id.buttonNIF);
        buttonNIF.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EnterNifActivity.class);
                intent.putExtra("name", editTextName.getText().toString());
                startActivityForResult(intent, 123);
            }
        });

    }
}
