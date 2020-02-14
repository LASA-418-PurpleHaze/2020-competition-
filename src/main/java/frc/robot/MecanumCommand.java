package frc.robot;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.OI;

public class MecanumCommand extends Command
{
    public MecanumCommand()
    {
        super.requires(Robot.HazyMecBase);
    }
    @Override
    protected void initialize()
    {
        //Doesn't actually do anything right now, look into whether or not we even need an intialization command
        Robot.HazyMecBase.initialize();
    }
    @Override
    protected void execute()
    {
        Robot.HazyMecBase.driveCartesian(-1* OI.getRightX(), OI.getLeftY(), -1 * OI.getLeftX());

    }

    @Override
    protected boolean isFinished()
    {
        return false;
    }

    @Override
    protected void interrupted()
    {
        Robot.HazyMecBase.driveCartesian(0, 0, 0);
    }
}