package mozt.edu.reactivemongo.config;

import com.mongodb.MongoClientSettings;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;
import com.mongodb.reactivestreams.client.MongoClient;
import com.mongodb.reactivestreams.client.MongoClients;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractReactiveMongoConfiguration;

import java.util.Collections;

@Configuration
public class MongoConfig extends AbstractReactiveMongoConfiguration {

    //@Value("${mongoDb.databaseName}")
    public static String dbName = "mongoDbForBeverages";

    @Bean
    public MongoClient getMongoClient(){
        return MongoClients.create();
    }
    //returns the database name that will be created in Mongo Db and used here
    @Override
    protected String getDatabaseName() {
//        return "mongoDbForBeverages";
//        return MongoConfig.dbName;
        return "sfg";
    }

    @Override
    protected void configureClientSettings(MongoClientSettings.Builder builder) {
        System.out.println("Databasename:" + getDatabaseName());
        builder.credential(MongoCredential.createCredential("root", "admin", "example".toCharArray()))
                .applyToClusterSettings(settings ->
                        settings.hosts(
                                Collections.singletonList(
                                        new ServerAddress("127.0.0.1", 27017)
                                )
                        ));

    }
}
