package org.usfirst.frc.team4959.robot.subsystems;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.networktables.NetworkTable;

/**
 *  It don't work ¯\_(ツ)_/¯
 *  geogg bu did 902
 */
public class Vision extends Subsystem {
	
	double goadDiagonalPx = 0;
	double goalDiagonal = 18.44;
	double goalWidth = 14;
	double goalHight =12;
	double goalWidthPx = 0;
	double f = 360;//1491.43;
	double distance = 0;
	
	public double findDistance() {
		// Gets value from RR
		goadDiagonalPx = NetworkTable.getTable("SmartDashboard").getNumber("distance", 0.0);
		
		// Finds width in pixels of goal
		goalWidthPx = (goadDiagonalPx / (goalDiagonal/goalWidth));
		distance = ((goalWidth*f)/goalWidthPx);
		
		System.out.println("Px Size: " + goalWidthPx);
		
		return distance;
	}

    public void initDefaultCommand() {
        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }
}

