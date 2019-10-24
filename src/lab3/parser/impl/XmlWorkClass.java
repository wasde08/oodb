package lab3.parser.impl;

import lab3.entity.Product;
import lab3.entity.Seller;
import lab3.parser.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class XmlWorkClass implements Parser {
    public static void main(String[] args) throws JAXBException {
        Parser parser = new XmlWorkClass();
        File file = new File("xml.xml");


        Seller seller = new Seller("Almaz","332332232",3);
        Product product = new Product(1, "swe", 32, 33);
        Product product2 = new Product(2, "ssdffsddfe", 3545, 1);
        Product product3 = new Product(3, "qwer", 1, 34);
        List<Product> products = new ArrayList<>();
        products.add(product);
        products.add(product2);
        products.add(product3);
        seller.setProductList(products);
        parser.saveObject(file,seller);

        System.out.println(parser.getObject(file, Seller.class));

        XmlWorkClass search = new XmlWorkClass();
        System.out.println(search.searchObject(3));
    }

    @Override
    public Object getObject(File file, Class c) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(c);
        Unmarshaller unmarshaller = context.createUnmarshaller();
        Object object = unmarshaller.unmarshal(file);

        return object;
    }

    @Override
    public void saveObject(File file, Object o) throws JAXBException {
        JAXBContext context = JAXBContext.newInstance(o.getClass());
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT,Boolean.TRUE);
        marshaller.marshal(o,file);
    }

    public Object searchObject(int id) throws JAXBException {
        File file = new File("xml.xml");
        Seller seller =(Seller) getObject(file,Seller.class);
        for (Product product: seller.getProduct() ) {
            if (product.getId()==id){
                return product;
            }
        }
        return null;
    }
}
