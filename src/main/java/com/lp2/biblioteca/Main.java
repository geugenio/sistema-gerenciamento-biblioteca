package com.lp2.biblioteca;

import com.lp2.biblioteca.model.Livro;
import com.lp2.biblioteca.model.Usuario;
import com.lp2.biblioteca.repository.LivroRepository;
import com.lp2.biblioteca.repository.UsuarioRepository;
import com.lp2.biblioteca.service.EmprestimoService;
import com.lp2.biblioteca.service.LivroService;
import com.lp2.biblioteca.service.UsuarioService;

public class Main {
    public static void main(String[] args) {
        // Inicialização dos repositórios em memória
        LivroRepository livroRepository = new LivroRepository();
        UsuarioRepository usuarioRepository = new UsuarioRepository();

        // Inicialização dos serviços
        LivroService livroService = new LivroService(livroRepository);
        UsuarioService usuarioService = new UsuarioService(usuarioRepository);
        EmprestimoService emprestimoService = new EmprestimoService(livroService, usuarioService);

        // Criando usuário
        Usuario u1 = new Usuario();
        u1.setNome("Gabriel");
        u1.setEmail("gabriel@email.com");
        usuarioService.save(u1);

        // Criando livro
        Livro l1 = new Livro();
        l1.setNome("Clean Code");
        l1.setAutor("Robert C. Martin");
        l1.setAno(2008);
        livroService.save(l1);

        System.out.println("Usuário criado: " + u1.getNome() + " (Empréstimos: " + u1.getEmprestimos() + ")");
        System.out.println("Livro criado: " + l1.getNome() + " (Disponível? " + l1.isStatus() + ")");

        // Realizando empréstimo
        System.out.println("\n--- Realizando empréstimo ---");
        emprestimoService.emprestar(l1.getId(), u1.getId());
        System.out.println("Livro emprestado com sucesso!");
        System.out.println("Status livro: " + l1.getStatusTexto());
        System.out.println("Total empréstimos do usuário: " + u1.getEmprestimos());

        // Realizando devolução
        System.out.println("\n--- Realizando devolução ---");
        emprestimoService.devolver(l1.getId(), u1.getId());
        System.out.println("Livro devolvido com sucesso!");
        System.out.println("Status livro: " + l1.getStatusTexto());
        System.out.println("Total empréstimos do usuário: " + u1.getEmprestimos());
    }
}
