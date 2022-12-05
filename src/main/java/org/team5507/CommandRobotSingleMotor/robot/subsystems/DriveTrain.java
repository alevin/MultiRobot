// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.CommandRobotSingleMotor.robot.subsystems;

import edu.wpi.first.wpilibj.XboxController;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.team5507.CommandRobotSingleMotor.robot.Constants;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

public class DriveTrain extends SubsystemBase {
  WPI_TalonFX m1_Motor;

  /** Creates a new DriveTrain. */

  public DriveTrain() {

    m1_Motor = new WPI_TalonFX(Constants.MOTOR1);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void driveWithJoystick(XboxController controller) {
    m1_Motor.set(ControlMode.PercentOutput, controller.getLeftY() * Constants.SPEED);
    //System.out.println("getY = " + controller.getLeftY());
  }

  public void driveForward() {
    m1_Motor.set(ControlMode.PercentOutput, 0.5 * Constants.SPEED);
  }

  public void stop() {
    m1_Motor.set(ControlMode.PercentOutput, 0);
  }

}
