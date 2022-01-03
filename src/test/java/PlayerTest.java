import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PlayerTest {
    @Test
    public void executionContext() throws Exception {

    }

    @Test
    public void findLandableSurface() throws Exception {
        /*
         *   Il existe une unique zone d'atterrissage plane sur la surface de Mars et elle mesure au moins 1000 mètres de large.
         *   2 ≤ surfaceN < 30
         */
        int surfaceN = 6;
        double[][] map = new double[surfaceN][2];

        map[0][0] = 0; // x
        map[0][1] = 0; // y

        map[1][0] = 500;
        map[1][1] = 1500;

        map[2][0] = 700;
        map[2][1] = 2000;

        map[3][0] = 1000;
        map[3][1] = 3000;

        map[4][0] = 2000;
        map[4][1] = 3000;

        map[5][0] = 2500;
        map[5][1] = 1000;
        Player.Shuttle shuttle = new Player.Shuttle(map, surfaceN);

        double[][] landableSufrace = {{map[3][0], map[3][1]}, {map[4][0], map[4][1]}};
        assertArrayEquals(shuttle.getLandableSurface(), landableSufrace);
    }

    @Test
    public void moveToThelandableSufrace() {

        int surfaceN = 6;
        double[][] map = new double[surfaceN][2];

        map[0][0] = 0; // x
        map[0][1] = 0; // y

        map[1][0] = 500;
        map[1][1] = 1500;

        map[2][0] = 700;
        map[2][1] = 2000;

        map[3][0] = 1000;
        map[3][1] = 3000;

        map[4][0] = 2000;
        map[4][1] = 3000;

        map[5][0] = 2500;
        map[5][1] = 1000;

        double[][] landableSufrace = {{map[3][0], map[3][1]}, {map[4][0], map[4][1]}};
        Player.Shuttle shuttle = new Player.Shuttle(map, surfaceN);

        assertTrue(shuttle.moveToThelandableSufrace());
    }

}
