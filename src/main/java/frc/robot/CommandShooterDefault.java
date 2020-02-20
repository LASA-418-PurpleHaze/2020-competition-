//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandShooterDefault extends Command {
    public CommandShooterDefault(){
        super.requires(Robot.hazyShooter);
    }

    @Override
    protected void initialize(){
        // Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute(){
        Robot.hazyShooter.stopShooter();
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}