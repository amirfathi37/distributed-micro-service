package com.amigoscode.customer;

public record CustomerRegisterResp(String name, String family, String email) {
    @Override
    public String toString() {
        return "CustomerRegisterResp{" +
                "name='" + name + '\'' +
                ", family='" + family + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
