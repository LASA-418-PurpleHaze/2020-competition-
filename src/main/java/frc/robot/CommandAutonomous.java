package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class CommandAutonomous extends Command
{
    public CommandAutonomous()
    {
        super.requires(Robot.hazyPathMecBase);
    }
    @Override
    protected void initialize()
    {
        Robot.hazyPathMecBase.initialize();
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