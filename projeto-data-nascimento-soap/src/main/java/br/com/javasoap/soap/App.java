package br.com.javasoap.soap;

import java.net.URL;

import javax.xml.namespace.QName;

import br.com.javasoap.soap.service.CertidaoNascimento;
import jakarta.xml.ws.Service;

public class App {

	public static void main(String[] args) throws Exception {
		URL url = new URL("http://localhost:8085/servico/certidao?wsdl");
  	  
        QName qname = new QName("http://service.soap.javasoap.com.br/", "CertidaoNascimentoImplService");
  
        Service service = Service.create(url, qname);
  
        CertidaoNascimento certidao = service.getPort(CertidaoNascimento.class);
        int idade = certidao.calcularIdade("02/05/1990");
        String diaSemana = certidao.calcularDiaSemanaNascimento("02/05/1990");
        System.out.println("Idade: " + idade);
        System.out.println("Dia da semana: " + diaSemana);

	}

}
