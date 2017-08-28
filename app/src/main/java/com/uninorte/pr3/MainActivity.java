package com.uninorte.pr3;

import android.graphics.Color;
import android.os.Bundle;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.style.LineBackgroundSpan;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import java.util.ArrayList;

import static android.R.attr.id;
import static com.uninorte.pr3.R.id.bottom;
import static com.uninorte.pr3.R.id.linear_layout_tags;

public class MainActivity extends AppCompatActivity {
    LinearLayout contenedor1;
    public int i=1 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                contenedor1 = (LinearLayout) findViewById(R.id.contenedor1);
                ArrayList<chek> lista = new ArrayList<chek>();
                lista.add(new chek(i,"Campo"+i));


                for(chek c:lista) {
                    CheckBox cb = new CheckBox(getApplicationContext());
                    cb.setText(c.nombre);
                    cb.setId(c.cod);
                    cb.setTextColor(Color.BLACK);
                    contenedor1.addView(cb);
                    cb.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                            Toast.makeText(getApplicationContext(),"Checkbox:"+ buttonView.getId(),Toast.LENGTH_SHORT).show();
                        }
                    });
                    i = i + 1;
                }


            }
        });
    }

    class chek{
        public int cod;
        public String nombre;
        public chek(int cod, String nombre){
            this.cod =cod;
            this.nombre = nombre;
        }
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
}
