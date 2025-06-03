//Aufgabe 15
class DaemonExample {
    public static void main(String[] args) {
        Thread daemon = new Thread(() -> {
            while (true) {
                System.out.println("Daemon läuft...");
                try { Thread.sleep(500); } catch (InterruptedException e) {}
            }
        });
        daemon.setDaemon(true);
        daemon.start();

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {}

        System.out.println("Hauptthread beendet sich.");
    }
}
