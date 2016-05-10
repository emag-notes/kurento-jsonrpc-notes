package kurento.jsonrpc.notes;

import com.google.gson.JsonObject;
import org.kurento.jsonrpc.DefaultJsonRpcHandler;
import org.kurento.jsonrpc.Transaction;
import org.kurento.jsonrpc.message.Request;

public class EchoJsonRpcHandler extends DefaultJsonRpcHandler<JsonObject> {

  @Override
  public void handleRequest(Transaction transaction, Request<JsonObject> request) throws Exception {
    if ("echo".equalsIgnoreCase(request.getMethod())) {
      transaction.sendResponse(request.getParams());
    }
  }

}
