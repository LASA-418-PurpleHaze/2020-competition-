//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandIntakeDefault extends Command
{
    public CommandIntakeDefault()
    {
        super.requires(Robot.hazyIntake);
    }
    @Override
    protected void initialize()
    {
        // Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        Robot.hazyIntake.intakeStopLift();
        Robot.hazyIntake.intakeStopSpin();
        //Robot.hazyIntake.printButtons();

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