package com.example.tdd2.chap03;

import java.time.LocalDate;

public class PayData {
    LocalDate fistBillingDate;
    LocalDate billingDate;
    int payAmount;

    private PayData() {
    }

    public PayData(LocalDate billingDate, int payAmount, LocalDate fistBillingDate) {
        this.fistBillingDate = fistBillingDate;
        this.billingDate = billingDate;
        this.payAmount = payAmount;
    }

    public LocalDate getBillingDate() {
        return billingDate;
    }

    public int getPayAmount() {
        return payAmount;
    }

    public LocalDate getFistBillingDate() {
        return fistBillingDate;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private PayData data = new PayData();
        public Builder billingDate(LocalDate billingDate) {
            data.billingDate = billingDate;
            return this;
        }
        public Builder payAmount(int payAmount) {
            data.payAmount = payAmount;
            return this;
        }
        public PayData build() {
            return data;
        }

        public Builder firstBillingDate(LocalDate firstBillingDate) {
            data.fistBillingDate = firstBillingDate;
            return this;
        }
    }
}
