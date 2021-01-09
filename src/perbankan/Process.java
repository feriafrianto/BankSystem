/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package perbankan;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JOptionPane;

/**
 *
 * @author Feri Afrianto
 */
public final class Process {

//    private static Nasabah tabungan;
//    private static Nasabah[] arrTabungan;
//    private static String[] line;
//    private static int currentAccount = 0;
//    String file = "E:\\SEMESTER 3\\PBO\\Tugas Akhir\\BankSystem\\src\\banksystem\\DataBank.txt";
//
//    public Nasabah getTabungan() {
//        return tabungan;
//    }
//
//    public void setTabungan(Nasabah tabungan) {
//        this.tabungan = tabungan;
//    }
//
//    public String[] getLine() {
//        return line;
//    }
//
//    public void setLine(String[] line) {
//        this.line = line;
//    }
//
//    public Nasabah[] getArrTabungan() {
//        return arrTabungan;
//    }
//
//    public void setArrTabungan(Nasabah[] tab) {
//        this.arrTabungan = tab;
//    }
//
//    public int getCurrentAccount() {
//        return currentAccount;
//    }
//
//    public void setCurrentAccount(int currentaccount) {
//        this.currentAccount = currentaccount;
//    }
//
//    public Process() throws FileNotFoundException, IOException {
//        readFile(file);
//        arrTabungan = new Nasabah[10];
//        for (int i = 0; i < line.length; i++) {
//            if (line[i] == null) {
//                break;
//            }
//            arrTabungan[i] = new Nasabah();
//            arrTabungan[i].setNoAccount(getLine()[i].split("/")[0]);
//            arrTabungan[i].setNama(getLine()[i].split("/")[1]);
//            arrTabungan[i].getTabungan().setPassword(getLine()[i].split("/")[2]);
//            arrTabungan[i].getTabungan().setSaldo(Integer.parseInt(getLine()[i].split("/")[3]));
//        }
//    }
//
//    public void readFile(String file) throws FileNotFoundException, IOException {
//        BufferedReader reader;
//        File f;
//        setLine(new String[10]);
//        f = new File(file);
//        reader = new BufferedReader(new FileReader(f));
//        int i = 0;
//        while (true) {
//            getLine()[i] = reader.readLine();
//            if (getLine()[i] == null) {
//                break;
//            }
//            i++;
//        }
//    }
//
//    public boolean validasiLogin(String noAccount, String password) {
//        for (int i = 0; i < getLine().length; i++) {
//            if (getLine()[i] == null) {
//                break;
//            }
//            String no = getArrTabungan()[i].getTabungan().getNoAccount();
//            String pass = getArrTabungan()[i].getTabungan().getPassword();
//            if (noAccount.equals(no) && password.equals(pass)) {
//                setCurrentAccount(i);
//                return true;
//            }
//        }
//        return false;
//    }
//
//    public String namaNasabah() {
//        return getArrTabungan()[getCurrentAccount()].getNama();
//    }
//
//    public int getSaldo() {
//        return getArrTabungan()[getCurrentAccount()].getTabungan().getSaldo();
//    }
//
//    public void tarikUang(int ambil) {
//        if (ambil < getArrTabungan()[getCurrentAccount()].getTabungan().getSaldo()) {
//            int saldo = getArrTabungan()[getCurrentAccount()].getTabungan().getSaldo() - ambil;
//            getArrTabungan()[getCurrentAccount()].getTabungan().setSaldo(saldo);
//            //exportData();
//        } else {
//            JOptionPane.showMessageDialog(null, "Maaf saldo anda tidak mencukupi");
//        }
//    }

//    public void exportData() {
//        try {
//            FileWriter writer = new FileWriter(file);
//            for (int i = 0; i < line.length; i++) {
//                if (line[i] == null) {
//                    break;
//                }
//                writer.write(getArrTabungan()[i].getTabungan().getNoAccount()+ "/" + getArrTabungan()[i].getNama() + "/" + getArrTabungan()[i].getTabungan().getPassword() + "/"+getArrTabungan()[i].getTabungan().getSaldo());
//                writer.write("\n");   // write new line
//            }
//            writer.close();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
//
//    public void simpanuang(int simpan) {
//        int saldo = getTab()[getCurrentId()].getTabungan().getSaldo() + simpan;
//        getTab()[getCurrentId()].getTabungan().setSaldo(saldo);
//    }
//
//    public void transfer(String tran) {
//        StringTokenizer st = new StringTokenizer(tran);
//        String id = st.nextToken();
//        int uangTran = Integer.parseInt(st.nextToken());
//        int cek = 0;
//        int i;
//
//        for (i = 0; i < line.length; i++) {
//            if (tab[i] != null) {
//                if (id.equals(tab[i].getTabungan().getIdTabungan())) {
//                    cek++;
//                    String inpMenu = JOptionPane.showInputDialog("Nama : " + tab[i].getNama() + "\nID Tabungan : " + tab[i].getTabungan().getIdTabungan() + "\nJumlah Transfer : " + uangTran + "\n1> Lanjut. 0> Batal");
//                    if (inpMenu.equals("1")) {
//                        if (uangTran < getTab()[getCurrentId()].getTabungan().getSaldo()) {
//                            int saldo = tab[currentId].getTabungan().getSaldo() - uangTran;
//                            tab[currentId].getTabungan().setSaldo(saldo);
//                        } else {
//                            JOptionPane.showMessageDialog(null, "maaf anda salah memasukan nominal");
//                        }
//                    } else {
//                        JOptionPane.showMessageDialog(null, "Transfer Terhadap " + tab[i].getNama() + " Telah Anda Batalkan");
//                        return;
//                    }
//                    break;
//                }
//            } else {
//                JOptionPane.showMessageDialog(null, "Nasabah Dengan ID " + id + "Belum Terdaftar");
//                break;
//            }
//        }
//    }
}
