package com.lp2.biblioteca.repository;

import com.lp2.biblioteca.model.Livro;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class LivroRepository {
    private final List<Livro> livros;

    public LivroRepository() {
        this.livros = new ArrayList<>();
    }

    public Livro save(Livro livro) {
        if (livro.getId() == null) {
            long novoId = livros.isEmpty() ? 1 : livros.get(livros.size() - 1).getId() + 1;
            livro.setId(novoId);
            livro.setStatus(true); // começa disponivel
            livros.add(livro);
        } else {
            for (int i = 0; i < livros.size(); i++) {
                if (livros.get(i).getId().equals(livro.getId())) {
                    livros.set(i, livro);
                    break;
                }
            }
        }
        saveList();
        return livro;
    }

    public void saveList() {
        // Armazenamento em memória mantido na lista
    }

    public List<Livro> findAll() {
        return livros;
    }

    public Optional<Livro> findById(Long id) {
        return livros.stream()
                .filter(l -> l.getId().equals(id))
                .findFirst();
    }

    public boolean delete(Long id) {
        Optional<Livro> livro = findById(id);

        if (livro.isPresent()) {
            if (!livro.get().isStatus()) { // se o status for false (emprestado)
                return false;
            }
            livros.remove(livro.get());
            saveList();
            return true;
        }
        return false;
    }
}
