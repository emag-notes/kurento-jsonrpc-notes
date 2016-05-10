package kurento.jsonrpc.notes;

import org.kurento.jsonrpc.internal.server.config.JsonRpcConfiguration;
import org.kurento.jsonrpc.server.JsonRpcConfigurer;
import org.kurento.jsonrpc.server.JsonRpcHandlerRegistry;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.web.socket.config.annotation.EnableWebSocket;

@SpringBootApplication
@EnableWebSocket
@Import(JsonRpcConfiguration.class)
public class EchoServerApplication implements JsonRpcConfigurer {

  @Override
  public void registerJsonRpcHandlers(JsonRpcHandlerRegistry registry) {
    registry.addHandler(new EchoJsonRpcHandler(), "/echo");
  }

  public static void main(String[] args) {
    SpringApplication.run(EchoServerApplication.class, args);
  }

}
