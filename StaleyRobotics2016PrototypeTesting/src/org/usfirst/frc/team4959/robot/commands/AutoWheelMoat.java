package org.usfirst.frc.team4959.robot.commands;

import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;
import org.usfirst.frc.team4959.robot.commands.Auto.DriveFoward;

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
