// //Imports fot the Subsystem and its functions
// package frc.robot;


// import edu.wpi.first.wpilibj.SerialPort;

// import edu.wpi.first.wpilibj.command.Subsystem;

// public class HazySerialPort extends Subsystem {
    
//     private SerialPort hazyPort;

//     public HazySerialPort(){
//         hazyPort = new SerialPort(RobotMap.BAUDRATE, SerialPort.Port.kMXP);
//         hazyPort.enableTermination();
//     }

//     public void getPortInfo(){
//         String data = hazyPort.readString();
//         if(!data.equals(""))
//             System.out.println(data);
//     }
    
//     @Override
//     public void initDefaultCommand(){
//         setDefaultCommand(Robot.commandGetData);
//     }
// }