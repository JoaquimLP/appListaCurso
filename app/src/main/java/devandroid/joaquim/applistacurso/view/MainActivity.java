package devandroid.joaquim.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.joaquim.applistacurso.R;
import devandroid.joaquim.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity
{
    Pessoa pessoa;
    String dadosPessoas;

    // Classe que está no layout
    // campos de texto
    EditText editNome;
    EditText editSobrenome;
    EditText editCurso;
    EditText editTelefone;
    // botões
    Button btnLimpar;
    Button btnSalvar;
    Button btnFinalizar;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
//        pessoa.setPrimeiroNome("Joaquim");
//        pessoa.setSobreNome("LOpes");
//        pessoa.setCurso("java");
//        pessoa.setTelefone("41992434693");

        editNome = findViewById(R.id.editNome);
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        editNome.setText(pessoa.getPrimeiroNome());
        editSobrenome.setText(pessoa.getSobreNome());
        editCurso.setText(pessoa.getCurso());
        editTelefone.setText(pessoa.getTelefone());

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editNome.setText("");
                editSobrenome.setText("");
                editTelefone.setText("");
                editCurso.setText("");
            }
        });

        btnFinalizar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Volte sempre", Toast.LENGTH_LONG).show();
                finish();
            }
        });

        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                pessoa.setPrimeiroNome(editNome.getText().toString());
                pessoa.setSobreNome(editSobrenome.getText().toString());
                pessoa.setCurso(editCurso.getText().toString());
                pessoa.setTelefone(editTelefone.getText().toString());

                Toast.makeText(MainActivity.this, "Salvo: " + pessoa.toString(), Toast.LENGTH_LONG).show();
            }
        });

        /*dadosPessoas = "Primeiro nome: ";
        dadosPessoas += pessoa.getPrimeiroNome();
        dadosPessoas += " Sobrenome " + pessoa.getSobreNome();
        dadosPessoas += " Curso " + pessoa.getCurso();
        dadosPessoas += " Telefone " + pessoa.getTelefone();*/

       // Log.i("POOAndroid", pessoa.toString()); // ->serve para ver o log da saída de um objeto
    }
}