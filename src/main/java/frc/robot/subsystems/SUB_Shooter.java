package frc.robot.subsystems;


import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
public class SUB_Shooter extends SubsystemBase{

  private final static TalonSRX shootMotor = new TalonSRX(40);
  private final static TalonSRX feedMotor = new TalonSRX(41);
  public boolean shootBool;
  public boolean feedBool;
  public double adjShootSpeed;
  public double adjFeedSpeed;
  
  public void setShooterSpeed(double speed){
    
    shootMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }
  public void setFeedSpeed(double speed){
    feedMotor.set(TalonSRXControlMode.PercentOutput, speed);
  }

  public void increaseShootSpeed(){
    if ((adjShootSpeed < 0) && (adjShootSpeed > -1)){
      adjFeedSpeed += .05;
    }
  }
  public void decreaseShootSpeed(){
    if ((adjShootSpeed < 0) && (adjShootSpeed > -1)){
      adjFeedSpeed -= .05;
    }
  }
  public void increaseFeedSpeed(){
    if ((adjFeedSpeed < 0) && (adjFeedSpeed > -1)){
      adjFeedSpeed += .05;
    }
  }
  public void decreaseFeedSpeed(){
    if ((adjFeedSpeed < 0) && (adjFeedSpeed > -1)){
      adjFeedSpeed -= .05;
    }
  }


  public SUB_Shooter() {
    shootMotor.enableCurrentLimit(true);
    shootMotor.configPeakCurrentLimit(50);
    feedMotor.enableCurrentLimit(true);
    feedMotor.configPeakCurrentLimit(50);
    
  }
}

