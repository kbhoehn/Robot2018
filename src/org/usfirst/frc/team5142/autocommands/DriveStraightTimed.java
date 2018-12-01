package org.usfirst.frc.team5142.autocommands;

import org.usfirst.frc.team5142.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveStraightTimed extends Command {

    
	double leftMotorPower;
	double rightMotorPower;
	
	  public DriveStraightTimed(double setLeftMotorPower, double setRightMotorPower, double time ) {
	    	
	    	this.setTimeout(time);
	    	this.leftMotorPower = setLeftMotorPower;
	    	this.rightMotorPower = setRightMotorPower;
	    	
	requires(Robot.drivetrain);
	

        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
    
    Robot.drivetrain.Drive(leftMotorPower, rightMotorPower);
    
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();
    }

    // Called once after isFinished returns true
    protected void end() {
    
    Robot.drivetrain.Drive(0, 0);
    
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
