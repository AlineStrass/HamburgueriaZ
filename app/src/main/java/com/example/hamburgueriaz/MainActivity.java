package com.example.hamburgueriaz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
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
    //criar um arquivo "meus dados" para salvar o nome do cliente
    public static final String ARQUIVO_MEUS_DADOS = "MeusDados";

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

    int precoTotal;;
    int totalAdicional;
    //String nomeCliente;


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

        mCheckBox01.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox01.isChecked()) {
                    totalAdicional = totalAdicional + 2;
                    //converte para string
                    String converteValor = String.valueOf(totalAdicional);
                    //adiciona a info ao campo
                    mTextViewTotalCompra.setText(converteValor);

                }else if (!mCheckBox01.isChecked()){
                    totalAdicional = totalAdicional - 2;
                    String converteValor = String.valueOf(totalAdicional);
                    mTextViewTotalCompra.setText(converteValor);
                }


        mCheckBox02.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox02.isChecked()) {
                    totalAdicional = totalAdicional + 2;
                    String convertValor2 = String.valueOf(totalAdicional);
                    mTextViewTotalCompra.setText((convertValor2));
                } else if (!mCheckBox02.isChecked()) {
                    totalAdicional = totalAdicional - 2;
                    String converteValor2 = String.valueOf(totalAdicional);
                    mTextViewTotalCompra.setText(converteValor2);
                }
            }
        });

        mCheckBox03.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mCheckBox03.isChecked()) {
                    totalAdicional = totalAdicional + 3;
                    String convertValor3 = String.valueOf(totalAdicional);
                    mTextViewTotalCompra.setText(convertValor3);
                    //Toast.makeText(MainActivity.this, "opcao 3", Toast.LENGTH_SHORT).show();
                } else if (!mCheckBox03.isChecked()) {
                    totalAdicional = totalAdicional - 3;
                    String convertValor3 = String.valueOf(totalAdicional);
                    mTextViewTotalCompra.setText(convertValor3);
                }
            }
        });
            }
        });

        mButtomPedido.setOnClickListener(new View.OnClickListener() {
           // @SuppressLint("ResourceType")
            @Override
            public void onClick(View v) {
                String nomeCliente = mEditText.getText().toString();
                mEditText.setText(nomeCliente);
                if (!nomeCliente.isEmpty()) {
                    getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE)
                            .edit().putString("nomeCliente", nomeCliente).apply();
                }


/*                @SuppressLint("ResourceType")
                SharedPreferences sharedPreferences = getSharedPreferences(getString(R.id.editTextText), Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(getString(R.id.editTextText), mEditText.getText().toString());
                editor.apply();
                sharedPreferences = getSharedPreferences(getString(R.id.editTextText), Context.MODE_PRIVATE);
                String result = sharedPreferences.getString(getString(R.id.editTextText), null);
*/
                //Toast.makeText(MainActivity.this, "result :  "+ result, Toast.LENGTH_SHORT).show();

                Toast.makeText(MainActivity.this, "fazer pedido "+nomeCliente, Toast.LENGTH_SHORT).show();


                Intent intent = new Intent(getBaseContext(), ResumoPedido.class);
                startActivity(intent);

            }

            //salvando o nome no bancode dados local
        /*    public void adicionarNome(String nomeCliente) {
                SharedPreferences sharedPreferences = getSharedPreferences(ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
                String campoNome = sharedPreferences.getString(String.valueOf(nomeCliente), null);
                String nomeDigitado = campoNome;
                sharedPreferences.edit().putString(String.valueOf(nomeCliente), nomeDigitado).apply();
                Toast.makeText(MainActivity.this, "teste "+ campoNome, Toast.LENGTH_SHORT).show();
            }
            */
        });
    }




}
