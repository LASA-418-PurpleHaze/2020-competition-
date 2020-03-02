// //Imports fot the Command
// package frc.robot;

// import edu.wpi.first.wpilibj.command.CommandGroup;
// import edu.wpi.first.wpilibj.command.WaitCommand;

// public class CommandGroupAuton extends CommandGroup {

//     public CommandGroupAuton(){
//        addParallel(Robot.commandAutonMove);
//        addSequential(Robot.commandToggleTurn);
//        addSequential(Robot.commandShooterSpit);
//        addParallel(Robot.commandSwallowHighFeed);
//        addSequential(new WaitCommand(2));
//        addSequential(Robot.commandHighFeedDefault);
//        addSequential(new WaitCommand(2));
//        addSequential(new CommandSwallowHighFeed());
//        addSequential(new WaitCommand(2));
//        addSequential(new CommandHighFeedDefault());
//        addSequential(new WaitCommand(2));
//        addSequential(new CommandSwallowHighFeed());
//        addSequential(new WaitCommand(3));
//        addSequential(new CommandHighFeedDefault());
//        addSequential(new CommandAutonTurn(180.0));
//        addSequential(new CommandAutonMove(7.0));
//     }
// }