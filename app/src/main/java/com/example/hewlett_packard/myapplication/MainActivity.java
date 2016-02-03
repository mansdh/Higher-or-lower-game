package com.example.hewlett_packard.myapplication;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends Activity {

    private int randomN;
    private int Attempts;
    private EditText InputN;
    private TextView AttemptsTextView;
    private Button btn;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.randomN = (int)(Math.random() * 20);
        InputN= (EditText) findViewById(R.id.InputNumber);
        AttemptsTextView= (TextView)findViewById(R.id.attemptsTextView);
        btn= (Button)findViewById(R.id.button);


    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void showMessage(View view) {


        Attempts++;




        if(Attempts > 0) {
            btn.setText("Guess it!");

            AttemptsTextView.setText("Attempts: " + Attempts);
        }




            if (Integer.parseInt(InputN.getText().toString()) > randomN) {
                Toast.makeText(MainActivity.this, "Lower...", Toast.LENGTH_LONG).show();


            }
            if (Integer.parseInt(InputN.getText().toString()) < randomN) {
                Toast.makeText(MainActivity.this, "Higher...", Toast.LENGTH_LONG).show();


            }
            if (Integer.parseInt(InputN.getText().toString()) == randomN) {

                if (Attempts == 1)
                    Toast.makeText(MainActivity.this, "Congratulations: You won in the " + Attempts + "st attempt.", Toast.LENGTH_LONG).show();
                if (Attempts == 2)
                    Toast.makeText(MainActivity.this, "Congratulations: You won in the " + Attempts + "nd attempt.", Toast.LENGTH_LONG).show();
                if (Attempts == 3)
                    Toast.makeText(MainActivity.this, "Congratulations: You won in the " + Attempts + "rd attempt.", Toast.LENGTH_LONG).show();
                if (Attempts > 3)
                    Toast.makeText(MainActivity.this, "Congratulations: You won in the " + Attempts + "th attempt.", Toast.LENGTH_LONG).show();

                Attempts = 0;
                AttemptsTextView.setText("Click in the button to play again.");
                randomN = (int) (Math.random() * 20);
                btn.setText("Play Again");



            }





    }




}
