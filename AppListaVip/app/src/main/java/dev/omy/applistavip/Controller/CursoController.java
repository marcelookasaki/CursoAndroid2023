package dev.omy.applistavip.Controller;

import java.util.ArrayList;
import java.util.List;

import dev.omy.applistavip.Model.Curso;
import dev.omy.applistavip.View.MainActivity;

public class CursoController {

    public List listCursos;

    public CursoController(MainActivity mainActivity) {

    }

    public List getListaCursos(){

        listCursos = new ArrayList<Curso>();

        listCursos.add(new Curso("Java"));
        listCursos.add(new Curso("HTML e CSS"));
        listCursos.add(new Curso("Dart"));
        listCursos.add(new Curso("Kotlin"));
        listCursos.add(new Curso("Python"));
        listCursos.add(new Curso("Flutter"));
        listCursos.add(new Curso("Swift"));

        return listCursos;
    }

    public ArrayList<String> listaSpinner(){

        ArrayList<String> lista = new ArrayList<>();

        for (int i = 0; i < getListaCursos().size(); i++){

            Curso objeto = (Curso) getListaCursos().get(i);

            lista.add(objeto.getCursoDesejado());

        }

        return lista;

    }

}
