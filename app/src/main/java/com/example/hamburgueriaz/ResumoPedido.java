package com.example.hamburgueriaz;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.util.Scanner;
import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ResumoPedido extends AppCompatActivity {

    private Button mButtonFinaliar;
    private Button mButtonVoltar;
    private TextView mTextviewNomeCliente;


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
                Toast.makeText(ResumoPedido.this, "finalizar", Toast.LENGTH_SHORT).show();
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

    //trazer os dados do pedido
    //trazer nome do cliente
    private void exibeNome(String nome){
        //acessa o arquivo onde as infos estao salvas
        SharedPreferences sharedPreferences =
                getSharedPreferences(MainActivity.ARQUIVO_MEUS_DADOS, Context.MODE_PRIVATE);
        //cria um objeto para trazer o dado salvo
        String nomeCliente = sharedPreferences.getString(String.valueOf(nome), "nome do cliente");
        //exibe o valor na tela
        mTextviewNomeCliente.setText(nomeCliente);
    }
}