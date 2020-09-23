/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.services;

/**
 *
 * @author faust
 */
public class PaypalService implements OnlinePaymentService{
    
    //Escrever as constantes das percentagens
    
    private static final double PAYMENT_FEE=0.02;
    private static final double MONTHLY_INTEREST=0.01;

    @Override
    public double paymentFee(double amount) {
        return amount*PAYMENT_FEE;
    }

    @Override
    public double interest(double amount, int months) {
        return amount*months*MONTHLY_INTEREST;
    }
    
}
