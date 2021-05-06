package example;

import ie.tudublin.*;

public class MyVisual extends Visual
{    
    WaveForm wf;
    AudioBandsVisual abv;
    Experiment ex;
    int which;

    public void settings()
    {
        size(1920, 1080, P3D);
        
        // Use this to make fullscreen
        //fullScreen();

        // Use this to make fullscreen and use P3D for 3D graphics
        // fullScreen(P3D, SPAN); 
    }

    public void setup()
    {
        startMinim();
                
        // Call loadAudio to load an audio file to process 
        loadAudio("Laszlo.mp3");  
        colorMode(HSB); 

        
        // Call this instead to read audio from the microphone
        //startListening(); 
        
        // wf = new WaveForm(this);
        // abv = new AudioBandsVisual(this);
        ex = new Experiment(this);
        ex.sun.spawnMoons(5);

        // background(0);
    }

    public void keyPressed()
    {
        if (keyCode >= '0' && keyCode <= '6') {
            ex.chooseVisual = keyCode - '0';
        }
        if (keyCode == ' ') {
            if (getAudioPlayer().isPlaying()) {
                getAudioPlayer().pause();
            } else {
                getAudioPlayer().rewind();
                getAudioPlayer().play();
            }
        }
    }

    public void draw()
    {
        background(0);
        try
        {
            // Call this if you want to use FFT data
            calculateFFT(); 
        }
        catch(VisualException e)
        {
            e.printStackTrace();
        }
        // Call this is you want to use frequency bands
        calculateFrequencyBands(); 

        // Call this is you want to get the average amplitude
        calculateAverageAmplitude();        
        // wf.render();
        // abv.render();
        ex.render();
    }
}
