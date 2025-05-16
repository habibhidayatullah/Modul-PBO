
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ManajemenStok {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        daftarBarang.add(new Barang("Pensil", 50));
        daftarBarang.add(new Barang("Buku", 25));

        boolean jalan = true;

        while (jalan) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilihan: ");

            try {
                int pilihan = scanner.nextInt();
                scanner.nextLine();

                switch (pilihan) {
                    case 1:
                        System.out.print("Nama Barang: ");
                        String nama = scanner.nextLine();
                        System.out.print("Stok Awal: ");
                        int stok = scanner.nextInt();
                        scanner.nextLine();
                        daftarBarang.add(new Barang(nama, stok));
                        System.out.println("Barang berhasil ditambahkan.");
                        break;

                    case 2:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                        } else {
                            System.out.println("Daftar Barang:");
                            for (Barang barang : daftarBarang) {
                                System.out.println("- " + barang.getNama() + " | Stok: " + barang.getStok());
                            }
                        }
                        break;

                    case 3:
                        if (daftarBarang.isEmpty()) {
                            System.out.println("Stok barang kosong.");
                            break;
                        }
                        for (int i = 0; i < daftarBarang.size(); i++) {
                            System.out.println(i + ". " + daftarBarang.get(i).getNama() + " | Stok: " + daftarBarang.get(i).getStok());
                        }
                        System.out.print("Pilih indeks barang: ");
                        int indeks = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Jumlah yang dikurangi: ");
                        int jumlah = scanner.nextInt();
                        scanner.nextLine();

                        try {
                            Barang barang = daftarBarang.get(indeks);
                            if (jumlah > barang.getStok()) {
                                throw new StokTidakCukupException("Stok untuk " + barang.getNama() + " hanya tersisa " + barang.getStok());
                            }
                            barang.setStok(barang.getStok() - jumlah);
                            System.out.println("Stok berhasil dikurangi.");
                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("Indeks tidak valid.");
                        } catch (StokTidakCukupException e) {
                            System.out.println("Error: " + e.getMessage());
                        }
                        break;

                    case 0:
                        jalan = false;
                        System.out.println("Terima kasih!");
                        break;

                    default:
                        System.out.println("Pilihan tidak tersedia.");
                }

            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
            }
        }

        scanner.close();
    }
}
