package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinWheelCommand extends Command {
    public SpinWheelCommand ()
    {
        super.requires(Robot.colorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.colorArm.initialize();
        Robot.colorSensor.initialize();
        Robot.colorArm.setInitColor();
    }

    @Override
    protected void execute()
    {
        Robot.colorArm.spinWheel(4);
    }

    @Override
    protected boolean isFinished()
    {
        return Robot.colorArm.spinWheelIsFinished();
    }

    @Override
    protected void interrupted()
    {
        
    }
}