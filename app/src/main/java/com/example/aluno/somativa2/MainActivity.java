package com.example.aluno.somativa2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    //Declaração de variáveis
    private NumberPicker npNum;
    private Button btnSorteio;
    private Random aleatorio = new Random();
    private int[] sorteado = new int[2];
    private int novoNum;
    private boolean repetiu = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Vinculando os componentes do layout com as variáveis referenciadas
        npNum = (NumberPicker) findViewById(R.id.npNum);
        btnSorteio = (Button) findViewById(R.id.btnSorteio);

        npNum.setMaxValue(10);
        npNum.setMinValue(1);

        btnSorteio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                for (int j = 0; j < 1; j++) {
                    //Atribui false para a variável boolean repetiu
                    repetiu = false;
                    //Faça
                    do {
                        //Atribui false para a variável boolean repetiu
                        repetiu = false;
                        //Gera o número aleatório de 0 a 99 e atribui para novoNum
                        novoNum = aleatorio.nextInt(11);
                        if(novoNum == 0)
                            novoNum = 1;
                        //laço de repetição incondicional
                        for (int k = j - 1; k >= 0; k--)
                            //Se o novo número aleatório é igual ao elemento da posição da matriz num
                            if (novoNum == sorteado[k])
                                //Atribui true para a variável boolean repetiu
                                repetiu = true;
                    } while (repetiu);//Enquanto repetiu
                    //Atribui ao vetor o novo valor aleatório
                    sorteado[j] = novoNum;
                }
                if(npNum.getValue() == sorteado[0] || npNum.getValue() == sorteado[1])
                {
                    Intent it = new Intent(MainActivity.this, Sorteio.class);
                    it.putExtra("nDigitado",npNum.getValue());
                    it.putExtra("sort1",sorteado[0]);
                    it.putExtra("sort2",sorteado[1]);
                    startActivity(it);
                }else
                    Toast.makeText(MainActivity.this,"Você não acertou o número sorteado",Toast.LENGTH_SHORT).show();
            }
        });
    }
}
