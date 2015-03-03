package es.open4job.ejb3.singleton;

import javax.jws.WebService;

@WebService
public interface ProductRegistryWebService {
	
    double getPrice(int id);

    void setPrice(int id, double price);

}