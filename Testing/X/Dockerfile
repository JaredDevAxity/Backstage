# Use an official Node runtime as a parent image
FROM node:14

# Set the working directory in the container
WORKDIR /usr/src/app

# Install any needed packages specified in package.json
COPY pom.xml ./
COPY Drivers/chromedriver-docker ./

# Install OpenJDK-11
RUN apt-get update && \
    apt-get install -y openjdk-11-jdk && \
    apt-get install -y ant && \
    apt-get clean;
    
# Fix certificate issues
RUN apt-get update && \
    apt-get install ca-certificates-java && \
    apt-get clean && \
    update-ca-certificates -f;

# Setup JAVA_HOME -- useful for docker commandline
ENV JAVA_HOME /usr/lib/jvm/java-11-openjdk-amd64/
RUN export JAVA_HOME

# Install Maven

ARG BASE_URL=https://apache-maven.mirror.gtcomm.net
ARG BASE_URL=https://dlcdn.apache.org/maven/maven-3
ARG MAVEN_VERSION=3.9.6

RUN mkdir -p /usr/share/maven /usr/share/maven/ref \
 && curl -fsSL -o /tmp/apache-maven.tar.gz ${BASE_URL}/${MAVEN_VERSION}/binaries/apache-maven-${MAVEN_VERSION}-bin.tar.gz \
 && tar -xzf /tmp/apache-maven.tar.gz -C /usr/share/maven --strip-components=1 \
 && rm -f /tmp/apache-maven.tar.gz \
 && ln -s /usr/share/maven/bin/mvn /usr/bin/mvn

ENV MAVEN_HOME /usr/share/maven
ENV MAVEN_CONFIG "$USER_HOME_DIR/.m2"

# Define working directory.
WORKDIR /data

#==============
# VNC and Xvfb
#==============
RUN apt-get update -y \
  && apt-get -y install \
    xvfb \
  && rm -rf /var/lib/apt/lists/* /var/cache/apt/*

#============================================
# Google Chrome
#============================================
ARG CHROME_VERSION="120.0.6099.109"

# Instalación de herramientas necesarias
RUN apt-get update && apt-get install -y wget unzip

# Descargar y descomprimir Google Chrome
RUN wget -q -O /tmp/chrome-linux64.zip https://edgedl.me.gvt1.com/edgedl/chrome/chrome-for-testing/${CHROME_VERSION}/linux64/chrome-linux64.zip \
    && unzip /tmp/chrome-linux64.zip -d /usr/local/bin/ \
    && rm /tmp/chrome-linux64.zip

# Asegurarse de que el ejecutable tenga permisos de ejecución
RUN chmod 777 /usr/local/bin/chrome-linux64/chrome

# Limpiar el sistema
RUN apt-get remove -y wget unzip && apt-get autoremove -y && apt-get clean && rm -rf /var/lib/apt/lists/*

# Establecer la variable de entorno PATH
ENV PATH="/usr/local/bin/chrome-linux64:${PATH}"

RUN apt-get update && apt-get install -y libgbm1

ENV LD_LIBRARY_PATH="/usr/local/bin/chrome-linux64:$LD_LIBRARY_PATH"

  
# Copy the current directory contents into the container at /usr/src/app
COPY . .

# Set environment variables
ENV DISPLAY=:99

# Start Xvfb and run the Cypress tests
CMD xvfb-run --auto-servernum --server-args='-screen 0 1920x1080x24' mvn clean install && mvn test -Dtest=Runner
