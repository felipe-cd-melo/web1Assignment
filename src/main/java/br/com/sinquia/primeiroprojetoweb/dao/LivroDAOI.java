package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Livro;

import java.util.List;
import java.util.Optional;

public interface LivroDAOI {

    void save(Livro livro);
    Optional<Livro> getById(String livroId);
    void update(Livro livro);
    void delete(String livroId);
    boolean contains(Livro livro);
    List<Livro> findAll();
}
