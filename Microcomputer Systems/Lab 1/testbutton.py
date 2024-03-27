import RPi.GPIO as GPIO
from time import sleep
import led_lights as led
from seg_lights import seg_lights

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
seg7 = seg_lights()

led.off1()
led.off2()
seg7.segOff()

'''
for i in range(40):
	GPIO.setup(i, GPIO.IN, pull_up_down = GPIO.PUD_UP)
	inputState = GPIO.input(i)
	print(i)
	if not inputState: #28, 30, 37
		print("Button")
	sleep(0.25)
'''

'''
for i in range(39):
	GPIO.setup(i, GPIO.IN, pull_up_down = GPIO.PUD_UP)
	inputState = GPIO.input(i)
	print(i)
	if inputState: #26, 28, 30, 37
		print("Button")
	sleep(0.25)
'''

while True:
    GPIO.setup(26, GPIO.IN, pull_up_down = GPIO.PUD_UP)
    inputState = GPIO.input(26)
    if not inputState:
        led.gr1()
        led.bl2()
    else:
        led.off1()
        led.off2()
    sleep(1)

'''
print('start')
while True:
    GPIO.setup(28, GPIO.IN, pull_up_down = GPIO.PUD_UP)
    inputState = GPIO.input(28)
    GPIO.setup(30, GPIO.IN, pull_up_down = GPIO.PUD_UP)
    inputState = GPIO.input(30)
    GPIO.setup(37, GPIO.IN, pull_up_down = GPIO.PUD_UP)
    inputState = GPIO.input(37)
    print('2')
    if not inputState:
        led.gr1()
        led.bl2()   
        sleep(20)
        led.off1()
        led.off2()
    print('3')
'''

led.off1()
led.off2()
seg7.segOff()