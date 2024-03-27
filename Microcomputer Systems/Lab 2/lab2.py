import RPi.GPIO as GPIO
from gpiozero import Button
import adafruit_mcp4725
import time
import math
import board
import busio

GPIO.setmode(GPIO.BCM)

#variables
i2c = busio.I2C(board.SCL, board.SDA)
dac = adafruit_mcp4725.MCP4725(i2c)

btn= Button(4)

try:
    while True:
        if btn.is_pressed:
            #asks user to enter shape,freq, and voltage
            shape = int(input("Enter - square wave (1), triangle wave (2), sin wave (3): "))
            freq =  float(input("Enter a frequency [0,20]Hz: "))
            vltg = int(input("Enter a max output voltage in V: "))
            
            #conditions for shapes
            if shape == 1:        #square
                while not btn.is_pressed:
                    dac.raw_value =4095
                    time.sleep(1/freq/2)
                    dac.raw_value = 2047
                    time.sleep(1/freq/2)
                    
            elif shape == 2:         #triangle
                while not btn.is_pressed:
                    val= 0
                    steps = 10
                    lensteps = vltg/steps
                    for i in range(0,4095,40):
                        dac.raw_value=int((i*vltg)/3.3)
                        val+= lensteps
                        time.sleep((1/freq/500))
                    val = vltg
                    for j in range(4095,0,-40):
                        dac.raw_value=int((j*vltg)/3.3)
                        val-= lensteps
                        time.sleep((1/freq/500))
                        
            elif shape == 3:                #sin
                while not btn.is_pressed:
                    val = 0
                    steps = 0.05
                    while True:
                        v = 2048.0*(1.0 + 0.5*math.sin(6.2832*val))
                        dac.raw_value= int((v*vltg)/3.3)
                        val+= steps
                        time.sleep(1/freq/20)
                        
            else:
                print("invalid")
                
except KeyboardInterrupt:
    GPIO.cleanup()

