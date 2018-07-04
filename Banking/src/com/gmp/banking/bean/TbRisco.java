package com.gmp.banking.bean;

import java.math.BigDecimal;
/**
 * @author GMP2018 (García, Manuel - Proyectos 2018).
 */
public class TbRisco {
    private Integer code_ris;

    private String desc_ris;

    private BigDecimal juro_ris;

    public Integer getCode_ris() {
        return code_ris;
    }

    public void setCode_ris(Integer code_ris) {
        this.code_ris = code_ris;
    }

    public String getDesc_ris() {
        return desc_ris;
    }

    public void setDesc_ris(String desc_ris) {
        this.desc_ris = desc_ris;
    }

    public BigDecimal getJuro_ris() {
        return juro_ris;
    }

    public void setJuro_ris(BigDecimal juro_ris) {
        this.juro_ris = juro_ris;
    }
}