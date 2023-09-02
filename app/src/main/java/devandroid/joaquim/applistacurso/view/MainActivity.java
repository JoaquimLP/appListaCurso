package devandroid.joaquim.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import devandroid.joaquim.applistacurso.R;
import devandroid.joaquim.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity
{
    Pessoa pessoa;
    String dadosPessoas;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
        pessoa.setPrimeiroNome("Joaquim");
        pessoa.setSobreNome("LOpes");
        pessoa.setCurso("java");
        pessoa.setTelefone("41992434693");

        /*dadosPessoas = "Primeiro nome: ";
        dadosPessoas += pessoa.getPrimeiroNome();
        dadosPessoas += " Sobrenome " + pessoa.getSobreNome();
        dadosPessoas += " Curso " + pessoa.getCurso();
        dadosPessoas += " Telefone " + pessoa.getTelefone();*/

        Log.i("POOAndroid", pessoa.toString()); // ->serve para ver o log da saída de um objeto
    }
}