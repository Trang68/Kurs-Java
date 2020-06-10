package app.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import app.entity.Clients;
import app.repository.ClientsRepository;


@Service
public class ClientsServiceImpl {
	@Autowired
	private ClientsRepository clientsRepository;
	
	public void save(Clients c) {
		clientsRepository.save(c);
	}
	
	public List<Clients> getAllClients() {
		return clientsRepository.findAll();
	}
	public Clients getClientBySeria(String passportSeria) {
		return clientsRepository.findClientBySeria(passportSeria);
	}
	
	public Map<Integer, Clients> clientsToMap(List<Clients> list) {
		Map<Integer, Clients> map = new HashMap<>();
		for (Clients c : list) {
			map.put(c.getId(), c);
		}
		
		return map;
	}
}
