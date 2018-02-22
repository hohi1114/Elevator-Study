import java.util.*;
class Ball 
{
	final double att; // 양수면 끌어당기게 음수면 멀어지게 
	double x, y;
	double vx, vy;
	LinkedList<Integer> xHist = new LinkedList<>(), yHist = new LinkedList<>();
	public Ball (double x, double y, double att){
		this.x=x;
		this.y=y;
		vx=0.0;
		vy=0.0;
		this.att=att;
	}
}
