package http;

public interface Server {
    HttpResponse submit(HttpRequest request);
}
