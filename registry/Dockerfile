FROM openjdk:11-jre-slim

RUN set -eux; \
	apt-get update; \
	apt-get install -y --no-install-recommends \
		procps curl \
	; \
	rm -rf /var/lib/apt/lists/*

COPY build/libs/registry.jar /app/
COPY build/resources/main/application-docker.properties /app/application.properties

COPY enterypoint.sh /app/

EXPOSE 8080 5432

WORKDIR /app/

ENTRYPOINT ["/app/enterypoint.sh", "start"]