FROM java:8
VOLUME /tmp
ADD finch-ExternalApi.jar service-externalapi.jar
RUN sh -c 'touch /service-externalapi.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx128m", "-jar", "/service-externalapi.jar"]