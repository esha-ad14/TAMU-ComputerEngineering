import RPi.GPIO as GPIO

class seg_lights:

    def __init__(self):
        
        GPIO.setwarnings(False)
        GPIO.setmode(GPIO.BCM)

        self.top = 14
        self.top_dot = 15
        self.bot_opp = 16
        self.bot_dot = 18
        self.top_opp = 20
        self.mid = 21
        self.bot = 23

        GPIO.setup(self.top, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.top_dot, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.bot_opp, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.bot_dot, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.top_opp, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.mid, GPIO.OUT, initial=GPIO.LOW)
        GPIO.setup(self.bot, GPIO.OUT, initial=GPIO.LOW)

    def onTop(self, val_on=0):
        GPIO.output(self.top, GPIO.HIGH) if val_on else GPIO.output(self.top, GPIO.LOW)
    def onTopDot(self, val_on=0):
        GPIO.output(self.top_dot, GPIO.HIGH) if val_on else GPIO.output(self.top_dot, GPIO.LOW)
    def onBotOpp(self, val_on=0):
        GPIO.output(self.bot_opp, GPIO.HIGH) if val_on else GPIO.output(self.bot_opp, GPIO.LOW)
    def onBotDot(self, val_on=0):
        GPIO.output(self.bot_dot, GPIO.HIGH) if val_on else GPIO.output(self.bot_dot, GPIO.LOW)
    def onTopOpp(self, val_on=0):
        GPIO.output(self.top_opp, GPIO.HIGH) if val_on else GPIO.output(self.top_opp, GPIO.LOW)
    def onMid(self, val_on=0):
        GPIO.output(self.mid, GPIO.HIGH) if val_on else GPIO.output(self.mid, GPIO.LOW)
    def onBot(self, val_on=0):
        GPIO.output(self.bot, GPIO.HIGH) if val_on else GPIO.output(self.bot, GPIO.LOW)

    def val_0(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp(1)
        self.onMid()
        self.onBotDot(1)
        self.onBotOpp(1)
        self.onBot(1)
    def val_1(self):
        self.onTop()
        self.onTopDot(1)
        self.onTopOpp()
        self.onMid()
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot()
    def val_2(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp()
        self.onMid(1)
        self.onBotDot()
        self.onBotOpp(1)
        self.onBot(1)
    def val_3(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp()
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot(1)
    def val_4(self):
        self.onTop()
        self.onTopDot(1)
        self.onTopOpp(1)
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot()
    def val_5(self):
        self.onTop(1)
        self.onTopDot()
        self.onTopOpp(1)
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot(1)
    def val_6(self):
        self.onTop()
        self.onTopDot()
        self.onTopOpp(1)
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp(1)
        self.onBot(1)
    def val_7(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp()
        self.onMid()
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot()
    def val_8(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp(1)
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp(1)
        self.onBot(1)
    def val_9(self):
        self.onTop(1)
        self.onTopDot(1)
        self.onTopOpp(1)
        self.onMid(1)
        self.onBotDot(1)
        self.onBotOpp()
        self.onBot()
    def segOff(self):
        self.onTop()
        self.onTopDot()
        self.onTopOpp()
        self.onMid()
        self.onBotDot()
        self.onBotOpp()
        self.onBot()

    