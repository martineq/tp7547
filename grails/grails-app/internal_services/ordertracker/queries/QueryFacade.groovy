package ordertracker.queries

import ordertracker.util.logger.Log
import org.apache.catalina.connector.RequestFacade

class QueryFacade {

    private QueryProtocol queryProtocol

    QueryFacade(QueryProtocol queryProtocol) {
        this.queryProtocol = queryProtocol
    }

    QueryFacade(AuthenticationQuery authenticationQuery) {
        this.queryProtocol = authenticationQuery
    }

    QueryFacade(Queryingly queryService) {
        this.queryProtocol = new Query(queryService)
    }

    def solve(RequestFacade request) {
        Log.info(request)
        this.queryProtocol.analyse(request)
        this.queryProtocol.run()
        this.queryProtocol.buildResponse()
    }
}
