package day01.ex00;

import java.util.UUID;

enum TransCategory {
    debits,
    credits
}

public class Transaction {

    Transaction(User recipient, User sender, TransCategory transCategory,
        Integer amount) {
        if ((transCategory == TransCategory.credits && sender.getBalance() < amount) ||
            (transCategory == TransCategory.debits &&  sender.getBalance() < -amount)) {
            System.err.println("Incorrect balance");
            System.exit(-1);
        }
        if ((transCategory == TransCategory.credits && amount > 0) ||
            (transCategory == TransCategory.debits &&  amount < 0)) {
            System.err.println("Incorrect category");
            System.exit(-1);
        }

        this.recipient = recipient;
        this.sender = sender;
        this.transCategory = transCategory;
        this.amount = amount;

    }

    UUID identifier = UUID.randomUUID();
    User recipient;
    User sender;
    TransCategory transCategory;
    Integer amount;

    public UUID getIdentifier() {
        return identifier;
    }

    public void setIdentifier(UUID identifier) {
        this.identifier = identifier;
    }

    public User getRecipient() {
        return this.recipient;
    }

    public void setRecipient (User recipient) {
        this.recipient = recipient;
    }

    public User getSender() {
        return sender;
    }

    public void setSender (User sender) {
        this.sender = sender;
    }

    public TransCategory getTransCategory() {
        return this.transCategory;
    }

    public void setTransCategory(TransCategory transCategory) {
        this.transCategory = transCategory;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
