//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class ColorCommand extends Command
{
    public ColorCommand()
    {
        super.requires(Robot.hazyColorSensor);
    }
    @Override
    protected void initialize()
    {
        Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        System.out.println(Robot.hazyColorSensor.getColor());
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