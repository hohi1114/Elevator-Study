import java.util.LinkedList;

public class RouteTest {
    public static void main(String[] args ){
            int[][] dat = {
                    {1, 100},
                    {51, 50},
                    {9, 16},
                    {78, 66},
                    {3, 55},
        };
        FindRoute r = new FindRoute(4, dat);
        System.out.println(r.minRoute.route);
    }
}
