package com.gmp.banking.bean;

import java.math.BigDecimal;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class TbEmprestimo {
	
	private double valorSolicitado;
	private double juros;
	private int tempo;
	private BigDecimal cuota;
	private BigDecimal total;
	
	public double getValorSolicitado() {
		return valorSolicitado;
	}
	public void setValorSolicitado(double valorSolicitado) {
		this.valorSolicitado = valorSolicitado;
	}
	public double getJuros() {
		return juros;
	}
	public void setJuros(double juros) {
		this.juros = juros;
	}
	public int getTempo() {
		return tempo;
	}
	public void setTempo(int tiempo) {
		this.tempo = tiempo;
	}
	public BigDecimal getCuota() {
		return cuota;
	}
	public void setCuota(BigDecimal cuota) {
		this.cuota = cuota;
	}
	public BigDecimal getTotal() {
		return total;
	}
	public void setTotal(BigDecimal total) {
		this.total = total;
	}

}
