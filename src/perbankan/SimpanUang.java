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
public class SimpanUang extends Transaction {
    private int addUang;

    public SimpanUang(int userAccountNumber, NasabahData atmNasabahData, int addUang) {
        super(userAccountNumber, atmNasabahData);
        this.addUang = addUang;
    }
    @Override
    public void execute() {
        NasabahData nasabahData = getNasabahData();
        int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() + addUang;
        nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
        nasabahData.exportData();
    }
    
}
