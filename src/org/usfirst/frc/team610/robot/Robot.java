/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package org.usfirst.frc.team610.robot;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.IterativeRobot;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.Victor;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the build.properties file in the
 * project.
 */
public class Robot extends IterativeRobot {
	
	public Victor leftFront, leftBack, rightFront, rightBack;
	public Victor shooterLeft, shooterRight, feeder, vibrator;
	public DoubleSolenoid shifterOne, shifterTwo, intakeOne, intakeTwo;
	public Joystick driver;
	

	/**
	 * This function is run when the robot is first started up and should be
	 * used for any initialization code.
	 */
	@Override
	public void robotInit() {
		
		leftFront = new Victor(1);
		leftBack = new Victor(0);
		rightBack = new Victor(2);
		rightFront = new Victor(3);
		shooterLeft = new Victor(4);
		driver = new Joystick(0);
		feeder = new Victor(8);
		
		
	}

	/**
	 * This autonomous (along with the chooser code above) shows how to select
	 * between different autonomous modes using the dashboard. The sendable
	 * chooser code works with the Java SmartDashboard. If you prefer the
	 * LabVIEW Dashboard, remove all of the chooser code and uncomment the
	 * getString line to get the auto name from the text box below the Gyro
	 *
	 * <p>You can add additional auto modes by adding additional comparisons to
	 * the switch structure below with additional strings. If using the
	 * SendableChooser make sure to add them to the chooser code above as well.
	 */
	@Override
	public void autonomousInit() {

	}

	/**
	 * This function is called periodically during autonomous.
	 */
	@Override
	public void autonomousPeriodic() {
		
	}

	/**
	 * This function is called periodically during operator control.
	 */
	@Override
	public void teleopPeriodic() {
		double x, y;
		int buttonCounter = 0;
		double left, right;
		y = driver.getRawAxis(1);
		x = driver.getRawAxis(4);
		y = y*y*y;
		x = x*x*x;
		
		left = y-x;
		right = y+x;
		
		//kaj drive
		leftFront.set(left);
		leftBack.set(left);
		rightFront.set(right);
		rightBack.set(right);
		
		
		//shooter toggle
		if(driver.getRawButton(6)) {
			shooterLeft.set(-0.7);
		}
		else {
			shooterLeft.set(0);
		}
		
		
		
		//feeder and vibrator
		if(driver.getRawButton(5)) {
			feeder.set(-0.6);
			vibrator.set(1.0);
		} else {
			feeder.set(0);
			vibrator.set(0);
		}

		
	}

	/**
	 * This function is called periodically during test mode.
	 */
	@Override
	public void testPeriodic() {
	}
}
