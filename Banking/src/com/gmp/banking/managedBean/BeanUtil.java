package com.gmp.banking.managedBean;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import org.apache.log4j.Logger;
import org.springframework.dao.DataAccessException;
import com.gmp.banking.bean.*;
import com.gmp.banking.business.*;
import com.gmp.banking.mockClass.MockClass;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
@ManagedBean(name = "utilBean")
@SessionScoped
public class BeanUtil implements Serializable {
	private static final long serialVersionUID = 1L;
	private static Logger log = Logger.getLogger(BeanUtil.class);
	
	private ArrayList<TbEstado> listEstado;
	private ArrayList<TbTipo> listTipo;
	private ArrayList<TbRisco> listRisco;
	
	BusinessEstado businessEstado;
	BusinessTipo businessTipo;
	BusinessRisco businessRisco;
	
	
	public String usuario = "";
    FacesContext jsfCtx= FacesContext.getCurrentInstance();
	ResourceBundle bundle = jsfCtx.getApplication().getResourceBundle(jsfCtx, "msg");
	
	public BeanUtil(){
		
		businessEstado = new BusinessEstadoImpl();
		businessTipo= new BusinessTipoImpl();
		businessRisco = new BusinessRiscoImpl();

		ListaEstados();
		ListaTipos();
		ListaRiscos();
	}
	
	public void ListaEstados (){
		try {
			TbEstado estado = new TbEstado();
			listEstado = (ArrayList<TbEstado>) businessEstado.listarEstado(estado);
			
		} catch (DataAccessException e) {
			log.debug("DataAccessException: " + e,e);
		} catch (Exception e) {
			log.debug("Exception: " + e,e);
		}
	}
	
	public void ListaTipos (){
		try {
			TbTipo tipo = new TbTipo();
			listTipo = (ArrayList<TbTipo>) businessTipo.listarTipo(tipo);
			
		} catch (DataAccessException e) {
			log.debug("DataAccessException: " + e,e);
		} catch (Exception e) {
			log.debug("Exception: " + e,e);
		}
	}
	
	
	public void ListaRiscos (){
		try {
			TbRisco risco = new TbRisco();
			listRisco = (ArrayList<TbRisco>) businessRisco.listarRisco(risco);
			
		} catch (DataAccessException e) {
			log.debug("DataAccessException: " + e,e);
		} catch (Exception e) {
			log.debug("Exception: " + e,e);
		}
	}

  /**
   * Para Avaliação
   * @param vc_codigo 
   * @param value string para escolher o tipo de ação
   * @return descrição da Tb_Estado | Tb_Risco | Tb_Tipo
   */
  public String ObtenerDescricao(String vc_codigo, String value){

	  if(!isEmpty(vc_codigo)){

		  try {
			  switch (value) {
			  case "est": 
				  TbEstado estado = new TbEstado();
				  estado.setCode_est(Integer.parseInt(vc_codigo));
				  estado = businessEstado.obtenerEstado(estado);
				  return estado.getDesc_est();

			  case "tip": 
				  TbTipo tipo = new TbTipo();
				  tipo.setCode_tip(Integer.parseInt(vc_codigo));
				  tipo = businessTipo.obtenerTipo(tipo);
				  return tipo.getDesc_tip();

			  case "ris": 
				  TbRisco risco = new TbRisco();
				  risco.setCode_ris(Integer.parseInt(vc_codigo));
				  risco = businessRisco.obtenerRisco(risco);
				  return risco.getDesc_ris();

			  default:
				  break;
			  }

		  } catch (DataAccessException e) {
			  log.debug("DataAccessException: " + e,e);
		  } catch (Exception e) {
			  log.debug("Exception: " + e,e);
		  }

	  }else {

		  return null;
	  }

	  return null;
  }
  
  public Boolean isEmpty(String cadena) {
		if((cadena == null || cadena.equals(""))){
			return true;
		}
		return false;

	}
  
	public ArrayList<TbEstado> getLstEstado() {
		return listEstado;
	}

	public void setLstEstado(ArrayList<TbEstado> lstEstado) {
		this.listEstado = lstEstado;
	}

	public ArrayList<TbEstado> getListEstado() {
		return listEstado;
	}

	public void setListEstado(ArrayList<TbEstado> listEstado) {
		this.listEstado = listEstado;
	}

	public ArrayList<TbTipo> getListTipo() {
		return listTipo;
	}

	public void setListTipo(ArrayList<TbTipo> listTipo) {
		this.listTipo = listTipo;
	}

	public ArrayList<TbRisco> getListRisco() {
		return listRisco;
	}

	public void setListRisco(ArrayList<TbRisco> listRisco) {
		this.listRisco = listRisco;
	}
	
}