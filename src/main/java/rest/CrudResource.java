/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import entity.Person;
import facade.PersonFacade;
import java.util.List;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.Produces;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PUT;
import javax.ws.rs.PathParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * REST Web Service
 *
 * @author oerte
 */
@Path("crud")
public class CrudResource {

    Gson gson = new GsonBuilder().setPrettyPrinting().create();
    PersonFacade facade = new PersonFacade();

    @Context
    private UriInfo context;

    /**
     * Creates a new instance of CrudResource
     */
    public CrudResource() {
    }

    // get all person
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonList() {
        List<Person> personList = facade.getPersonList();
        return Response.ok().entity(gson.toJson(personList)).build();
    }

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPersonBYId(@PathParam("id") int id) {
        Person personById = facade.getPersonById(id-1);
        return Response.ok().entity(gson.toJson(personById)).build();
    }

    @POST
    @Path("add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response addPerson(String jsonContext) {
        Person add = gson.fromJson(jsonContext, Person.class);
        Person addPerson = new Person(facade.maxId(), add.getName(), add.getBirthPlace(), add.getAge());
        facade.addPerson(addPerson);
        return Response.ok().entity(gson.toJson(facade.getPersonList())).build();
    }
    
    @DELETE
    @Path("/del/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response deletePersonBYId(@PathParam("id") int id) {
        Person personById = facade.deletePersonById(id -1);
        System.out.println(personById);
        return Response.ok().entity(gson.toJson(personById)).build();
    }

    @PUT
    @Path("/update/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response changePersonObject(String jsonContent, @PathParam("id") int id ) {
        Person personChangeInfo = gson.fromJson(jsonContent, Person.class);
        Person getPersonById = facade.getPersonById(id-1);
        //
        if(personChangeInfo.getName() != null){ getPersonById.setName(personChangeInfo.getName());}
        if(personChangeInfo.getBirthPlace() != null){ getPersonById.setBirthPlace(personChangeInfo.getBirthPlace());}
        if(personChangeInfo.getAge() != 0){ getPersonById.setAge(personChangeInfo.getAge());}
        // Return Person
        return Response.ok().entity(gson.toJson(getPersonById)).build();

    }
}