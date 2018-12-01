package org.usfirst.frc.team5142.robot.subsystems;

import com.kauailabs.navx.frc.*;

import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class NotGyro extends Subsystem {
	AHRS gyro = new AHRS(SPI.Port.kMXP);
	
	
	public double GetYaw(){
		return gyro.getYaw();
		
	}

	public void ResetGyro(){
		
		gyro.reset();
	}
	
	
	
	
	
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

