package es.open4job.ejb3.singleton;

import javax.ejb.Remote;

@Remote
public interface ProductRegistryRemote {

	double getPrice(int id);

	void setPrice(int id, double price);

}