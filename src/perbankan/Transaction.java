/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perbankan;

/**
 *
 * @author Feri Afrianto
 */
public abstract class Transaction {

    private int accountNumber;
    private NasabahData nasabahData;

    public Transaction(int userAccountNumber, NasabahData atmNasabahData) {
        accountNumber = userAccountNumber;
        nasabahData = atmNasabahData;
    }

    public int getAccountNumber() {
        return accountNumber;
    }

    public NasabahData getNasabahData() {
        return nasabahData;
    }

    abstract public void execute();
}
