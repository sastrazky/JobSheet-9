import java.util.Scanner;

public class SuratDemo20 {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        StackSurat20 stackSurat = new StackSurat20(10);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Terima Surat Izin");
            System.out.println("2. Proses Surat Izin");
            System.out.println("3. Lihat Surat Izin Terakhir");
            System.out.println("4. Cari Surat Izin berdasarkan Nama");
            System.out.println("5. Lihat Semua Surat Izin");
            System.out.println("6. Keluar");
            System.out.print("Pilih: ");
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("ID Surat: ");
                    String idSurat = scan.nextLine();
                    System.out.print("Nama Mahasiswa: ");
                    String nama = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    System.out.print("Jenis Izin (S/I): ");
                    char jenis = scan.next().charAt(0);
                    System.out.print("Durasi (hari): ");
                    int durasi = scan.nextInt();

                    Surat20 surat = new Surat20(idSurat, nama, kelas, jenis, durasi);
                    stackSurat.push(surat);
                    System.out.println("Surat izin dari " + nama + " telah diterima.");
                    break;

                case 2:
                    Surat20 diproses = stackSurat.pop();
                    if (diproses != null) {
                        System.out.println("\nMemproses Surat Izin:");
                        diproses.tampilkanSurat();
                    }
                    break;

                case 3:
                    Surat20 terakhir = stackSurat.peek();
                    if (terakhir != null) {
                        System.out.println("\nSurat Izin Terakhir:");
                        terakhir.tampilkanSurat();
                    }
                    break;

                case 4:
                    System.out.print("Masukkan Nama Mahasiswa: ");
                    String cariNama = scan.nextLine();
                    if (stackSurat.cariSurat(cariNama)) {
                        System.out.println("Surat izin dari " + cariNama + " ditemukan.");
                    } else {
                        System.out.println("Tidak ada surat izin dari " + cariNama + ".");
                    }
                    break;

                case 5:
                    stackSurat.printAllSurat();
                    break;

                case 6:
                    System.out.println("Keluar dari program.");
                    break;

                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilih != 6);

        scan.close();
    }
}