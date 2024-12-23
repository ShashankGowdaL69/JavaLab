class SharedResource {
    synchronized void method1(SharedResource other) {
        System.out.println(Thread.currentThread().getName() + " is executing method1");
        try { Thread.sleep(100); } catch (InterruptedException e) {}
        other.method2(this);
    }

    synchronized void method2(SharedResource other) {
        System.out.println(Thread.currentThread().getName() + " is executing method2");
    }
}

public class javalab10 {
    public static void main(String[] args) {
        SharedResource resource1 = new SharedResource();
        SharedResource resource2 = new SharedResource();

        Thread t1 = new Thread(() -> resource1.method1(resource2), "Thread-1");
        Thread t2 = new Thread(() -> resource2.method1(resource1), "Thread-2");

        t1.start();
        t2.start();
    }
}
