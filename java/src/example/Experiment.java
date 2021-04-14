package example;

import processing.core.*;

public class Experiment {
    MyVisual mv;
    float cy = 0;
    float cw = 0;
    int which = 1;

    public Experiment(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cw = this.mv.width / 2;
        
    }

    public void keyPressed() {
        if (mv.keyCode >= '0' && mv.keyCode <= '6') {
            which = mv.keyCode - '0';
        }
        // if (mv.keyCode == ' ') {
        //     if (ap.isPlaying()) {
        //         ap.pause();
        //     } else {
        //         ap.rewind();
        //         ap.play();
        //     }
        // }
    }

    float t = 0;

    float x1(float t )
    {
        return PApplet.sin(t / 10) * 100 + PApplet.sin(t/5) * 20;
    }

    float y1(float t)
    {
        return PApplet.cos(t / 10) * 100;
    }

    float x2(float t )
    {
        return PApplet.sin(t/10) * 200 + PApplet.sin(t) * 2;
    }

    float y2(float t)
    {
        return PApplet.cos(t / 20) * 200 + PApplet.cos(t / 12) * 20;
    }

    
    public void render()
    {

        switch (which)
        {
            case 0:
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
                break;

            }
            
            case 1:
            {
                mv.strokeWeight(5);
                int Num_lines = 10;

                mv.translate(mv.width / 2, mv.height / 2);

                for(int i = 0 ; i < (mv.getAudioBuffer().size() % 150) ; i ++)
                {
                    mv.noFill();
                    mv.stroke(
                        PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                        , 255
                        , 255
                    );

                    mv.line(x1(t + i), y1(t + i), x2(t + i), y2(t + i));
                }
                t += 0.7;
                
                // for(int i = 0; i < Num_lines; i++){
                //     mv.line(x1(t + i), y1(t + i), x2(t + i), y2(t + i));
                //     // mv.line(x2(t), y2(t), x1(t), y1(t));
                // }
                // t += 0.7;
            }
            break;
        }//end switch

    }//end render

}//end main class 
