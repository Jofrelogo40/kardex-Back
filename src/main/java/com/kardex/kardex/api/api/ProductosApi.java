package com.kardex.kardex.api.api;

import com.kardex.kardex.api.model.ProductoDto;
import com.kardex.kardex.api.service.ProductoService;
import com.zaxxer.hikari.pool.HikariPool;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.DirectFieldAccessor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.DataSource;
import java.util.HashMap;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductosApi {

    private final ProductoService productoService;

    private DataSource dataSource;

    @PostMapping
    public ResponseEntity saveProducto(@RequestBody ProductoDto productoDto){
        return new ResponseEntity(productoService.saveProducto(productoDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getProducto(@PathVariable("id") String idProducto){
        return new ResponseEntity(productoService.getProducto(idProducto), HttpStatus.OK);
    }

    @GetMapping()
    public ResponseEntity getAllProducto(){
        return new ResponseEntity(productoService.getAllProducto(), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateProducto(@PathVariable("id") String idProducto, @RequestBody ProductoDto productoDto){
        return new ResponseEntity(productoService.updateProducto(idProducto, productoDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteProducto(@PathVariable("id") String idProducto){
        boolean respuesta = productoService.deleteProducto(idProducto);
        if (respuesta) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping(value = "/connection")
    public Object datasourceMonitoring() {
        HikariPool hikariPool = (HikariPool) new DirectFieldAccessor(dataSource).getPropertyValue("pool");

        Map<String, Object> params = new HashMap<>();

        if (hikariPool != null) {
            params.put("activeConnections", hikariPool.getActiveConnections());
            params.put("idleConnections", hikariPool.getIdleConnections());
            params.put("totalConnections", hikariPool.getTotalConnections());
        }
        return params;
    }
}
