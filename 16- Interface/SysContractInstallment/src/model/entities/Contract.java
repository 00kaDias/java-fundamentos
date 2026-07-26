package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private int number;
    private LocalDate contractDate;
    private double totalValue;
    List <Installment> installments = new ArrayList<>();

    public Contract() {

    }

    public Contract(int number, LocalDate contractDate, double totalValue) {
        this.number = number;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
    }

    public Contract(int number, LocalDate contractDate, double totalValue, List<Installment> installments) {
        this.number = number;
        this.contractDate = contractDate;
        this.totalValue = totalValue;
        this.installments = installments;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public LocalDate getContractDate() {
        return contractDate;
    }

    public void setContractDate(LocalDate contractDate) {
        this.contractDate = contractDate;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public List<Installment> getInstallments() {
        return installments;
    }

    public void setInstallments(List<Installment> installments) {
        this.installments = installments;
    }
}