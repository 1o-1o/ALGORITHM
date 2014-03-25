/**
 * Created with IntelliJ IDEA.
 * User: zfan
 * Date: 11/26/13
 * Time: 5:13 PM
 * To change this template use File | Settings | File Templates.
 */
import java.util.LinkedList;
//import

public class stack<LRPairModel> {
    private LinkedList<LRPairModel> list = new LinkedList<LRPairModel>();
    public stack() {
    }
    public void clear() {
        list.clear();
    }
    public boolean isEmpty() {
        return list.isEmpty();
    }
    public LRPairModel topElement() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.getLast();
    }
    public LRPairModel pop() {
        if (isEmpty()) {
            throw new java.util.EmptyStackException();
        }
        return list.removeLast();
    }
    public void push(LRPairModel element) {
        list.addLast(element);
    }
    public String toString() {
        return list.toString();
    }
}
