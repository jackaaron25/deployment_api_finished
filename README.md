# deployment_api_finished
Deployment API
===========================

How to run for Development

#### Database Requirements

You need to have PostgreSQL installed on the host machine

The database and table name can be changed during the docker build process by using "--build-arg dbase="YOUR_DATABASE_NAME_HERE" --build-arg table="YOUR_TABLE_NAME_HERE""

database**: bgp

table**: api_hijacks

The following credentials are set just for testing purposes. In production it will not be set this way.

The username and password can be changed during the docker build process by using "--build-arg uname="YOUR_USERNAME_HERE" --build-arg pword="YOUR_PASSWORD_HERE""

user**: postgres

password**: password


Make sure the user has been given permission to LOGIN and necessary privleges to access the data for the hijacks table.

#### Build the image

```
docker build --build-arg uname="YOUR_USERNAME_HERE" --build-arg pword="YOUR_PASSWORD_HERE" --build-arg dbase="YOUR_DATABASE_NAME_HERE --build-arg table="YOUR_TABLE_NAME_HERE" --tag="deploymentapi" .

```

Depending on how you set your docker install you may requie to use sudo for your docker commands

#### How to run

This will run in the forground 

```
docker run --network=host deploymentapi
```


This command binds port 8080 on your machine to port 8080 in the container, which is exposed by the Dockerfile. Most importantly it also connects the container's network to the host, so you're machine's localhost is also localhost in the docker conatiner.


If you want it to run in the background just add the -d option

```
docker run --network=host -d -p 8080:8080 deploymentapi
```

#### Test the API endpoints

Depending on your machine you can either use curl or your browser. For exmaple with curl` you can try the following:


curl -X GET --header 'Accept: application/json' 'localhost:8080/deploy-api/api/ApiDeployment/get_hijacks'
```
