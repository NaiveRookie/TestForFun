package JucTest.PrintABC;

/**
 * @author zy
 * @Date 16:01 2021/9/19
 * @Description 多线程打印1-100 (线程安全)
 */
public class Print123 {

    public static volatile Integer index = 0;

    public static class PrinterNum implements Runnable {
        @Override
        public void run() {
            synchronized (index) {
                while (index <= 100) {
                    System.out.println(Thread.currentThread().getName() + "打印:" + index);
                    index++;
                }
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new PrinterNum(), "线程A").start();
        new Thread(new PrinterNum(), "线程B").start();
        new Thread(new PrinterNum(), "线程C").start();
    }
}
