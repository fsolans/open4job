package es.open4job.ejb3.singleton;

import javax.ejb.Local;

@Local
public interface ProductRegistryLocal {

	double getPrice(int id);

	void setPrice(int id, double price);

}
