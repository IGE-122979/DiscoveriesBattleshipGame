FROM maven:3.9.9-eclipse-temurin-21

RUN useradd -m -s /bin/bash vscode \
    && mkdir -p /workspaces \
    && chown -R vscode:vscode /workspaces

WORKDIR /workspaces/DiscoveriesBattleshipGame
