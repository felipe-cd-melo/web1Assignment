package br.com.sinquia.primeiroprojetoweb.bo;


import br.com.sinquia.primeiroprojetoweb.dao.LivroDAOI;
import br.com.sinquia.primeiroprojetoweb.model.Livro;

import javax.inject.Inject;
import java.util.List;
import java.util.Optional;

public class LivroBOImpl implements LivroBOI{

    private LivroDAOI livroDAO;

    @Inject
    public LivroBOImpl(LivroDAOI livroDAO){this.livroDAO = livroDAO;}

    @Override
    public void save(Livro livro) {
        validate(livro);
        if(!livroDAO.contains(livro)){
            livroDAO.save(livro);
        }else{
            throw new IllegalArgumentException("livro ja cadastrado");

        }
    }

    @Override
    public Livro getById(String livroId) {
        Optional<Livro> opLivro = livroDAO.getById(livroId);
        if(opLivro.isPresent()){
            return  opLivro.get();
        }
        throw new IllegalArgumentException("nenhum livro encontrado com o id: ".concat(livroId));
    }

    @Override
    public void update(Livro livro) {
        if(!livroDAO.contains(livro)){
            livroDAO.update(livro);
        }else{
            throw new IllegalArgumentException("alterações ja cadastradas");
        }
    }

    @Override
    public void delete(String livroId) {livroDAO.delete(livroId);}

    @Override
    public List<Livro> findAll() {
        return livroDAO.findAll();
    }

    @Override
    public boolean contains(Livro livro){ return livroDAO.contains(livro);}

    private void validate(Livro livro){
        if(livro.getNome().equals("") || livro.getAutor().equals("")){
            throw new IllegalArgumentException("O livro deve conter nome e autor");
        }
    }
}
