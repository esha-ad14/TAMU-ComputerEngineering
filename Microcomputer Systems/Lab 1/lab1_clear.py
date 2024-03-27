from time import sleep
import RPi.GPIO as GPIO
import led_lights as led
from seg_lights import seg_lights

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
led.lED()
seg7 = seg_lights()

seg7.segOff()
led.off1()
led.off2()