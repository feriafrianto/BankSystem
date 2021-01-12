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
public class SetorTunaiTeller extends Transaction {
    private int nominal;
    

    public SetorTunaiTeller(int userAccountNumber, NasabahData atmNasabahData, int nominal) {
        super(userAccountNumber, atmNasabahData);
        this.nominal = nominal;
    }

    @Override
    public void execute() {
        NasabahData nasabahData = getNasabahData();
        int cek = 0;
        int i;
        String NoRek = Integer.toString(getAccountNumber());
        
        for (i = 0; i < nasabahData.getLine().length; i++) {
            if (nasabahData.getArrTabungan()[i] != null) {
                if (NoRek.equals(nasabahData.getArrTabungan()[i].getNoAccount())) {
                    cek++;
                    int saldo = nasabahData.getArrTabungan()[i].getSaldo() + nominal;
                    nasabahData.getArrTabungan()[i].setSaldo(saldo);
                    JOptionPane.showMessageDialog(null, "Setor Tunai Telah Berhasil");
                    nasabahData.exportData();
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nasabah Belum Terdaftar");
                break;
            }
        }  
    }
}
