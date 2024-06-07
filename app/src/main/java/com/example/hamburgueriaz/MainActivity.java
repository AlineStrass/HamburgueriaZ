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


public class MainActivity extends AppCompatActivity {

    //instanciando objetos das views que irão ter alguma interação.
    private TextView mTextView;
    private TextView mTextViewQntCompra;
    private EditText mEditText;
    private Button mButtomSoma;
    private Button mButtomSubtrai;
    private Button mButtom;

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
        //mButtomSoma = findViewById(R.id.button);
        mButtomSubtrai = findViewById(R.id.button2);
        mButtom = findViewById(R.id.button3);



        Button buttonSoma = (Button) findViewById(R.id.button);
        buttonSoma.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                System.out.println("clicou");
            }
        });
    }


}