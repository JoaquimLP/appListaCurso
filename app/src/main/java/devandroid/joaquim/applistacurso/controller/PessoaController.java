package devandroid.joaquim.applistacurso.controller;

import android.content.SharedPreferences;
import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.joaquim.applistacurso.model.Pessoa;
import devandroid.joaquim.applistacurso.view.MainActivity;

public class PessoaController
{

    SharedPreferences preferences;
    SharedPreferences.Editor listaVip;
    public static final String NOME_PREFERENCES = "pref_lista_vip";


    public PessoaController(MainActivity mainActivity)
    {
        preferences = mainActivity.getSharedPreferences(NOME_PREFERENCES, 0);
        listaVip = preferences.edit();
    }

    @NonNull
    @Override
    public String toString() {
        Log.i("MVC_controller", "Controller inciada.......");
        return super.toString();
    }

    public void salvar(Pessoa pessoa)
    {
        listaVip.putString("primeiroNome", pessoa.getPrimeiroNome());
        listaVip.putString("sobrenome", pessoa.getSobreNome());
        listaVip.putString("curso", pessoa.getCurso());
        listaVip.putString("telefone", pessoa.getTelefone());
        listaVip.apply();

        Log.i("MVC_controller", "Salvo: " + pessoa.toString());
    }

    public Pessoa buscar(Pessoa pessoa)
    {
        pessoa.setPrimeiroNome(preferences.getString("primeiroNome", ""));
        pessoa.setSobreNome(preferences.getString("sobrenome", ""));
        pessoa.setCurso(preferences.getString("curso", ""));
        pessoa.setTelefone(preferences.getString("telefone", ""));

        return pessoa;
    }

    public void limpar()
    {
        listaVip.clear();
        listaVip.apply();
    }

}
