FROM ubuntu
RUN apt-get update
RUN apt-get -y install openjdk-8-jdk
RUN apt-get -y install wget
RUN wget http://mirror.cc.columbia.edu/pub/software/apache/maven/maven-3/3.6.3/binaries/apache-maven-3.6.3-bin.tar.gz -P /tmp
RUN tar xf /tmp/apache-maven-*.tar.gz -C /opt
RUN ln -s /opt/apache-maven-3.6.3 /opt/maven
RUN apt -y install nano
RUN apt -y install vim
ENV JAVA_HOME=/usr/lib/jvm/java-8-openjdk-amd64
ENV M2_HOME=/opt/maven
ENV MAVEN_HOME=/opt/maven
ENV PATH=${M2_HOME}/bin:${PATH}
RUN groupadd tomcat
RUN useradd -s /bin/false -g tomcat -d /opt/tomcat tomcat
RUN wget http://www.trieuvan.com/apache/tomcat/tomcat-8/v8.5.57/bin/apache-tomcat-8.5.57.tar.gz 
RUN tar -xzvf apache-tomcat-8.5.57.tar.gz
RUN mv apache-tomcat-8.5.57/ /opt/tomcat/
RUN chown -R tomcat:tomcat /opt/tomcat/
RUN chmod +x /opt/tomcat/bin/*
ENV CATALINA_HOME=/opt/tomcat
WORKDIR /dockerFinale
COPY . .
RUN mvn clean install
EXPOSE 8080
EXPOSE 5432
CMD ["java", "-jar", "target/deploy-api.war"]
