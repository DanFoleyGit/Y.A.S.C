package ie.tudublin;

import java.util.ArrayList;
import java.util.concurrent.TimeUnit;

import processing.core.PApplet;

public class YASC extends PApplet
{

    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    Ship ship;
    AIShip aiShip;

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
        aiShip = new AIShip(this, 100, 100, 5, 50);
        gameObjects.add(aiShip);

        //add in powerup and ai ships
        gameObjects.add(new AmmoPowerup(this));
        gameObjects.add(new AmmoPowerup(this));

    }

    public float timeDelta;
    private float last;
    
    public void draw()
    {
        float now = millis();
        timeDelta = (now - last) /1000.0f;
        float timeOfDeath = 0;
        last = now;

        background (255);
        fill(0);
        text("GameObjects: " + gameObjects.size(), 50, 100);

        for( int i = gameObjects.size() - 1; i >= 0 ; i--){
            GameObject b = gameObjects.get(i);
            b.render();
            b.update();

            //add powerup instances here
            if (b instanceof Powerup)
            {
                if (dist(b.pos.x, b.pos.y, ship.pos.x, ship.pos.y) < 50)
                {
                    ((Powerup)b).applyTo(ship);
                    gameObjects.remove(b);
                }
            }
            //check for dead ship, then call new aiShip
            if (aiShip.getHealth() < 1)
            {
                gameObjects.remove(aiShip);
                aiShip = new AIShip(this, 100, 100, 5, 50);
                gameObjects.add(aiShip);
            }
        }
    }


}