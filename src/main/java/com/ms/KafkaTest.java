package com.ms;

import com.microsoft.azure.functions.annotation.*;
import com.microsoft.azure.functions.*;

/**
 * Azure Functions with Kafka Trigger.
 */
public class KafkaTest {
    /**
     * This function consume KafkaEvents on the localhost. Change the topic, brokerList, and consumerGroup to fit your enviornment.
     * The function is trigged one for each KafkaEvent
     * @param kafkaEventData
     * @param context
     */
    @FunctionName("KafkaTest")
    public void run(
            @KafkaTrigger(name = "kafkaTrigger", 
                          topic = "hanli-event-hub",
                          brokerList = "BrokerList",
                          username = "$ConnectionString",
                          password = "%Password%",
                          authenticationMode = BrokerAuthenticationMode.PLAIN,
                          protocol = BrokerProtocol.SASLSSL,
                          consumerGroup="$Default") String kafkaEventData,
            final ExecutionContext context) {
        context.getLogger().info("kafka Info:" + kafkaEventData);
    }
}