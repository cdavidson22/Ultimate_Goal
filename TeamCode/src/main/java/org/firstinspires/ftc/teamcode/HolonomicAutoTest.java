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

@Autonomous(name="Honolomic Autonomous Test", group="autonomous")
//@Disabled
public class HolonomicAutoTest extends LinearOpMode{
    private DcMotor F1 = null;
    private DcMotor F2 = null;
    private DcMotor R1 = null;
    private DcMotor R2 = null;

    double powerF1;
    double powerF2;
    double powerR1;
    double powerR2;

    double Pi = Math.PI/4;

    public void forwardDrive(int length) {
        F1.setPower(.25);
        F2.setPower(.25);
        R1.setPower(.25);
        R2.setPower(.25);
        telemetry.addData("Status","Forward Drive");
        telemetry.update();
        sleep(length);
    }
    public void backwardsDrive(int length){
        F1.setPower(-.25);
        F2.setPower(-.25);
        R1.setPower(-.25);
        R2.setPower(-.25);
        telemetry.addData("Status","Backwards Drive");
        telemetry.update();
        sleep(length);
    }
    public void strafeLeft(int length){
        F1.setPower(-.25);
        F2.setPower(.25);
        R1.setPower(.25);
        R2.setPower(-.25);
        telemetry.addData("Status","strafing left");
        telemetry.update();
        sleep(length);
    }
    public void strafeRight(int length){
        F1.setPower(.25);
        F2.setPower(-.25);
        R1.setPower(-.25);
        R2.setPower(.25);
        telemetry.addData("Status","Strafing right");
        telemetry.update();
        sleep(length);
    }

    public void robotStop(int length){
        F1.setPower(0);
        F2.setPower(0);
        R1.setPower(0);
        R2.setPower(0);
        telemetry.addData("Status","Robot at standstill");
        telemetry.update();
        sleep(length);
    }


    public void turnRight(int length){
        F1.setPower(0.25);
        F2.setPower(-0.25);
        R1.setPower(0.25);
        R2.setPower(-0.25);
        telemetry.addData("Status","turning riht");
        telemetry.update();
        sleep(length);
    }

    public void turnLeft(int length){
        F1.setPower(-0.25);
        F2.setPower(0.25);
        R1.setPower(-0.25);
        F2.setPower(0.25);
        telemetry.addData("Status","Turning left");
        telemetry.update();
        sleep(length);
    }




    @Override
    public void runOpMode() throws InterruptedException {
        telemetry.addData("Status", "Initialized");
        telemetry.update();

        F1 = hardwareMap.get(DcMotor.class, "F1");
        F2 = hardwareMap.get(DcMotor.class, "F2");
        R1 = hardwareMap.get(DcMotor.class, "R1");
        R2 = hardwareMap.get(DcMotor.class, "R2");

        F1.setDirection(DcMotorSimple.Direction.REVERSE);
        F2.setDirection(DcMotorSimple.Direction.FORWARD);
        R1.setDirection(DcMotorSimple.Direction.FORWARD);
        R2.setDirection(DcMotorSimple.Direction.FORWARD);

        F1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        F2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R1.setMode(DcMotor.RunMode.RUN_USING_ENCODER);
        R2.setMode(DcMotor.RunMode.RUN_USING_ENCODER);

        waitForStart();
        telemetry.addData("version","1.0");
        telemetry.update();

        sleep(1000);

        forwardDrive(1000);
        robotStop(2000);
        backwardsDrive(1000);
        robotStop(2000);
        strafeLeft(1000);
        robotStop(2000);
        strafeRight(1000);
        robotStop(2000);
    }
}
