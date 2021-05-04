package example;

import java.util.ArrayList;

import processing.core.*;

// import peasy.*;

// PeasyCam cam;

public class Experiment {
    MyVisual mv;
    float cy = 0;
    float cw = 0;
    int chooseVisual;


    //variables for visual 2
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

    //variales for visual 3
    float x = 1 * 0.01f;
    float y = 0;
    float z = 0;

    float a = 10;
    float b = 28;
    float c = 8/3;
    PVector current;
    PVector temp;

    ArrayList<PVector> points = new ArrayList<PVector>();
    // cam = new PeasyCam(this, 500);

    Planet sun; 

    //variales for 4th visual

    float sphereSize;
    boolean showCube = false;
    float angle = 0;

    public Experiment(MyVisual mv)
    {
        this.mv = mv;
        cy = this.mv.height / 2;
        cw = this.mv.width / 2;
        sun = new Planet(50,0, mv,0);
        
    }

    public void render()
    {

        switch (chooseVisual)
        {
            case 0:
            {
                int temp = 0;
                //background dots
                for(int i = 0 ; i < mv.getAudioBuffer().size() ; i ++)
                {   
                    if(temp % 60 == 0)
                    {
                        mv.noStroke();
                        mv.fill(255);
                        float rw = mv.random(mv.width);
                        float rh = mv.random(mv.height);
                        float size = cy * mv.getAudioBuffer().get(i);
                        mv.circle(rw ,rh, size % 20);
                    }
                    temp += 1;
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
                // int Num_lines = 10;
                mv.colorMode(PApplet.HSB);
                int temp;

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
                break;
            }
            

            case 2: {
                mv.strokeWeight(1);
                mv.camera(mv.mouseX, mv.height/2, (mv.height/2) / PApplet.tan(PApplet.PI/6), mv.width/2, mv.height/2, 0, 0, 1, 0);
                


                float dt = 1 * 0.01f;
                float dx = (a * (y - x)) * dt;
                float dy = (x * (b - z) - y) * dt;
                float dz = (x * y - c * z) * dt;
                float musicAmp = mv.getSmoothedAmplitude();
                float temp = 4;
                x = x + dx;
                y = y + dy;
                z = z + dz;

                // mv.camera(0, 0, (mv.height/2) / (PApplet.tan(PApplet.PI/6)), 0, 0, 0, 0, 1, 0);
                mv.pushMatrix();
                points.add(new PVector(x, y, z));

                mv.translate(mv.width/2, mv.height/2);
                mv.scale(temp);
                // mv.stroke(255);
                mv.noFill();

                PApplet.println(musicAmp);


                // for loop to identify current amp
                // for(int i = 0 ; i < (mv.getAudioBuffer().size()); i++)
                // {
                //     float x = mv.getAudioBuffer().get(i);
                                            
                //     temp = new PVector(x,x,x);
                // }

                float color = 0;
                // for(int i = 0; i < (mv.getAudioBuffer().size()); i++)
                // {
                    mv.beginShape();
                    for(PVector v : points)
                    {   
                        if(musicAmp > 0.2 && musicAmp < 0.23 )
                        {
                            mv.noStroke();
                        }
                        else{
                            // current.set(temp.add(v));
                            mv.stroke((color % 255),255,255);
                            mv.vertex(v.x, v.y, v.z);
                            color += 1;
                            // PVector offset = new PVector(0,musicAmp,musicAmp);
                            // offset.mult(0.001f);
                            // v.add(offset);
                        }
                        
        
                    }
                    // angle += 0.1f;
                    mv.endShape();

                    mv.popMatrix();
                // }
                break;


            }

            case 3:
            {
                mv.camera(mv.mouseX, mv.height/2, (mv.height/2) / PApplet.tan(PApplet.PI/6), mv.width/2, mv.height/2, 0, 0, 1, 0);

                mv.pushMatrix();
                mv.translate(mv.width/2, mv.height/2, 0);
                mv.strokeWeight(3);
                mv.stroke(30,255,255);
                mv.rotateX(PApplet.PI/2);
                mv.rotateZ(-PApplet.PI/6);
                mv.noFill();

                //make pyramid
                mv.beginShape();
                mv.vertex( 150, -150, -150);
                mv.vertex(-150, -150, -150);
                mv.vertex(   0,    0,  150);

                mv.vertex( 150, -150, -150);
                mv.vertex( 150,  150, -150);
                mv.vertex(   0,    0,  150);

                mv.vertex( 150, 150, -150);
                mv.vertex(-150, 150, -150);
                mv.vertex(   0,   0,  150);

                mv.vertex(-150,  150, -150);
                mv.vertex(-150, -150, -150);
                mv.vertex(   0,    0,  150);
                mv.endShape();

                mv.popMatrix();

                mv .pushMatrix();
                mv.translate(mv.width/2, mv.height/2 + 50, 0);
                for(int i = 0 ; i < (mv.getAudioBuffer().size()) ; i ++)
                {
                    mv.noStroke();
                    mv.fill(
                        PApplet.map(i, 0, mv.getAudioBuffer().size(), 0, 255)
                        , 255
                        , 255
                    );
                    // sphereSize = PApplet.map(mv.getAudioBuffer().get(i),0,mv.getAudioBuffer().size(),10,90);
                    mv.sphere(170 * mv.getAudioBuffer().get(i));

                    if(mv.getAudioBuffer().get(i) > 0.15)
                    {
                        showCube = true;
                        // PApplet.println(mv.getAudioBuffer().get(i));
                    }
                    else
                    {
                        showCube = false;
                    }
                }
                mv.popMatrix();
               
                if(showCube == true)
                {
                    
                    //right cube 
                    mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                    mv.strokeWeight(5);
                    mv.noFill();
                    mv.lights();
                    mv.pushMatrix();
                    //
                    mv.translate(mv.width/2 -350, mv.height/2, 0);
                    // mv.rotateX(angle);
                    // mv.rotateZ(angle);       
                    float boxSize = 50 + (200 * mv.getSmoothedAmplitude()); 
                    mv.box(boxSize);
                    mv.popMatrix();   

                    //left cube 
                    mv.stroke(PApplet.map(mv.getSmoothedAmplitude(), 0, 1, 0, 255), 255, 255);
                    mv.strokeWeight(5);
                    mv.noFill();
                    mv.lights();
                    mv.pushMatrix();
                    //
                    mv.translate(mv.width/2+350, mv.height/2, 0);
                    // mv.rotateX(angle);
                    // mv.rotateZ(angle);       
                    mv.box(boxSize);
                    mv.popMatrix();   
                    
                    angle += 0.01f;
                }
                
                break;
            }

            case 4: 
            {
                mv.translate(mv.width/2, mv.height/2);
                sun.show();
                sun.orbit();

                break;
            }
        }//end switch

    }//end render

}//end main class 


