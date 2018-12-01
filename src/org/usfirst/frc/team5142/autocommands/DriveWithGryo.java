package org.usfirst.frc.team5142.autocommands;

import org.usfirst.frc.team5142.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithGryo extends Command {

   
	public double mTime;
	public double mSpeed;
	public double mKp;
	public double mAngle;
	public double tolerance;
	public double error;

	
	
	
	
	
	
	public DriveWithGryo(double aAngle, double aSpeed, double aTime, double aKp) {
        
    requires(Robot.gyro);	
    this.mSpeed = aSpeed;
	this.mKp = aKp;
	tolerance = 0.5;
	this.mAngle = aAngle;
	
	
	
	setTimeout(aTime);
    	
    	
    	// Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
  
    		double speed;
    	   error = Math.abs(mAngle-Robot.gyro.GetYaw());
    	     
    	   if(error*mKp > mSpeed){
    		   speed = mSpeed;
    	   }
    	   else{
    		   speed = error*mKp;
    	   }
    	     
    	     if(mAngle > Robot.gyro.GetYaw()){
    	    	 Robot.drivetrain.Drive(-speed, speed);
    	    
    	     }
    	     else{
    	    	 Robot.drivetrain.Drive(speed, -speed);
    	     }
    	    
    
    
    
    
    
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut();// || (error) <= (tolerance);
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
