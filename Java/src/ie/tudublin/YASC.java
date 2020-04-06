package ie.tudublin;

import java.util.ArrayList;

import processing.core.PApplet;

public class YASC extends PApplet
{

    boolean[] keys = new boolean[1024];

    public ArrayList<GameObject> gameObjects = new ArrayList<GameObject>();

    Ship ship;


    public void settings()
    {
        size(500,500);

    }

    


}