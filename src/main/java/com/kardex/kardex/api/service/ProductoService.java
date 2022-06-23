package com.kardex.kardex.api.service;

import com.kardex.kardex.api.model.ProductoDto;

import java.util.List;
import java.util.Optional;

public interface ProductoService {

    ProductoDto saveProducto(ProductoDto productos);

    Optional<ProductoDto> getProducto(String referencia);

    List<ProductoDto> getAllProducto();

    ProductoDto updateProducto(String referencia, ProductoDto producto);

    boolean deleteProducto(String referencia);

}
