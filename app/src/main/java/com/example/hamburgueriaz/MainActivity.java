package com.example.hamburgueriaz;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.widget.RadioGroup;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //instanciando objetos das views que irão ter alguma interação.
    private TextView mTextView;
    private TextView mTextViewQntCompra;
    private EditText mEditText;
    private Button mButtomSoma;
    private Button mButtomSubtrai;
    private Button mButtomPedido;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        //Relacionando com o id que foi cadastrado no arquivo xml
        mTextView = findViewById(R.id.textView2);
        mTextView = findViewById(R.id.textView);
        mTextView = findViewById(R.id.textView4);
        mTextView = findViewById(R.id.textView5);
        mTextViewQntCompra = findViewById(R.id.textView3);
        mEditText = findViewById(R.id.editTextText);
        mButtomSoma = findViewById(R.id.button);
        mButtomSubtrai = findViewById(R.id.button2);
        mButtomPedido = findViewById(R.id.button3);



        mButtomSoma.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                //mensagem de teste
                //Toast.makeText(MainActivity.this, "aumentar", Toast.LENGTH_SHORT).show();
                int valor;
                mTextViewQntCompra.getText().toString();
                //converte a string em inteiro
                valor =  Integer.parseInt(mTextViewQntCompra.getText().toString());
                valor = valor + 1;

                String converteValor = String.valueOf(valor);
                mTextViewQntCompra.setText(converteValor);
            }
        });

        mButtomSubtrai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                Toast.makeText(MainActivity.this, "diminuir", Toast.LENGTH_SHORT).show();

                int valor;
                mTextViewQntCompra.getText().toString();
                valor =  Integer.parseInt(mTextViewQntCompra.getText().toString());

                if (valor > 0){
                    valor = valor - 1;
                }

                String converteValor = String.valueOf(valor);
                mTextViewQntCompra.setText(converteValor);
            }
        });

        mButtomPedido.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "comprar", Toast.LENGTH_SHORT).show();
            }

        });






    }


}