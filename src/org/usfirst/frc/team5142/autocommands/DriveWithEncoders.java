package org.usfirst.frc.team5142.autocommands;

import org.usfirst.frc.team5142.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithEncoders extends Command {

   
		public double mTime;
		public double mSpeed;
		public double mKp;
		public double mDistance;
		public double tolerance;
		public double error;
	
		
		/**
		 * 
		 * @param aDistance
		 * @param aSpeed
		 * @param aTime
		 * @param aKp
		 */
		
		
	public DriveWithEncoders(double aDistance, double aSpeed, double aTime, double aKp) {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
    
		requires(Robot.drivetrain);
	
		this.mDistance = aDistance;
		this.mSpeed = aSpeed;
		this.mKp = aKp;
		tolerance = 2;
		
		setTimeout(aTime);
				
	
	
	}

    // Called just before this Command runs the first time
    protected void initialize() {
    

    
    
    
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
    
    
     error = Math.abs(mDistance-Robot.drivetrain.Average());
     double speed = error*mKp;
    
     
     if(mDistance-Robot.drivetrain.Average()>0){
    	 Robot.drivetrain.Drive(-speed, -speed);
    
     }
     else{
    	 Robot.drivetrain.Drive(speed, speed);
     }
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return isTimedOut()||(error) <= (tolerance);
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
