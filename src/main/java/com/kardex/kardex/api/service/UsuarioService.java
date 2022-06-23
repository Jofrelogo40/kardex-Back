package com.kardex.kardex.api.service;

import com.kardex.kardex.api.model.UsuarioDto;

import java.util.Optional;

public interface UsuarioService {

    UsuarioDto saveUsuario(UsuarioDto usuario);

    Optional<UsuarioDto> getUsuario(Long id);

    UsuarioDto updateUsuario(long id, UsuarioDto usuario);

    boolean deleteUsuario(long id);
}
