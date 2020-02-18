//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class EndArmDownCommand extends Command {
    public EndArmDownCommand()
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
        Robot.hazyEndArm.foldDown();
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