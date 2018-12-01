package org.usfirst.frc.team5142.robot.subsystems;

import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.command.Subsystem;

/**
 *
 */
public class AutoMXP extends Subsystem {

   
	public DigitalInput Bit3 = new DigitalInput(14);
	public DigitalInput Bit2 = new DigitalInput(15);
	public DigitalInput Bit1 = new DigitalInput(16);
	public DigitalInput Bit0 = new DigitalInput(17);
	
	
	
	
	
	// Put methods for controlling this subsystem
    // here. Call these from Commands.

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }


  public boolean GetNumber1(){
    	
    	return Bit0.get();
  }

   public boolean GetNumber2(){
    	
    	return Bit1.get();
   }
  
   public boolean GetNumber3(){
   	
   	return Bit2.get();
   }

   public boolean GetNumber4(){
   	
   	return Bit3.get();
   	
   }






}



