package com.eazybytes.cards.models;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import lombok.Data;

@Data
public class Cards extends MetaData
{
    @NotNull(message = "Mobile number cannot be null")
    @NotEmpty(message = "Mobile number cannot be null or empty")
    @Pattern(regexp = "^[0-9]{10}$", message = "Mobile number must be 10 digits")
    private String mobileNumber;

    @NotNull(message = "Card number cannot be null")
    @NotEmpty(message = "Card number cannot be empty")
    private String cardNumber;

    @NotNull(message = "Card type cannot be null")
    @NotEmpty(message = "Card type cannot be empty")
    private String cardType;

    @NotNull(message = "Total limit cannot be null")
    private Integer totalLimit;

    @NotNull(message = "Amount used cannot be null")
    private Integer amountUsed;

    @NotNull(message = "Available amount cannot be null")
    private Integer availableAmount;
}
