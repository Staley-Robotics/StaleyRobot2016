package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoWheelMoat extends CommandGroup {
    
    public  AutoWheelMoat() {
    	addParallel(new ZeroEncoder());
    	addSequential(new DriveFoward(0.6, 2.7));
    }
}
