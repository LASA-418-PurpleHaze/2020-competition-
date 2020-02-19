//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandGoToColor extends Command {
    public CommandGoToColor()
    {
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyColorArm.initialize();
        // Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute()
    {
        if(Robot.hazyColorArm.returnColorToTravelTo() == 0)
            Robot.hazyColorArm.goToColor("Blue");
            
        else if(Robot.hazyColorArm.returnColorToTravelTo() == 1)
            Robot.hazyColorArm.goToColor("Green");

        else if(Robot.hazyColorArm.returnColorToTravelTo() == 2)
            Robot.hazyColorArm.goToColor("Yellow");

        else if(Robot.hazyColorArm.returnColorToTravelTo() == 3)
            Robot.hazyColorArm.goToColor("Red");

        Robot.hazyColorArm.increaseColorToTravelTo(); //Increase the color to travel to so that if the function is called again then it will go to the next color wanted by the user
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted()
    {
        
    }
}