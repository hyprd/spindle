#!/usr/bin/env python3
from ev3dev2 import *
from ev3dev2.sensor import INPUT_1
from ev3dev2.sensor.lego import TouchSensor
from ev3dev2.led import Leds
from ev3dev2.motor import MoveTank, OUTPUT_B, OUTPUT_C, SpeedPercent
from ev3dev2.sensor.lego import ColorSensor
from ev3dev2.button import Button
from time import sleep


def main():

    btn = Button()  # we will us0e any button to stop scripts
    tank_pair = MoveTank(OUTPUT_B, OUTPUT_C)


    # Connect an EV3 color sensor to any sensor port.
    cl = ColorSensor()
    ts = TouchSensor()

    while not btn.any():  # exit loop when any button pressed
        if ts.is_pressed:
            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(30), -1)

            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(0), -0.5)
            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(30), 1)
            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(0), 0.5)
            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(30), 1)
            tank_pair.on_for_rotations(SpeedPercent(30), SpeedPercent(0), 0.5)

            while cl.reflected_light_intensity > 30:

                tank_pair.on(left_speed=35, right_speed=35)


        # if we are over the black line (weak reflection)

        if cl.reflected_light_intensity < 30:
            # medium turn right
            tank_pair.on(left_speed=35, right_speed=0)

        else:  # strong reflection (>=30) so over white surface
            # medium turn left
            tank_pair.on(left_speed=0, right_speed=35)

        sleep(0.1)  # wait for 0.1 seconds


try:
    main()

except:

    import traceback
    exc_type, exc_value, exc_traceback = sys.exc_info()
    traceback.print_exception(exc_type, exc_value, exc_traceback, file=sys.stdout)
    while True:
        pass


