//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandHighFeedDefault extends Command
{
    public CommandHighFeedDefault()
    {
        super.requires(Robot.hazyHighFeeder);
    }
    @Override
    protected void initialize()
    {
        // Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        Robot.hazyLowFeeder.stop();

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