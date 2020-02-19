//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandColorArmDefault extends Command
{
    public CommandColorArmDefault()
    {
        super.requires(Robot.hazyColorArm);
    }
    @Override
    protected void initialize()
    {
        // Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        Robot.hazyColorArm.defaultColorSpin();
       
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