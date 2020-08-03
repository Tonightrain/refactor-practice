package com.twu.refactoring;

public class Direction {
    private final char direction;
    private char[] dir = {'N','E','S','W'};

    public Direction(char direction) {
        this.direction = direction;
    }

    public Direction turn(boolean left) {
        switch (direction) {
            case 'N':
                return new Direction(left? dir[3]:dir[1]);
            case 'S':
                return new Direction(left? dir[1]:dir[3]);
            case 'E':
                return new Direction(dir[0]);
            case 'W':
                return new Direction(dir[2]);
            default:
                throw new IllegalArgumentException();
        }
    }

    public Direction turnLeft(boolean left) {
        switch (direction) {
            case 'N':
                return new Direction('W');
            case 'S':
                return new Direction('E');
            case 'E':
                return new Direction('N');
            case 'W':
                return new Direction('S');
            default:
                throw new IllegalArgumentException();
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Direction direction1 = (Direction) o;

        return direction == direction1.direction;
    }

    @Override
    public int hashCode() {
        return direction;
    }

    @Override
    public String toString() {
        return "Direction{direction=" + direction + '}';
    }

}

