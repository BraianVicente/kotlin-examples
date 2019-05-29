package to.dev.example

import io.dropwizard.Application
import io.dropwizard.Configuration
import io.dropwizard.setup.Environment
import javax.ws.rs.*
import kotlinx.serialization.*
import kotlinx.serialization.json.Json


fun main(args: Array<String>) {
    CalculatorApp().run(*args)
}

class CalculatorConfig(val name: String = "unknown") : Configuration()

class CalculatorApp : Application<CalculatorConfig>() {
    override fun run(configuration: CalculatorConfig, environment: Environment) {
        println("Running ${configuration.name}!")
        val calculatorComponent = CalculatorComponent()
        environment.jersey().register(calculatorComponent)
    }
}

@Serializable
data class DataResponse(val result: String = "OK", val value: Double)

fun dataResponseSerializer(result :Double) :String{
    return Json.stringify(DataResponse.serializer(),DataResponse(value = result))
}


@Path("/calculator")
class CalculatorComponent {
    @Path("/add")
    @GET
    fun add(@QueryParam("a") a: Double, @QueryParam("b") b: Double): String {
        val operationResult = a + b
        return dataResponseSerializer(operationResult)
    }

    @Path("/multiply")
    @GET
    fun multiply(@QueryParam("a") a: Double, @QueryParam("b") b: Double): String {
        val operationResult = a*b
        return dataResponseSerializer(operationResult)
    }

    @Path("/divide")
    @GET
    fun divide(@QueryParam("a") a: Double, @QueryParam("b") b: Double): String  {
        if (b == .0) {
            throw WebApplicationException("Can't divide by zero")
        }
        val operationResult = a / b
        return dataResponseSerializer(operationResult)

    }
}