package com.kardex.kardex.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioDto {

    @Id
    @Column(nullable = false)
    private long id;
    @Column(nullable = false)
    private String nombres;
    @Column(nullable = false)
    private String apellidos;
    private String telefono;

}
