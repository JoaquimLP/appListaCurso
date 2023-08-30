package devandroid.joaquim.applistacurso.view;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import devandroid.joaquim.applistacurso.R;
import devandroid.joaquim.applistacurso.model.Pessoa;

public class MainActivity extends AppCompatActivity
{
    Pessoa pessoa;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        pessoa = new Pessoa();
    }
}