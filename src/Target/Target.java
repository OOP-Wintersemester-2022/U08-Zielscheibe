package Target;

import de.ur.mi.oop.app.GraphicsApp;
import de.ur.mi.oop.colors.Color;
import de.ur.mi.oop.colors.Colors;
import de.ur.mi.oop.graphics.Circle;
import de.ur.mi.oop.launcher.GraphicsAppLauncher;

public class Target extends GraphicsApp {

    /* Private Konstanten */
    private static final int CANVAS_HEIGHT = 800;
    private static final int CANVAS_WIDTH = 800;
    private static final Color BACKGROUND_COLOR = Colors.WHITE;

    // Das Zentrum des Kreises wird auf die Mitte der Zeichenfläche festgelegt
    private static final int HORIZONTAL_CENTER = CANVAS_WIDTH / 2;
    private static final int VERTICAL_CENTER = CANVAS_HEIGHT / 2;

    /* Eigenschaften des Dart-Targets */
    private static final Color RING_COLOR_UNEVEN = Colors.RED;
    private static final Color RING_COLOR_EVEN = Colors.WHITE;
    private static final int NUM_RINGS = 15;
    private static final int INITIAL_RING_WIDTH = 10;

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
        drawDartTarget();
    }

    private void setupCanvas() {
        setCanvasSize(CANVAS_WIDTH, CANVAS_HEIGHT);
        drawBackground(BACKGROUND_COLOR);
    }

    /*
        Die Kreisfarbe soll sich abwechseln, daher ermittelt man, ob die aktuelle Nummer des Kreises
        gerade oder ungerade ist und legt dementsprechend die Farbe fest. Der Test auf gerade oder ungerade
        erfolgt durch den Modulo-Operator (%), dieser liefert den Rest einer Division. Eine Zahl % 2 liefert
        daher entweder 1 oder 0. Ist das Ergebnis 1 ist die Zahl ungerade, da sie nicht durch 2 ohne
        Rest teilbar ist, ist das Ergebnis 0 ist die Zahl gerade, da sie ohne Rest durch 2 teilbar
        ist.
        Der Radius jedes Rings ist der initiale Radius von 10 + die Nummer des Rings mal den initialen
        Radius. Dadurch hat der erste Ring den initialen Radius, der zweite 2 * den initialen Radius, der
        dritte 3 * den initialen Radius usw.
        Die for-Schleife zählt von der Zahl der zu erzeugenden Ringe bis 0 runter. Denn später gezeichnete
        Objekte werden in der GraphicsApp als oberstes angezeigt. Zeichnet man daher den größten Ring zu letzt
        wäre dieser das oberste Element und die anderen nicht mehr sichtbar. Der größte Ring muss daher zuerst#
        gezeichnet werden und der kleinste Ring als letztes.
    */
    private void drawDartTarget() {
        Color ringColor;
        int radius;
        Circle ring;

        for (int i = NUM_RINGS; i > 0; i--) {
            if (i % 2 == 0) {
                ringColor = RING_COLOR_EVEN;
            } else {
                ringColor = RING_COLOR_UNEVEN;
            }

            radius = (INITIAL_RING_WIDTH) + (i * INITIAL_RING_WIDTH);
            ring = new Circle(HORIZONTAL_CENTER, VERTICAL_CENTER, radius, ringColor);
            ring.draw();
        }
    }

    public static void main(String[] args) {
        GraphicsAppLauncher.launch();
    }
}
