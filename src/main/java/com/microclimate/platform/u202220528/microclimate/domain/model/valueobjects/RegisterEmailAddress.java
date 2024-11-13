package com.microclimate.platform.u202220528.microclimate.domain.model.valueobjects;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.Getter;

import java.util.Objects;
import java.util.regex.Pattern;

@Getter
@Embeddable
public class RegisterEmailAddress {
    private static final Pattern EMAIL_PATTERN =
            Pattern.compile("^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$");

    @Column(nullable = false, length = 50)
    private String registerEmailAddress;

    protected RegisterEmailAddress() {
        //empty constructor JPA
    }

    public RegisterEmailAddress(String registerEmailAddress) {
        if (!EMAIL_PATTERN.matcher(registerEmailAddress).matches()) {
            throw new IllegalArgumentException("Invalid email format");
        }
        this.registerEmailAddress = registerEmailAddress;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegisterEmailAddress that = (RegisterEmailAddress) o;
        return Objects.equals(registerEmailAddress, that.registerEmailAddress);
    }

    @Override
    public int hashCode() {
        return Objects.hash(registerEmailAddress);
    }

    @Override
    public String toString() {
        return registerEmailAddress;
    }
}
