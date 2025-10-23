package com.lab8.service;

public interface MailService {

    public static class Mail {
        private String from = "WebShop <web-shop@gmail.com>";
        private String to;
        private String cc;
        private String bcc;
        private String subject;
        private String body;
        private String filenames;

        // Constructors
        public Mail() {}

        public Mail(String from, String to, String cc, String bcc, String subject, String body, String filenames) {
            this.from = from;
            this.to = to;
            this.cc = cc;
            this.bcc = bcc;
            this.subject = subject;
            this.body = body;
            this.filenames = filenames;
        }

        // ====== GETTERS & SETTERS ======
        public String getFrom() {
            return from;
        }

        public void setFrom(String from) {
            this.from = from;
        }

        public String getTo() {
            return to;
        }

        public void setTo(String to) {
            this.to = to;
        }

        public String getCc() {
            return cc;
        }

        public void setCc(String cc) {
            this.cc = cc;
        }

        public String getBcc() {
            return bcc;
        }

        public void setBcc(String bcc) {
            this.bcc = bcc;
        }

        public String getSubject() {
            return subject;
        }

        public void setSubject(String subject) {
            this.subject = subject;
        }

        public String getBody() {
            return body;
        }

        public void setBody(String body) {
            this.body = body;
        }

        public String getFilenames() {
            return filenames;
        }

        public void setFilenames(String filenames) {
            this.filenames = filenames;
        }

        // ====== Builder hỗ trợ ======
        public static Builder builder() {
            return new Builder();
        }

        public static class Builder {
            private String from = "WebShop <web-shop@gmail.com>";
            private String to;
            private String cc;
            private String bcc;
            private String subject;
            private String body;
            private String filenames;

            public Builder from(String from) {
                this.from = from;
                return this;
            }

            public Builder to(String to) {
                this.to = to;
                return this;
            }

            public Builder cc(String cc) {
                this.cc = cc;
                return this;
            }

            public Builder bcc(String bcc) {
                this.bcc = bcc;
                return this;
            }

            public Builder subject(String subject) {
                this.subject = subject;
                return this;
            }

            public Builder body(String body) {
                this.body = body;
                return this;
            }

            public Builder filenames(String filenames) {
                this.filenames = filenames;
                return this;
            }

            public Mail build() {
                return new Mail(from, to, cc, bcc, subject, body, filenames);
            }
        }
    }

    // ====== Các phương thức gốc ======
    void send(Mail mail);

    default void send(String to, String subject, String body) {
        Mail mail = Mail.builder().to(to).subject(subject).body(body).build();
        this.send(mail);
    }

    void push(Mail mail);

    default void push(String to, String subject, String body) {
        this.push(Mail.builder().to(to).subject(subject).body(body).build());
    }
}
