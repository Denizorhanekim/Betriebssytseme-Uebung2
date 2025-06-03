//Aufgabe 14


class WaitNotifyExample {
    static boolean ready = false;

    public static void main(String[] args) {
        Object lock = new Object();

        Thread waiter = new Thread(() -> {
            synchronized (lock) {
                while (!ready) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {}
                }
                System.out.println("Thread wurde geweckt!");
            }
        });

        Thread notifier = new Thread(() -> {
            synchronized (lock) {
                ready = true;
                lock.notify();
                System.out.println("Thread wurde benachrichtigt.");
            }
        });

        waiter.start();
        try { Thread.sleep(1000); } catch (InterruptedException e) {}
        notifier.start();
    }
}
