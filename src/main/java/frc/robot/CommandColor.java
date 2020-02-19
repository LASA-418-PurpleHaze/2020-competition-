//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class CommandColor extends Command
{
    public CommandColor()
    {
        super.requires(Robot.hazyColorSensor);
    }
    @Override
    protected void initialize()
    {
        // Robot.hazyColorSensor.initialize();
    }
    @Override
    protected void execute()
    {
        System.out.println(Robot.hazyColorSensor.getColor());
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted()
    {
        
    }
}