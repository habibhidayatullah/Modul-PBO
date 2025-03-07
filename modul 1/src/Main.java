import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Program Login Sederhana ===");
        System.out.println("Pilih Jenis Pengguna:");
        System.out.println("1. Admin");
        System.out.println("2. Mahasiswa");
        System.out.print("Masukkan pilihan (1/2): ");

        int pilihan = scanner.nextInt();
        scanner.nextLine(); // Membuang newline agar tidak terbaca saat input berikutnya

        String username, password;

        // Input username & password
        System.out.print("Masukkan Username: ");
        username = scanner.nextLine();

        System.out.print("Masukkan Password: ");
        password = scanner.nextLine();

        // Proses Login
        if (pilihan == 1) {
            if (username.equals("admin") && password.equals("admin123")) {
                System.out.println("Login berhasil sebagai Admin!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else if (pilihan == 2) {
            if (username.equals("mahasiswa") && password.equals("mhs123")) {
                System.out.println("Login berhasil sebagai Mahasiswa!");
            } else {
                System.out.println("Login gagal! Username atau password salah.");
            }
        } else {
            System.out.println("Pilihan tidak valid!");
        }

        scanner.close();
    }
}