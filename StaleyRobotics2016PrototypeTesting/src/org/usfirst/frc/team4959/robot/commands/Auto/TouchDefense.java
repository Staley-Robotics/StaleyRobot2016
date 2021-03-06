package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TouchDefense extends CommandGroup {
    
    public  TouchDefense() {
    	// drive forward for (speed, time)
    	addParallel(new ZeroEncoder());
    	addSequential(new DriveFoward(-.7, 1));
    }
}
