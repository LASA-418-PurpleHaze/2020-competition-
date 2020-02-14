package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class ColorCommand extends Command
{
    public ColorCommand()
    {
        super.requires(Robot.colorSensor);
    }
    @Override
    protected void initialize()
    {
        Robot.colorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        System.out.println(Robot.colorSensor.getColor());
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