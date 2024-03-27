from time import sleep
import subprocess
from PIL import Image, ImageEnhance
import RPi.GPIO as GPIO
import numpy as np
import matplotlib.pyplot as plt

#Setting up the buzzer which is our main form of stating fall detection
GPIO.setwarnings(False)
GPIO.setmode(GPIO.BCM)
GPIO.setup(4, GPIO.OUT)

IMURECV = False

#Infinite loop which continually runs to take pictures
while True:
    try:
        IMU = open("IMU.txt", "r")
        IMURECV = True
    except FileNotFoundError: #Except required to keep the image detection running
        print('No IMU data detected')
        
    #Taking the picture through command line, enhancing the image, and cropping the top 60%
    subprocess.run(["sudo","fswebcam", "--no-banner","image1.jpg"], stdout=subprocess.DEVNULL)
    img = Image.open('/home/pi/Desktop/image1.jpg')
    enhancer = ImageEnhance.Brightness(img)
    factor = 2
    img1 = enhancer.enhance(factor)
    img1 = img1.crop((0, 80, 352, 288))
    rgbValues = np.asarray(img1).reshape(352,208,3)
    
    #Setting up some inital variables for the actual red detection
    redCount = 0
    x = 168
    y = 352
    xValue = []
    yValue = []
    
    #Iterates through each row of the picture, looks for red colors wihtin a specific range
    #item[0] - item[2] == R G B
    for color in rgbValues:
        y = 352
        for item in color:
            if(item[0] >= 125 and item[0] <= 255 and item[1] <= 50 and item[2] <= 50):
                redCount += 1
                xValue.append(y)
                yValue.append(x)
            y -= 1        
        x -= 1
    print("Number of Red Pixels Detected: " + str(redCount))
    
    #If there are more than 50 red pixels and the IMU file exists on the screen, the buzzer will go off
    if(redCount > 50 and IMURECV):
        IMURECV = False
        print('Fall Detected')
        GPIO.output(4, GPIO.HIGH)
        sleep(30)
        GPIO.output(4, GPIO.LOW)
        subprocess.run(["sudo","rm", "IMU.txt"]) #For automation, the file will be deleted in order to allow for multiple falls 
