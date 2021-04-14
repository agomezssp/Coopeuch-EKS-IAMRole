package com.htp.porvenir;

import com.mongodb.client.*;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Value;

public class MongoConnect {

//    @Value("${app.mongo.username}")
//    protected String username;
//
//    @Value("${app.mongo.password}")
//    protected String password;
//
//    @Value("${app.mongo.cluster-endpoint}")
//    protected String clusterEndpoint;

    @Value("${app.mongo.connection-string}")
    protected String connectionString;




    public void TestMongo(){
//        String template = "mongodb://%s:%s@%s/sample-database?ssl=true&replicaSet=rs0&readpreference=%s";
//        String template = "mongodb://%s:%s@%s/?ssl=true&ssl_ca_certs=rds-combined-ca-bundle.pem&replicaSet=rs0&readPreference=%s&retryWrites=false";
//        String username = "<sample-user>";

//        String password = "<password>";
//        String clusterEndpoint = "docdb-2021-04-14-13-31-15.cluster-c3x1l4aay9gk.us-east-2.docdb.amazonaws.com:27017";
//        String readPreference = "secondaryPreferred";
//        String connectionString = String.format(template, username, password, clusterEndpoint, readPreference);

//        String truststore = "<truststore>";
//        String truststorePassword = "<truststorePassword>";

//        System.setProperty("javax.net.ssl.trustStore", truststore);
//        System.setProperty("javax.net.ssl.trustStorePassword", truststorePassword);

        MongoClient mongoClient = MongoClients.create(connectionString);

        MongoIterable databases = mongoClient.listDatabases();
        try {
            while (databases.cursor().hasNext()) {
                System.out.println(databases.cursor().next().toString());
            }
        } finally {
            databases.cursor().close();
        }

//        MongoDatabase testDB = mongoClient.getDatabase("sample-database");
//        MongoCollection<Document> numbersCollection = testDB.getCollection("sample-collection");
//
//        Document doc = new Document("name", "pi").append("value", 3.14159);
//        numbersCollection.insertOne(doc);
//
//        MongoCursor<Document> cursor = numbersCollection.find().iterator();
//        try {
//            while (cursor.hasNext()) {
//                System.out.println(cursor.next().toJson());
//            }
//        } finally {
//            cursor.close();
//        }
    }
}
