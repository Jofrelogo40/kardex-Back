package com.kardex.kardex.api.dao;

import com.kardex.kardex.api.model.UsuarioDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioDao extends JpaRepository<UsuarioDto,Long> {
}
