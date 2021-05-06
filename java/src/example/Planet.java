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
        orbitSpeed = mv.random(0.01f,0.1f);
        
        this.mv = mv;
    }

    void spawnMoons(int total){
        
        planets = new Planet[total];
        for(int i=0; i< planets.length; i++)
        {
            
            
            float r = radius * 0.3f;
            float d = mv.random(100,250);
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
        mv.fill((mv.getSmoothedAmplitude()*1000) % 255);
        // PApplet.println(PApplet.map(mv.getSmoothedAmplitude()*1000, 0, mv.getAudioBuffer().size(), 0, 255));
        mv.rotate(angle);
        mv.translate(distance, 0);
        mv.sphere(radius);
        // float offset = PApplet.map(mv.getSmoothedAmplitude(), 0, mv.getAudioBuffer().size(), 1, 5);
        // mv.ellipse(0,0,radius*2, radius*2);

        if(planets != null)
        {
           
            for(int i=0; i< planets.length; i++)
            {
                // planets[i].radius = planets  [i].radius * offset;
                planets[i].show();
            }

        }
        mv.popMatrix();
    }

}
