import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        double[][] map = new double[surfaceN][1];

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            map[i][0]= landX;
            map[i][1]= landY;
        }

        // game loop
        Shuttle shuttle = new Shuttle(map);
        while (true) {
            shuttle.setX(in.nextInt());
            shuttle.setY(in.nextInt());
            shuttle.sethSpeed(in.nextInt()); // the horizontal speed (in m/s), can be negative.
            shuttle.setvSpeed(in.nextInt()); // the vertical speed (in m/s), can be negative.
            shuttle.setFuel(in.nextInt()); // the quantity of remaining fuel in liters.
            shuttle.setRotate(in.nextInt()); // the rotation angle in degrees (-90 to 90).
            shuttle.setPower(in.nextInt()); // the thrust power (0 to 4).

            // Write an action using System.out.println()
            // To debug: System.err.println("Debug messages...");


            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            System.out.println("-20 3");
        }
    }

    static class Shuttle {
        int X =0;
        int Y =0;
        int hSpeed =0;
        int vSpeed =0;
        int fuel =0;
        int rotate =0;
        int power =0;
        double[][] map;

        public Shuttle(double[][] map) {
            this.map = map;
        }

        public int getX() {
            return X;
        }

        public void setX(int x) {
            X = x;
        }

        public int getY() {
            return Y;
        }

        public void setY(int y) {
            Y = y;
        }

        public int gethSpeed() {
            return hSpeed;
        }

        public void sethSpeed(int hSpeed) {
            this.hSpeed = hSpeed;
        }

        public int getvSpeed() {
            return vSpeed;
        }

        public void setvSpeed(int vSpeed) {
            this.vSpeed = vSpeed;
        }

        public int getFuel() {
            return fuel;
        }

        public void setFuel(int fuel) {
            this.fuel = fuel;
        }

        public int getRotate() {
            return rotate;
        }

        public void setRotate(int rotate) {
            this.rotate = rotate;
        }

        public int getPower() {
            return power;
        }

        public void setPower(int power) {
            this.power = power;
        }

        public double[][]  getLandableSurface() {
            return null;
        }
    }


}