package com.Banking.Banking.Management.Banking;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class Mongo extends Bank{

    private static final String DATABASE_NAME = "Banking";
    private static final String COLLECTION_NAME = "bankingData";

    private MongoClient mongoClient;
    private MongoCollection<Document> collection;

    public Mongo() {
        try {
            mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"));
            MongoDatabase database = mongoClient.getDatabase(DATABASE_NAME);
            collection = database.getCollection(COLLECTION_NAME);
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void addAccount(String name, long accountNumber, double balance,int age) {
        try {
            Document document = new Document("name", name)
                    .append("accountNumber", accountNumber)
                    .append("balance", balance)
                    .append("age", age)
                    ;

            collection.insertOne(document);
            System.out.println("Account added successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void deposit(long accountNumber, double amount) {
        try {
            Document account = collection.find(Filters.eq("accountNumber", accountNumber)).first();
            if (account != null) {
                double currentBalance = account.getDouble("balance");
                double newBalance = currentBalance + amount;
                collection.updateOne(Filters.eq("accountNumber", accountNumber),
                        Updates.set("balance", newBalance));
                System.out.println("Deposit successful.");
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void withdraw(long accountNumber, double amount) {
        try {
            Document account = collection.find(Filters.eq("accountNumber", accountNumber)).first();
            if (account != null) {
                double currentBalance = account.getDouble("balance");
                if (currentBalance >= amount) {
                    double newBalance = currentBalance - amount;
                    collection.updateOne(Filters.eq("accountNumber", accountNumber),
                            Updates.set("balance", newBalance));
                    System.out.println("Withdrawal successful.");
                } else {
                    System.out.println("Insufficient balance.");
                }
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void checkBalance(long accountNumber) {
        try {
            Document account = collection.find(Filters.eq("accountNumber", accountNumber)).first();
            if (account != null) {
                double balance = account.getDouble("balance");
                System.out.println("Account Balance: " + balance);
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public void showInterest(long accountNumber, double interestRate, int period) {
        try {
            Document account = collection.find(Filters.eq("accountNumber", accountNumber)).first();
            if (account != null) {
                double balance = account.getDouble("balance");
                double interest = balance * (interestRate / 100) * period;
                System.out.println("Interest accrued: " + interest);
            } else {
                System.out.println("Account not found.");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        Mongo account = new Mongo();
//        mongo.addAccount("Roy",15264853L,50000,24);
//        mongo.deposit(15264853L,2000);
//        mongo.withdraw(15264853L,6000);
        account.checkBalance(15264853L);

    }
}




























//import com.mongodb.ConnectionString;
//import com.mongodb.client.MongoClient;
//import com.mongodb.client.MongoClients;
//import com.mongodb.client.MongoCollection;
//import com.mongodb.client.MongoDatabase;
//import com.mongodb.client.model.Filters;
//import org.bson.Document;

//public class Mongo {
//            try (MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"))) {
//
//                MongoDatabase database = mongoClient.getDatabase("Banking");
//
//                MongoCollection<Document> collection = database.getCollection("bankingData");
//
//                Document document = new Document("name", "Nagaraj Gadag")
//                        .append("accountNumber", 89549880L)
//                        .append("balance", 25000.0)
//                        .append("transactionLimit", 25);
//
//                collection.insertOne(document);
//                System.out.println("Data inserted successfully.");
//            } catch (Exception e) {
//                System.err.println("Error: " + e.getMessage());
//            }
//        }

//    }

