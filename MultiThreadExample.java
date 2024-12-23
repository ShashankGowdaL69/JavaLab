public class MultiThreadExample {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            while (true) {
                System.out.println("BMS College of Engineering");
                try { Thread.sleep(10000); } catch (InterruptedException e) {}
            }
        });
        Thread t2 = new Thread(() -> {
            while (true) {
                System.out.println("CSE");
                try { Thread.sleep(2000); } catch (InterruptedException e) {}
            }
        });
        t1.start();
        t2.start();
    }
}
