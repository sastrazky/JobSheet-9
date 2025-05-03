import java.util.Scanner;

public class MahasiswaDemo20 {
    public static void main(String[] args) {
        StackTugasMahasiswa20 stack = new StackTugasMahasiswa20(5);
        Scanner scan = new Scanner(System.in);
        int pilih;

        do {
            System.out.println("\nMenu:");
            System.out.println("1. Mengumpulkan Tugas");
            System.out.println("2. Menilai Tugas");
            System.out.println("3. Melihat Tugas Teratas");
            System.out.println("4. Melihat Daftar Tugas");
            System.out.println("5. Hitung Jumlah Tugas Yg Sudah Dikumpulkan");
            System.out.print("Pilih: "); 
            pilih = scan.nextInt();
            scan.nextLine();

            switch (pilih) {
                case 1:
                    System.out.print("Nama: ");
                    String nama = scan.nextLine();
                    System.out.print("NIM: ");
                    String nim = scan.nextLine();
                    System.out.print("Kelas: ");
                    String kelas = scan.nextLine();
                    Mahasiswa20 mhs = new Mahasiswa20(nama, nim, kelas);
                    stack.push(mhs);
                    System.out.printf("Tugas %s berhasil dikumpulkan \n", mhs.nama);
                    break;
                case 2:
                    Mahasiswa20 dinilai = stack.pop();
                    if (dinilai != null) {
                        System.out.println("Menilai tugas dari " + dinilai.nama);
                        System.out.print("Masukkan nilai (0-100): ");
                        int nilai = scan.nextInt();
                        dinilai.tugasDinilai(nilai);
                        System.out.printf("Nilai Tugas %s adalah %d\n", dinilai.nama, nilai);
                        String biner = stack.konversiDesimalKeBiner(nilai);
                        System.out.println("Nilai Biner Tugas: " + biner);
                    } else {
                        System.out.println("Tidak ada tugas untuk dinilai.");
                    }
                    break;
                case 3:
                    Mahasiswa20 lihat = stack.peek();
                    if (lihat != null) {
                        System.out.println("Tugas terakhir dikumpulkan oleh " + lihat.nama);
                    } else {
                        System.out.println("Tidak ada tugas dalam daftar.");
                    }
                    break;
                case 4:
                    System.out.println("Daftar semua tugas");
                    stack.print();
                    break;
                case 5:
                    System.out.println("Jumlah tugas yang sudah dikumpulkan: " + stack.countTasks());
                    break;
                default:
                System.out.println("Pilihan tidak valid."); 
            }
        } while (pilih >= 1 && pilih <= 4);

        Mahasiswa20 tugasPertama = stack.lihatTugasTerbawah();
        if (tugasPertama != null) {
            System.out.println("Mahasiswa pertama yang mengumpulkan tugas: " + tugasPertama.nama + " - " + tugasPertama.nim);
        }

        scan.close(); 
    }
}