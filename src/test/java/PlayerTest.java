import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    private static Player.Shuttle shuttle;
    private static int surfaceN =6;
    private static double[][] map = new double[surfaceN][2];
    private static double[][] landableSufrace;

    @BeforeEach
    public void init(){
        System.out.println("BeforeEach init() method called");
        /*
         *   Il existe une unique zone d'atterrissage plane sur la surface de Mars et elle mesure au moins 1000 mètres de large.
         *   2 ≤ surfaceN < 30
         */
        map[0][0] = 0; // y Distance
        map[0][1] = 0; // x Hauteur

        map[1][0] = 500;
        map[1][1] = 1500;

        map[2][0] = 700;
        map[2][1] = 900;

        map[3][0] = 1000;
        map[3][1] = 2000;

        map[4][0] = 2000;
        map[4][1] = 2000;

        map[5][0] = 2500;
        map[5][1] = 1000;
        shuttle = new Player.Shuttle(map, surfaceN);

        landableSufrace = new double[][]{{map[3][0], map[3][1]}, {map[4][0], map[4][1]}};
        shuttle.setLandableSufrace(landableSufrace);
    }
    @Test
    public void executionContext() throws Exception {

    }

    @Test
    public void findLandableSurface() throws Exception {
        shuttle.getLandableSurface(map);
        assertEquals(1500,shuttle.yToReach);
        assertEquals(2000,shuttle.xToReach);
    }

    @Test
    public void isAboveTheLandingSurface(){
        assertFalse(shuttle.isAboveTheLandingSurface());
    }

    @Test
    public void howToMoveWhenNotAboveTheLandableSurface(){
        shuttle.howToMove();
        assertEquals("moveToThelandableSufrace" ,shuttle.getState());
    }

    @Test
    public void move(){
        //Angle de -90° à 90°. Puissance des fusées de 0 à 4.
        shuttle.move();
        assertTrue(shuttle.nextAngle >= -90 && shuttle.nextAngle <= 90 );
        assertTrue(shuttle.nextPower >= 0 && shuttle.nextAngle <= 40 );

    }

}
