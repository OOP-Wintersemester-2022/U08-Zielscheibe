package Target;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Target extends GraphicsApp {

    /* Private Konstanten */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final Color BACKGROUND_COLOR = Colors.BLACK;

    /*
     * Die initialize-Methode wird einmalig zum Start des Programms
     * aufgerufen.
     */

    @Override
    public void initialize() {
        setupCanvas();
    }

    /*
     * Die draw-Methode wird so lange wiederholt aufgerufen, bis das Programm
     * beendet wird.
     */

    @Override
    public void draw() {
        drawBackground(BACKGROUND_COLOR);
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        drawBackground(BACKGROUND_COLOR);
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}