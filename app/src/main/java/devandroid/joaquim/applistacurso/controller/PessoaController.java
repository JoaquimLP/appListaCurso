package devandroid.joaquim.applistacurso.controller;

import android.util.Log;

import androidx.annotation.NonNull;

import devandroid.joaquim.applistacurso.model.Pessoa;

public class PessoaController
{

    @NonNull
    @Override
    public String toString() {
        Log.i("MVC_controller", "Controller inciada.......");
        return super.toString();
    }

    public void salvar(Pessoa pessoa)
    {
        Log.i("MVC_controller", "Salvo: " + pessoa.toString());
    }
}
