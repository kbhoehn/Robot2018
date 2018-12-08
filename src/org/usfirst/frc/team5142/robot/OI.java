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
	// Initialize joysticks
	Joystick Driver= new Joystick(0);
	Joystick NotDriver = new Joystick(1);
public OI() {
	// Joystick buttons and specifications, as interpretted by Ken:
	// Currently uses Thrustmaster T.16000M
	// Bind button (1) so that when its pressed, it triggers the PowerGrabber command.
	// GRABS THING
	// trigger button on left joystick
	JoystickButton grabberbutton = new JoystickButton(Driver, 1);
	grabberbutton.toggleWhenPressed(new PowerGrabber());

	// Bind button (2) so that when its held, it triggers PowerElevator
	// LETS ELEVATOR DOWN
	// lower button on left joystick
	JoystickButton elevatorbutton = new JoystickButton(Driver,2);
	elevatorbutton.whileHeld(new PowerElevator());

	// Bind button (3) so that when its held, it triggers the PowerClimber command
	// MOVES ELEVATOR UP
	// outer button on left joystick
	JoystickButton climberbutton = new JoystickButton(Driver,3);
	climberbutton.whileHeld(new PowerClimber());

	//Inner button on left joysitck does nothing (button 4)

	// Bind Button (1) so that when its held, it triggers PowerPusher command
	// PUSHES THING OUT
	// trigger button on right joystick
	JoystickButton pusherbutton = new JoystickButton(NotDriver,1);
	pusherbutton.whileHeld(new PowerPusher());

	// Bind button (3) so that when its held, it triggers PowerElevator command
	// LETS ELEVATOR DOWN
	// inner button on right joystick
	JoystickButton Notelevatorbutton = new JoystickButton(NotDriver,3);
	Notelevatorbutton.whileHeld(new PowerElevator());

	// Bind button (4) to PowerLiftOff command
	// TRIGGERS MOTOR TO LIFT ROBOT
	// outer button on right joystick
	JoystickButton BlastOff = new JoystickButton(NotDriver,4);
	BlastOff.toggleWhenPressed(new PowerLiftOff());

}
	/*public Joystick getJoystick (){
	return Driver;
	}*/

	/*public double GetControllerValue(){
	return controller.getRawAxis(1);

}*/

	// Gets the value of the joysticks position, stores it in double
	public double GetLeftJoystick(){ return Driver.getRawAxis(1); }
	public double GetRightJoystick(){
		return NotDriver.getRawAxis(1);
	}
}
