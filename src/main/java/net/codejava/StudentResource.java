package net.codejava;

import java.net.*;
import java.util.*;

import javax.ws.rs.*;
import javax.ws.rs.core.*;

@Path("/student")
public class StudentResource {
	private StudentDAO dao = StudentDAO.getInstance();
	
	@GET
	@Produces(MediaType.APPLICATION_JSON)
	public List<Student> list(){
		
		return dao.listAll();	
	}
	
	@GET
	@Path("{studn}")
	@Produces(MediaType.APPLICATION_JSON)
	public Response get(@PathParam("studno") int studno) {
		Student student= dao.get(studno);
		if (student != null) {
			return Response.ok(student, MediaType.APPLICATION_JSON).build();		
			}else {
				return Response.status(Response.Status.NOT_FOUND).build();
			}
	}
	
	@POST
	@Consumes(MediaType.APPLICATION_JSON)
	public Response add(Student student) throws URISyntaxException{
		int newStudentId = dao.add(student);
		URI uri = new URI("/student/" + newStudentId);
		return Response.created(uri).build();
	}
	
	@PUT
	@Consumes(MediaType.APPLICATION_JSON)
	@Path("{studno}")
	public Response update(@PathParam("studno") int studno, Student student) {
		student.setId(studno);
		if (dao.update(student)) {
			return Response.ok().build();
		}else {
			return Response.notModified().build();
		}
		
	}
	
	@DELETE
	@Path("{studno}")
	public Response delete(@PathParam("studno") int studno) {
		if (dao.delete(studno)) {
			return Response.ok().build();
			
		}else {
			return Response.notModified().build();
		}
	}
}
