package com.lp2.biblioteca.service;

import com.lp2.biblioteca.dto.UpdateUsuarioDTO;
import com.lp2.biblioteca.model.Usuario;
import com.lp2.biblioteca.repository.UsuarioRepository;

import java.util.List;
import java.util.Optional;

public class UsuarioService {
    public UsuarioRepository ur;

    public UsuarioService() {
        this.ur = new UsuarioRepository();
    }

    public UsuarioService(UsuarioRepository ur) {
        this.ur = ur;
    }

    public List<Usuario> findAll() {
        return ur.findAll();
    }

    public Optional<Usuario> findById(Long id) {
        return ur.findById(id);
    }

    public Usuario save(Usuario usuario) {
        return ur.save(usuario);
    }

    public boolean delete(Long id) {
        return ur.delete(id);
    }

    public Optional<Usuario> update(long id, UpdateUsuarioDTO dto) {
        Optional<Usuario> existente = ur.findById(id);

        if (existente.isPresent()) {
            Usuario usuario = existente.get();

            if (dto.getNome() != null) {
                usuario.setNome(dto.getNome());
            }
            if (dto.getEmail() != null) {
                usuario.setEmail(dto.getEmail());
            }

            ur.save(usuario);

            return Optional.of(usuario);
        }
        return Optional.empty();
    }
}
