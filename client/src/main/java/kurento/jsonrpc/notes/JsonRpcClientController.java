package kurento.jsonrpc.notes;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.kurento.jsonrpc.client.JsonRpcClient;
import org.kurento.jsonrpc.client.JsonRpcClientWebSocket;
import org.kurento.jsonrpc.message.Request;
import org.kurento.jsonrpc.message.Response;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import java.io.IOException;

@Path("/")
public class JsonRpcClientController {

  @GET
  @Produces(MediaType.APPLICATION_JSON)
  public String get() {

    try (JsonRpcClient client = new JsonRpcClientWebSocket("ws://localhost:8080/echo")) {
      Request<JsonObject> request = new Request<>();
      request.setMethod("echo");
      JsonObject params = new JsonObject();
      params.addProperty("some property", "Some Value");
      request.setParams(params);
      Response<JsonElement> response = client.sendRequest(request);
      return response.toString();
    } catch (IOException e) {
      throw new WebApplicationException(e);
    }

  }

}
