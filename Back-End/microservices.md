## 微服务

### **1. 服务注册发现**

服务注册就是维护一个登记簿，它管理系统内所有的服务地址。当新的服务启动后，它会向登记簿交待自己的地址信息。服务的依赖方直接向登记簿要 Service Provider 地址就行了。当下用于服务注册的工具非常多 ZooKeeper，Consul，Etcd, 还有 Netflix 家的 eureka 等。

服务注册有两种形式：客户端注册和第三方注册。

#### 1.1客户端注册(**zookeeper**)

客户端注册是服务自身要负责注册与注销的工作。当服务启动后向注册中心注册自身，当服务下线时注销自己。期间还需要和注册中心保持心跳。心跳不一定要客户端来做，也可以由注册中心负责(这个过程叫探活)。这种方式的缺点是注册工作与服务耦合起不同语言都要实现一套注册逻辑。

```java
service instance A --> register("serviceName",104.3.1:8756)=heartbeat() || unregister() --> service registry
```

#### 1.2第三方注册(**独立的服务Registrar**)

第三方注册由一个独立的服务 Registrar 负责注册与注销。当服务启动后以某种方式通知 Registrar，然后 Registrar 负责注册中心发起注册工作。同时注册中心要维护与服务之间的心跳，当服务不可用时，向注册中心注销服务。这种方式的缺点是Registrar 必须是一个高可用的系统，否则注册工作没法进展。

```java
service instance A <--  Registrar(第三方负责) --> register("serviceName",104.3.1:8756)=heartbeat() || unregister() --> service registry
```

#### 1.3 客户端发现

客户端发现是指客户端负责查询可用服务地址，以及负载均衡的工作。这种方式最方便直接，而且也方便做负载均衡。再者一旦发现某个服务不可用立即换另外一个，非常直接。缺点也在于多语言时的重复工作，每个语言实现相同的逻辑。

#### 1.4服务端发现

服务端发现需要额外的 Router 服务，请求先打到 Router，然后 Router 负责查询服务与负载均衡。这种方式虽然没有客户端发现的缺点，但是它的缺点是保证 Router 的高可用。

### 2. 微服务中的 API 网关（API Gateway） 

#### 1.定义

API Gateway 是一个服务器，也可以说是进入系统的唯一节点。

API Gateway 封装内部系统的架构，并且提供 API 给各个客户端。它还可能有其他功能，如授权、监控、负载均衡、缓存、请求分片和管理、静态响应处理等。下图展示了一个适应当前架构的 API Gateway。 

API Gateway 负责请求转发、合成和协议转换。所有来自客户端的请求都要先经过 API Gateway，然后路由这些请求到对应的微服务。API Gateway 将经常通过调用多个微服务来处理一个请求以及聚合多个服务的结果。它可以在 web 协议与内部使用的非 Web 友好型协议间进行转换，如 HTTP 协议、WebSocket 协议。 

```java 
浏览器->API网关->服务 
```

#### 2.引入 

API 网关并不是微服务场景中必须的组件，如下图，不管有没有 API 网关，后端微服务都可以通过 API 很好地支持客户端的访问。 

但对于服务数量众多、复杂度比较高、规模比较大的业务来说，引入 API 网关也有一系列的好处： 

* 聚合接口使得服务对调用者透明，客户端与后端的耦合度降低 
* 聚合后台服务，节省流量，提高性能，提升用户体验 
* 提供安全、流控、过滤、缓存、计费、监控等 API 管理功能 

#### 3. 特点

配置中心一般用作系统的参数配置，它需要满足如下几个要求：高效获取、实时感知、分布式访 

问。 

### 3.**配置中心**

































































## Dubbo

https://segmentfault.com/a/1190000019896723

#### 3.1 服务端

首先，我们先把服务端的接口写好，因为其实 dubbo 的作用简单来说就是给消费端提供接口。

##### 接口定义

```java
/**
 * xml方式服务提供者接口
 */
public interface ProviderService {

    String SayHello(String word);
}
```

这个接口非常简单，只是包含一个 SayHello 的方法。

接着，定义它的实现类。

```java
/**
 * xml方式服务提供者实现类
 */
public class ProviderServiceImpl implements ProviderService{

    public String SayHello(String word) {
        return word;
    }
}
```

这样我们就把我们的接口写好了，那么我们应该怎么将我们的服务暴露出去呢？

##### 导入 maven 依赖

```xml
<?xml version="1.0" encoding="UTF-8"?>
<project xmlns="http://maven.apache.org/POM/4.0.0"
         xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
         xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
    <modelVersion>4.0.0</modelVersion>

    <groupId>com.ouyangsihai</groupId>
    <artifactId>dubbo-provider</artifactId>
    <version>1.0-SNAPSHOT</version>

    <dependencies>
        <dependency>
            <groupId>junit</groupId>
            <artifactId>junit</artifactId>
            <version>3.8.1</version>
            <scope>test</scope>
        </dependency>
        <!-- https://mvnrepository.com/artifact/com.alibaba/dubbo -->
        <dependency>
            <groupId>com.alibaba</groupId>
            <artifactId>dubbo</artifactId>
            <version>2.6.6</version>
        </dependency>
        <dependency>
            <groupId>org.apache.zookeeper</groupId>
            <artifactId>zookeeper</artifactId>
            <version>3.4.10</version>
        </dependency>
        <dependency>
            <groupId>com.101tec</groupId>
            <artifactId>zkclient</artifactId>
            <version>0.5</version>
        </dependency>
        <dependency>
            <groupId>io.netty</groupId>
            <artifactId>netty-all</artifactId>
            <version>4.1.32.Final</version>
        </dependency>
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-framework</artifactId>
            <version>2.8.0</version>
        </dependency>
        <dependency>
            <groupId>org.apache.curator</groupId>
            <artifactId>curator-recipes</artifactId>
            <version>2.8.0</version>
        </dependency>

    </dependencies>
</project>
```

这里使用的 dubbo 的版本是 `2.6.6` ，需要注意的是，如果你只导入 dubbo 的包的时候是**会报错**的，**找不到 netty 和 curator 的依赖**，所以，在这里我们需要把这两个的依赖加上，就不会报错了。