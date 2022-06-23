package com.kardex.kardex.api.service;

import com.kardex.kardex.api.dao.UsuarioDao;
import com.kardex.kardex.api.model.UsuarioDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class UsuarioServiceImpl implements UsuarioService{

    private final UsuarioDao usuarioDao;

    @Override
    public UsuarioDto saveUsuario(UsuarioDto usuario) {
        return usuarioDao.save(usuario);
    }

    @Override
    public Optional<UsuarioDto> getUsuario(Long id) {
        return Optional.ofNullable(usuarioDao.findById(id).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }

    @Override
    public UsuarioDto updateUsuario(long id, UsuarioDto usuario) {
        UsuarioDto usuarioBuscado = usuarioDao.findById(id).get();
        usuarioBuscado.setNombres(usuario.getNombres());
        usuarioBuscado.setApellidos(usuario.getApellidos());
        usuarioBuscado.setTelefono(usuario.getTelefono());
        return usuarioDao.save(usuarioBuscado);
    }

    @Override
    public boolean deleteUsuario(long id) {
        try {
            usuarioDao.deleteById(id);
            return true;
        } catch (Exception e){
            return false;
        }
    }
}
