![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![PostgreSQL](https://img.shields.io/badge/postgresql-%23316192.svg?style=for-the-badge&logo=postgresql&logoColor=white)
![RabbitMQ](https://img.shields.io/badge/rabbitmq-%23FF6600.svg?style=for-the-badge&logo=rabbitmq&logoColor=white)
![OpenAPI](https://img.shields.io/badge/openapi-%2361DAFB.svg?style=for-the-badge&logo=openapi-initiative&logoColor=white)
![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![Kubernetes](https://img.shields.io/badge/kubernetes-%23326ce5.svg?style=for-the-badge&logo=kubernetes&logoColor=white)

# TasDis

**TasDis** is a Distributed system where teachers and students can keep track and monitor their academical duties. This project was developed for Scalable Software Engineering class from Instituto Infnet.

## How to run locally

The projects provides a [devcontainer](https://containers.dev/) environment to easily run the project locally.

**The docker image will provide the following features in the container**:

- Java 21;
- Docker in Docker (A newly created docker daemon inside the container);
- Kubernetes ([Minikube](https://minikube.sigs.k8s.io/docs/)) with [Helm](https://helm.sh/) and kubectl;
- [k9s](https://k9scli.io/) (A CLI tool to manage Kubernetes clusters);
- [Skaffold](https://skaffold.dev/) (A CLI tool to manage the development workflow for Kubernetes applications);
- Deployed RabbitMQ Helm Chart (A message broker to handle the communication between the services);
- Deployed PostgreSQL Helm Chart (A database to store the data).

**Pre-requisites**:

- Docker;
- Devcontainers extension for Visual Studio Code/other supported IDEs or [DevContainers CLI](https://containers.dev/supporting#devcontainer-cli);

**Inside the container, follow the steps below:**

**1.** Run the following command to build the microsservices images, push it to the github registry and deploy it to the kubernetes cluster:

```bash
    skaffold dev
```

**2.** Port forward the gateway services to access the endpoints in Swagger:

```bash
    kubectl port-forward service/gateway-service 8080:8080
```

**3.** Access the Swagger UI in the URL `http://localhost:8080/swagger-ui/index.html`.
