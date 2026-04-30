const { Kafka } = require("kafkajs");

const kafka = new Kafka({
  clientId: "notification-service",
  brokers: ["localhost:9092"],
});

const consumer = kafka.consumer({ groupId: "notification-group" });

const sleep = (ms) => new Promise((resolve) => setTimeout(resolve, ms));

async function sendPushNotifications(authorId, postId) {
  await sleep(2000); // Імітація виклику зовнішнього API

  console.log(
    `🔔 [УСПІХ] Сповіщення про пост ${postId} доставлені всім підписникам!\n`,
  );
}

async function startNotificationService() {
  await consumer.connect();
  console.log("🎧 Notification Service підключено до Kafka.");

  await consumer.subscribe({ topic: "post-events", fromBeginning: true });

  await consumer.run({
    eachMessage: async ({ topic, partition, message }) => {
      const event = JSON.parse(message.value.toString());

      if (event.eventType === "PostCreated") {
        console.log(
          `[Notification Service] 📥 Отримано подію: ${event.eventType} (Post: ${event.data.postId})`,
        );
        await sendPushNotifications(event.data.authorId, event.data.postId);
      }
    },
  });
}

startNotificationService().catch(console.error);
