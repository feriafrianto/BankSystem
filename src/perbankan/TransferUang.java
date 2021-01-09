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
public class TransferUang extends Transaction {
    private String descNoAccount;
    private int transUang;
    
    public TransferUang(int userAccountNumber, NasabahData atmNasabahData, String desc,int tUang) {
        super(userAccountNumber, atmNasabahData);
        this.descNoAccount = desc;
        this.transUang = tUang;
    }
    
    @Override
    public void execute() {
        NasabahData nasabahData = getNasabahData();
        int cek = 0;
        int i;

        for (i = 0; i < nasabahData.getLine().length; i++) {
            if (nasabahData.getArrTabungan()[i] != null) {
                if (descNoAccount.equals(nasabahData.getArrTabungan()[i].getNoAccount())) {
                    cek++;
                    String menu = JOptionPane.showInputDialog("Nama : " + nasabahData.getArrTabungan()[i].getNama() + "\nID Tabungan : " + nasabahData.getArrTabungan()[i].getNoAccount() + "\nJumlah Transfer : " + transUang + "\n1> Lanjut. 0> Batal");
                    if (menu.equals("1")) {
                        if (transUang < nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo()) {
                            int saldo = nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].getSaldo() - transUang;
                            int saldodesc = nasabahData.getArrTabungan()[i].getSaldo() + transUang;
                            nasabahData.getArrTabungan()[nasabahData.getCurrentAccount()].setSaldo(saldo);
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
                JOptionPane.showMessageDialog(null, "Nasabah Dengan ID " + descNoAccount + "Belum Terdaftar");
                break;
            }
        }
    }
    
}
