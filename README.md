# kurento-jsonrpc-notes

Notes for [kurento-jsonrpc](https://github.com/Kurento/kurento-java/tree/master/kurento-jsonrpc).

## Usage

### Run server

``` sh
./mvnw spring-boot:run -pl server
```

### Run client

#### Run WildFly

``` sh
cd $WILDFLY_HOME/bin
./standalone.sh -Djboss.socket.binding.port-offset=100
```

#### Deploy client

``` sh
./mvnw wildfly:deploy -pl client -Dwildfly.port=10090
```

#### Access client API

``` sh
curl localhost:8180/kurento-jsonrpc-notes-client
```

and then you can see the following response.

``` json
{
  "id": 1,
  "result": {
    "some property": "Some Value",
    "sessionId": "jiut3jt21s14gdtst5i82g3qeh"
  },
  "jsonrpc": "2.0"
}
```

## Reference

[Kurento JSON-RPC documentation](http://doc-kurento-jsonrpc.readthedocs.io/)