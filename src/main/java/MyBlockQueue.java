import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author coolestyue
 * 手写一个简单的阻塞队列
 * 要努力呀.
 */
public class MyBlockQueue {
    private List<Integer> container = new ArrayList<>();
    private volatile int size;
    private volatile int cap;
    private Lock lock = new ReentrantLock();
    private Condition isFull = lock.newCondition();
    private Condition isNull = lock.newCondition();

    public MyBlockQueue(int cap) {
        this.cap = cap;
    }

    public void add(int num) {
        lock.lock();
        while (size >= cap) {
            //队列满了 自旋等消费者消费后再
            try {
                isFull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size++;
        container.add(num);
        isNull.signal();
        lock.unlock();
    }

    public int take() {
        lock.lock();
        while (size == 0) {
            //队列为空,自旋等生产者添加
            try {
                isNull.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        size--;
        Integer integer = container.get(0);
        container.remove(0);
        isFull.signal();
        lock.unlock();
        return integer;
    }

    public static void main(String[] args) {

    }
}
