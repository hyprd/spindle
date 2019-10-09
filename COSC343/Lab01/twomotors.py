#!/usr/bin/env python3
from ev3dev2.motor import LargeMotor, OUTPUT_B, OUTPUT_C, MoveTank, SpeedPercent
from ev3dev2.sound import Sound
from time import sleep
drive = MoveTank(OUTPUT_B, OUTPUT_C)
sound = Sound()
# Run the wheels forwards ( left at 50% of speed , right also at
# 50% speed , for 3 rotations )
drive . on_for_rotations(SpeedPercent(50), SpeedPercent(50), 3)
# Beep and stop for 2 seconds
sound.beep()
sleep(2)
# Run the wheels backwards ( left at 50% of speed , right at
# 30% speed , for 3 rotations )
drive.on_for_rotations(SpeedPercent(50), SpeedPercent(30), -3)
# Beep at program