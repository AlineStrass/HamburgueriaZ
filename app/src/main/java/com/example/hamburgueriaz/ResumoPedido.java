package com.example.hamburgueriaz;

import static java.net.Proxy.Type.HTTP;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Scanner;
import java.util.prefs.Preferences;
import java.net.Proxy;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ShareCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedido extends AppCompatActivity {

    private Button mButtonFinaliar;
    private Button mButtonVoltar;
    private TextView mTextviewNomeCliente;
    String nomeCliente;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_resumo_pedido);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        mButtonFinaliar = findViewById(R.id.buttonFinalizar);
        mButtonVoltar = findViewById(R.id.buttonVoltar);
        mTextviewNomeCliente = findViewById(R.id.textView13);


        //função para chamar o e-mail
        mButtonFinaliar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
                emailIntent.setType("text/plain");
                emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[] {"pedidos@hamburgueriaz.com"});
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Confirmação de pedido - Hamburgueria Z");
                emailIntent.putExtra(Intent.EXTRA_TEXT, "Seguem as informações doseu pedido: ");
                emailIntent.putExtra(Intent.EXTRA_STREAM, Uri.parse("content://path/to/email/attachment"));

                startActivity(emailIntent);
            }
        });












        //voltar para a view principal
        mButtonVoltar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(ResumoPedido.this, "voltar", Toast.LENGTH_SHORT).show();
                Intent internt = new Intent(getBaseContext(), MainActivity.class);
                startActivity(internt);
            }
        });
    }



    // -------------------------------------------------------------------------------------------
    //TENTATIVAS DE TRAZER O NOME DO CLIENTE PARA APARCER NA VIEW DO RESUMO DO PEDIDO - NADA FUNCIONOU :(

/*    @SuppressLint("ResourceType")
    private void exibeNome(String nome){
        @SuppressLint("ResourceType")
        SharedPreferences sharedPreferences = getSharedPreferences(getString(R.id.editTextText), Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(getString(R.id.editTextText), mTextviewNomeCliente.getText().toString());
        editor.apply();

        sharedPreferences = getSharedPreferences(getString(R.id.editTextText), Context.MODE_PRIVATE);
        String result = sharedPreferences.getString(getString(R.id.editTextText), null);

        Toast.makeText(ResumoPedido.this, "result :  "+ result, Toast.LENGTH_SHORT).show();
    }
*/


    //trazer os dados do pedido
    //trazer nome do cliente
 /*  private void exibeNome(String nome){
        //acessa o arquivo onde as infos estao salvas
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);

        //cria um objeto para trazer o dado salvo
        String nomeCliente = sharedPreferences.getString(nome, "nome do cliente");
        //exibe o valor na tela
        mTextviewNomeCliente.setText(nomeCliente);
        //return nomeCliente;
    }
    */

    private void alteraNome(String nomeCliente){
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        String nomeAtual = sharedPreferences.getString(String.valueOf(nomeCliente), null);
        String novoNome = nomeAtual;
        sharedPreferences.edit().putString(String.valueOf(nomeCliente), novoNome).apply();
    }

    private void exibeNome(String nomeCliente){
        SharedPreferences sharedPreferences = getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        String nome = sharedPreferences.getString(String.valueOf(nomeCliente), null);
        mTextviewNomeCliente.setText(nome);
    }


}