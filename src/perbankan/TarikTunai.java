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
        if (ambil < nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo()) {
            if(("Platinum").equals(nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getType()) && ambil <= 20000000){
                int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() - ambil;
                System.out.println(""+saldo);
                nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
                JOptionPane.showMessageDialog(null, "Penarikan Tunai Telah Berhasil");
                nasabahData.exportData();
            }
            else if(("Gold").equals(nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getType()) && ambil <= 10000000){
                int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() - ambil;
                System.out.println(""+saldo);
                nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
                JOptionPane.showMessageDialog(null, "Penarikan Tunai Telah Berhasil");
                nasabahData.exportData();
            }else if(("Silver").equals(nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getType()) && ambil <= 5000000){
                int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() - ambil;
                System.out.println(""+saldo);
                nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
                JOptionPane.showMessageDialog(null, "Penarikan Tunai Telah Berhasil");
                nasabahData.exportData();
            }
            else {
                JOptionPane.showMessageDialog(null, "Penarikan Tunai Gagal !! Akun mencapai Limit ");
            }
        } else {
           JOptionPane.showMessageDialog(null, "Maaf saldo anda tidak mencukupi");
        }
    }

}
