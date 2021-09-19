import com.sun.tools.javac.Main;

/**
 * @author coolestyue
 * 要努力呀.
 */
public class TestYinYong {
    public static void main(String[] args) {
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
        l3.next = l4;
        l4.next = l5;
        ListNode cur = l1;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        test1(l3);
        cur = l1;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
        test2(l3);
        cur = l1;
        while(cur!=null){
            System.out.println(cur.val);
            cur = cur.next;
        }
    }
    public static void test1(ListNode cur){
        cur = null;
    }
    public static void test2(ListNode cur){
        cur.next = null;
    }

}
