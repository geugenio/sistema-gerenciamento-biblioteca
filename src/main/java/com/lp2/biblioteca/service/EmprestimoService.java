package com.lp2.biblioteca.service;

import com.lp2.biblioteca.model.Livro;
import com.lp2.biblioteca.model.Usuario;

import java.util.Optional;

public class EmprestimoService {
    private LivroService livroService;
    private UsuarioService usuarioService;

    public EmprestimoService(LivroService livroService, UsuarioService usuarioService) {
        this.livroService = livroService;
        this.usuarioService = usuarioService;
    }

    public EmprestimoService() {
        this.livroService = new LivroService();
        this.usuarioService = new UsuarioService();
    }

    public Optional<Livro> emprestar(Long idLivro, Long idUsuario) {
        Optional<Livro> livroExistente = livroService.findById(idLivro);
        if (livroExistente.isEmpty()) {
            return Optional.empty();
        }
        Livro livro = livroExistente.get();

        if (!livro.isStatus()) {
            throw new RuntimeException("Livro já emprestado! Não está disponivel.");
        }
        Optional<Usuario> usuarioExistente = usuarioService.findById(idUsuario);
        if (usuarioExistente.isEmpty()) {
            return Optional.empty();
        }
        Usuario usuario = usuarioExistente.get();

        // logica pra emprestar
        livro.setStatus(false);
        livro.setResponsavelId(idUsuario);
        livroService.save(livro);

        usuario.setEmprestimos(usuario.getEmprestimos() + 1);
        usuarioService.save(usuario);

        return Optional.of(livro);
    }

    public Optional<Livro> devolver(Long idLivro, Long idUsuario) {
        Optional<Livro> livroExistente = livroService.findById(idLivro);
        if (livroExistente.isEmpty()) {
            return Optional.empty();
        }
        Livro livro = livroExistente.get();

        if (livro.isStatus()) {
            throw new RuntimeException("O livro ainda não foi emprestado.");
        }
        Optional<Usuario> usuarioExistente = usuarioService.findById(idUsuario);
        if (usuarioExistente.isEmpty()) {
            return Optional.empty();
        }
        Usuario usuario = usuarioExistente.get();

        if (!idUsuario.equals(livro.getResponsavelId())) {
            throw new RuntimeException("Este usuário não é o responsável.");
        }

        // logica pra devolver
        livro.setStatus(true);
        livro.setResponsavelId(null);
        livroService.save(livro);

        usuario.setEmprestimos(usuario.getEmprestimos() - 1);
        usuarioService.save(usuario);

        return Optional.of(livro);
    }
}
