mvn clean package
sudo docker build -t image/collector .
sudo docker run -t --net host --name collector image/collector
