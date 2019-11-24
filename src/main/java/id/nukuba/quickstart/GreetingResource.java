package id.nukuba.quickstart;

import id.nukuba.quickstart.entity.Person;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.time.LocalDate;
import java.time.Month;

@Path("/hello")
public class GreetingResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "hello dude";
    }

    @GET @Path("/create-person")
    @Produces(MediaType.TEXT_PLAIN)
    @Transactional
    public String createPerson() {
        for (int i = 0; i < 10; i++) {
            Person p = new Person();

            p.setName( "Bagus" );
            p.setJob( "Software Engineer" );
            p.setBirth(LocalDate.of(1994, Month.JANUARY, 8));

            p.persist();
        }

        return "create success";
    }

}