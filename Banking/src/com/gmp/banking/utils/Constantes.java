package com.gmp.banking.utils;

import java.math.BigDecimal;

/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class Constantes {
	
	public static final String VC_BOTAO_UPDATE = "lbl.button.update";
	public static final String VC_BOTAO_ADD = "lbl.button.add";
	
	public static final String VC_REDIRECT_TRUE_ID="?faces-redirect=true&id=";
	public static final String VC_RUTA_CLIENTE = "pages/cliente/searchCliente.xhtml";
	public static final String VC_PAGINA_CLIENTE = "searchCliente.xhtml";
	public static final String VC_PAGINA_ADD_CLIENTE = "addCliente.xhtml";
	public static final String VC_PAGINA_LOAN_CLIENTE = "loanCliente.xhtml";
	public static final String VC_TITULO_CLIENTE = "lbl.menuleft.admin.cliente";
	
	public static final String VC_ERROR_ITEM_DUPLICADO = "lbl.mensaje.registrar.item.erroritemduplicado";
	public static final String VC_ERROR_FALTA_DADOS="lbl.mensaje.need.data";
	public static final String VC_TITLE_SUCCESS = "lbl.mensaje.registrar.item.title.exito";
	public static final String VC_SUCCESS = "lbl.mensaje.registrar.item.exito";

	public static final String VC_TITLE_ERROR = "lbl.mensaje.registrar.item.title.error";
	public static final String VC_ERROR = "lbl.mensaje.registrar.item.error";
	public static final String VC_TITLE_SELECT = "lbl.mensaje.seleccionar.item.title";
	public static final String VC_SELECT = "lbl.mensaje.seleccionar.item";
	public static final String VC_TITLE_MESSAGE = "lbl.title_mensaje";
	
	public static final String VC_ATRIBUTO_SESION="usuarioLogin";
	public static final String VC_USUARIO_SESION="usuarioLogin";
	
	public static final String VC_RISCO_A="A";
	public static final String VC_RISCO_B="B";
	public static final String VC_RISCO_C="C";
	
	public static final Integer IN_FLAG_ADD= 1;
	public static final Integer IN_FLAG_UPDATE= 2;
	public static final Integer IN_FLAG_ZERO= 0;
	public static final Integer IN_FLAG_ONE= 1;
	public static final Integer IN_FLAG_TWO= 2;
	public static final Integer IN_FLAG_NON_TWO= -2;
	public static final Integer IN_FLAG_THREE= 3;
	
	public static final BigDecimal BD_FACTOR_A = BigDecimal.valueOf(2000.0);
	public static final BigDecimal BD_FACTOR_B = BigDecimal.valueOf(8000.0);
	
}
