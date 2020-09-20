package br.com.exactalabs.bicycleshop;

import br.com.exactalabs.bicycleshop.entity.Adress;
import br.com.exactalabs.bicycleshop.entity.Client;
import br.com.exactalabs.bicycleshop.service.ClientService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;

@SpringBootApplication
public class BicycleShopApplication {

    public static void main(String[] args) {
        SpringApplication.run(BicycleShopApplication.class, args);
    }

    @Bean
    public CommandLineRunner run(ApplicationContext appContext) {
        return args -> {

            var clientService = appContext.getBean(ClientService.class);

            var customerAdress = new Adress("My Street", "My District", "My City", "My State",
                    "My ZipCode", "My Number");
            var customerAdressEmpty = new Adress("", "", "", "",
                    "", "");
            var customer = new Client("Customer Name", "Customer LastName", "Customer Phone",
                    "", LocalDate.of(1991, 10,10), customerAdress);
            System.out.println(customer.getAdressList());
            customer.addAdress(customerAdressEmpty);
            //customer.addAdress(null);

            System.out.println(clientService.saveClient(customer));
            //clientService.deleteClientById(100L);


            System.out.println("Spring bootado");





        };
    }

}
