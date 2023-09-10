package devandroid.joaquim.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import devandroid.joaquim.applistacurso.R;
import devandroid.joaquim.applistacurso.controller.PessoaController;
import devandroid.joaquim.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";


    Pessoa pessoa;
    PessoaController controller;
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

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController();
        controller.toString();

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobrenome", ""));
        pessoa.setCurso(preferences.getString("curso", ""));
        pessoa.setTelefone(preferences.getString("telefone", ""));


        editNome = findViewById(R.id.editNome); // cria o vinculo com os campos no layout
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

                listaVip.clear();
                listaVip.apply();
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

                listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
                listaVip.putString("sobrenome", pessoa.getSobreNome());
                listaVip.putString("curso", pessoa.getCurso());
                listaVip.putString("telefone", pessoa.getTelefone());
                listaVip.apply();
                controller.salvar(pessoa);
            }
        });

       // Log.i("POOAndroid", pessoa.toString()); // ->serve para ver o log da saída de um objeto
    }
}