
import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;

public class Route {
    LinkedList<Integer> route; //get, add

    public Route(LinkedList<Integer> a) {
        route = a;
    }

    public boolean contains(int a, int b, int c) {
        return (a - c) * (b - c) <= 0;
    }

    public boolean has(int a) {
        Iterator<Integer> it = route.iterator();
        int before = it.next();
        while (it.hasNext()) {
            if (contains(before, (before = it.next()), a)) {
                return true;
            }
        }
        return false;
    }

    public Route cut(int a) {
        LinkedList<Integer> route2 = new LinkedList<>(route);
        ListIterator<Integer> it = route2.listIterator();
        int before = it.next();
        while (it.hasNext()) {
            if (contains(before, (before = it.next()), a)) {
                it.previous();
                if (before != a) {
                    it.previous();
                }
                it.set(a);
                while (it.hasPrevious()) {
                    it.previous();
                    it.remove();
                }
                break;
            }
        }
        return new Route(route2);
    }

    public boolean hasP(int a, int b) {
        if(!has(a)) return false;
        Route r = this.cut(a);
        if (r.has(b)) {
            return true;
        } else
            return false;
    }

    public int rLen() {
        int length = 0;
        Iterator<Integer> it = route.iterator();
        int before = it.next();
        while (it.hasNext()) {
            length += Math.abs(before - (before = it.next()));
        }
        return length;
    }

    public void add(int a) {
        route.offerLast(a);
    }

    public void remove() {
        route.removeLast();
    }

    public Route copy() {
        return new Route(new LinkedList<>(route));

    }
}



