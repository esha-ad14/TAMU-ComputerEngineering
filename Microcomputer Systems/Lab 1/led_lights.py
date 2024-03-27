import RPi.GPIO as GPIO

#LED 1 Mapping
LED_Gr1 = 3 #GPIO
LED_Rd1 = 2 #GPIO
LED_Bl1 = 4 #GPIO
#LED 2 Mapping
LED_Gr2 = 27  #GPIO
LED_Rd2 = 17  #GPIO
LED_Bl2 = 22  #GPIO

#---------------------------
def lED():
    GPIO.setwarnings(False)
    GPIO.setmode(GPIO.BCM)
    #LED1
    GPIO.setup(LED_Gr1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl1, GPIO.OUT, initial=GPIO.LOW)
    #LED2
    GPIO.setup(LED_Gr2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl2, GPIO.OUT, initial=GPIO.LOW)
#---------------------------
def gr1(): #set 1 green
    GPIO.setup(LED_Gr1, GPIO.OUT, initial=GPIO.HIGH)
    GPIO.setup(LED_Rd1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl1, GPIO.OUT, initial=GPIO.LOW)
def rd1(): #set 1 red
    GPIO.setup(LED_Gr1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd1, GPIO.OUT, initial=GPIO.HIGH)
    GPIO.setup(LED_Bl1, GPIO.OUT, initial=GPIO.LOW)
def bl1(): #set 1 blue
    GPIO.setup(LED_Gr1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl1, GPIO.OUT, initial=GPIO.HIGH)
def off1(): #set 1 off
    GPIO.setup(LED_Gr1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd1, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl1, GPIO.OUT, initial=GPIO.LOW)
#--------------------------------------
def gr2(): #set 2 green
    GPIO.setup(LED_Gr2, GPIO.OUT, initial=GPIO.HIGH)
    GPIO.setup(LED_Rd2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl2, GPIO.OUT, initial=GPIO.LOW)
def rd2(): #set 2 red
    GPIO.setup(LED_Gr2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd2, GPIO.OUT, initial=GPIO.HIGH)
    GPIO.setup(LED_Bl2, GPIO.OUT, initial=GPIO.LOW)
def bl2(): #set 2 blue
    GPIO.setup(LED_Gr2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl2, GPIO.OUT, initial=GPIO.HIGH)
def off2(): #set 2 off
    GPIO.setup(LED_Gr2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Rd2, GPIO.OUT, initial=GPIO.LOW)
    GPIO.setup(LED_Bl2, GPIO.OUT, initial=GPIO.LOW)