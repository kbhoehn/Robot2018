/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team5142.robot;

import org.usfirst.frc.team5142.autopaths.DriveAndTurn;
import org.usfirst.frc.team5142.autopaths.HomeToSwitchLeft;
import org.usfirst.frc.team5142.autopaths.MidToMidRight;
import org.usfirst.frc.team5142.autocommands.CenterSwitch;
import org.usfirst.frc.team5142.autocommands.DriveStraightTimed;
import org.usfirst.frc.team5142.autocommands.DriveWithEncoders;
import org.usfirst.frc.team5142.autocommands.DriveWithGryo;
import org.usfirst.frc.team5142.autocommands.*;
//import org.usfirst.frc.team5142.autocommands.DriveAround;
//import org.usfirst.frc.team5142.robot.subsystems.AutoMXP;
import org.usfirst.frc.team5142.robot.subsystems.Drivetrain;
import org.usfirst.frc.team5142.robot.subsystems.Elevator;
import org.usfirst.frc.team5142.robot.subsystems.Grabber;
import org.usfirst.frc.team5142.robot.subsystems.LiftOff;
import org.usfirst.frc.team5142.robot.subsystems.Limelight;
import org.usfirst.frc.team5142.robot.subsystems.NotGyro;
import org.usfirst.frc.team5142.robot.subsystems.Pusher;
import org.usfirst.frc.team5142.robot.util.GameState;

//import edu.wpi.first.networktables.NetworkTable;
//import edu.wpi.first.networktables.NetworkTableInstance;
import edu.wpi.first.wpilibj.CameraServer;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.command.Command;
import edu.wpi.first.wpilibj.command.Scheduler;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;



/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the TimedRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 *
 * This is the primary code for interacting with driver station and outputing to smart dashboard
 *
 * FYI:
 * Not = RIGHT (Why? No reason - that most powerful element of style.)
 * To upload to Robot, in Eclipse select project then select Run As -> WPIlib deploy,
 * then start praying.
 */
public class Robot extends TimedRobot {
	//public static final ExampleSubsystem kExampleSubsystem
	//		= new ExampleSubsystem();

	//Init subsystems
	public static final Drivetrain drivetrain = new Drivetrain (); 
	public static final NotGyro gyro = new NotGyro();
	public static final Grabber grabber = new Grabber();
	//public static AutoMXP NotAutoMXP = new AutoMXP();
	public static final Pusher pusher = new Pusher();
	public static final Elevator elevator = new Elevator();
	public static final Limelight limelight = new Limelight();
	public static final LiftOff winch = new LiftOff();
	public GameState gameState;
	
	public static final OI oi = new OI();
	
	public static final String CrossBaseLine = "CrossBaseLine";
	public static final String RightSwitch = "RightSwitch";
	public static final String LeftSwitch = "LeftSwitch";
	//public static final String CenterSwitch = "CenterSwitch";
	
	final String defaultAuto = "Default";
	final String customAuto = "My Auto";
	Command autoSelected;
	SendableChooser<String> chooser = new SendableChooser<>();

	Command m_autonomousCommand;
	SendableChooser<Command> m_chooser = new SendableChooser<>();
	
	Command autonomousCommand;
	SendableChooser<String> autochooser = new SendableChooser<>();

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 * Sets up features.
	 */
	@Override
	public void robotInit() {
		//three different autonomous modes to the autochooser. Selected below.
		autochooser.addDefault("Cross BaseLine", CrossBaseLine);
		autochooser.addObject("RightSide", RightSwitch);
		autochooser.addObject("LeftSide", LeftSwitch);
	//	autochooser.addObject("CenterSwitch", CenterSwitch);
		SmartDashboard.putData("Auto mode", autochooser);
		CameraServer.getInstance().startAutomaticCapture(); //camera start
		Robot.elevator.TurnOffNotLift();
	}

	/**
	 * This function is called once each time the robot enters Disabled mode.
	 * You can use it to reset any subsystem information you want to clear when
	 * the robot is disabled.
	 * Useful for quickly turnign the robot on and off
	 */
	@Override
	public void disabledInit() {
		Robot.elevator.TurnOffNotLift();
	}

