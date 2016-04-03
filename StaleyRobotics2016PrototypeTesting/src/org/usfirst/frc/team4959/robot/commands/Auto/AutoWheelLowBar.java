package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoWheelLowBar extends CommandGroup {
    
    public  AutoWheelLowBar() {
    	addParallel(new ZeroEncoder());
    	addSequential(new DriveFoward(0.6, 2.7));
    }
}
