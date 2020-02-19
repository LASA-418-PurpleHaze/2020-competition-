//Imports fot the Command
package frc.robot;


import edu.wpi.first.wpilibj.command.Command;

public class CommandShooterSpit extends Command {

    public CommandShooterSpit()
    {
        super.requires(Robot.hazyShooter);
    }
    
    @Override
    protected void initialize()
    {
        // Robot.hazyShooter.initialize();
    }

    @Override
    protected void execute()
    {
        Robot.hazyShooter.shooterSpit();
        //System.out.println("Pressed Shooter Spit");
    }

    @Override
    protected boolean isFinished()
    {
        return true;
    }

    @Override
    protected void interrupted(){}
}