package frc.robot;

import frc.robot.Robot;
import edu.wpi.first.wpilibj.command.Command;

public class GoToColorCommand extends Command {
    public GoToColorCommand()
    {
        super.requires(Robot.hazyColorArm);
    }
    
    @Override
    protected void initialize()
    {
        Robot.hazyColorArm.initialize();
        Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute()
    {
        //Robot.hazyColorArm.goToColor("Blue");
        //Robot.hazyColorArm.goToColor("Green");
        //Robot.hazyColorArm.goToColor("Yellow");
        //Robot.hazyColorArm.goToColor("Red");
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