import java.util.*;

/**
 * Auto-generated code below aims at helping you parse
 * the standard input according to the problem statement.
 **/
class Player {

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int surfaceN = in.nextInt(); // the number of points used to draw the surface of Mars.
        double[][] map = new double[surfaceN][2];

        for (int i = 0; i < surfaceN; i++) {
            int landX = in.nextInt(); // X coordinate of a surface point. (0 to 6999)
            int landY = in.nextInt(); // Y coordinate of a surface point. By linking all the points together in a sequential fashion, you form the surface of Mars.
            map[i][0] = landX;
            map[i][1] = landY;
        }

        // game loop
        Shuttle shuttle = new Shuttle(map, surfaceN);
        shuttle.printMap();
        shuttle.getLandableSurface(map);
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
            shuttle.howToMove();
            shuttle.move();




            // rotate power. rotate is the desired rotation angle. power is the desired thrust power.
            System.out.println("-45 4");
        }
    }

    static class Shuttle {
        int X = 0; // X max: 7000 hauteur horizontal
        int Y = 2500; // Y max: 3000 distance vertical
        int hSpeed = 0;
        int vSpeed = 0;
        int fuel = 0;
        int rotate = 0;
        int power = 0;
        double[][] map;
        int surfaceN = 0;
        double[][] landableSufrace; // the coordonate of the landable sufrace
        String state = "init";
        double yToReach ;
        double xToReach ;
        int nextAngle;
        int nextPower;

        public Shuttle(double[][] map, int surfaceN) {
            this.map = map;
            this.surfaceN = surfaceN;
        }

        public void printMap() {
            for (double[] point : map)
                System.err.println("x: " + point[0] + " y: " + point[1]);
        }

        public void getLandableSurface(double[][] paramMap) {
            //get 2 same following height points
            try {
                for (int i = 0; i < surfaceN; i++)
                    if (paramMap[i][1] == paramMap[i + 1][1] && !(paramMap[i][0] - paramMap[i + 1][0] >= 1000)) {
                        System.err.println("--- plane suface getted ---");
                        System.err.println(paramMap[i]);
                        System.err.println(paramMap[i + 1]);
                        // land on the middle Y of the landableSurface
                        yToReach = (paramMap[i + 1][0] + paramMap[i][0])/2;
                        // land on the top X of the landableSurface
                        xToReach = paramMap[i][1];
                        return;
                    }
            } catch (IndexOutOfBoundsException e) {
                return ;
            }
            return ;
        }

        public boolean isAboveTheLandingSurface() {
            if((X <= landableSufrace[0][0] || X >= landableSufrace[1][0]) ||  Y < landableSufrace[0][1])
                return false;
            return true;
        }

        public void howToMove() {
            // select the move to do moveToThelandableSufrace or landing
            if(isAboveTheLandingSurface()) {
                setState("landing");
            } else {
                setState("moveToThelandableSufrace");
            }
        }


        public void move() {
            //Angle de -90° à 90°. Puissance des fusées de 0 à 4.



            nextAngle = 189;
            nextPower = 5;
        }

        // Setter and Getter
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
        public String getState() {
            return state;
        }
        public void setState(String state) {
            this.state = state;
        }
        public int getSurfaceN() {
            return surfaceN;
        }
        public void setSurfaceN(int surfaceN) {
            this.surfaceN = surfaceN;
        }
        public double[][] getMap() {
            return map;
        }
        public void setMap(double[][] map) {
            this.map = map;
        }
        public double[][] getLandableSufrace() {
            return landableSufrace;
        }
        public void setLandableSufrace(double[][] landableSufrace) {
            this.landableSufrace = landableSufrace;
        }


    }


}