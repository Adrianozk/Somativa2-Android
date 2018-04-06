package com.example.aluno.somativa2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declaração de variáveis
    private NumberPicker npNum;
    private Button btnSorteio;
    private Random aleatorio = new Random();
    private TextView txtPontuacao;
    private int novoNum, sorteado1, sorteado2;
    private boolean repetiu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculando os componentes do layout com as variáveis referenciadas
        npNum = (NumberPicker) findViewById(R.id.npNum);
        btnSorteio = (Button) findViewById(R.id.btnSorteio);

        txtPontuacao = (TextView) findViewById(R.id.txtPontuacao);

        //Configurando o valor mínimo e máximo do NumberPiker
        npNum.setMaxValue(10);
        npNum.setMinValue(1);

        //Ação do botão Sorteio
        btnSorteio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //Atribui o primeiro número aleatório
                sorteado1 = aleatorio.nextInt(10);
                sorteado1++;
                //Atribui o segundo número aleatório
                sorteado2 = aleatorio.nextInt(10);
                sorteado2++;
                //Enquanto o primeiro número é igual ao segundo gera um novo segundo número
                while (sorteado1 == sorteado2) {
                    sorteado2 = aleatorio.nextInt(10);
                    sorteado2++;
                }
                if (npNum.getValue() == sorteado1 || npNum.getValue() == sorteado2) {

                    //Declaração do Intent para a tela Sorteio
                    Intent it = new Intent(MainActivity.this, Sorteio.class);

                    //Aponta quais valores serão passados pelo Intent
                    it.putExtra("nDigitado", npNum.getValue());
                    it.putExtra("sort1", sorteado1);
                    it.putExtra("sort2", sorteado2);
                    startActivity(it);
                } else
                    //Mensagem para quando não acertar o número aleatório
                    Toast.makeText(MainActivity.this, "Você não acertou o número sorteado", Toast.LENGTH_SHORT).show();
            }
        });
    }

    protected void onStart() {
        super.onStart();
        //Utilização do SharedPreferences para ler a pontuação no arquivo de configuração
        SharedPreferences leitor = getSharedPreferences("nome_config", MODE_PRIVATE);

        //Aponta onde no arquivo de configuração está guardado a pontuação
        Sorteio.pontuacao = leitor.getInt("pontuacao", 0);

        //Atribui ao TextView txtPontuação o valor da pontuação armazenado
        txtPontuacao.setText("Pontuação: " + Sorteio.pontuacao);
    }
}