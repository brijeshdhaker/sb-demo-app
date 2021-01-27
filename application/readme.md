$ minikube start

$ 
export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.101:2376"
export DOCKER_CERT_PATH="C:\Users\brijeshdhaker\.minikube\certs"
export MINIKUBE_ACTIVE_DOCKERD="minikube"


cd  /cygdrive/e/git-repos/sb-demo-app/application

docker-compose -f docker-compose.yaml up
docker-compose -f docker-compose.yaml down


docker-compose -f docker-compose.yaml start
docker-compose -f docker-compose.yaml stop

docker exec -it mysql-server bash

lower_case_table_names=2

## mysql-server 
docker-compose -f docker/mysql/docker-compose.yaml up -d
docker-compose -f docker/mysql/docker-compose.yaml down

docker-compose -f docker/mysql/docker-compose.yaml start mysql
docker-compose -f docker/mysql/docker-compose.yaml stop adminer

## kafka 
docker-compose -f docker/kafka/docker-compose.yaml up -d
docker-compose -f docker/kafka/docker-compose.yaml down
docker-compose ps

docker-compose -f docker/kafka/docker-compose.yaml exec broker kafka-topics \
  --create \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 \
  --partitions 1 \
  --topic users

docker-compose -f docker/kafka/docker-compose.yaml exec broker kafka-topics \
  --create \
  --bootstrap-server localhost:9092 \
  --replication-factor 1 \
  --partitions 1 \
  --topic pageviews

## sample-app
docker-compose -f docker/app/docker-compose.yaml up -d
docker-compose -f docker/app/docker-compose.yaml down
docker-compose -f docker/app/docker-compose.yaml stop