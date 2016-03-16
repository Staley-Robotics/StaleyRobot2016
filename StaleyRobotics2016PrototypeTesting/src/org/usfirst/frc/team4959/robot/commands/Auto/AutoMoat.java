package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoMoat extends CommandGroup {
    
    public  AutoMoat() {
    	// drive forward for (speed, time)
    	addParallel(new ZeroEncoder());
    	addSequential(new DriveFoward(0.8, 5.3));
    }
}
