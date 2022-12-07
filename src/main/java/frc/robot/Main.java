// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.RobotBase;

/**
 * Do NOT add any static variables to this class, or any initialization at all. Unless you know what
 * you are doing, do not modify this file except to change the parameter class to the startRobot
 * call.
 */
public final class Main {
  private Main() {}

  /**
   * Main initialization function. Do not perform any initialization here.
   *
   * <p>If you change your main robot class, change the parameter type.
   */
  public static void main(String... args) {
    //RobotBase.startRobot(Robot::new);
    //RobotBase.startRobot(org.team5507.CommandRobotSingleMotor.robot.Robot::new);
    //RobotBase.startRobot(org.team5507.CommandRobotSingleMotorAuto.robot.Robot::new);

    // src\main\java\org\team5507\motorcontroller\robot\Robot.java
    // RobotBase.startRobot(org.team5507.CommandRobotTwoTalonFXDrive.robot.Robot::new);
    // RobotBase.startRobot(org.team5507.CommandRobotTwoTalonSRXDrive.robot.Robot::new);

    // RobotBase.startRobot(org.team5507.BearSwerve001.robot.Robot::new);
     RobotBase.startRobot(org.team5507.FalconRecharged2021.robot.Robot::new);

  }
}
