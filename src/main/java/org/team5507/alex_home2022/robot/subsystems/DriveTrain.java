// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.alex_home2022.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.TalonSRXConfiguration;
//import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
//import edu.wpi.first.wpilibj.motorcontrol.MotorController;
//import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.team5507.alex_home2022.robot.Constants;

public class DriveTrain extends SubsystemBase {

  WPI_TalonSRX  leftMotor;
  WPI_TalonSRX  rightMotor;
 // MotorControllerGroup leftMotors;
 // MotorControllerGroup rightMotors;
  DifferentialDrive drive;

  
  /** Creates a new DriveTrain. */
  public DriveTrain() {

    TalonSRXConfiguration config = new TalonSRXConfiguration();
    config.peakCurrentLimit = 4;
    config.peakCurrentDuration = 1500;
    config.continuousCurrentLimit = 2;

    WPI_TalonSRX  leftMotor = new WPI_TalonSRX (11);
    leftMotor.setInverted(true);
    leftMotor.configAllSettings(config);
    WPI_TalonSRX rightMotor = new WPI_TalonSRX (12);
    rightMotor.setInverted(false);
    drive = new DifferentialDrive(leftMotor,rightMotor);
    rightMotor.configAllSettings(config);


  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoysticks(XboxController controller, double speed)
  {
    drive.arcadeDrive(-1*controller.getRawAxis(Constants.XBOX_LEFT_Y_AXIS)*speed,-1*controller.getRawAxis(Constants.XBOX_LEFT_X_AXIS)*speed);
  }

  public void driveForward(double speed)
  {
    drive.tankDrive(speed, speed);
  }

  public void stop()
  {
    drive.stopMotor();
  }
}
