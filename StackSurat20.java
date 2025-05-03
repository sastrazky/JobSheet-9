public class StackSurat20 {
    Surat20[] stack;
    int top;
    int size;

    public StackSurat20(int size) {
        this.size = size;
        stack = new Surat20[size];
        top = -1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public boolean isFull() {
        return top == size - 1;
    }

    public void push(Surat20 surat) {
        if (!isFull()) {
            stack[++top] = surat;
        } else {
            System.out.println("Stack penuh! Tidak bisa menambahkan surat lagi.");
        }
    }

    public Surat20 pop() {
        if (!isEmpty()) {
            return stack[top--];
        } else {
            System.out.println("Stack kosong! Tidak ada surat izin untuk diproses.");
            return null;
        }
    }

    public Surat20 peek() {
        if (!isEmpty()) {
            return stack[top];
        } else {
            System.out.println("Stack kosong! Tidak ada surat terakhir.");
            return null;
        }
    }

    public boolean cariSurat(String nama) {
        for (int i = 0; i <= top; i++) {
            if (stack[i].namaMahasiswa.equalsIgnoreCase(nama)) {
                return true;
            }
        }
        return false;
    }

    public void printAllSurat() {
        if (!isEmpty()) {
            System.out.println("\nDaftar Surat Izin:");
            for (int i = 0; i <= top; i++) {
                stack[i].tampilkanSurat();
                System.out.println("---------------------------");
            }
        } else {
            System.out.println("Stack kosong! Tidak ada surat yang tersimpan.");
        }
    }
}