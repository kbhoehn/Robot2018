package org.usfirst.frc.team5142.robot.commands;

import org.usfirst.frc.team5142.robot.Robot;

import edu.wpi.first.wpilibj.command.Command;

/**
 *
 */
public class DriveWithJoysticks extends Command {

    public DriveWithJoysticks() {
        // Use requires() here to declare subsystem dependencies
        // eg. requires(chassis);
   
    	requires(Robot.drivetrain);
    
    
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
   
   //   Robot.drivetrain.ArcadeDrive(Robot.oi.GetLeftJoystickValue(), Robot.oi.GetRightJoystickValue());
  //      Robot.drivetrain.ArcadeDrive(Robot.oi.getJoystick());
    
    Robot.drivetrain.Drive(Robot.oi.GetLeftJoystick(), Robot.oi.GetRightJoystick());
    
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
  
    	//Robot.drivetrain.stop();
    
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
   
    end();
    
    }
}
