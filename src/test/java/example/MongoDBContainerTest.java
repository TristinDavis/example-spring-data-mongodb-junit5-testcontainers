package example;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;

class MongoDBContainerTest extends AbstractIntegrationTest {

    @Autowired
    private MongoTemplate mongo;

    @Test
    void testConnection() {
        final String uuid = UUID.randomUUID().toString();
        this.mongo.createCollection(uuid);
        assertThat(this.mongo.collectionExists(uuid)).isTrue();
    }

}
