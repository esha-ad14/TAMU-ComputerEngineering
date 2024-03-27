from time import sleep
import board
import busio
import adafruit_mpu6050
import matplotlib.pyplot as plt
import socket
import statistics

#This is the port and IP of the other raspberry (camera) which the IMU data will be sent to, must be encoded
UDP_IP = "192.168.0.105" #CAN CHANGE DUE TO ROUTER 
UDP_PORT = 5005
MESSAGE = "IMU".encode()
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)

#Creating some inital requirements such as the IMU
i2c = busio.I2C(board.SCL, board.SDA)
mpu = adafruit_mpu6050.MPU6050(i2c)
yValues = [] e
yValuesPreFiltered = []
yValuesFilter = []
xValues = []

i = 0
counter = 0
filterCount  = 0
lowCounter = 0
highCounter = 0
lowDetect = False
highDetect = False
stdCount = 0


while True:
    totalMotion = abs(mpu.acceleration[0] + mpu.acceleration[1] + mpu.acceleration[2])
    yValues.append(totalMotion)
    
    #Filtering the data, converting 3 values in the mean of them
    counter += 1
    if counter % 3 == 0:
        yValuesPreFiltered.append(totalMotion)
    if counter % 3 == 1:
        yValuesPreFiltered.append(totalMotion)
    if counter % 3 == 2:
        yValuesPreFiltered.append(totalMotion)
    if len(yValuesPreFiltered) == 3:
        yValuesFilter.append(sum(yValuesPreFiltered)/3.0)
        yValuesPreFiltered = []
        filterCount += 1
        
        #Only looking at the filtered data once the there are more than 3 points
        if len(yValuesFilter) >= 3:
            firstValue = yValuesFilter[filterCount - 3]
            secondValue = yValuesFilter[filterCount - 2]
            thirdValue = yValuesFilter[filterCount - 1]
            stdCheck = [firstValue, secondValue, thirdValue]
            std = statistics.stdev(stdCheck)

            #Checks to see if there is a low peak
            if(secondValue < firstValue and secondValue < thirdValue and secondValue <= 4):
                lowCounter = filterCount
                lowDetect = True
            if(filterCount - lowCounter > 30): #If 30 points go by in time before detecting a high peak, set to false
                lowDetect = False
                lowCounter = 0

            #Checks to see if there is a high peak is detected
            if(lowDetect and secondValue > firstValue and secondValue > thirdValue and secondValue >= 16 and filterCount - lowCounter < 30):
                highCounter = filterCount
                highDetect = True
            if(filterCount - highCounter > 30): #If 30 points go by in time before detecting a nearly no acceleration, set to false
                highCounter = 0
                highDetect = False

            #If both high detect and low detect are true and the points dont have much variance and less than 30 points away, send fall
            if(highDetect and lowDetect and filterCount - highCounter < 30):
                if(std < 0.75):
                    stdCount += 1
                if(stdCount >= 4):
                    stdCount = 0
                    print('Fall Detected')
                    sock.sendto(MESSAGE, (UDP_IP, UDP_PORT))
                    highDetect = False
                    lowDetect = False

    
