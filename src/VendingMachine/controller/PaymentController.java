package VendingMachine.controller;

import VendingMachine.Dto.TransactionDTO;
import VendingMachine.domain.Transaction;
import VendingMachine.service.PaymentService;

public class PaymentController {

    private PaymentService paymentService ;


    public TransactionDTO processPayment(TransactionDTO transactionDTO){

        return paymentService.processPayment(transactionDTO);
    }
}
