package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GoToColorCommand extends Command {
    public GoToColorCommand()
    {
        super.requires(Robot.colorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.colorArm.initialize();
        Robot.colorSensor.initialize();
    }

    @Override
    protected void execute()
    {
        //Robot.colorWheelArm.goToColor("Blue");
        //Robot.colorWheelArm.goToColor("Green");
        //Robot.colorWheelArm.goToColor("Yellow");
        //Robot.colorWheelArm.goToColor("Red");
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