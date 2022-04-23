# OBA [![License: CC BY 4.0](https://img.shields.io/badge/License-CC_BY_4.0-lightgrey.svg)](https://creativecommons.org/licenses/by/4.0/)
A public repository for learning objects

## Setting up local containers

The project has a docker-compose file that allows you to set up containers on a service network of the database, sonarqube and later on other services.To run the the docker, with sudo permissions
on Linux, use the following command:

```shell
docker-compose up --build -d
```

**Rising up an specific service**

```shell
docker-compose up [ service_name_01 | service_name_02] --build -d
```

**Stop all the containers**

```shell
docker-compose down
```

**Another commands**

To delete images/containers/volumes/network not used.

```shell
docker system prune -f && docker network prune -f && docker image prune -a -f && docker volume prune -f
```

**Note:** The following data are the default configuration to access the database:
* URL: ``` jdbc:postgres:thin@//localhost:5432/postgres ```
* POSTGRES_USER: OBA_ADMIN
* POSTGRES_PASSWORD: OBA_LOCAL


## Setting up the database's tables

The initial database is empty, so it is important to run the migrations of the tables. To do so run the following command:

```shell
./gradlew flywayMigrate -DServer=local_database
```
