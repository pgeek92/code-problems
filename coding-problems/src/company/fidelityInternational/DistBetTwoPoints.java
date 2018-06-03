/**
 * In this challenge you will be working with points in two or three dimensional space. The classes
 * and methods you implement will store values for coordinates as well as calculate distance between
 * points. The 2D and 3D distances between two points are calculated using the following formulae:
 * 
 * 2D distance = SquareRoot((x2-x1)^2 + (y2-y1)^2)
 * 3D distance = SquareRoot((x2-x1)^2 + (y2-y1)^2 + (z2-z1)^2)
 * 
 */

package company.fidelityInternational;

import java.util.Scanner;

class Point2D {
	int x, y;

	public Point2D(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double dist2D(Point2D p) {
		double distance = Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2));
		return distance;
	}

	public void printDistance(double d) {
		System.out.println("2D distance = " + (int) Math.ceil(d));
	}
}

class Point3D extends Point2D{
	int z;
	
	public Point3D(int x, int y, int z) {
		super(x, y);
		this.z = z;
	}
	
	public double dist3D(Point3D p) {
		double distance = Math.sqrt(Math.pow((p.x - x), 2) + Math.pow((p.y - y), 2) + Math.pow((p.z - z), 2));
		return distance;
	}

	public void printDistance(double d) {
		System.out.println("3D distance = " + (int) Math.ceil(d));
	}
}

public class DistBetTwoPoints {

	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int x1 = in.nextInt();
		int y1 = in.nextInt();
		int z1 = in.nextInt();
		int x2 = in.nextInt();
		int y2 = in.nextInt();
		int z2 = in.nextInt();
		in.close();
		
		Point3D p1 = new Point3D(x1, y1, z1);
		Point3D p2 = new Point3D(x2, y2, z2);
		double d2 = p1.dist2D(p2);
		double d3 = p1.dist3D(p2);
		
		Point2D p = new Point2D(0, 0);
		p.printDistance(d2);
		p = p1;
		p.printDistance(d3);
	}

}
