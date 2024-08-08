package com.my.java.suanfa;

import java.math.BigDecimal;

public class squire {

    public static void main(String[] args) {

        Point apoint = new Point(1f,1f);
        Point bpoint = new Point(2f,1f);
        Point cpoint = new Point(1f,2f);
        Point dpoint = new Point(2f,2f);
        System.out.println(isSquire(apoint,bpoint,cpoint,dpoint));

        System.out.println(new BigDecimal("16").pow(2));
        BigDecimal d = new BigDecimal("16");

    }

    static boolean isSquire(Point aPoint,Point bPoint,Point cPoint,Point dPoint) {
        boolean result = false;
        if (aPoint == null || bPoint == null || cPoint == null || dPoint == null) {
            return result;
        }
        if (getDistance(aPoint,bPoint).compareTo(getDistance(cPoint,aPoint)) != 0) {
            return result;
        }
        if (getDistance(aPoint,dPoint).compareTo(getDistance(aPoint,bPoint).add(getDistance(aPoint,cPoint))) == 0) {
            result = true;
        }
        return result;
    }

    public static BigDecimal getDistance(Point aPoint,Point bPoint) {
        BigDecimal pointx = new BigDecimal(String.valueOf(aPoint.getxPoint())).subtract(new BigDecimal(String.valueOf(bPoint.getxPoint())));
        BigDecimal pointy = new BigDecimal(String.valueOf(aPoint.getyPoint())).subtract(new BigDecimal(String.valueOf(bPoint.getyPoint())));
        BigDecimal pointXMu = pointx.multiply(pointx);
        BigDecimal pointYMu = pointy.multiply(pointy);
        System.out.println(pointXMu.add(pointYMu).toString());
        return pointXMu.add(pointYMu);
    }
}

class Point {

    float xPoint;

    float yPoint;

    public Point(float xPoint, float yPoint) {
        this.xPoint = xPoint;
        this.yPoint = yPoint;
    }

    public float getxPoint() {
        return xPoint;
    }

    public void setxPoint(float xPoint) {
        this.xPoint = xPoint;
    }

    public float getyPoint() {
        return yPoint;
    }

    public void setyPoint(int yPoint) {
        this.yPoint = yPoint;
    }
}
