#lab 1 python file
from time import sleep 
import RPi.GPIO as GPIO
#7 segment mapping
sgA = 16 #GPIO23
sgB = 18 #GPIO24
sgC = 13 #GPIO27
sgD = 11 #GPIO17
sgE = 7  #GPIO4
sgF = 12 #GPIO18
sgG = 32 #GPIO12
#LED 1 Mapping
LED_Gr1 = 36 #GPIO16
LED_Rd1 = 38 #GPIO20
LED_Bl1 = 40 #GPIO21
#LED 2 Mapping
LED_Gr2 = 33  #GPIO13
LED_Rd2 = 31  #GPIO6
LED_Bl2 = 35  #GPIO19
#Button Press Mapping
BUTTON_P = 37 #GPIO26
#---------------------------
def lED():
    GPIO.setwarnings(False)
    GPIO.setmod(GPIO.BCM)
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
#-----------------------------
        #setup pins
GPIO.setup(sgA, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgB, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgC, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgD, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgE, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgF, GPIO.OUT, intial=GPIO.LOW)
GPIO.setup(sgG, GPIO.OUT, intial=GPIO.LOW)

def onA(self, val_on=0):
    GPIO.output(sgA, GPIO.HIGH) if val_on else GPIO.output(sgA, GPIO.LOW)
def onB(self, val_on=0):
    GPIO.output(sgB, GPIO.HIGH) if val_on else GPIO.output(sgB, GPIO.LOW)
def onC(self, val_on=0):
    GPIO.output(sgC, GPIO.HIGH) if val_on else GPIO.output(sgC, GPIO.LOW)
def onD(self, val_on=0):
    GPIO.output(sgD, GPIO.HIGH) if val_on else GPIO.output(sgD, GPIO.LOW)
def onE(self, val_on=0):
    GPIO.output(sgE, GPIO.HIGH) if val_on else GPIO.output(sgE, GPIO.LOW)
def onF(self, val_on=0):
    GPIO.output(sgF, GPIO.HIGH) if val_on else GPIO.output(sgF, GPIO.LOW)
def onG(self, val_on=0):
    GPIO.output(sgG, GPIO.HIGH) if val_on else GPIO.output(sgG, GPIO.LOW)

def val_0(self): #ABCDEF
    onA(1)
    onB(1)
    onC(1)
    onD(1)
    onE(1)
    onF(1)
    onG()
def val_1(self): #BC
    onA()
    onB(1)
    onC(1)
    onD()
    onE()
    onF()
    onG()
def val_2(self): #ABDEG
    onA(1)
    onB(1)
    onC()
    onD(1)
    onE(1)
    onF()
    onG(1)
def val_3(self): #ABCDG
    onA(1)
    onB(1)
    onC(1)
    onD(1)
    onE()
    onF()
    onG(1)
def val_4(self): #BCFG
    onA()
    onB(1)
    onC(1)
    onD()
    onE()
    onF(1)
    onG(1)
def val_5(self): #ACDFG
    onA(1)
    onB()
    onC(1)
    onD(1)
    onE()
    onF(1)
    onG(1)
def val_6(self): #CDEFG
    onA()
    onB()
    onC(1)
    onD(1)
    onE(1)
    onF(1)
    onG(1)
def val_7(self): #AC
    onA(1)
    onB()
    onC(1)
    onD()
    onE()
    onF()
    onG()
def val_8(self): #ABCDEFG
    onA(1)
    onB(1)
    onC(1)
    onD(1)
    onE(1)
    onF(1)
    onG(1)
def val_9(self): #ABCDFG
    onA(1)
    onB(1)
    onC(1)
    onD(1)
    onE()
    onF(1)
    onG(1)

GPIO.setup(BUTTON_P, GPIO.IN, pull_up_down = GPIO.PUD_UP)

while True:
    gr2() #while button not pressed, 2 stays green
    rd1()

    inputState = GPIO.input(BUTTON_P)
    if not inputState:
        print("Pressed")
        bl2()
        sleep(0.5)
        off2() #blink blue once
        sleep(0.5)
        bl2()
        sleep(0.5)
        off2() #blink blue twice
        sleep(0.5)
        bl2()
        sleep(0.5)
        rd2() #turns red after blinking blue 3x
        gr1()
        val_9() #countdown begins from 9 to 0 
        sleep(1)
        val_8()
        sleep(1)
        val_7()
        sleep(1)
        val_6()
        sleep(1)
        val_5()
        sleep(1)
        val_4() #countdown hits 4
        bl1() # 1 flashes blue
        sleep(1)
        val_3()
        off1()
        sleep(1)
        val_2()
        bl1()
        sleep(1)
        val_1()
        off1()
        sleep(1)
        val_0() #countdown hits 0
        rd1() #light 1 turns red
        gr2() #light 2 becomes green
        sleep(20)


    