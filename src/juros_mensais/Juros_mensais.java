/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juros_mensais;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Scanner;
import model.entities.Contrato;
import model.entities.Installment;
import model.services.ContractService;
import model.services.OnlinePaymentService;
import model.services.PaypalService;

/**
 *
 * @author faust
 */
public class Juros_mensais {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws ParseException {
        // TODO code application logic here
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Contract Data:");
        System.out.print("Number: ");
        Integer number = sc.nextInt();
        System.out.print("Date (dd/MM/yyyy): ");
        Date date = sdf.parse(sc.next());
        System.out.print("Contract Value: ");
        Double totalvalue = sc.nextDouble();
        System.out.print("Enter number of installments: ");
        int N = sc.nextInt();

        Contrato contrato = new Contrato(number, date, totalvalue);

        ContractService cs = new ContractService(new PaypalService());
        cs.porcessContract(contrato, N);
        System.out.println("Instalments: ");
        for (Installment it : contrato.getInstallments()) {
            System.out.println(it);

        }

    }

}
