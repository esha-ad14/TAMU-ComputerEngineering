import board
import busio
import adafruit_mpu6050
from mpu6050 import mpu6050
from time import sleep, perf_counter
import matplotlib.pyplot as plt


sensor = mpu6050(0x68)
accelerometer_data = sensor.get_accel_data()


count = 0
count_filter = 0
xVal = []
xVal_filter = []
yVal = []
count_step = 0
val_pre_filter = []
step_filter = []


while True:
  
   val_accel = sensor.get_accel_data()
   #print("Accelerometer")
   #print("x: " + str(val_accel['x'])) #print x acceleration
   #print("y: " + str(val_accel['y'])) #print y acceleration
   #print("z: " + str(val_accel['z'])) #print z acceleration
   total_xyz = abs(val_accel['x']) + abs(val_accel['y']) + abs(val_accel['z'])
   #print(total_xyz)
  
   count += 1
   #take 3 consecutive values
   if count%3 == 0 or count%3 == 1 or count%3 == 2:
       val_pre_filter.append(total_xyz) #append pre-filtered values
       #print("test1")
   if len(val_pre_filter) == 3: #append avg of 3 values
       xVal_filter.append(sum(val_pre_filter)/3.0)
       val_pre_filter = []
       count_filter += 1
       #print("test2")
       if (count_filter >= 3): #once 3 filtered reached, then find peak
           #check if index 1 if bigger than index 0 AND index 2 and above mininum (15)
           if (xVal_filter[count_filter - 2] > xVal_filter[count_filter - 3] and
               xVal_filter[count_filter - 2] > xVal_filter[count_filter - 1] and
               xVal_filter[count_filter - 2] >= 16):
               #print 3 total_xyz vals
               print(xVal_filter[count_filter - 3], xVal_filter[count_filter -2],
                     xVal_filter[count_filter - 1])
               count_step += 1 #count step up one
               print("Step -----------------------------")
               print(str(count_step))
   sleep(0.1)

