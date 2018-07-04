package com.gmp.banking.mockClass;

import static org.junit.Assert.*;

import java.math.BigDecimal;

import org.apache.log4j.Logger;
import org.junit.Before;
import org.junit.Test;

import com.gmp.banking.bean.TbCliente;
import com.gmp.banking.bean.TbEmprestimo;
import com.gmp.banking.utils.Constantes;

public class MockClassTest {
	
	private static Logger log = Logger.getLogger(MockClassTest.class);
	
	MockClass mClass;
	
	String cadena;
	BigDecimal value1;
	
	TbEmprestimo emprestimo1;
	TbCliente cliente1;

	@Before
	public void init() {
		this.mClass = new MockClass();
		this.emprestimo1 = new TbEmprestimo();
		
		this.cliente1 = new TbCliente();
		this.cliente1.setPatr_cli(BigDecimal.valueOf(1000.0));
		this.cliente1.setDivi_cli(BigDecimal.valueOf(2000.0));
		this.cliente1.setCode_est(1);
	}
	
	@Test
	public void isEmptyMockTest() {
		assertTrue(mClass.isEmptyMock(cadena));
	}
	
	@Test
	public void ObtenerTipoRiscoMockTest1() {
		this.value1 = new BigDecimal(1000);
		assertEquals(mClass.ObtenerTipoRiscoMock(value1), Constantes.VC_RISCO_C);
	}
	
	@Test
	public void ObtenerTipoRiscoMockTest2() {
		this.value1 = new BigDecimal(2000);
		assertEquals(mClass.ObtenerTipoRiscoMock(value1), Constantes.VC_RISCO_C);
	}
	
	@Test
	public void ObtenerTipoRiscoMockTest3() {
		this.value1 = new BigDecimal(5000);
		assertEquals(mClass.ObtenerTipoRiscoMock(value1), Constantes.VC_RISCO_B);
	}
	
	@Test
	public void ObtenerTipoRiscoMockTest4() {
		this.value1 = new BigDecimal(8000);
		assertEquals(mClass.ObtenerTipoRiscoMock(value1), Constantes.VC_RISCO_B);
	}
	
	@Test
	public void ObtenerTipoRiscoMockTest5() {
		this.value1 = new BigDecimal(9000);
		assertEquals(mClass.ObtenerTipoRiscoMock(value1), Constantes.VC_RISCO_A);
	}
	
	@Test
	public void CalcularMockTest1() {
		this.emprestimo1.setValorSolicitado(1000.0);
		this.emprestimo1.setJuros(1.9);
		this.emprestimo1.setTempo(12);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(84.19));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(1010.28));
	}
	
	@Test
	public void CalcularMockTest2() {
		this.emprestimo1.setValorSolicitado(1000.0);
		this.emprestimo1.setJuros(1.9);
		this.emprestimo1.setTempo(14);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(72.28));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(1011.92));
	}
	
	@Test
	public void CalcularMockTest3() {
		this.emprestimo1.setValorSolicitado(8000.0);
		this.emprestimo1.setJuros(5.0);
		this.emprestimo1.setTempo(12);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(684.86));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(8218.32));
	}
	
	@Test
	public void CalcularMockTest4() {
		this.emprestimo1.setValorSolicitado(2000.0);
		this.emprestimo1.setJuros(5.0);
		this.emprestimo1.setTempo(24);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(87.74));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(2105.76));
	}
	
	@Test
	public void CalcularMockTest5() {
		this.emprestimo1.setValorSolicitado(4000.0);
		this.emprestimo1.setJuros(10.0);
		this.emprestimo1.setTempo(12);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(351.66));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(4219.92));
	}
	
	@Test
	public void CalcularMockTest6() {
		this.emprestimo1.setValorSolicitado(1000.0);
		this.emprestimo1.setJuros(10.0);
		this.emprestimo1.setTempo(36);
		mClass.CalcularMock(emprestimo1);
		assertEquals(emprestimo1.getCuota(),BigDecimal.valueOf(32.27));
		assertEquals(emprestimo1.getTotal(),BigDecimal.valueOf(1161.72));
	}
	
	@Test
	public void setValuesAccordingTypeMockTest1() {
		assertNotNull(cliente1.getPatr_cli());
		assertNotNull(cliente1.getDivi_cli());
		assertNotNull(cliente1.getCode_est());
		cliente1.setCode_tip(1);
		mClass.setValuesAccordingTypeMock(cliente1);
		assertNotNull(cliente1.getPatr_cli());
		assertNull(cliente1.getDivi_cli());
		assertNull(cliente1.getCode_est());
	}
	
	@Test
	public void setValuesAccordingTypeMockTest2() {
		assertNotNull(cliente1.getPatr_cli());
		assertNotNull(cliente1.getDivi_cli());
		assertNotNull(cliente1.getCode_est());
		cliente1.setCode_tip(2);
		mClass.setValuesAccordingTypeMock(cliente1);
		assertNull(cliente1.getPatr_cli());
		assertNotNull(cliente1.getDivi_cli());
		assertNull(cliente1.getCode_est());
	}
	
	@Test
	public void setValuesAccordingTypeMockTest3() {
		assertNotNull(cliente1.getPatr_cli());
		assertNotNull(cliente1.getDivi_cli());
		assertNotNull(cliente1.getCode_est());
		cliente1.setCode_tip(3);
		mClass.setValuesAccordingTypeMock(cliente1);
		assertNull(cliente1.getPatr_cli());
		assertNull(cliente1.getDivi_cli());
		assertNotNull(cliente1.getCode_est());
	}

}
