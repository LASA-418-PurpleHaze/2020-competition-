//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class EndArmCommand extends Command {
    public EndArmCommand()
    {
        super.requires(Robot.hazyEndArm);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyEndArm.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyEndArm.fold();
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