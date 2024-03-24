package com.neonlab.common.dto.enums;

public enum OtpPurpose {
    SIGN_UP,
    LOG_IN;

    public static OtpPurpose fromString(String text) {
        for (OtpPurpose purpose : OtpPurpose.values()) {
            if (purpose.name().equalsIgnoreCase(text)) {
                return purpose;
            }
        }
        throw new IllegalArgumentException("No constant with text " + text + " found in OtpPurpose enum");
    }
}
