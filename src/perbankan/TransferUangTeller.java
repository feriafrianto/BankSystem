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
public class TransferUangTeller extends Transaction {
    private int TujuanRek;
    private int nominal;
    

    public TransferUangTeller(int userAccountNumber, NasabahData atmNasabahData,int tujuan,int nominal) {
        super(userAccountNumber, atmNasabahData);
        this.nominal = nominal;
        this.TujuanRek = tujuan;
    }

    @Override
    public void execute() {
           NasabahData nasabahData = getNasabahData();
        int cekNoAccount = 1;
        int cekTujuan = 1;
        int i;
        String rekTujuan = Integer.toString(TujuanRek);
        String No = Integer.toString(getAccountNumber());
        
        for (i = 0; i < nasabahData.getLine().length; i++) {
            if (nasabahData.getArrTabungan()[i] != null) {
                if (No.equals(nasabahData.getArrTabungan()[i].getNoAccount())) {
                    cekNoAccount++;
                    break;
                }
            }
        }
        System.out.println(""+nasabahData.getArrTabungan()[cekNoAccount].getNoAccount());
        
        for (i = 0; i < nasabahData.getLine().length; i++) {
            if (nasabahData.getArrTabungan()[i] != null) {
                if (rekTujuan.equals(nasabahData.getArrTabungan()[i].getNoAccount())) {
                    cekTujuan++;
                    System.out.println(""+nasabahData.getArrTabungan()[cekNoAccount].getSaldo());
                    if (JOptionPane.showConfirmDialog(null, "Nama : " + nasabahData.getArrTabungan()[i].getNama() + "\nID Tabungan : " + nasabahData.getArrTabungan()[i].getNoAccount() + "\nJumlah Transfer : " + nominal + "\n", "info",
                            JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                        if (nominal < nasabahData.getArrTabungan()[cekNoAccount].getSaldo()) {
                            int saldo = nasabahData.getArrTabungan()[cekNoAccount].getSaldo() - nominal;
                            int saldodesc = nasabahData.getArrTabungan()[i].getSaldo() + nominal;
                            nasabahData.getArrTabungan()[cekNoAccount].setSaldo(saldo);
                            nasabahData.getArrTabungan()[i].setSaldo(saldodesc);
                            JOptionPane.showMessageDialog(null, "Transfer Terhadap " + nasabahData.getArrTabungan()[i].getNama() + " Telah Berhasil");
                        } else {
                            JOptionPane.showMessageDialog(null, "maaf anda salah memasukan nominal");
                        }
                    } else {
                        JOptionPane.showMessageDialog(null, "Transfer Terhadap " + nasabahData.getArrTabungan()[i].getNama() + " Telah Anda Batalkan");
                        return;
                    }
                    break;
                }
            } else {
                JOptionPane.showMessageDialog(null, "Nasabah Belum Terdaftar");
                break;
            }
        }
        nasabahData.exportData();
    }
}
