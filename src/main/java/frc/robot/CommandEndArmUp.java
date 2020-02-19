//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class CommandEndArmUp extends Command {
    public CommandEndArmUp()
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