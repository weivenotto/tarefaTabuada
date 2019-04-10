package br.org.catolicasc.tarefatabuada;

import android.annotation.SuppressLint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private EditText number;
    private ListView texto;
    private Button button;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        number = findViewById(R.id.number);
        texto = findViewById(R.id.texto);
        Button bt = findViewById(R.id.button);

        bt.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                try{
                    int numero = Integer.valueOf(number.getText().toString());

                    List<Integer>tabuada = new ArrayList<>();
                    for(int i = 1; i<= 10; i++){
                        tabuada.add(i *numero);

                    }

                    ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<>(
                            MainActivity.this,R.layout.list_item, tabuada
                    );
                    texto.setAdapter(arrayAdapter);
                }catch (NumberFormatException e){
                    Toast.makeText(MainActivity.this,
                            "Digite um numero valido",Toast.LENGTH_LONG).show();
                }




            }
        });



        }
    }
