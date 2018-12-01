package org.usfirst.frc.team5142.robot.subsystems;

import edu.wpi.first.wpilibj.Talon;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class LiftOff extends Subsystem {

  Talon winch = new Talon(0);
	
	
	
	public void TakeOffOn(){
		winch.set(0.25);
	}
	
	public void TakeOffOff(){
		winch.set(0.0);

	}
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
      
    	
    	
    	
    	
    	// Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

