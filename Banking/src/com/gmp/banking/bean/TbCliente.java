package com.gmp.banking.bean;

import java.math.BigDecimal;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class TbCliente {
    private Integer code_cli;

    private String name_cli;

    private String sobr_cli;

    private BigDecimal rmes_cli;

    private String end1_cli;

    private String end2_cli;

    private BigDecimal patr_cli;

    private BigDecimal divi_cli;

    private Integer code_est;

    private Integer code_tip;

    private Integer code_ris;

    public Integer getCode_cli() {
        return code_cli;
    }

    public void setCode_cli(Integer code_cli) {
        this.code_cli = code_cli;
    }

    public String getName_cli() {
        return name_cli;
    }

    public void setName_cli(String name_cli) {
        this.name_cli = name_cli;
    }

    public String getSobr_cli() {
        return sobr_cli;
    }

    public void setSobr_cli(String sobr_cli) {
        this.sobr_cli = sobr_cli;
    }

    public BigDecimal getRmes_cli() {
        return rmes_cli;
    }

    public void setRmes_cli(BigDecimal rmes_cli) {
        this.rmes_cli = rmes_cli;
    }

    public String getEnd1_cli() {
        return end1_cli;
    }

    public void setEnd1_cli(String end1_cli) {
        this.end1_cli = end1_cli;
    }

    public String getEnd2_cli() {
        return end2_cli;
    }

    public void setEnd2_cli(String end2_cli) {
        this.end2_cli = end2_cli;
    }

    public BigDecimal getPatr_cli() {
        return patr_cli;
    }

    public void setPatr_cli(BigDecimal patr_cli) {
        this.patr_cli = patr_cli;
    }

    public BigDecimal getDivi_cli() {
        return divi_cli;
    }

    public void setDivi_cli(BigDecimal divi_cli) {
        this.divi_cli = divi_cli;
    }

    public Integer getCode_est() {
        return code_est;
    }

    public void setCode_est(Integer code_est) {
        this.code_est = code_est;
    }

    public Integer getCode_tip() {
        return code_tip;
    }

    public void setCode_tip(Integer code_tip) {
        this.code_tip = code_tip;
    }

    public Integer getCode_ris() {
        return code_ris;
    }

    public void setCode_ris(Integer code_ris) {
        this.code_ris = code_ris;
    }
}