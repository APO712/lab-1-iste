package es.upm.dit.apsv.transportationorderserver;

import es.upm.dit.apsv.transportationorderserver.repository.TransportationOrderRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;

@SpringBootApplication

public class TransportationOrderServerApplication {
    public static final Logger log = LoggerFactory.getLogger(TransportationOrderServerApplication.class);
    private TransportationOrderRepository torderRepository;

    @Autowired 
    private Environment env;

    public TransportationOrderServerApplication(TransportationOrderRepository repository transportationOrderRepository) {
        this.transportationOrderRepository = transportationOrderRepository;
    }

        public static void main(String[] args) {

                SpringApplication.run(TransportationOrderServerApplication.class, args);

        }

}