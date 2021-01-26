export DOCKER_TLS_VERIFY="1"
export DOCKER_HOST="tcp://192.168.99.101:2376"
export DOCKER_CERT_PATH="C:\Users\brijeshdhaker\.minikube\certs"
export MINIKUBE_ACTIVE_DOCKERD="minikube"


cd  /cygdrive/e/git-repos/sb-demo-app/application

docker-compose -f docker-compose.yaml up

docker-compose -f docker-compose.yaml down

docker exec -it mysql-server bash

lower_case_table_names=2
