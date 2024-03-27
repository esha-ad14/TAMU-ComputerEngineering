'''
GPIO.input() #read current input statement

GPIO.add_event_detect() #callback function

GPIO.add_event_callback() #use detect to say condition, then callback to said condition

can also use detect with .ouput()
#--------------------
'''
#lab 1 python file
from time import sleep
import RPi.GPIO as GPIO
import led_lights as led
from seg_lights import seg_lights
import threading

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
led.lED()
seg7 = seg_lights()

GPIO.setup(26, GPIO.IN, pull_up_down = GPIO.PUD_UP)

def button_Pressed(channel):
    print("Pressed")
    led.gr2()
    led.rd1()
    led.bl2()
    sleep(0.5)
    led.off2() #blink blue once
    sleep(0.5)
    led.bl2()
    sleep(0.5)
    led.off2() #blink blue twice
    sleep(0.5)
    led.bl2()
    sleep(0.5)
    led.rd2() #turns red after blinking blue 3x
    led.gr1()
    seg7.val_9() #countdown begins from 9 to 0 
    sleep(1)
    seg7.val_8()
    sleep(1)
    seg7.val_7()
    sleep(1)
    seg7.val_6()
    sleep(1)
    seg7.val_5()
    sleep(1)
    seg7.val_4() #countdown hits 4
    led.bl1() # 1 flashes blue
    sleep(1)
    seg7.val_3()
    led.off1()
    sleep(1)
    seg7.val_2()
    led.bl1()
    sleep(1)
    seg7.val_1()
    led.off1()
    sleep(1)
    seg7.val_0() #countdown hits 0
    sleep(1)
    seg7.segOff()
    led.rd1() #light 1 turns red
    led.gr2() #light 2 becomes green
    sleep(20)
    
GPIO.add_event_detect(26, GPIO.RISING, callback=button_Pressed)




while True:
    led.gr2() #while button not pressed, 2 stays green
    led.rd1()
    sleep(10000)