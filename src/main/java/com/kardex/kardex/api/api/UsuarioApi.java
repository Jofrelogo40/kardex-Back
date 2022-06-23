package com.kardex.kardex.api.api;

import com.kardex.kardex.api.model.Respuesta;
import com.kardex.kardex.api.model.UsuarioDto;
import com.kardex.kardex.api.service.UsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioApi {

    private final UsuarioService usuarioService;

    @PostMapping(value = "/version")
    public Respuesta version(@RequestBody String version) {
        Respuesta respuesta = new Respuesta();
        respuesta.setMessage("version: 1.0.0");
        return respuesta;
    }

    @PostMapping
    public ResponseEntity saveUsuario(@RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity(usuarioService.saveUsuario(usuarioDto), HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity getUsuario(@PathVariable("id") Long idUsuario){
        return new ResponseEntity(usuarioService.getUsuario(idUsuario), HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity updateUsuario(@PathVariable("id") Long idUsuario, @RequestBody UsuarioDto usuarioDto){
        return new ResponseEntity(usuarioService.updateUsuario(idUsuario, usuarioDto), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteUsuario(@PathVariable("id") Long idUsuario){
        boolean respuesta = usuarioService.deleteUsuario(idUsuario);
        if (respuesta) {
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return new ResponseEntity(HttpStatus.NOT_FOUND);
        }
    }
}
