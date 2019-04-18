FROM java:8
VOLUME /tmp
ADD finch-Security.jar service-security.jar
RUN sh -c 'touch /service-domain.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx128m", "-jar", "/service-security.jar"]