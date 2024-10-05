/**
 *@author:<ANA PAULA DE OLIVEIRA SILVA>
 *RA1110482123028
 *ANA PAULA DE OLIVEIRA SILVA
 */

package br.edu.fateczl.imprimenumeros;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText etNumero;
    private Button btnGerar;
    private TextView tvResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etNumero = findViewById(R.id.etNumero);
        btnGerar = findViewById(R.id.btnGerar);
        tvResultado = findViewById(R.id.tvResultado);

        btnGerar.setOnClickListener(v -> gerarResultado());
    }

    private void gerarResultado() {
        String input = etNumero.getText().toString();

        if (input.isEmpty()) {
            tvResultado.setText(R.string.invalido);
            return;
        }

        int numero = Integer.parseInt(input);

        // Validação do número
        if (numero < 100 || numero > 999) {
            tvResultado.setText(R.string.invalido);
        } else {
            // Extrair centena, dezena e unidade
            int centena = numero / 100;
            int dezena = (numero / 10) % 10;
            int unidade = numero % 10;

            // Exibir o resultado
            String resultado = getString(R.string.centena) + " " + centena + "\n" +
                    getString(R.string.dezena) + " " + dezena + "\n" +
                    getString(R.string.unidade) + " " + unidade;

            tvResultado.setText(resultado);
        }
    }
}
