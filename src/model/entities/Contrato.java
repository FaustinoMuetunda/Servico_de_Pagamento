/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author faust
 */
public class Contrato {

    private Integer numero;
    private Date data;
    private Double ValorContrato;
    
    List<Installment> installments= new ArrayList<Installment>();

    public Contrato() {
    }

    public Contrato(Integer numero, Date data, Double ValorContrato) {
        this.numero = numero;
        this.data = data;
        this.ValorContrato = ValorContrato;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public Double getValorContrato() {
        return ValorContrato;
    }

    public void setValorContrato(Double ValorContrato) {
        this.ValorContrato = ValorContrato;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    
    
    

}
