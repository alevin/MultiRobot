// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.CommandRobotTwoTalonSRXDrive.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.team5507.CommandRobotTwoTalonSRXDrive.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class DriveTrain extends SubsystemBase {
  DifferentialDrive drive;
  WPI_TalonSRX m1_Motor;
  WPI_TalonSRX m2_Motor;
  /** Creates a new DriveTrain. */

  public DriveTrain() {

    m1_Motor = new WPI_TalonSRX(Constants.MOTOR1);
    m2_Motor = new WPI_TalonSRX (Constants.MOTOR2);

    m2_Motor.setInverted(true);
    drive = new DifferentialDrive(m1_Motor, m2_Motor);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoystick(XboxController controller) {
    drive.arcadeDrive(controller.getLeftY() * Constants.SPEED, controller.getRightX() * Constants.SPEED);
  }

  public void driveForward() {
   drive.arcadeDrive(0.5 * Constants.SPEED, 0);
  }

  public void stop() {
    m1_Motor.set(ControlMode.PercentOutput, 0);
  }

}
