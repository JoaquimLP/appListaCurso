package devandroid.joaquim.applistacurso.controller;

import java.util.ArrayList;
import java.util.List;

import devandroid.joaquim.applistacurso.model.Curso;

public class CursoController
{
    private List listCruso;

    public List getListaCurso()
    {
        listCruso = new ArrayList<Curso>();

        listCruso.add(new Curso("Java"));
        listCruso.add(new Curso("PHP"));
        listCruso.add(new Curso("HTML"));
        listCruso.add(new Curso("C#"));
        listCruso.add(new Curso("Flutter"));
        listCruso.add(new Curso("Dart"));

        return listCruso;
    }

    public ArrayList<String> dadosParaSpinner()
    {
        ArrayList<String> dados = new ArrayList<>();

        for (int i = 0; i < getListaCurso().size(); i ++) {
            Curso objeto = (Curso) getListaCurso().get(i);
            dados.add(objeto.getCursoDesejado());
        }

        return dados;
    }


}
