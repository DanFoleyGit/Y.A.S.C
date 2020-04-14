package ie.tudublin;

import processing.core.PVector;

public class Bullet extends GameObject
{
    public Bullet(YASC yasc, float x, float y, float rotation)
    {
        super(yasc, x, y, rotation, 5);
    }

    public void render()
    {
        yasc.pushMatrix();
        yasc.translate(pos.x, pos.y);
        yasc.rotate(rotation);
        yasc.line(0, -5, 0, 5);
        yasc.popMatrix();
    }

    //add in check collision
    public void checkCollisions()
    {
        float dist = PVector.dist(yasc.aiShip.getPos(), pos);
        if (dist < yasc.aiShip.size / 2)
        {
            yasc.aiShip.setHealth(yasc.aiShip.getHealth() - 1);
            yasc.gameObjects.remove(this);
        }
    }

    public void update()
    {
        forward.x = (float)Math.sin(rotation);
        forward.y = - (float)Math.cos(rotation);

        //pos += forawrd*speed 
        pos.add(PVector.mult(forward, speed));

        checkBoundry();

        // if (pos.x < 0){
        //     pos.x = yasc.width;
        // }

        // if (pos.x > yasc.width){
        //     pos.x = 0;
        // }
        
        // if (pos.y < 0){
        //     pos.y = yasc.width;
        // }

        // if (pos.y > yasc. height){
        //     pos.y = 0;
        // }
        alive += yasc.timeDelta;
        if (alive >= 5.0){
            yasc.gameObjects.remove(this);
        }
        //call CheckCollisons
        checkCollisions();
    }
    float alive;
}