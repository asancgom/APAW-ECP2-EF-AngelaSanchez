package API;

import API.resources.AuthorResource;
import API.resources.PublisherResource;
import API.resources.exceptions.RequestInvalidException;
import http.HttpRequest;
import http.HttpResponse;
import http.HttpStatus;
import http.Server;

public class Dispatcher implements Server {

	private PublisherResource publisher = new PublisherResource();
	private AuthorResource author = new AuthorResource();

	private void responseError(HttpResponse response, Exception e) {
		response.setBody("{\"error\":\"" + e + "\"}");
		response.setStatus(HttpStatus.BAD_REQUEST);
	}

	public void doGet(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(PublisherResource.PUBLISHER + PublisherResource.ID)) {

				response.setBody(publisher.readPublisher(Integer.valueOf(request.paths()[1])).toString());

			}else if (request.isEqualsPath(AuthorResource.AUTHOR + AuthorResource.ID)) {

				response.setBody(author.readAuthor(Integer.valueOf(request.paths()[1])).toString());

			} else if (request.isEqualsPath(PublisherResource.PUBLISHER + PublisherResource.ID_CITY)) {

				response.setBody(publisher.readCityPublisher(Integer.valueOf(request.paths()[1])).toString());

			} else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPost(HttpRequest request, HttpResponse response) {
		try {
			if (request.isEqualsPath(PublisherResource.PUBLISHER)) {

				String id = request.getBody().split(":")[0];
				String title = request.getBody().split(":")[1];
				String city = request.getBody().split(":")[2];
				publisher.createPublisher(Integer.valueOf(id), title, city);

			} else if (request.isEqualsPath(AuthorResource.AUTHOR)) {

				String name = request.getBody().split(":")[0];
				String language = request.getBody().split(":")[1];
				author.createAuthor(name, language);

			}else {
				throw new RequestInvalidException(request.getPath());
			}
		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPut(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doPatch(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
	}

	public void doDelete(HttpRequest request, HttpResponse response) {
		try {

		} catch (Exception e) {
			responseError(response, e);
		}
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
