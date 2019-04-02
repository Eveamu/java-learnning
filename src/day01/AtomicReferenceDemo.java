package day01;

import java.util.concurrent.atomic.AtomicReference;

public class AtomicReferenceDemo {
    public final static AtomicReference<String> atomicStr = new AtomicReference<>("abc");

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            final int num = i;
            new Thread(() -> {
                try {
                    Thread.sleep(Math.abs((int) (Math.random() * 100)));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                if (atomicStr.compareAndSet("abc", "def")) {
                    System.out.println("Thread" + Thread.currentThread().getId() + "change success");
                } else {
                    System.out.println("Thread" + Thread.currentThread().getId() + " failed");
                }
            }).start();
        }
    }

}
