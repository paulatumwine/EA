package edu.mum.cs544;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
@ComponentScan("edu.mum.cs544")
public class Config {

    @Bean
    public List<IBookSupplier> createSupplierList() {
        List<IBookSupplier> suppliers = new ArrayList<>();

        IBookSupplier amazon = new Amazon();
        IBookSupplier barnesandnoble = new BarnesAndNoble();
        IBookSupplier ebooks = new EBooks();

        suppliers.add(amazon);
        suppliers.add(barnesandnoble);
        suppliers.add(ebooks);

        return suppliers;
    }
}
