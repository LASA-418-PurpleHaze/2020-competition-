//Imports fot the Command
package frc.robot;

import edu.wpi.first.wpilibj.command.Command;

public class CommandGetData extends Command {
    public CommandGetData(){
        super.requires(Robot.hazySerialPort);
    }
    
    @Override
    protected void initialize(){
        // Robot.hazyColorArm.initialize();
        // Robot.hazyColorSensor.initialize();
    }

    @Override
    protected void execute(){ 
        Robot.hazySerialPort.getPortInfo();
    }

    @Override
    protected boolean isFinished(){
        return false;
    }

    @Override
    protected void interrupted(){}
}