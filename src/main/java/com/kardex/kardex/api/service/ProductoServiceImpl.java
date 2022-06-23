package com.kardex.kardex.api.service;

import com.kardex.kardex.api.dao.ProductoDao;
import com.kardex.kardex.api.model.ProductoDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class ProductoServiceImpl implements ProductoService{

    private final ProductoDao productoDao;

    @Override
    public ProductoDto saveProducto(ProductoDto producto) {
        return productoDao.save(producto);
    }

    @Override
    public Optional<ProductoDto> getProducto(String referencia) {

        return Optional.ofNullable(productoDao.findById(referencia).orElseThrow(() -> {
            throw new RuntimeException();
        }));
    }

    @Override
    public List<ProductoDto> getAllProducto() {
        return productoDao.findAll();
    }

    @Override
    public ProductoDto updateProducto(String referencia, ProductoDto producto) {

        ProductoDto productoBuscado = productoDao.findById(referencia).get();
        productoBuscado.setNombre(producto.getNombre());
        productoBuscado.setDescripcion(producto.getDescripcion());
        productoBuscado.setPrecio(producto.getPrecio());
        productoBuscado.setCantidad(producto.getCantidad());

        return productoDao.save(productoBuscado);
    }

    @Override
    public boolean deleteProducto(String referencia) {
        try {
            productoDao.deleteById(referencia);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
