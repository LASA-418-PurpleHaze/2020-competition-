//Imports fot the Subsystem and its functions
package frc.robot;

import com.revrobotics.ColorSensorV3;
import edu.wpi.first.wpilibj.command.Subsystem;

public class HazyColorSensor extends Subsystem {
    private ColorSensorV3 sensor;
    
    private Double [] colors = new Double[3];

    public HazyColorSensor(){

        sensor = new ColorSensorV3(RobotMap.COLORSENSORPORT);

    }


    //public void initialize (){}

    //converts rgb (from color sensor) to hsv for easier color detection
    static Double[] rgbToHsv(double r, double g, double b) 
    {
        // h, s, v = hue, saturation, value 
        double cmax = Math.max(r, Math.max(g, b)); // maximum of r, g, b 
        double cmin = Math.min(r, Math.min(g, b)); // minimum of r, g, b 
        double diff = cmax - cmin; // diff of cmax and cmin. 
        double h = -1, s = -1; 
            
        if (cmax == cmin) 
            h = 0; 
        else if (cmax == r) 
            h = (60 * ((g - b) / diff) + 360) % 360; 
        else if (cmax == g) 
            h = (60 * ((b - r) / diff) + 120) % 360; 
        else if (cmax == b) 
            h = (60 * ((r - g) / diff) + 240) % 360; 

        if (cmax == 0) 
            s = 0; 
        else
            s = (diff / cmax) * 100; 

        double v = cmax * 100; 
        Double[] out = {h,s,v};
        return out;
    } 
        
    //returns a string of the color detected
    public String getColor ()
    {
	    //if there is a color detected (to reduce error)
        if (sensor.getColor() != null) 
        {
            colors = rgbToHsv(sensor.getColor().red, sensor.getColor().green, sensor.getColor().blue); //converts to hsv format for easier detection
            //System.out.println(colors[0]);
            String col = "Blue";
            if (colors[0] < 85.0)
                col = "Red";
            else if (colors[0] < 100.0)
                col = "Yellow";
            else if(colors[0] < 150.0)
                col = "Green";
            return col;
        }
        System.out.println("icky bad no color");
        return ""; 
    }
    
    @Override
    public void initDefaultCommand()
    {
        setDefaultCommand(Robot.commandColor);
    }
}