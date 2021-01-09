/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perbankan;

import javax.swing.JOptionPane;

/**
 *
 * @author Feri Afrianto
 */
public class TarikTunai extends Transaction {
    private int ambil;

    public TarikTunai(int userAccountNumber, NasabahData atmNasabahData, int ambil) {
        super(userAccountNumber, atmNasabahData);
        this.ambil = ambil;
    }

    @Override
    public void execute() {
        NasabahData nasabahData = getNasabahData();
        System.out.println(""+nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getType());
        if (ambil < nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo()) {
            int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() - ambil;
            System.out.println(""+saldo);
            nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
//            //exportData();
        } else {
           JOptionPane.showMessageDialog(null, "Maaf saldo anda tidak mencukupi");
        }
    }

}
