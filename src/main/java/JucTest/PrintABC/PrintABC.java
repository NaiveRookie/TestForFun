package JucTest.PrintABC;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author coolestyue
 * 三个线程循环交替打印ABC10次  condition实现
 */
public class PrintABC {
    private static Lock lock = new ReentrantLock();
    private static Condition A = lock.newCondition();
    private static Condition B = lock.newCondition();
    private static Condition C = lock.newCondition();
    public static volatile int index = 0; // 当前
    // num个线程
    public static int num = 3;

    public static class PrinterA implements Runnable {

        @Override
        public void run() {
            // 每个线程打印10
            lock.lock();
            for (int i = 0; i < 10; i++) {
                // 自旋
                while (index % num != 0) {
                    try {
                        A.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("A");
                index++;
                B.signal();
            }
            lock.unlock();
        }
    }
    public static class PrinterB implements Runnable {

        @Override
        public void run() {
            // 每个线程打印10
            lock.lock();
            for (int i = 0; i < 10; i++) {
                // 自旋
                while (index % num != 1) {
                    try {
                        B.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("b");
                index++;
                C.signal();
            }
            lock.unlock();
        }
    }
    public static class PrinterC implements Runnable {

        @Override
        public void run() {
            // 每个线程打印10
            lock.lock();
            for (int i = 0; i < 10; i++) {
                // 自旋
                while (index % num != 2) {
                    try {
                        C.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println("C");
                index++;
                A.signal();
            }
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        new Thread(new PrinterA(), "线程A").start();
        new Thread(new PrinterB(), "线程B").start();
        new Thread(new PrinterC(), "线程C").start();
    }
}
