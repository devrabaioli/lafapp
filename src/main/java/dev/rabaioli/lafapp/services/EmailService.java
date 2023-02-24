package dev.rabaioli.lafapp.services;

import org.springframework.mail.SimpleMailMessage;

import dev.rabaioli.lafapp.domain.Pedido;



public interface EmailService {

	void sendOrderConfirmationEmail(Pedido obj);

	void sendEmail(SimpleMailMessage msg);
}
