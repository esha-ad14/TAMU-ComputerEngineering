import RPi.GPIO as GPIO

from gpiozero import Button

import Adafruit_MCP4725

import time 

import math



GPIO.setmode(GPIO.BCM)



#variables

adaF = Adafruit_MCP4725.MCP4725()

btn = Button(4)



try: 

    while True:

        if btn.is_pressed:

            #asks user to enter shape, freq, and voltage

            shape = input("Enter- square wave (1), triangle wave (2), sin wave (3): ")

            freq = float(input("Enter a Frequence [0,20] Hz: "))

            vltg = int(input("Enter a max output voltage in mV: "))

            #conditions for shapes

            #square

            if shape == 1:

                while not btn.is_pressed:

                    adaF.set_voltage(vltg)

                    time.sleep(1/freq/2)

                    adaF.set_voltage(0)

                    time.sleep(1/freq/2)

            #triangle wave

            elif shape == 2:

                while not btn.is_pressed:

                    val =0;

                    steps = 25;

                    lensteps=vltg/steps 

                    for i in range(steps):

                        adaF.set_voltage(val)

                        val += lensteps

                        time.sleep(1/freq/50)

                    val = vltg

                    for j in range(steps):

                        adaF.set_voltage(val)

                        val -= lensteps

                        time.sleep(1/freq/50)

            #sin wave

            elif shape == 3:

                while not btn.is_pressed:

                    val =0

                    steps = 50

                    lensteps = 2 * math.pi/steps

                    for i in range (steps):

                        adaF.set_voltage(vltg/2+ int(vltg/2*math.sin(val)))

                        temp += lensteps

                        time.sleep(1/f/50)

                        

            else:

                print("Not an acceptible input")

except KeyboardInterrupt:

    GPIO.cleanup()