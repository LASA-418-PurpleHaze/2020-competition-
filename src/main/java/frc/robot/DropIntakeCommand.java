//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class DropIntakeCommand extends Command {

    public DropIntakeCommand()
    {
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize()
    {
        Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyIntake.moveIntake();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted(){}
}