# `springboot-cloudkarafka`

The goal of this project is to implement a [`Spring Boot`](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
application that _produces_ messages to a [`Kafka`](https://kafka.apache.org/) topic and another `Spring Boot`
application that _consumes_ those messages.

Similar projects are: [`springboot-spring-kafka`](https://github.com/ivangfr/springboot-spring-kafka)
and [`spring-cloud-stream-elasticsearch`](https://github.com/ivangfr/spring-cloud-stream-elasticsearch).

However, in this one, when the profile `cloudkarafka` is used, `producer` and `consumer` will connect to a `Kafka`
that is located in a cloud-based messaging service called [`CloudKarafka`](https://www.cloudkarafka.com/). When running
the applications with `default` profile, `producer` and `consumer` will connect to `Kafka` that is running locally in a
`Docker` container.

## Examples

### [spring-kafka](https://github.com/ivangfr/springboot-cloudkarafka/tree/master/spring-kafka#springboot-cloudkarafka)

### [spring-cloud-stream](https://github.com/ivangfr/springboot-cloudkarafka/tree/master/spring-cloud-stream#springboot-cloudkarafka)

## CloudKarafka Configuration

First of all, access https://www.cloudkarafka.com/ and create an account. There is the `Developer Duck` plan that is
totally free.

Once you log into `CloudKarafka`, click on `Details` menu. You should see something like the picture below. In
this page you have all the credentials and the URLs of the `Kafka` brokers.

![cloudkarafka-details](images/cloudkarafka-details.png)

In order to get information about the topic you will use, click on the `Topics` menu.

![cloudkarafka-topics](images/cloudkarafka-topics.png)

You can use the default topic or create a new one. In my case, I created a new one with suffix `news.json`.

## Running Kafka locally

If you prefer to have `Kafka` running locally in your machine, run the command below. It will start all containers needed.
```
docker-compose up -d
```
> To stop and remove containers, networks and volumes, run
> ```
> docker-compose down -v
> ```

### Useful links

#### Kafka Topics UI
     
`Kafka Topics UI` can be accessed at http://localhost:8085

#### Kafka Manager
     
`Kafka Manager` can be accessed at http://localhost:9000

**Configuration**

- First, you must create a new cluster. Click on `Cluster` (dropdown on the header) and then on `Add Cluster`
- Type the name of your cluster in `Cluster Name` field, for example: `MyZooCluster`
- Type `zookeeper:2181` in `Cluster Zookeeper Hosts` field
- Enable checkbox `Poll consumer information (Not recommended for large # of consumers if ZK is used for offsets tracking on older Kafka versions)`
- Click on `Save` button at the bottom of the page.
