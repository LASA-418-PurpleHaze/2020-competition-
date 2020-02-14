package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import frc.robot.RobotMap;
import edu.wpi.first.wpilibj.buttons.JoystickButton;
import edu.wpi.first.wpilibj.command.Command;



public class OI
{
    //Declare and initialize all input devices
    public static Joystick leftJoystick = new Joystick(RobotMap.LEFTJOYSTICKPORT);
    public static Joystick rightJoystick = new Joystick(RobotMap.RIGHTJOYSTICKPORT);

    public static JoystickButton rightTrigger = new JoystickButton(rightJoystick, 1);
    public static JoystickButton leftTrigger = new JoystickButton(leftJoystick, 1);

    public static JoystickButton leftThumbButton = new JoystickButton(leftJoystick, 2);
    public static JoystickButton rightThumbButton = new JoystickButton(rightJoystick, 2);

    public static JoystickButton leftMidButton = new JoystickButton(leftJoystick, 3);
    public static JoystickButton rightMidButton = new JoystickButton(rightJoystick, 3);

    public static JoystickButton leftLeftButton = new JoystickButton(leftJoystick, 4);
    public static JoystickButton rightLeftButton = new JoystickButton(rightJoystick, 4);
    
    public static HazyController controller = new HazyController(RobotMap.CONTROLLERPORT);
    

    public OI(){
        //Set commands to run on button press
        
        // rightThumbButton.whenPressed(new GoTo());

        // leftThumbButton.whenPressed(new GoTo2());

        // controller.getLeftBumper().whenPressed(new GrabberOpenCommand());
        
        // controller.getRightBumper().whenPressed(new GrabberCloseCommand());

        // controller.getLeftBumper().whenPressed(new GrabberOpenCommand());

        // rightTrigger.whileHeld(new GrabberIntakeCommand());

        // //controller.getXButton().whileHeld(new GrabberIntakeCommand());

        // controller.getYButton().whileHeld(new GrabberSpitCommand());

        
        // if(controller.getHazyTriggers().getLeftAxis())
        //     new LiftGrabberCommand().execute();

        // if(controller.getHazyTriggers().getRightAxis())
        //     new LowerGrabberCommand().execute();
        
    
    }
    
    //Getter methods for all our input devices
    public static double getLeftX()
    {
        return controller.getHazyJoysticks().getLeftXAxis();
    }

    public static double getLeftY()
    {
        return controller.getHazyJoysticks().getLeftYAxis();
    }

    public static double getRightX()
    {
        return controller.getHazyJoysticks().getRightXAxis();
    }

    public static double getRightY()
    {
        return controller.getHazyJoysticks().getRightYAxis();   
    }
    


    
    
        
    
}

    




    