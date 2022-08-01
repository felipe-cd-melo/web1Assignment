package br.com.sinquia.primeiroprojetoweb.dao;

import br.com.sinquia.primeiroprojetoweb.model.Livro;
import java.util.*;


public class LivroDAOImpl implements LivroDAOI{

    private static HashSet<Livro> bancoLivros = new HashSet<>();
    private static long countLivro;

    @Override
    public void save(Livro livro) {
        countLivro++;
        livro.setId(countLivro);
        bancoLivros.add(livro);
    }

    @Override
    public Optional<Livro> getById(String livroId) {
        for(Livro l:bancoLivros){
            if(l.getId().equals(Long.valueOf(livroId))){
                return Optional.of(l);
            }
        }
        return Optional.empty();
    }

    @Override
    public void update(Livro livro) {
            for(Livro l: bancoLivros){
                if(Objects.equals(l.getId(), livro.getId())){
                    updateLivro(livro,l);
                    return;
                }
            }
            throw new IllegalArgumentException("id invalido");
    }

    @Override
    public void delete(String livroId) {
        for(Livro l: bancoLivros){
            if(l.getId().equals(Long.valueOf(livroId))){
                bancoLivros.remove(l);
                return;
            }
        }
        throw new IllegalArgumentException("id invalido");
    }

    @Override
    public List<Livro> findAll() {
        return new ArrayList<>(bancoLivros);
    }

    private void updateLivro(Livro livroNewData, Livro livroOldData){
        bancoLivros.remove(livroOldData);
        bancoLivros.add(livroNewData);
    }

    public boolean contains(Livro livro){
       return (bancoLivros.contains(livro));
       }
}

