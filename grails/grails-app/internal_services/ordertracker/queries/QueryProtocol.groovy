package ordertracker.queries

import ordertracker.constants.HttpProtocol
import ordertracker.protocol.ProtocolJsonBuilder
import ordertracker.protocol.Result
import ordertracker.protocol.Status
import org.apache.catalina.connector.RequestFacade
import org.apache.tools.ant.taskdefs.condition.Http

abstract class QueryProtocol {

    protected ProtocolJsonBuilder builder
    protected String queryExceptionMessage
    protected Requester requester

    QueryProtocol analyse(RequestFacade request) {
        this.getBody(request)
        this.requester.addProperty( HttpProtocol.METHOD, request.method )
        this.requester.addProperty( HttpProtocol.REQUEST_URI, request.requestURI )
        this.requester.addProperty( HttpProtocol.REMOTE_HOST, request.remoteHost )
        request.headerNames.each { header -> this.requester.addProperty( header, request.getHeader(header)) }

        return this
    }

    abstract QueryProtocol run()

    def buildResponse() {
        if ( this.queryExceptionMessage.empty == true )
            return this.builder.build()

        return new ProtocolJsonBuilder(new Status(Result.ERROR, this.queryExceptionMessage)).build()
    }

    private void getBody(RequestFacade request) {
        try {
            String body = ""
            try {
                body = this.readBody(request.getReader())
            }

            catch (IOException e ) {}

            this.requester.addProperty( HttpProtocol.BODY, body )
        }
        catch ( UnsupportedEncodingException e ) {}
        catch ( IllegalStateException e ) {}
        catch ( IOException e ) {}
    }

    private String readBody(BufferedReader bufferedReader) {
        String body = ""
        String bodyLine

        if ( ( bodyLine = bufferedReader.readLine() ) != null )
            body += bodyLine

        while( ( bodyLine = bufferedReader.readLine() ) != null )
            body += '\n' + bodyLine

        return body
    }
}
