package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.ColorSensor;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.ftccommon.ClassManagerFactory;
import com.qualcomm.robotcore.hardware.CRServo;
import java.math.*;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DeviceInterfaceModule;
import com.qualcomm.robotcore.hardware.DigitalChannel;
import android.app.Activity;
import android.graphics.Color;
import android.view.View;

/**
 * Created by Robo-Admin on 12/13/2017.
 */
@Autonomous(name="Blue Autonomous 1", group="autonomous")
@Disabled
public class RedAutonomous1 extends LinearOpMode {

    private DcMotor F1 = null;
    private DcMotor F2 = null;
    private DcMotor R1 = null;
    private DcMotor R2 = null;
    //private DcMotor Winch = null;
    private CRServo claw_rotate = null;
    private DcMotor arm_rotate = null;
    private DcMotor Winch = null;

//    public Servo claw_front_left = null;
//    public Servo claw_front_right = null;
//    public Servo Color_arm = null;
//    public ColorSensor color_sensor_front = null;

    double power;
    double angle;

    double powerF1;
    double powerF2;
    double powerR1;
    double powerR2;

    double Pi = Math.PI/4;

    @Override
    public void runOpMode(){

        telemetry.addData("Status", "Initialized");

        F1 = hardwareMap.get(DcMotor.class, "F1");
        F2 = hardwareMap.get(DcMotor.class, "F2");
        R1 = hardwareMap.get(DcMotor.class, "R1");
        R2 = hardwareMap.get(DcMotor.class, "R2");
        Winch = hardwareMap.get(DcMotor.class, "Winch");
        arm_rotate = hardwareMap.get(DcMotor.class,"arm_rotate");
        claw_rotate = hardwareMap.get(CRServo.class,"claw_rotate");

//        claw_front_left = hardwareMap.get(Servo.class, "claw_front_left");
//        claw_front_right = hardwareMap.get(Servo.class,"claw_front_right");
//        Color_arm = hardwareMap.get(Servo.class,"color_arm");
//
//        color_sensor_front = hardwareMap.get(ColorSensor.class,"color_sensor_front");




        F1.setDirection(DcMotorSimple.Direction.FORWARD);
        F2.setDirection(DcMotorSimple.Direction.FORWARD);
        R1.setDirection(DcMotorSimple.Direction.FORWARD);
        R2.setDirection(DcMotorSimple.Direction.FORWARD);

        //Winch.setDirection(DcMotorSimple.Direction.FORWARD);

        F1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        F2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        Winch.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

//        claw_front_right.setPosition(0);
//        claw_front_left.setPosition(35.);
//        Color_arm.setPosition(90);

        /*public void direction(float angle,float power){
            powerF2 = (power * Math.cos(angle - Pi));
            powerF1 = (power * -Math.cos(angle + Pi));
            powerR1 = (power * -Math.cos(angle - Pi));
            powerR2 = (power * Math.cos(angle + Pi));
            powerF1 = Range.clip(powerF1,-1.0, 1.0);
            powerF2 = Range.clip(powerF2,-1.0, 1.0);
            powerR1 = Range.clip(powerR1,-1.0, 1.0);
            powerR2 = Range.clip(powerR2,-1.0, 1.0);
        }*/



        waitForStart();
        telemetry.addData("version","1.0");


        /*Color_arm.setPosition(90);
        F1.setPower(-.125);
        F2.setPower(-.125);
        R1.setPower(.125);
        R2.setPower(.125);
        sleep(500);
        F1.setPower(0);
        F2.setPower(0);
        R1.setPower(0);
        R2.setPower(0);
        */

//        Color_arm.setPosition(0);
        sleep(1000);




//        if(color_sensor_front.red() > color_sensor_front.blue()){ //checks if the jewel in front of the sensor is red or blue
//            F1.setPower(.25);//moves forward if ball is blue
//            F2.setPower(-.25);
//            R1.setPower(.25);
//            R2.setPower(-.25);
//            sleep(250);
//            Color_arm.setPosition(90);
//            F1.setPower(-.25);
//            F2.setPower(.25);
//            R1.setPower(-.25);
//            R2.setPower(.25);
//            sleep(350);//reverses back to starting starting position
//
//        }
//        else{
//            F1.setPower(-.25);
//            F2.setPower(.25);//reverses if ball is red to knock off blue
//            R1.setPower(-.25);
//            R2.setPower(.25);
//            sleep(250);
//            Color_arm.setPosition(90);
//            F1.setPower(.25);
//            F2.setPower(-.25);// moves forward back to starting position
//            R1.setPower(.25);
//            R2.setPower(-.25);
//            sleep(275);
//
//        }




        F1.setPower(.25);
        F2.setPower(-.25);
        R1.setPower(.25);
        R2.setPower(-.25);
        sleep(1750);// moves forward off balence board

        F1.setPower(0);
        F2.setPower(0);//stops
        R1.setPower(0);
        R2.setPower(0);
        sleep(250);

        F1.setPower(.125);
        F2.setPower(.125);
        R1.setPower(-.125);
        R2.setPower(-.125);//moves sideways to have space to turn

        sleep(800);
        F1.setPower(0);
        F2.setPower(0);
        R1.setPower(0);
        R2.setPower(0);

        F1.setPower(-.25);
        F2.setPower(-.25);
        R1.setPower(-.25);
        R2.setPower(-.25);//rotates to face cryptobox
        sleep(1075);

        F1.setPower(0);
        F2.setPower(0);
        R1.setPower(0);
        R2.setPower(0);
        sleep(500);

        F1.setPower(.25);
        F2.setPower(-.25);//drives forward to score
        R1.setPower(.25);
        R2.setPower(-.25);
        sleep(700);

        F1.setPower(0);
        F2.setPower(0);
        R1.setPower(0);//stops
        R2.setPower(0);
        sleep(250);

//        claw_front_left.setPosition(0);
//        claw_front_right.setPosition(35);

        F1.setPower(-.25);
        F2.setPower(.25);
        R1.setPower(-.25);
        R2.setPower(.25);
        sleep(300);// moves forward off balence board










    }
}