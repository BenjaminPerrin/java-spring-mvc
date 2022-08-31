package fr.m2i.javaspringmvc.form;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class UserForm {
    @Min(value=1,message = "Enter valide balance")
    @NotNull(message = "The field is mandatory")
    private Double balance;

    public Double getBalance() {
        return balance;
    }

    public void setBalance(Double balance) {
        this.balance = balance;
    }

    

}
