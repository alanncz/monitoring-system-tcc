cd ./shared
mvn clean package
cd ..
cd ./api
mvn clean package
cd ..
cd servidor
sh start.sh
cd ..
cd coletor
sh start.sh
cd ..
