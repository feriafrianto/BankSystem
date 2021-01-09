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
public class Nasabah {

    private String noAccount;
    private String pin;
    private String nama;
    private int saldo;
    private String type;

    public Nasabah(String noAccount,String pin,String nama, int saldo,String type) {
        setNoAccount(noAccount);
        setPin(pin);
        setNama(nama);
        setSaldo(saldo);
        setType(type);
    }

    public String getNoAccount() {
        return noAccount;
    }

    public void setNoAccount(String noAccount) {
        this.noAccount = noAccount;
    }
    
    public String getPin() {
        return pin;
    }

    public void setPin(String pin) {
        this.pin = pin;
    }
    
    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getSaldo() {
        return saldo;
    }

    public void setSaldo(int saldo) {
        this.saldo = saldo;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
