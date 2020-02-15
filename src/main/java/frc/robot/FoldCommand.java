package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class FoldCommand extends Command {
    public FoldCommand()
    {
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.hazyColorArm.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyColorArm.fold();
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