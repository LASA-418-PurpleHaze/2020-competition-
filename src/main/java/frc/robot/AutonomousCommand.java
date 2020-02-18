package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class AutonomousCommand extends Command
{
    public AutonomousCommand()
    {
        super.requires(Robot.pathMecBase);
    }
    @Override
    protected void initialize()
    {
        Robot.pathMecBase.initialize();
    }
    @Override
    protected void execute()
    {
        //go
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