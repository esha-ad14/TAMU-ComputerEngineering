import RPi.GPIO as GPIO
from time import sleep
import led_lights as led
from seg_lights import seg_lights

GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)

for i in range(40): #set up to 20 to low
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
    
sleep(1)
print('start run')

led.lED()
seg7 = seg_lights()

seg7.val_0()
sleep(1)
seg7.val_1()
sleep(1)
seg7.val_2()
sleep(1)
seg7.val_3()
sleep(1)
seg7.val_4()
sleep(1)
seg7.val_5()
sleep(1)
seg7.val_6()
sleep(1)
seg7.val_7()
sleep(1)
seg7.val_8()
sleep(1)
seg7.val_9()
sleep(1)
seg7.segOff()

led.rd1()
sleep(1)
led.gr1()
sleep(1)
led.bl1()
sleep(1)
led.off1()

led.rd2()
sleep(1)
led.gr2()
sleep(1)
led.bl2()
sleep(1)
led.off2()

#led.rd1()
#GPIO.setup(1, GPIO.OUT, initial=GPIO.HIGH)
print('finish run')


'''
for i in range(40):
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    sleep(0.5) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
    print("execute")
    print(i)
'''

'''
for i in range(1,5): #2-red1 3-gr1 4-bl1
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''
'''
for i in range(5,10): #nothing
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''
'''
for i in range(10,15): #14-top seg
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''
'''
for i in range(15,20): #15-top/dot 16-bot/opp 17-red2 18-bot/dot
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''
'''
for i in range(20,25): #20-top/opp 21-mid 22-bl2 23-bot
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''
'''
for i in range(25,30): #27-gr2
    GPIO.setup(i, GPIO.OUT, initial=GPIO.HIGH)
    print("execute")
    print(i)
    sleep(2) #modify
    GPIO.setup(i, GPIO.OUT, initial=GPIO.LOW)
'''

'''
GPIO.setup(2, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(3, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(4, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(5, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(6, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(7, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(8, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(9, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(10, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(11, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(12, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(13, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(14, GPIO.OUT, initial=GPIO.LOW)
GPIO.setup(15, GPIO.OUT, initial=GPIO.LOW) 

#GPIO.setup(4, GPIO.OUT, initial=GPIO.HIGH) #5
GPIO.setup(13, GPIO.OUT, initial=GPIO.HIGH) #13
print('running')
'''