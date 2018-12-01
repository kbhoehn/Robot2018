package org.usfirst.frc.team5142.robot.subsystems;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Elevator extends Subsystem {

  
	
	Solenoid Lift = new Solenoid(2);
	DoubleSolenoid NotLift = new DoubleSolenoid(3,4);
	
	
	public void TurnOnLift(){
		Lift.set(true);
		
	}
	public void TurnOffLift(){
		Lift.set(false);
	}
	public void TurnOnNotLift(){
		NotLift.set(DoubleSolenoid.Value.kForward);
		
	}
	public void TurnOffNotLift(){
		NotLift.set(DoubleSolenoid.Value.kReverse);
	}
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

