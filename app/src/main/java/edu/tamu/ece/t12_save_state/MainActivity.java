package edu.tamu.ece.t12_save_state;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String mystring = "blank";
    TextView textview;
    int myint = 0; //Number of times I press the button

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textview = (TextView) findViewById(R.id.textview);
    }

    public void myclick(View view) {
        EditText edittext = (EditText) findViewById(R.id.edittext);
        mystring = edittext.getText().toString();
        textview.setText(mystring);
        myint++;
        Toast.makeText(this,String.valueOf(myint), 2).show();
    }

    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString("savedString", mystring);
        outState.putInt("points",myint);
    }

    public void onRestoreInstanceState(Bundle inState){
       super.onRestoreInstanceState(inState);
       mystring=inState.getString("savedString", "default");
       textview.setText(mystring);
       myint=inState.getInt("points",25);
       Toast.makeText(this,"Restored", 2).show();
    }
}
