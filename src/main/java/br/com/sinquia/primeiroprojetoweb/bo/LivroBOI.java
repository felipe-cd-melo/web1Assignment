package br.com.sinquia.primeiroprojetoweb.bo;


import br.com.sinquia.primeiroprojetoweb.model.Livro;
import java.util.List;

public interface LivroBOI {

    void save(Livro livro);
    Livro getById(String livroId);
    void update(Livro livro);
    void delete(String livroId);
    List<Livro> findAll();
    boolean contains(Livro livro);

}
