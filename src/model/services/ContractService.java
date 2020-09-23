/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

import java.util.Calendar;
import java.util.Date;
import model.entities.Contrato;
import model.entities.Installment;

/**
 *
 * @author faust
 */
public class ContractService {

    private OnlinePaymentService onlinepaymentService;

    public ContractService(OnlinePaymentService onlinepaymentService) {
        this.onlinepaymentService = onlinepaymentService;
    }

    public void porcessContract(Contrato contrato, int months) {

        double basicQuota = contrato.getValorContrato() / months;

        for (int i = 1; i <= months; i++) {
            double updatedQuota = basicQuota + onlinepaymentService.interest(basicQuota, i);
            double fullQuota =updatedQuota+ onlinepaymentService.paymentFee(updatedQuota);
            
            Date dueDate=addMonths(contrato.getData(), i);
            
            contrato.getInstallments().add(new Installment(dueDate, fullQuota));
        }

    }
    
    private Date addMonths(Date date, int N){
        
        Calendar calendar=Calendar.getInstance();
        calendar.setTime(date);
        calendar.add(Calendar.MONTH, N);
        
        return calendar.getTime();
    
    
    }

}
