//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class CommandLowFeedDefault extends Command
{
    public CommandLowFeedDefault()
    {
        super.requires(Robot.hazyLowFeeder);
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