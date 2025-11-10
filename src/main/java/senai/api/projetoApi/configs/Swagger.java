import org.springframework.context.annotation.Configuration;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;

@Configuration
@OpenAPIDefinition(
    info = @Info(
        title = "Api",
        version = "1.0",
        description = "Caio Borsato,Otavio,Marlon,Miguel,Thiago e Pedro Vogel"
    )
)
public class Swagger {

}

