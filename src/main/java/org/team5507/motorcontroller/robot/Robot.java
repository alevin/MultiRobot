// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.motorcontroller.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.TimedRobot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;

/**
 * This sample program shows how to control a motor using a joystick. In the operator control part
 * of the program, the joystick is read and the value is written to the motor.
 *
 * <p>Joystick analog values range from -1 to 1 and speed controller inputs also range from -1 to 1
 * making it easy to work together.
 */
public class Robot extends TimedRobot {
  private static final int kMotorPort = 6;
  private static final int kXboxPort = 0;

  private WPI_TalonFX m_motor;
  private XboxController m_xbox;

  @Override
  public void robotInit() {
    m_motor = new WPI_TalonFX(kMotorPort);
    m_xbox = new XboxController(kXboxPort);
  }

  @Override
  public void teleopPeriodic() {
        m_motor.set(ControlMode.PercentOutput, m_xbox.getRightY());
  }
}
