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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Feri Afrianto
 */
public class NasabahData {

    private static Nasabah[] arrTabungan;
    private static String[] line;
    private static int newUser;
    private static int currentAccount = 0;
    String file = "E:\\SEMESTER 3\\PBO\\Tugas Akhir\\BankSystem\\src\\banksystem\\DataBank.txt";

    public NasabahData() {
        try {
            readFile(file);
            arrTabungan = new Nasabah[10];
            for (int i = 0; i < line.length; i++) {
                if (line[i] == null) {
                    newUser = i;
                    break;
                }
                arrTabungan[i] = new Nasabah(getLine()[i].split("/")[0], getLine()[i].split("/")[1],
                        getLine()[i].split("/")[2], Integer.parseInt(getLine()[i].split("/")[3]),
                        getLine()[i].split("/")[4]);
            }
        } catch (IOException ex) {
            Logger.getLogger(NasabahData.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public String[] getLine() {
        return line;
    }

    public void setLine(String[] line) {
        this.line = line;
    }

    public Nasabah[] getArrTabungan() {
        return arrTabungan;
    }

    public void setArrTabungan(Nasabah[] tab) {
        this.arrTabungan = tab;
    }

    public int getCurrentAccount() {
        return currentAccount;
    }

    public void setCurrentAccount(int currentaccount) {
        this.currentAccount = currentaccount;
    }

    public void readFile(String file) throws FileNotFoundException, IOException {
        BufferedReader reader;
        File f;
        setLine(new String[10]);
        f = new File(file);
        reader = new BufferedReader(new FileReader(f));
        int i = 0;
        while (true) {
            getLine()[i] = reader.readLine();
            if (getLine()[i] == null) {
                break;
            }
            i++;
        }
    }

    public boolean validasiLogin(String noAccount, String pinLogin) {
        for (int i = 0; i < getLine().length; i++) {
            if (getLine()[i] == null) {
                break;
            }
            String no = getArrTabungan()[i].getNoAccount();
            String pin = getArrTabungan()[i].getPin();
            if (noAccount.equals(no) && pinLogin.equals(pin)) {
                setCurrentAccount(i);
                return true;
            }
        }
        return false;
    }

    public String getNamaNasabah() {
        return getArrTabungan()[getCurrentAccount()].getNama();
    }

    public int getSaldo() {
        return getArrTabungan()[getCurrentAccount()].getSaldo();
    }

    public static void addAccount(String noAccount, String pin, String nama, int saldo, String type) {
        arrTabungan[newUser] = new Nasabah(noAccount, pin, nama, saldo, type);
        newUser++;
    }

    public void exportData() {
        try {
            FileWriter writer = new FileWriter(file);
            for (int i = 0; i < newUser; i++) {
                writer.write(getArrTabungan()[i].getNoAccount() + "/" + getArrTabungan()[i].getPin() + "/" + getArrTabungan()[i].getNama() + "/" + getArrTabungan()[i].getSaldo() + "/" + getArrTabungan()[i].getType());
                writer.write("\n");   // write new line
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
