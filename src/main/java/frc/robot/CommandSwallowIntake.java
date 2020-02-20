//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandSwallowIntake extends Command {
    public CommandSwallowIntake()
    {
        super.requires(Robot.hazyIntake);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyIntake.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyIntake.intakeSwallow();
        //System.out.println("Pressed Swallow intake");
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted(){}
}