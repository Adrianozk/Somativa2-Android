package com.example.aluno.somativa2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Sorteio extends AppCompatActivity {

    //Declaração de variáveis
    public static int pontuacao;
    private TextView txtParabens, txtPontuacao, txtSort1, txtSort2, txtNum;
    private int sorteado1, sorteado2, nDigitado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sorteio);

        pontuacao += 50;
        //Vinculando os componentes do layout com as variáveis referenciadas
        txtParabens = (TextView) findViewById(R.id.txtParabens);
        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);
        txtSort1 = (TextView) findViewById(R.id.txtSort1);
        txtSort2 = (TextView) findViewById(R.id.txtSort2);
        txtNum = (TextView) findViewById(R.id.txtNum);

        //Pega os valores da outra tela através de Intent
        sorteado1 = getIntent().getIntExtra("sort1",0);
        sorteado2 = getIntent().getIntExtra("sort2",0);
        nDigitado = getIntent().getIntExtra("nDigitado",0);

        txtPontuacao.append(""+pontuacao);
        txtSort1.append(""+sorteado1);
        txtSort2.append(""+sorteado2);
        txtNum.append(""+nDigitado);


    }
}
