FROM ubuntu
ARG uname="api"
ARG pword="BGP/-\\PIuser2020"
ARG dbase="bgp"
ARG table="hijacks"
ENV usname=$uname
ENV psword=$pword
ENV dabase=$dbase
ENV tble=$table
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
RUN wget apache.claz.org/tomcat/tomcat-8/v8.5.61/bin/apache-tomcat-8.5.61.tar.gz 
RUN tar -xzvf apache-tomcat-8.5.61.tar.gz
RUN mv apache-tomcat-8.5.61/ /opt/tomcat/
RUN chown -R tomcat:tomcat /opt/tomcat/
RUN chmod +x /opt/tomcat/bin/*
ENV CATALINA_HOME=/opt/tomcat
WORKDIR /dockerFinale
COPY . .
RUN mvn clean install
EXPOSE 8080
EXPOSE 5432
RUN cp target/deploy-api.war /opt/tomcat/webapps
CMD ["/opt/tomcat/bin/catalina.sh", "run"]
