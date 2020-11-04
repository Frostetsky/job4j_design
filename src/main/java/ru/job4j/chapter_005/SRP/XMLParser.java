package ru.job4j.chapter_005.SRP;

import ru.job4j.chapter_005.OCP.Parser;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.StringWriter;
import java.util.List;

public class XMLParser implements Parser {
    @Override
    public String formatted(List<Employee> list) {
        StringWriter writer = new StringWriter();
        for (Employee employee : list) {
            try {
                JAXBContext jaxbContext = JAXBContext.newInstance(Employee.class);
                Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
                jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
                jaxbMarshaller.marshal(employee, writer);

            } catch (JAXBException e) {
                e.printStackTrace();
            }
        }
        return writer.toString();
    }
}
