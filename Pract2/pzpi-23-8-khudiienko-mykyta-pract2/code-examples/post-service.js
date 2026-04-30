const { Kafka } = require("kafkajs");
const { v4: uuidv4 } = require("uuid");

const kafka = new Kafka({
  clientId: "post-service",
  brokers: ["localhost:9092"],
});

const producer = kafka.producer();

async function createPost(authorId, imageUrl, caption) {
  await producer.connect();
  const postId = uuidv4();
  const eventPayload = {
    eventId: uuidv4(),
    eventType: "PostCreated",
    timestamp: new Date().toISOString(),
    data: {
      postId,
      authorId,
      imageUrl,
      caption,
    },
  };
  await producer.send({
    topic: "post-events",
    messages: [
      {
        key: authorId,
        value: JSON.stringify(eventPayload),
      },
    ],
  });

  await producer.disconnect();
  return postId;
}

(async () => {
  await createPost(
    "user_alex",
    "https://insta.com/photo1.jpg",
    "Подорож у гори! 🏔️",
  );
})();
