package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FoldCommand extends Command {
    public FoldCommand()
    {
        super.requires(Robot.colorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.colorArm.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.colorArm.fold();
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