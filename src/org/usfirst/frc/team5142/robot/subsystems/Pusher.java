package org.usfirst.frc.team5142.robot.subsystems;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class Pusher extends Subsystem {

    // Put methods for controlling this subsystem
    // here. Call these from Commands.

	Solenoid PushBlock = new Solenoid(5);
	
	
	public void TurnOnPusher(){
		PushBlock.set(true);
		
	}
	public void TurnOffPusher(){
		PushBlock.set(false);
	}
	
	
    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

