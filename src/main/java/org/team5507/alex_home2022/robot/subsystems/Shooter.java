// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package org.team5507.alex_home2022.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonFX;
//import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import org.team5507.alex_home2022.robot.Constants;

public class Shooter extends SubsystemBase {
  WPI_TalonFX shooter;

  /** Creates a new Shooter. */
  public Shooter() {
    shooter = new WPI_TalonFX(Constants.SHOOTER_ID);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void shootBall(double speed) {
    shooter.set(speed);

  }

  public void stop() {
    shooter.set(0);
  }
}
