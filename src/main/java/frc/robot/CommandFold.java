//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandFold extends Command {
    public CommandFold()
    {
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyColorArm.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyColorArm.fold();
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted()
    {
        
    }
}