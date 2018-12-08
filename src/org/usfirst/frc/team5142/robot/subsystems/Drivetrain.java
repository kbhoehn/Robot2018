package org.usfirst.frc.team5142.robot.subsystems;

import org.usfirst.frc.team5142.robot.commands.DriveWithJoysticks;

//import com.ctre.CANTalon.TalonControlMode;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DigitalOutput;
import edu.wpi.first.wpilibj.Ultrasonic;
import edu.wpi.first.wpilibj.command.Subsystem;
import com.ctre.phoenix.*;
/**
 *
 */
public class Drivetrain extends Subsystem {

    // Assign encoders to CAN network
	TalonSRX LeftMaster = new TalonSRX(1);
	TalonSRX RightMaster = new TalonSRX(2);
	TalonSRX LeftSlave = new TalonSRX(4);
	TalonSRX RightSlave = new TalonSRX(3);
	//RobotDrive myDrive = new RobotDrive(1,0,2,3); 
    //private RobotDrive MainDrive = new RobotDrive(RobotMap.Drive_Left,RobotMap.Drive_Right);
	
	
//	public DigitalInput echo = new DigitalInput(1);
//	public DigitalOutput trig = new DigitalOutput(0);
	public DigitalInput echo2 = new DigitalInput(2);
	public DigitalOutput trig2 = new DigitalOutput(3);

	public Ultrasonic front = new Ultrasonic(1, 0);
	public Ultrasonic NotFront = new Ultrasonic(trig2,echo2);
	
	public Drivetrain(){
		//Have the slave (backup) encoders follow the master (main) encoders for each side
		LeftSlave.follow(LeftMaster);
		RightSlave.follow(RightMaster);
		LeftMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		RightMaster.configSelectedFeedbackSensor(FeedbackDevice.QuadEncoder, 0, 0);
		RightMaster.setSensorPhase(true);
	}
	
	public double GetRightEncoder(){
		return LeftMaster.getSelectedSensorPosition(0) * 0.0128;
	}
	
	public double GetLeftEncoder(){
		return RightMaster.getSelectedSensorPosition(0)*0.0128;
	}
	
	public void ResetEncoder(){
		LeftMaster.setSelectedSensorPosition(0,0,0);
		RightMaster.setSelectedSensorPosition(0,0,0);
	}
	
	public double Average(){
		return (this.GetLeftEncoder()+this.GetRightEncoder())/2;
	//	return (((LeftMaster.getSelectedSensorPosition(0)) + (RightMaster.getSelectedSensorPosition(0))/2)) * 0.0183984375;
		
	}
	
	
	public void Drive(double left, double right){
		LeftMaster.set(ControlMode.PercentOutput, -left);
		RightMaster.set(ControlMode.PercentOutput, right);
	}
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
    	setDefaultCommand(new DriveWithJoysticks());
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


    /*public void ArcadeDrive(Joystick Driver) {
	MainDrive.arcadeDrive(Driver.getY(),Driver.getX());

	}

		public void AutoArcadeDrive(int moveValue, int rotateValue){
  		MainDrive.arcadeDrive(moveValue, rotateValue);
}

		public void stop(){
 		MainDrive.drive(0, 0);
}*/

     public double ReadUltrasonic(){
 	  return front.getRangeInches();
      }

     public double ReadUltrasonic2(){
		return NotFront.getRangeInches();
     }
}
    
    // public void ArcadeDrive(double leftMotorPower, double rightMotorPower) {
  	// TODO Auto-generated method stub
//}


//}

