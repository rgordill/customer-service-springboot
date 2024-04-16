# Spring Boot  Sample

## Testing
For testing, you can do the following:

### Local (laptop)
Just execute 

```bash
mvn clean spring-boot:run -Plocal
```

Connect to http://localhost:8080/swagger-ui.html and test some methods

If you want to check everything is ok, connect to http://localhost:8080/actuator/prometheus, and see the cache_* metrics

### Kubernetes

mvn clean compile jar:jar spring-boot:repackage k8s:build k8s:push k8s:resource k8s:deploy -Pkubernetes -Djkube.build.strategy=jib
