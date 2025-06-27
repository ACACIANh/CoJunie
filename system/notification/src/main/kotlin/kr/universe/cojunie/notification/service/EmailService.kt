package kr.universe.cojunie.notification.service

import org.springframework.beans.factory.annotation.Value
import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

/**
 * Service for sending email notifications
 */
@Service
class EmailService(private val mailSender: JavaMailSender) {
    @Value("\${spring.mail.username}")
    private lateinit var fromEmail: String

    /**
     * Send a simple email
     * @param to Recipient email address
     * @param subject Email subject
     * @param text Email body text
     */
    fun sendSimpleEmail(
        to: String,
        subject: String,
        text: String,
    ) {
        val message =
            SimpleMailMessage().apply {
                setFrom(fromEmail)
                setTo(to)
                setSubject(subject)
                setText(text)
            }
        mailSender.send(message)
    }

    /**
     * Send a simple email to multiple recipients
     * @param to List of recipient email addresses
     * @param subject Email subject
     * @param text Email body text
     */
    fun sendSimpleEmail(
        to: List<String>,
        subject: String,
        text: String,
    ) {
        val message =
            SimpleMailMessage().apply {
                setFrom(fromEmail)
                setTo(to.joinToString(","))
                setSubject(subject)
                setText(text)
            }
        mailSender.send(message)
    }
}
