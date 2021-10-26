package pe.com.backend;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

@RestController
public class ClientController {
	//@Value("${spring.application.environment}")
	private String entorno;
	
	@RequestMapping(value ="/services/rest/large", 
			method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public String large() {
								
	for(int i=0;i<1000000;i++) {
	  int calculo = i * i;	
      System.out.println("Atendiendo: " + i);   
    }		
		return "OK";
	}

	@RequestMapping(value ="/services/rest/medium", 
			method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public String medium() {
								
	for(int i=0;i<10000;i++) {
	  int calculo = i * i;	
      System.out.println("Atendiendo: " + i);   
    }		
		return "OK";
	}

	@RequestMapping(value ="/services/rest/listadoclientes", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public List<Client> listClients(@RequestBody Autenticacion request) {
		
		List<Client> response = new ArrayList<Client>();
		
		if(request.getToken().equals("41818310")) {
		
		Client c1 = new Client();
		c1.setEmail("willy@gmail.com");
		c1.setNombre("Willy");		
		response.add(c1);
		
		Client c2 = new Client("vivi@gmail.com","Marco");
		response.add(c2);
		
		response.add(new Client("chino@gmail.com","Wilmer"));
		}
		
		return response;
	}
	

	@RequestMapping(value ="/services/rest/listClient", 
			method = RequestMethod.GET, produces = { "application/json" })
	@ResponseBody
	public List<Client> listClient() {
		
		List<Client> response = new ArrayList<Client>();
						
		response.add(new Client("mvega@gmail.com","Martha Vega"));
		response.add(new Client("rlopez@gmail.com","Rosario Lopez"));
		response.add(new Client("vsalas@gmail.com","Vanesa Salas"));		
		response.add(new Client("wrivera@gmail.com","Wilmer Rivera"));
		response.add(new Client("jmartinez@gmail.com","Jose Martinez"));
		
		return response;
	}
	

	@RequestMapping(value ="/services/rest/crearcliente", 
			method = RequestMethod.POST, produces = { "application/json" })
	@ResponseBody
	public Response crearCliente(@RequestBody Client request) {
		
		Response response = new Response();
		response.setCode("OK");
		response.setDescription("Usuario "+ request.getNombre() + " registrado.");
		
		return response;
	}
	
	

	
}
