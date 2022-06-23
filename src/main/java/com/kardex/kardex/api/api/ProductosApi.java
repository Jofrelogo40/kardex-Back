package com.kardex.kardex.api.api;

import com.kardex.kardex.api.model.ProductoDto;
import com.kardex.kardex.api.service.ProductoService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/productos")
@RequiredArgsConstructor
public class ProductosApi {

    private final ProductoService productoService;

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
}
