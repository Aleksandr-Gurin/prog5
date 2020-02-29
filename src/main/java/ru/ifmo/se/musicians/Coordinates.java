package ru.ifmo.se.musicians;

import java.util.Objects;

public class Coordinates {
    private long x; //Максимальное значение поля: 913
    private double y; //Значение поля должно быть больше -224
    public Coordinates(){};

    public Coordinates(long x, double y){
        this.x = x;
        this.y = y;
    }

    public double getY() {
        return y;
    }

    public long getX() {
        return x;
    }

    public void setX(long x) {
        this.x = x;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x,y);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Coordinates testClass = (Coordinates) o;
        return x == testClass.x &&
                y == testClass.y;
    }

    @Override
    public String toString() {
        return "Класс: " + getClass() + ", координата x:" + getX() + ", координата y: " +getY();
    }
}
