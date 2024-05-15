import java.util.Scanner;

public class HeapDemo {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        MinHeap<WorkOrder> q = new MinHeap<>();
        
        while (true) {
            System.out.println("1. Simpan Tugas");
            System.out.println("2. Tampilkan Tugas");
            System.out.println("3. Selesai Tugas");
            System.out.println("4. Hapus semua tugas");
            System.out.println("5. Keluar");
            int choice = s.nextInt(); s.nextLine();

            switch (choice) {
                case 1:
                    System.out.println("Masukkan tugas:");
                    String tugas = s.nextLine();
                    System.out.println("Masukkan prioritas:");
                    int prioritas = s.nextInt();

                    q.add(new WorkOrder(prioritas, tugas));
                    
                    System.out.println(tugas + " berhasil ditambahkan");
                    break;
                case 2:
                    System.out.println("Task terdekat yang harus diselesaikan: " + q.peek().getDescription());
                    break;
                case 3:
                    System.out.println(q.remove().getDescription() + " selesai dilaksanakan, berikutnya " + q.peek().getDescription());
                    break;
                case 4:
                    while (q.size() > 0) {
                        q.remove();
                    }
                    System.out.println("Semua tugas berhasil dihapus");
                    break;
                case 5:
                    System.exit(0);
            }
        }
    }
}
