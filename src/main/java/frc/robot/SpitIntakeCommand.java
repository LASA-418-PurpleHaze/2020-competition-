//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class SpitIntakeCommand extends Command {

    public SpitIntakeCommand()
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
        Robot.hazyIntake.intakeSpit();
    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted(){}
}