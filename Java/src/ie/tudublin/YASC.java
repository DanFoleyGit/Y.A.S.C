package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{

    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    Ship ship;

    public void keyPressed()
    {
        keys[keyCode] = true;
    }

    public void keyReleased()
    {
        keys[keyCode] = false;
    }

    public boolean checkKey(int c)
    {
        return keys[c] || keys [Character.toUpperCase(c)];
    }

    public void settings()
    {
        size(500,500);

    }

    public void setup()
    {
        ship = new Ship(this, width /2, height / 2, 5, 50);
        gameObjects.add(ship);

        //add in powerup and ai ships

    }

    public float timeDelta;
    private float last;
    
    public void draw()
    {
        float now = millis();
        timeDelta = (now - last) /1000.0f;
        last = now;

        background (255);
        fill(0);
        text("GameObjects: " + gameObjects.size(), 50, 100);

        for( int i = gameObjects.size() - 1; i >= 0 ; i--){
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();

            //add powerup instances here
        }
    }


}