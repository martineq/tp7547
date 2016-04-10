package ordertracker.services

import grails.test.mixin.Mock
import grails.test.mixin.TestFor
import ordertracker.AvailableProductsService
import ordertracker.Product
import ordertracker.ProductController
import ordertracker.constants.HttpProtocol
import ordertracker.constants.Keywords
import ordertracker.queries.QueryException
import ordertracker.queries.Requester
import ordertracker.tranmission.DefaultTransmission
import spock.lang.Specification

@TestFor(ProductController)
@Mock(Product)
class ProductsControllerSpec extends Specification {

    private Requester generateMartinRequester() {
        Requester requester = new Requester()
        requester.addProperty(HttpProtocol.METHOD, HttpProtocol.GET)
        requester.addProperty(Keywords.USERNAME, 'martin')
        requester.addProperty(Keywords.TOKEN, 'token1')
        return requester
    }

    void "test invalidRequestMethod"() {
        given:
            Requester requester = new Requester()
            requester.addProperty(HttpProtocol.METHOD, HttpProtocol.PUT)

        and:
            def validationService = new AvailableProductsService();
            def message = ""

        when:
        try {
            validationService.validate(requester)
        }
        catch (QueryException qe ) {
            message = qe.getMessage()
        }

        then:
            message == 'Invalid HTTP request method: must be GET'
    }

    void "test validRequestMethod"() {
        given:
            def requester = this.generateMartinRequester()

        and:
            def products = new AvailableProductsService()

        when:
            def validationResult = products.validate(requester)

        then:
            validationResult == true
    }

    void "test emptyDatabase"() {
        given:
            def requester = this.generateMartinRequester()

        and:
            def products = new AvailableProductsService()

        when:
            products.validate(requester)
            def validationResult = products.generateQuery()

        then:
        validationResult == true
    }

    void "test obtainEmptyDatabase"() {
        given:
            def requester = this.generateMartinRequester()

        and:
            def products = new AvailableProductsService()

        when:
            products.validate(requester)
            products.generateQuery()
            def jsonBuilder = products.obtainResponse(DefaultTransmission.obtainDefaultTransmission())

        then:
            jsonBuilder.build() == '{"status":{"result":"ok","description":"Available product"},"data":{}}'
    }
}
