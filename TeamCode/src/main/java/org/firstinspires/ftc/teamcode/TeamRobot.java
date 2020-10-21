package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class TeamRobot {
    public DcMotor leftDrive = null;
    public DcMotor rightDrive = null;

    public void init(HardwareMap hwMap) {
        leftDrive = hwMap.get(DcMotor.class, "left_drive");
        rightDrive = hwMap.get(DcMotor.class, "right_drive");
    }
}
//step 2: spin right for 1.3 seconds

//step 3: go backwards for 3 seconds