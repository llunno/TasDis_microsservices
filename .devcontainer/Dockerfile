FROM mcr.microsoft.com/devcontainers/base:ubuntu AS prepare-ambient

# update server
RUN sudo apt update -y && sudo apt upgrade -y

#install skaffold
RUN curl -Lo skaffold https://storage.googleapis.com/skaffold/releases/latest/skaffold-linux-amd64 && \
sudo install skaffold /usr/local/bin/