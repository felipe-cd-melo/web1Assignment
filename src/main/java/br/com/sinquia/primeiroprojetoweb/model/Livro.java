package br.com.sinquia.primeiroprojetoweb.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.Objects;

@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Data
@ToString(of = {"id","nome","autor"})
public class Livro {

    private Long id;
    @EqualsAndHashCode.Include
    private String nome;
    @EqualsAndHashCode.Include
    private String autor;

    public Livro(String name, String author) {
        this.nome = name;
        this.autor = author;
    }
}
