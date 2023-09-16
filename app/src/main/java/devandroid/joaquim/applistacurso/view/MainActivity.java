package devandroid.joaquim.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.List;

import devandroid.joaquim.applistacurso.R;
import devandroid.joaquim.applistacurso.controller.CursoController;
import devandroid.joaquim.applistacurso.controller.PessoaController;
import devandroid.joaquim.applistacurso.model.Curso;
import devandroid.joaquim.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity
{
    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";


    Pessoa pessoa;
    List<String> listaCurso;
    PessoaController controller;
    CursoController cursoController;

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

    Spinner spinner;


    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        preferences = getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();

        controller = new PessoaController(MainActivity.this);
        controller.toString();

        cursoController = new CursoController();
        listaCurso = cursoController.dadosParaSpinner();

        pessoa = new Pessoa();
        controller.buscar(pessoa);



        editNome = findViewById(R.id.editNome); // cria o vinculo com os campos no layout
        editSobrenome = findViewById(R.id.editSobrenome);
        editCurso = findViewById(R.id.editCurso);
        editTelefone = findViewById(R.id.editTelefone);
        spinner = findViewById(R.id.spinner);

        btnLimpar = findViewById(R.id.btnLimpar);
        btnSalvar = findViewById(R.id.btnSalvar);
        btnFinalizar = findViewById(R.id.btnFinalizar);

        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_list_item_1, cursoController.dadosParaSpinner());
        adapter.setDropDownViewResource(android.R.layout.simple_list_item_1);
        spinner.setAdapter(adapter);

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

                controller.limpar();
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
                controller.salvar(pessoa);
            }
        });

       // Log.i("POOAndroid", pessoa.toString()); // ->serve para ver o log da saída de um objeto
    }
}