package com.entrenamosuy.core.data;

import java.util.Objects;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.entrenamosuy.core.exceptions.EmailParseException;

public class Email {

    private static final Pattern pattern = Pattern.compile("(.+)@(.+)");

    public static Email of(String prefix, String domain) {
        return new Email(prefix, domain);
    }

    public static Email parse(String email) throws EmailParseException {
        Matcher matcher = pattern.matcher(email);

        if (matcher.find()) {
            String prefix = matcher.group(1);
            String domain = matcher.group(2);

            return Email.of(prefix, domain);
        }

        throw new EmailParseException("email invalido");
    }

    private final String prefix;

    private final String domain;

    public Email(String prefix, String domain) {
        Objects.requireNonNull(prefix, "prefix es null en constructor Email");
        Objects.requireNonNull(domain, "domain es null en constructor Email");
        
        this.prefix = prefix;
        this.domain = domain;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getDomain() {
        return domain;
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, domain);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) 
            return true;
        if (obj == null || getClass() != obj.getClass()) 
            return false;
        Email other = (Email) obj;
        return Objects.equals(prefix, other.prefix)
                && Objects.equals(domain, other.domain);
    }

    @Override
    public String toString() {
        return prefix + "@" + domain;
    }
}
