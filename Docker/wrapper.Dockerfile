FROM java:8
VOLUME /tmp
ADD finch-Wrapper.jar service-wrapper.jar
RUN sh -c 'touch /service-wrapper.jar'
ENTRYPOINT ["java", "-Djava.security.egd=file:/dev/./urandom", "-Xmx128m", "-jar", "/service-wrapper.jar"]