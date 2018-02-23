import java.util.*;

public class FindRoute {
    int start;
    public int[][] people; // 사람이 있는 층수/ 가야하는 층수를 2차원 array로
    Set<Integer> c = new HashSet<>(); //가야되는층수
    int min = 99999;
    Route minRoute = new Route(new LinkedList<>());
    Set<Integer> edge = new HashSet<>(); //add, remove만 사용
    Route r = new Route(new LinkedList<>());

    public FindRoute(int start, int[]... people) {
        this.start = start;
        this.people = people;
        for (int i = 0; i < people.length; i++) {
            for (int j = 0; j < 2; j++) {
                c.add(people[i][j]);
            }
        }
        r.add(start);
        for(int i: c) {
            if(i < start) {
                down(i);
            }
            if(i > start) {
                up(i);
            }
        }
    }

    public boolean vaild() {
        int a, b;
        for (int i = 0; i < people.length; i++) {
            a = people[i][0];
            b = people[i][1];
            if (!r.hasP(a, b)) {
                //System.out.println(r.route + " doesn't have " + a + ", " + b);
                return false;
            }
            //} else
            //System.out.println(r.route + " does have " + a + ", " + b);
        }
        return true;
    }

    public void up(int a) {
        //System.out.println("up " + r.route + ", " + a);
        r.add(a);
        edge.add(a);
        if (vaild() && min > r.rLen()) {
            min = r.rLen();
            minRoute = r.copy();
            r.remove();
            edge.remove(a);
            return;
        }
        for (int i : c) {
            if (i < a && !edge.contains(i))
                down(i);
        }
        r.remove();
        edge.remove(a);
    }

    public void down(int a) {
        //System.out.println("down " + r.route + ", " + a);
        r.add(a);
        edge.add(a);
        if (vaild() && min > r.rLen()) {
            min = r.rLen();
            minRoute = r.copy();
            r.remove();
            edge.remove(a);
            return;
        }
        for (int i : c) {
            if (i > a && !edge.contains(i))
                up(i);
        }
        r.remove();
        edge.remove(a);
    }

}


