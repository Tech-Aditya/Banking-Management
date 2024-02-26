package com.Banking.Banking.Management.Banking;

import com.mongodb.ConnectionString;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class MongoConnect {
    public static void main(String[] args) {
        try (MongoClient mongoClient = MongoClients.create(new ConnectionString("mongodb://localhost:27017"))) {
            // Connect to your database
            MongoDatabase database = mongoClient.getDatabase("Banking");

            // Get a collection (similar to a table in SQL)
            MongoCollection<Document> collection = database.getCollection("bankingData");

            // Create a new document representing your data
            Document document = new Document("name", "Shankar")
                    .append("accountNumber", 855458)
                    .append("balance", 15000.0)
                    .append("transactionLimit", 25);

            // Insert the document into the collection
            collection.insertOne(document);

            System.out.println("Data inserted successfully.");
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
    }
}