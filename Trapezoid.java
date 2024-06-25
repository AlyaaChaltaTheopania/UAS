import java.io.*;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class Trapezoid {
    public static void main(String[] args) {
        String namafile = "C:\\Ayaa's\\PL\\src\\UAS.txt";
        List<Trapesium> trapesiums = new ArrayList<>();

        try {
            BufferedReader br = new BufferedReader(new FileReader(namafile));
            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {

                String[] hitung = line.split(",");
                Trapesium sisi = new Trapesium();
                sisi.baseA = Double.parseDouble(hitung[0]);
                sisi.baseB = Double.parseDouble(hitung[1]);
                sisi.tinggi = Double.parseDouble(hitung[2]);
                trapesiums.add(sisi);
            }

        } catch (IOException e) {
            System.err.println(e.getMessage());
        }

for (Trapesium t : trapesiums) {
        double luasTrapesium = t.Luas();
        System.out.println("Luas trapesium = " + luasTrapesium);
        }
        for (Trapesium t : trapesiums) {
        double kelilingTrapesium = t.Keliling();
        System.out.println("Keliling trapesium = " + kelilingTrapesium);
        }
        Collections.sort(trapesiums, (t1, t2) -> {
        double keliling1 = t1.Keliling();
        double keliling2 = t2.Keliling();
        if (keliling1 < keliling2) {
        return -1;
        } else if (keliling1 > keliling2) {
        return 1;
        } else {
        return 0;
        }
        });

        System.out.println("\nHasil sorting keliling trapesium:");
        for (Trapesium t : trapesiums) {
        double kelilingTrapesium = t.Keliling();
        System.out.println("Keliling trapesium = " + kelilingTrapesium);
        }
        String filebaru = "C:\\Ayaa's\\PL\\src\\TextSortir.txt";
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filebaru));
            bw.write("Hasil sorting berdasarkan keliling trapesium:\n");
            for (Trapesium t : trapesiums) {
                double kelilingTrapesium = t.Keliling();
                bw.write("Keliling trapesium = " + kelilingTrapesium + "\n");
            }
            bw.close();
            System.out.println("Hasil sorting keliling trapesium telah ditulis ke dalam file: " + filebaru);
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
    }
}
