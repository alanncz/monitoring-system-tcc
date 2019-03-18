mvn clean package
sudo docker build -t image/server .
sudo docker run -d -t --net host --name server image/server