	@Override
	public void disabledPeriodic() {
		Scheduler.getInstance().run();
		this.gameState = new GameState(DriverStation.getInstance().getGameSpecificMessage());
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString code to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional commands to the
	 * chooser code above (like the commented example) or additional comparisons
	 * to the switch structure below with additional strings & commands.
	 */
	@Override
	public void autonomousInit() {
		String selectedAuto = (String) autochooser.getSelected();
		Robot.elevator.TurnOffNotLift();
		Robot.drivetrain.ResetEncoder();
		Robot.gyro.ResetGyro();
		
	//defines what happens with each autonomous option
	switch (selectedAuto) {
		case "CrossBaseLine":
			autonomousCommand = new DriveWithEncoders(90,0.6,2,0.02);
			break;
		
		case "LeftSwitch":
			autonomousCommand = new LeftSwitch(gameState);
			break;
		
		case "RightSwitch":
		autonomousCommand = new RightSwitch(gameState);
			break;
			
		default:
			autonomousCommand = new DriveWithEncoders(90,0.6,2,0.02);
			break;
	}

	//	autonomousCommand = new DriveStraightTimed(-0.3,-0.3,2);
	//	autonomousCommand = new DriveWithEncoders(-120, 0.6, 5, 0.02);
	//	autonomousCommand = new DriveWithGryo(-90 ,0.5,3,0.030);
		
		//	if(Robot.NotAutoMXP.GetNumber1()){
		//	autoSelected = new DriveAround();
	//	}
		
	//	if(Robot.NotAutoMXP.GetNumber2()){
			
		//}
	//	Robot.drivetrain.ResetEncoder();
		/*
		 * String autoSelected = SmartDashboard.getString("Auto Selector",
		 * "Default"); switch(autoSelected) { case "My Auto": autonomousCommand
		 * = new MyAutoCommand(); break; case "Default Auto": default:
		 * autonomousCommand = new ExampleCommand(); break; }
		 */

		// schedule the autonomous command (example)
		if (autonomousCommand != null) {
			autonomousCommand.start();
		}
	}

	/**
	 * This function is called periodically during autonomous.
	 * Outputs inforation to smart dashboard. Purely for reporting.
	 * SmartDashboard is just for readouts.
	 */
	@Override
	public void autonomousPeriodic(){
		Scheduler.getInstance().run();
		//autoSelected.start();
		SmartDashboard.putNumber("RightEncoder",drivetrain.GetRightEncoder() );
		SmartDashboard.putNumber("LeftEncoder",drivetrain.GetLeftEncoder());
		SmartDashboard.putNumber("Enoder Average", drivetrain.Average());
		SmartDashboard.putNumber("gyro angle",gyro.GetYaw() );
	}

	@Override
	public void teleopInit() {
		// This makes sure that the autonomous stops running when
		// teleop starts running. If you want the autonomous to
		// continue until interrupted by another command, remove
		// this line or comment it out.
		// This is the code that actually runs the drivetrain
		if (autonomousCommand != null) {
			autonomousCommand.cancel();
		}
		Robot.drivetrain.ResetEncoder();
		Robot.drivetrain.front.setEnabled(true); //sets ultrasonic
		Robot.elevator.TurnOffNotLift();
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		Scheduler.getInstance().run();
		
		SmartDashboard.putNumber("Front UltraSonic", drivetrain.ReadUltrasonic());
		SmartDashboard.putNumber("gyro angle",gyro.GetYaw() );
//		SmartDashboard.putBoolean("Bit0",NotAutoMXP.GetNumber1() );
//		SmartDashboard.putBoolean("Bit1",NotAutoMXP.GetNumber2() );
//		SmartDashboard.putBoolean("Bit2",NotAutoMXP.GetNumber3() );
//		SmartDashboard.putBoolean("Bit3",NotAutoMXP.GetNumber4() );
		SmartDashboard.putNumber("RightEncoder",drivetrain.GetRightEncoder() );
		SmartDashboard.putNumber("LeftEncoder",drivetrain.GetLeftEncoder());
		SmartDashboard.putNumber("Enoder Average", drivetrain.Average());
		
		SmartDashboard.putNumber("NotFront UltraSonic", drivetrain.ReadUltrasonic2());
		SmartDashboard.putNumber("LimelightXValue", limelight.GetX());
		SmartDashboard.putNumber("LimelightYValue", limelight.GetY());
		SmartDashboard.putNumber("LimelightAreaValue", limelight.GetArea());
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
