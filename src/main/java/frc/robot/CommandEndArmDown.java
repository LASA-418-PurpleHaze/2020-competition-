//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class CommandEndArmDown extends Command {
    public CommandEndArmDown()
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
        return true;
    }

    @Override
    protected void interrupted()
    {
        
    }
}