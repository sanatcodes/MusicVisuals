package example;

import processing.core.PApplet;

//extend my visuals 
//use pollymorphism 

public class Planet {
    
    float radius;
    float angle;
    float distance;
    Planet[] planets;
    MyVisual mv;


    public Planet(float r, float d, MyVisual mv)
    {
        radius = r;
        distance = d;
        angle = 0;
        this.mv = mv;
    }

    void spawnMoons(int total){
        
        planets = new Planet[total];
        for(int i=0; i< planets.length; i++)
        {

            float r = radius * 0.5f;;
            float d = mv.random(100,200);
            planets[i] = new Planet(r, d, mv);
        }
    }

    void show()
    {
        mv.fill(255);
        mv.ellipse(0,0,radius*2, radius*2);

        if(planets != null)
        {
           
            for(int i=0; i< planets.length; i++)
            {
                planets[i].show();
            }

        }
    }

}
