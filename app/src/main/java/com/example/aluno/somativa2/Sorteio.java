package com.example.aluno.somativa2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sorteio extends AppCompatActivity {

    //Declaração de variáveis
    public static int pontuacao;
    private TextView txtParabens, txtSort1, txtSort2, txtNum;
    private int sorteado1, sorteado2, nDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        //Vinculando os componentes do layout com as variáveis referenciadas
        txtParabens = (TextView) findViewById(R.id.txtParabens);
        txtSort1 = (TextView) findViewById(R.id.txtSort1);
        txtSort2 = (TextView) findViewById(R.id.txtSort2);
        txtNum = (TextView) findViewById(R.id.txtNum);

        //Pega os valores da outra tela através de Intent
        sorteado1 = getIntent().getIntExtra("sort1", 0);
        sorteado2 = getIntent().getIntExtra("sort2", 1);
        nDigitado = getIntent().getIntExtra("nDigitado", 0);

        txtSort1.append("" + sorteado1);
        txtSort2.append("" + sorteado2);
        txtNum.append("" + nDigitado);

    }

    protected void onPause()
    {
        super.onPause();
        //Utilização do SharedPreferences para gravar a pontuação no arquivo de configuração
        SharedPreferences.Editor gravar = getSharedPreferences("nome_config", MODE_PRIVATE).edit();

        gravar.putInt("pontuacao", pontuacao);

        gravar.commit();
    }

    protected void onStart() {
        super.onStart();
        pontuacao = 50;
        //Utilização do SharedPreferences para ler a pontuação no arquivo de configuração
        SharedPreferences leitor = getSharedPreferences("nome_config", MODE_PRIVATE);

        int p = leitor.getInt("pontuacao", 0);
        pontuacao += p;
    }
}
