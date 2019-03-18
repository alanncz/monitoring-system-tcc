mvn clean package
sudo docker build -t image/collector .
sudo docker run -d -t --net host --name collector image/collector
