package com.tarkiflettes.main;

import java.awt.Point;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;

public class Calculs
{

	public static Point getIntersect(Laser l1, Line2D l2)
	{
		Line2D line1 = new Line2D.Double(l1.getStartCoords(), new Point2D.Double(l1.getStartCoords().getX() + l1.getCoefX() * 20000, l1.getStartCoords().getY() + l1.getCoefY() * 20000));
		Line2D line2 = l2;

		double Ax = line1.getX1();
		double Bx = line1.getX2();
		double Cx = line2.getX1();
		double Dx = line2.getX2();
		double Ay = line1.getY1();
		double By = line1.getY2();
		double Cy = line2.getY1();
		double Dy = line2.getY2();

		double Sx;
		double Sy;

		if (Ax == Bx)
		{
			if (Cx == Dx)
				return null;
			else
			{
				double pCD = (Cy - Dy) / (Cx - Dx);
				Sx = Ax;
				Sy = pCD * (Ax - Cx) + Cy;
			}
		}
		else
		{
			if (Cx == Dx)
			{
				double pAB = (Ay - By) / (Ax - Bx);
				Sx = Cx;
				Sy = pAB * (Cx - Ax) + Ay;
			}
			else
			{
				double pCD = (Cy - Dy) / (Cx - Dx);
				double pAB = (Ay - By) / (Ax - Bx);
				double oCD = Cy - pCD * Cx;
				double oAB = Ay - pAB * Ax;
				Sx = (oAB - oCD) / (pCD - pAB);
				Sy = pCD * Sx + oCD;
			}
		}
		System.out.println(Sx + " " + Sy);
		if ((Sx < Ax && Sx < Bx) | (Sx > Ax && Sx > Bx) | (Sx < Cx && Sx < Dx) | (Sx > Cx && Sx > Dx) | (Sy < Ay && Sy < By) | (Sy > Ay && Sy > By) | (Sy < Cy && Sy < Dy) | (Sy > Cy && Sy > Dy))
			return null;
		return new Point((int) Sx, (int) Sy); // or : return new
												// Point2D.Float((float)Sx,(float)Sy)

	}
}
