# 1. Overview
This project I use jdk1.8 and SpringBoot web framework to write a  web service about finonacci.
# 2. Creat docker image
In my project, there is a directory called "docker_create" which contains 2 files: Dockerfile and assessment1-0.0.1-SNAPSHOT.jar. We can use these 2 files to create docker image.

1. cd to the docker_create directory
1. type instruction below to create docker image. assessment is the image's name. My computer is macbook air with m1 chip so I use arm64 architecture to build this image.
```java
docker build -t assessment .
```

3. after creating the image, we can run the instruction below to run docker image
```java
docker run -d -p 8000:8000 --name fibonacci assessment
```
