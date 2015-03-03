package es.open4job.ejb3.singleton;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Singleton;

@Singleton
public class ProductRegistryBean implements ProductRegistryLocal,
		ProductRegistryRemote, ProductRegistryWebService {

	Map<Integer, Double> pdtRegistry;

	@PostConstruct
	void initialize() {

		pdtRegistry = new HashMap<Integer, Double>();
		pdtRegistry.put(100, 5000.00);
		pdtRegistry.put(101, 6000.00);
		pdtRegistry.put(102, 7000.00);
		pdtRegistry.put(103, 8000.00);
		pdtRegistry.put(104, 9000.00);

	}

	public double getPrice(int id) {
		return pdtRegistry.get(id);
	}

	public void setPrice(int id, double price) {
		pdtRegistry.put(id, price);
	}

	@PreDestroy
	void cleanup() {
		pdtRegistry = null;
	}

}
