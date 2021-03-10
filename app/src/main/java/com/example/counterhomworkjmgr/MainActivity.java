package com.example.counterhomworkjmgr;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int mCount = 0;
    private TextView mShowCount;
    private TextView myText;
    private TextView myCounter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //obtenemos la referencia que fue escrito en nuestra primera activity EditText y lo guardamos en mShowCount
        mShowCount = (TextView) findViewById(R.id.text_counter);

        //obtenemos nuestro TextView del editText del mensaje
        myText = findViewById(R.id.editText_main);
        //obtenemos nuestro TextView del editText del contador
        myCounter = findViewById(R.id.text_counter);

        // Restore the saved state.
        // See onSaveInstanceState() for what gets saved.
        if (savedInstanceState != null) {
            boolean isVisible = savedInstanceState.getBoolean("reply_visible");
            boolean isVisibleCounter = savedInstanceState.getBoolean("reply_visibleCounter");
            // Show both the header and the message views. If isVisible is
            // false or missing from the bundle, use the default layout.
            if (isVisible || isVisibleCounter) {
                //haceos visible nuestro editText
                myText.setVisibility(View.VISIBLE);
                //establecemos lo que hay en nuestro editText para colocarlo cuando se gire la pantalla
                myText.setText(savedInstanceState.getString("reply_text"));

                //hacemos visibble nuestro editText del contador
                myCounter.setVisibility(View.VISIBLE);
                //establecemos lo que hay en nuestro editText para colocarlo cuando se gire la pantalla
                myCounter.setText(savedInstanceState.getString("reply_counter"));
            }//fin del if
        }//fin del if
    }//fin del método onCreate

    /**
     * Método para realizar el contador cada vez que se presione el boton
     * @param view
     */
    public void countUp(View view) {
        mCount++;
        if (mShowCount != null)
            mShowCount.setText(Integer.toString(mCount));
    }//fin del método countUp

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        //verificamos la visibilidad de nuestros editText del texto y del counter
        if (myText.getVisibility() == View.VISIBLE || myCounter.getVisibility() == View.VISIBLE) {
            //creamos una key llamada reply_visible con valor true
            outState.putBoolean("reply_visible", true);
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_text
            outState.putString("reply_text",myText.getText().toString());

            //creamos una key llamada reply_visibleCounter con valor true
            outState.putBoolean("reply_visibleCounter", true);
            //obtenemos el valor que se tiene en el EditText del texto en la variable reply_counter
            outState.putString("reply_counter", myCounter.getText().toString());
        }//fin del if
    }//fin del método onSaveInstanceState

    @Override
    public void onStart(){
        super.onStart();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}