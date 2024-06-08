package com.example.hamburgueriaz;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.widget.Toast;


public class MainActivity extends AppCompatActivity {

    //instanciando objetos das views que irão ter alguma interação.
    private TextView mTextView;
    private TextView mTextViewTotalCompra;
    private TextView mTextViewQntCompra;
    private EditText mEditText;
    private Button mButtomSoma;
    private Button mButtomSubtrai;
    private Button mButtomPedido;
    private CheckBox mCheckBox01;
    private CheckBox mCheckBox02;
    private CheckBox mCheckBox03;

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
        mTextViewTotalCompra = findViewById(R.id.textView5);
        mTextViewQntCompra = findViewById(R.id.textView3);
        mEditText = findViewById(R.id.editTextText);
        mButtomSoma = findViewById(R.id.button);
        mButtomSubtrai = findViewById(R.id.button2);
        mButtomPedido = findViewById(R.id.button3);
        mCheckBox01 = findViewById(R.id.checkBox);
        mCheckBox02 = findViewById(R.id.checkBox2);
        mCheckBox03 = findViewById(R.id.checkBox3);

        mButtomSoma.setOnClickListener(new View.OnClickListener() {
            @Override
                    public void onClick(View v){
                //mensagem de teste
                //Toast.makeText(MainActivity.this, "aumentar", Toast.LENGTH_SHORT).show();
                int valor;
                //captura o campo
                mTextViewQntCompra.getText().toString();
                //converte a string em inteiro
                valor =  Integer.parseInt(mTextViewQntCompra.getText().toString());
                valor = valor + 1;
                //converte para string
                String converteValor = String.valueOf(valor);
                //adiciona a info ao campo
                mTextViewQntCompra.setText(converteValor);
            }
        });

        mButtomSubtrai.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(MainActivity.this, "diminuir", Toast.LENGTH_SHORT).show();

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

        mCheckBox01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adicional = 0;
                int precoTotal = 20;
                if (mCheckBox01.isChecked()) {
                    adicional = adicional + 2;
                    Toast.makeText(MainActivity.this, "opcao 1", Toast.LENGTH_SHORT).show();
                }

        mCheckBox02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adicional = 0;
                if (mCheckBox02.isChecked()) {
                    adicional = adicional + 2;
                    Toast.makeText(MainActivity.this, "opcao 2", Toast.LENGTH_SHORT).show();
                }
            }
        });

        mCheckBox03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int adicional = 0;
                if (mCheckBox03.isChecked()) {
                    adicional = adicional + 3;
                    Toast.makeText(MainActivity.this, "opcao 3", Toast.LENGTH_SHORT).show();
                }
            }
        });


                precoTotal = precoTotal + adicional;

                //int converteTotal = Integer.valueOf(precoTotal);
               // mTextViewQntCompra.setText(converteTotal);

            }
        });

    }









}