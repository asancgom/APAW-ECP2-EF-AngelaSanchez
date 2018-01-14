package API;

import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import http.Server;

public class Dispatcher implements Server {

    private static final String PATH_ERROR = "Path Error";


    private void responseError(HttpResponse response, String msg) {
        response.setBody("{\"error\":\"" + msg + "\"}");
        response.setStatus(HttpStatus.BAD_REQUEST);
    }

    public void doGet(HttpRequest request, HttpResponse response) {
        responseError(response, PATH_ERROR);
    }

    public void doPost(HttpRequest request, HttpResponse response) {
        responseError(response, PATH_ERROR);
    }

    public void doPut(HttpRequest request, HttpResponse response) {
        responseError(response, PATH_ERROR);
    }

    public void doPatch(HttpRequest request, HttpResponse response) {
        responseError(response, PATH_ERROR);
    }

    public void doDelete(HttpRequest request, HttpResponse response) {
        responseError(response, PATH_ERROR);
    }

    @Override
    public HttpResponse submit(HttpRequest request) {
        HttpResponse response = new HttpResponse();
        switch (request.getMethod()) {
        case POST:
            doPost(request, response);
            break;
        case GET:
            doGet(request, response);
            break;
        case PUT:
            doPut(request, response);
            break;
        case DELETE:
            doDelete(request, response);
            break;
        default:
        }
        return response;
    }

}
