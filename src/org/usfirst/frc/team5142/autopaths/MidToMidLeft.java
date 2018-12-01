package org.usfirst.frc.team5142.autopaths;

import org.usfirst.frc.team5142.autocommands.DriveWithEncoders;
import org.usfirst.frc.team5142.autocommands.DriveWithGryo;
import org.usfirst.frc.team5142.autocommands.PUUUUUUUSH;
import org.usfirst.frc.team5142.autocommands.ReleaseCube;
import org.usfirst.frc.team5142.autocommands.RiseElevatorToSwitch;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class MidToMidLeft extends CommandGroup {

    public MidToMidLeft() {
   
    	
    	addSequential(new DriveWithEncoders(121, 0.75,2 , 0.02)); 
    	addSequential(new DriveWithGryo(-90, 0.5,2,0.02));
    	addSequential(new DriveWithEncoders(15, 0.75,2 , 0.02)); 
    	addSequential(new RiseElevatorToSwitch());
    	addSequential(new DriveWithGryo(90, 0.5,2,0.02));
    	addSequential(new DriveWithEncoders(121, 0.75,2 , 0.02)); 
    	addSequential(new ReleaseCube()); 
    	addSequential(new PUUUUUUUSH());
    	
    	
    	
    	
    	
    	
    	
    	
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
