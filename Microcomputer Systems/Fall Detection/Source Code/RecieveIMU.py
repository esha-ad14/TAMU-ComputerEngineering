import socket
import subprocess


UDP_IP = "192.168.0.103"
UDP_PORT = 5005

#It has bind to the ip which is assigned to the common router between both of the RPI's
sock = socket.socket(socket.AF_INET, socket.SOCK_DGRAM)
sock.bind((UDP_IP, UDP_PORT))
while True:
    data, addr = sock.recvfrom(1024)
    code = data.decode("utf-8")
    if(code == 'IMU'):
        #Upon recieving a message, it creates a file on the desktop which is read by the main program
        subprocess.run(["sudo","touch", "IMU.txt"], stdout=subprocess.DEVNULL)

        