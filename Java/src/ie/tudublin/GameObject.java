package ie.tudublin;

import processing.core.PVector;

public abstract class GameObject
{
    protected PVector pos;
    protected PVector forward;
    protected float rotation;
    protected float speed;
    protected YASC yasc;

    public GameObject(YASC yasc, float x, float y, float rotation, float speed)
    {
        this.yasc = yasc;
        pos = new PVector(x, y);
        forward = new PVector(0, -1);
        this.rotation = rotation;
        this.speed = speed;
    }

    //checks if a gameobject has collided with the boundries
    //and translates it to the other side of the screen
    //
    public void checkBoundry()
    {
        if (pos.x < 0){
            pos.x = yasc.width;
        }

        if (pos.x > yasc.width){
            pos.x = 0;
        }
        
        if (pos.y < 0){
            pos.y = yasc.width;
        }

        if (pos.y > yasc. height){
            pos.y = 0;
        }
    }

    public abstract void update();
    public abstract void render();

    /**
     * @return the pos
     */
    public PVector getPos() {
        return pos;
    }

    /**
     * @param pos the pos to set
     */
    public void setPos(PVector pos) {
        this.pos = pos;
    }

    /**
     * @return the forward
     */
    public PVector getForward() {
        return forward;
    }

    /**
     * @param forward the forward to set
     */
    public void setForward(PVector forward) {
        this.forward = forward;
    }

    /**
     * @return the rotation
     */
    public float getRotation() {
        return rotation;
    }

    /**
     * @param rotation the rotation to set
     */
    public void setRotation(float rotation) {
        this.rotation = rotation;
    }

    /**
     * @return the speed
     */
    public float getSpeed() {
        return speed;
    }

    /**
     * @param speed the speed to set
     */
    public void setSpeed(float speed) {
        this.speed = speed;
    }

    /**
     * @return the yasc
     */
    public YASC getYasc() {
        return yasc;
    }

    /**
     * @param yasc the yasc to set
     */
    public void setYasc(YASC yasc) {
        this.yasc = yasc;
    }


}


