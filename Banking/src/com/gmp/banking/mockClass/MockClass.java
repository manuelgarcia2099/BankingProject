package com.gmp.banking.mockClass;

import java.math.BigDecimal;

import org.apache.log4j.Logger;

import com.gmp.banking.bean.TbCliente;
import com.gmp.banking.bean.TbEmprestimo;
import com.gmp.banking.managedBean.BeanUtil;
import com.gmp.banking.utils.Constantes;

public class MockClass {
	
	private static Logger log = Logger.getLogger(MockClass.class);
	
	TbEmprestimo emprestimoMock;
	TbCliente clienteMock;

	public MockClass() {}

	public Boolean isEmptyMock(String cadena) {
		if((cadena == null || cadena.equals(""))){
			return true;
		}
		return false;

	}
	
	public String ObtenerTipoRiscoMock(BigDecimal rendimento){
		
		String resultado =null;

		if(rendimento.compareTo(Constantes.BD_FACTOR_A)<=Constantes.IN_FLAG_ZERO) {
			resultado = Constantes.VC_RISCO_C;
		}else if(rendimento.compareTo(Constantes.BD_FACTOR_A)>Constantes.IN_FLAG_ZERO && rendimento.compareTo(Constantes.BD_FACTOR_B)<=Constantes.IN_FLAG_ZERO){
			resultado = Constantes.VC_RISCO_B;
		} else if(rendimento.compareTo(Constantes.BD_FACTOR_B)>Constantes.IN_FLAG_ZERO) {
			resultado = Constantes.VC_RISCO_A;
		}
		
		return resultado;
	}
	
	public void CalcularMock(TbEmprestimo prestamo){

		if(prestamo.getTempo()!=Constantes.IN_FLAG_ZERO && prestamo.getValorSolicitado()!=Constantes.IN_FLAG_ZERO) {

			double importe = prestamo.getValorSolicitado();
			double juros = prestamo.getJuros();
			double tempo = prestamo.getTempo();
			
			juros = juros/1200;

			double numerador = juros * Math.pow(Constantes.IN_FLAG_ONE+juros, tempo);
			double denominador = Math.pow(Constantes.IN_FLAG_ONE+juros, tempo)-Constantes.IN_FLAG_ONE;

			double cuota = importe*(numerador/denominador);
			BigDecimal cuotaBD = BigDecimal.valueOf(cuota).setScale(Constantes.IN_FLAG_TWO, BigDecimal.ROUND_HALF_UP);

			BigDecimal totalBD = cuotaBD.multiply(BigDecimal.valueOf(tempo));
			totalBD = totalBD.setScale(Constantes.IN_FLAG_TWO, BigDecimal.ROUND_HALF_UP);

			prestamo.setCuota(cuotaBD);
			prestamo.setTotal(totalBD);

		} 
		else {
			log.debug("Constantes.VC_ERROR_FALTA_DADOS");
		}
	}
	
	public void setValuesAccordingTypeMock(TbCliente cliente) {

		switch (cliente.getCode_tip()) {
		case 1:
			cliente.setDivi_cli(null);
			cliente.setCode_est(null);
			break;
		case 2:
			cliente.setPatr_cli(null);
			cliente.setCode_est(null);
			break;
		case 3:
			cliente.setDivi_cli(null);
			cliente.setPatr_cli(null);
			break;
		default:
			cliente.setCode_est(null);
			cliente.setDivi_cli(null);
			cliente.setPatr_cli(null);
			break;
		}

	}

	public TbEmprestimo getEmprestimoMock() {
		return emprestimoMock;
	}

	public void setEmprestimoMock(TbEmprestimo emprestimoMock) {
		this.emprestimoMock = emprestimoMock;
	}

	public TbCliente getClienteMock() {
		return clienteMock;
	}

	public void setClienteMock(TbCliente clienteMock) {
		this.clienteMock = clienteMock;
	}

}
