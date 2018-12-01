package org.usfirst.frc.team5142.autocommands;

import org.usfirst.frc.team5142.autopaths.DriveAndTurn;
import org.usfirst.frc.team5142.autopaths.HomeToSwitchLeft;
import org.usfirst.frc.team5142.robot.util.GameState;
import org.usfirst.frc.team5142.robot.util.GameState.Side;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class RightSwitch extends CommandGroup {


       
    	
	public RightSwitch(GameState gameState) {
    	       
    	    	if (gameState.mySwitchSide == Side.RIGHT){
    	    		
    	    		addSequential(new DriveAndTurn());
    	    		
    	    	}
    	    	
    	    	else {
    	    		addSequential(new DriveWithEncoders(90,0.6,2,0.02));
    	    	}
    	
    	
    	
    	
    	
    	
    	// Add Commands here:
        // e.g. addSequential(new Command1());
        //      addSequential(new Command2());
        // these will run in order.

        // To run multiple commands at the same time,
        // use addParallel()
        // e.g. addParallel(new Command1());
        //      addSequential(new Command2());
        // Command1 and Command2 will run in parallel.

        // A command group will require all of the subsystems that each member
        // would require.
        // e.g. if Command1 requires chassis, and Command2 requires arm,
        // a CommandGroup containing them would require both the chassis and the
        // arm.
    }
}
