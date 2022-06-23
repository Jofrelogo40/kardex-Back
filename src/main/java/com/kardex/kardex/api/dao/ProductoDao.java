package com.kardex.kardex.api.dao;

import com.kardex.kardex.api.model.ProductoDto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoDao extends JpaRepository<ProductoDto,String> {
}
