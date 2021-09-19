/**
 * @author zy
 *
 */
public class Test {

    public static void main(String[] args) {

    }
}
class One{

    private One(){
    }
    private volatile static One o ;

    public static One getInstance(){
        if(o==null){
            synchronized (o){
                if(o==null){
                    o = new One();
                }
            }
        }

        return o;
    }
}
