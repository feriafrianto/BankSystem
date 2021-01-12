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
public class TarikTunaiTeller extends Transaction {
    private int ambil;
    

    public TarikTunaiTeller(int userAccountNumber, NasabahData atmNasabahData, int ambil) {
        super(userAccountNumber, atmNasabahData);
        this.ambil = ambil;
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
                    if (ambil < nasabahData.getArrTabungan()[i].getSaldo()) {
                        int saldo = nasabahData.getArrTabungan()[i].getSaldo() - ambil;
                        System.out.println(""+saldo);
                        nasabahData.getArrTabungan()[i].setSaldo(saldo);
                        JOptionPane.showMessageDialog(null, "Tarik Tunai Telah Berhasil");
                        nasabahData.exportData();
                    } else {
                       JOptionPane.showMessageDialog(null, "Maaf saldo anda tidak mencukupi");
                    }
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nasabah Dengan ID " + NoRek + "Belum Terdaftar");
                break;
            }
        }   
    }
}
