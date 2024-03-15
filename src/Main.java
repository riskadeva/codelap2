 import java.util.Scanner;

 class Mahasiswa
 {
    String nama;
    long nim;
    String jurusan;

    // Constructor
    public Mahasiswa(String nama, long nim, String jurusan){
        this.nama = nama;
        this.nim = nim;
        this.jurusan = jurusan;
    }

    public static String tampilUniversitas() {
        return "Universitas";
    }

    public String tampilDataMahasiswa() {
        return "Nama: " + nama + "\nNIM: " + nim + "\nJurusan: " + jurusan;
    }


    public class Main {
        public static void main(String[] args) {
            Scanner xinput = new Scanner(System.in);
            Mahasiswa mahasiswa = null;

            int pilihan = 0;

            do {
                System.out.println("\nMenu:");
                System.out.println("1. Tambah Data Mahasiswa");
                System.out.println("2. Tampilkan Data Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Pilih menu (1-3): ");

                if (xinput.hasNextInt()) {
                    pilihan = xinput.nextInt();
                    switch (pilihan) {
                        case 1:
                            mahasiswa = tambahDataMahasiswa(xinput);
                            break;
                        case 2:
                            tampilkanDataMahasiswa(mahasiswa);
                            break;
                        case 3:
                            System.out.println("Keluar. Terima kasih!");
                            break;
                        default:
                            System.out.println("Pilihan tidak valid. Silakan pilih lagi.");
                            break;
                    }
                } else {
                    System.out.println("Masukkan angka sebagai pilihan menu.");
                    xinput.next(); // Membersihkan buffer
                }
            } while (pilihan != 3);

            xinput.close();
        }

        private static Mahasiswa tambahDataMahasiswa(Scanner xinput) {
            System.out.print("Masukkan nama mahasiswa: ");
            xinput.nextLine(); // Membersihkan buffer
            String xnama = xinput.nextLine();

            long nim;
            do {
                System.out.print("Masukkan NIM mahasiswa (15 digit): ");
                while (!xinput.hasNextLong()) {
                    System.out.println("NIM harus berupa angka.");
                    xinput.next(); // Membersihkan buffer
                }
                nim = xinput.nextLong();
            } while (String.valueOf(nim).length() != 15);

            xinput.nextLine(); // Membersihkan buffer
            System.out.print("Masukkan jurusan mahasiswa: ");
            String jurusan = xinput.nextLine();

            return new Mahasiswa(xnama, nim, jurusan);
        }

        static void tampilkanDataMahasiswa(Mahasiswa mahasiswa) {
            if (mahasiswa != null) {
                System.out.println("Universitas: " + Mahasiswa.tampilUniversitas());
                System.out.println("\nDetail Mahasiswa:\n" + mahasiswa.tampilDataMahasiswa());
            } else {
                System.out.println("Data mahasiswa belum ditambahkan.");
            }
        }
    }
}
