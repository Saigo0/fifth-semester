package ex01.refatoracao;

public class EnvioRelatorio {
    public void enviarPorEmail(String destinatario, String assunto, String corpo) {
        // Simula envio de e-mail
        System.out.println("Enviando e-mail para: " + destinatario);
        System.out.println("Assunto: " + assunto);
        System.out.println("Corpo: " + corpo);
        // Na vida real: JavaMail, Spring Mail, etc.
    }
}
