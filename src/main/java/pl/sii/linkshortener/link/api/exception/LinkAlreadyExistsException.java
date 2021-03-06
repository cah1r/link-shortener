package pl.sii.linkshortener.link.api.exception;

public class LinkAlreadyExistsException extends RuntimeException {

    public LinkAlreadyExistsException(String id) {
        super("Link with " + id + " already exists");
    }
}
