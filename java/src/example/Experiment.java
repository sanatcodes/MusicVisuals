package example;

import processing.core.*;

public class Experiment {
    MyVisual mv;
    float cy = 0;
    float cw = 0;

    public Experiment(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cw = this.mv.width / 2;
        
    }

    public void render()
    {

        //background dots
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.noStroke();
            mv.fill(255);
            float rw = mv.random(mv.width);
            float rh = mv.random(mv.height);
            float size = cy * mv.getAudioBuffer().get(i);
            mv.circle(rw ,rh, size % 20);
        }

        //main circle
        mv.colorMode(PApplet.HSB);
        for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
        {
            mv.noFill();
            mv.stroke(
                PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                , 255
                , 255
            );

            mv.circle(cw, cy, cy + 50 + cy * mv.getAudioBuffer().get(i));
        }

        

    }
}
