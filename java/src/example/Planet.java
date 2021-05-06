package example;

import processing.core.PApplet;

//extend my visuals 
//use pollymorphism 

public class Planet {
    
    float radius;
    float angle;
    float distance;
    Planet[] planets;
    float orbitSpeed;
    MyVisual mv;


    public Planet(float r, float d, MyVisual mv, float o)
    {
        radius = r;
        distance = d;
        orbitSpeed = o;
        angle = mv.random(PApplet.TWO_PI);
        orbitSpeed = mv.random(0.1f,0.3f);
        this.mv = mv;
    }

    void spawnMoons(int total){
        
        planets = new Planet[total];
        for(int i=0; i< planets.length; i++)
        {

            float r = radius * 0.3f;;
            float d = mv.random(75,150);
            float o = mv.random(0.02f,0.1f);
            planets[i] = new Planet(r, d, mv, o);
        }
    }


    void orbit(){
        angle = angle + orbitSpeed;
        if(planets != null)
        {
            for(int i=0; i< planets.length; i++)
            {
                planets[i].orbit();
            }
        }
    }

    void show()
    {   
        mv.pushMatrix();
        mv.noStroke();
        mv.fill(255,100);
        mv.rotate(angle);
        mv.translate(distance, 0);
        mv.sphere(r);
        // mv.ellipse(0,0,radius*2, radius*2);

        if(planets != null)
        {
           
            for(int i=0; i< planets.length; i++)
            {
                planets[i].show();
            }

        }
        mv.popMatrix();
    }

}
