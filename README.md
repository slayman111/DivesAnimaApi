# DivesAnimaApi
Spring REST Api for "Dives Anima" project.

# Docker Deployment
Create .jar file.
> mvn clean package -Dmaven.test.skip=true

Build docker image.
> docker build -t dives-anima-api:latest .

Run docker compose.
> docker compose up
