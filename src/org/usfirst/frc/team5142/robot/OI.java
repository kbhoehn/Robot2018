/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5142.robot;

import org.usfirst.frc.team5142.robot.commands.PowerClimber;
import org.usfirst.frc.team5142.robot.commands.PowerElevator;
import org.usfirst.frc.team5142.robot.commands.PowerGrabber;
import org.usfirst.frc.team5142.robot.commands.PowerLiftOff;
import org.usfirst.frc.team5142.robot.commands.PowerPusher;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.JoystickButton;

/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
	Joystick Driver= new Joystick(0);
	Joystick NotDriver = new Joystick(1);
public OI() {
	
	JoystickButton grabberbutton = new JoystickButton(Driver, 1);
	grabberbutton.toggleWhenPressed(new PowerGrabber());
	
	JoystickButton elevatorbutton = new JoystickButton(Driver,2);
	elevatorbutton.whileHeld(new PowerElevator());

	JoystickButton climberbutton = new JoystickButton(Driver,3);
	climberbutton.whileHeld(new PowerClimber());

	JoystickButton pusherbutton = new JoystickButton(NotDriver,1);
	pusherbutton.whileHeld(new PowerPusher());
	
	JoystickButton Notelevatorbutton = new JoystickButton(NotDriver,3);
	Notelevatorbutton.whileHeld(new PowerElevator());

	JoystickButton BlastOff = new JoystickButton(NotDriver,4);
	BlastOff.toggleWhenPressed(new PowerLiftOff());

}

	/*public Joystick getJoystick (){
	return Driver;
	}*/

	/*public double GetControllerValue(){
	return controller.getRawAxis(1);

}*/

	public double GetLeftJoystick(){
		return Driver.getRawAxis(1);
	}
	public double GetRightJoystick(){
		return NotDriver.getRawAxis(1);
	}
}
