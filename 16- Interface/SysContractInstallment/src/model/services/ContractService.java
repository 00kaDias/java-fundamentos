package model.services;

import java.time.LocalDate;

import model.entities.Contract;
import model.entities.Installment;

public class ContractService {
    private OnlinePaymentService onlinePaymentService;

    public ContractService() {
    }

    public ContractService(OnlinePaymentService onlinePaymentService) {
        this.onlinePaymentService = onlinePaymentService;
    }

public void processContract(Contract contract, int months){
double installmentValue = contract.getTotalValue() / months;
for(int i = 1; i <= months; i++){
    double fee = onlinePaymentService.paymentFee(installmentValue);
    double interestValue = onlinePaymentService.interest(installmentValue, i);
    double amount = installmentValue + fee + interestValue;
    LocalDate dueDate = contract.getContractDate().plusMonths(i);
    Installment installment = new Installment(dueDate, amount);
    contract.getInstallments().add(installment);
}
}

}
