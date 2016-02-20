package org.usfirst.frc.team4959.robot.commands.Auto;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class TouchDefense extends CommandGroup {
    
    public  TouchDefense() {
    	// drive forward for (speed, time)
    	addSequential(new DriveFoward(-.7, 1));
    }
}
