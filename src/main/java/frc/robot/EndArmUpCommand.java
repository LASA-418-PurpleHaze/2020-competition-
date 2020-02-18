//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class EndArmUpCommand extends Command {
    public EndArmUpCommand()
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
        Robot.hazyEndArm.foldUp();
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