package org.usfirst.frc.team4959.robot.commands.Auto;

import org.usfirst.frc.team4959.robot.commands.Delay;
import org.usfirst.frc.team4959.robot.commands.Arm.SetArm;
import org.usfirst.frc.team4959.robot.commands.Arm.ZeroEncoder;

import edu.wpi.first.wpilibj.command.CommandGroup;

/**
 *
 */
public class AutoWheelUtil extends CommandGroup {
    
    public  AutoWheelUtil() {
    	addParallel(new ZeroEncoder());
    	addParallel(new SetArm(45));
    	addSequential(new DriveFoward(0.8, 2.5));
    }
}
