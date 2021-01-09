/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banksystem;

import java.io.BufferedWriter;
import java.io.FileWriter;

/**
 *
 * @author Feri Afrianto
 */
public class WriteFile {

    public static void main(String args[]) {
        try {
            FileWriter fstream = new FileWriter("E:\\SEMESTER 3\\PBO\\Tugas Akhir\\DataBank.txt", true);
            BufferedWriter out = new BufferedWriter(fstream);
            out.write("Line Added on: " + new java.util.Date() + "\n");
            out.close();
        } catch (Exception e) {
            System.err.println("Error while writing to file: "
                    + e.getMessage());
        }
    }
}
