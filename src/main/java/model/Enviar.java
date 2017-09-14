package model;

import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;


import model.Email;
public class Enviar {

	public static void main(String[] args) {
		
		Email e = new Email("teste", "vamos ver", "betinlimma@gmail.com", "N2S");
		try {
			e.sendEmail();
		} catch (EmailException e1) {
			
			e1.printStackTrace();
		}

	}

}
