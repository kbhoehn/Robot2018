package org.usfirst.frc.team5142.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Grabber extends Subsystem {

	 Solenoid GrabBlock = new Solenoid(0);
		
	   public void TurnOnSolenoid(){
		   GrabBlock.set(true);
	   }
	   
	   public void TurnOffSolenoid(){
		   GrabBlock.set(false);
	   }
		
	
	
	
	
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

