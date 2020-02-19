//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandEndArmDefault extends Command
{
    public CommandEndArmDefault()
    {
        super.requires(Robot.hazyEndArm);
    }
    @Override
    protected void initialize()
    {
        // Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        Robot.hazyEndArm.stopMotors();
   
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