package com.kardex.kardex.api.model;

import oracle.jdbc.OracleStruct;
import oracle.sql.STRUCT;

import java.io.Serializable;
import java.sql.SQLException;

@SuppressWarnings("deprecation")
public class Mensaje implements Serializable {

	private static final long serialVersionUID = 1L;

	private long codigoSistema;
	private String descripcionSistema;
	private long codigoUsuario;
	private String descripcionUsuario;

	public long getCodigoSistema() {
		return codigoSistema;
	}

	public void setCodigoSistema(long codigoSistema) {
		this.codigoSistema = codigoSistema;
	}

	public String getDescripcionSistema() {
		return descripcionSistema;
	}

	public void setDescripcionSistema(String descripcionSistema) {
		this.descripcionSistema = descripcionSistema;
	}

	public long getCodigoUsuario() {
		return codigoUsuario;
	}

	public void setCodigoUsuario(long codigoUsuario) {
		this.codigoUsuario = codigoUsuario;
	}

	public String getDescripcionUsuario() {
		return descripcionUsuario;
	}

	public void setDescripcionUsuario(String descripcionUsuario) {
		this.descripcionUsuario = descripcionUsuario;
	}

	public void setStructAttrs(Object struct) throws SQLException {

		Object[] attrs;

		if (struct instanceof OracleStruct) {
			attrs = ((OracleStruct) struct).getAttributes();
		} else {
			attrs = ((STRUCT) struct).getAttributes();
		}

		this.setCodigoSistema(Long.parseLong(attrs[0] == null ? "0" : attrs[0].toString()));
		this.setDescripcionSistema(attrs[1] == null ? "" : attrs[1].toString());
		this.setCodigoUsuario(Long.parseLong(attrs[2] == null ? "0" : attrs[2].toString()));
		this.setDescripcionUsuario(attrs[3] == null ? "" : attrs[3].toString());
	}

}
