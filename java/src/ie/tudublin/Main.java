package ie.tudublin;

import example.AudioBandsVisual;
import example.CubeVisual;
import example.MyVisual;
import example.RotatingAudioBands;

public class Main
{	

	public void startUI()
	{
		String[] a = {"MAIN"};
        // processing.core.PApplet.runSketch( a, new RotatingAudioBands());		
        // processing.core.PApplet.runSketch( a, new CubeVisual());		
        processing.core.PApplet.runSketch( a, new MyVisual());				
	}

	public static void main(String[] args)
	{
		Main main = new Main();
		main.startUI();			
	}
}