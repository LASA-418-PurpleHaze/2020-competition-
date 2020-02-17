//Imports fot the Command
package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class SpinWheelCommand extends Command {
    public SpinWheelCommand ()
    {
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.hazyColorArm.initialize();
        Robot.hazyColorSensor.initialize();
        Robot.hazyColorArm.setInitColor();
    }

    @Override
    protected void execute()
    {
        Robot.hazyColorArm.spinWheel(4);
    }

    @Override
    protected boolean isFinished()
    {
        return Robot.hazyColorArm.spinWheelIsFinished();
    }

    @Override
    protected void interrupted()
    {
        
    }
}