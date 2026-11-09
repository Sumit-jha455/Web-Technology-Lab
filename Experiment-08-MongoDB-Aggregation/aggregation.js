const { MongoClient } = require("mongodb");

// MongoDB connection URL
const url = "mongodb://127.0.0.1:27017";

// Create MongoDB client
const client = new MongoClient(url);

async function main() {
    try {
        // Connect to MongoDB
        await client.connect();
        console.log("Connected to MongoDB successfully!");

        // Select database and collection
        const db = client.db("UserAnalyticsDB");
        const collection = db.collection("users");

        // Remove previous sample records
        await collection.deleteMany({});

        // Insert sample user records
        const users = [
            { name: "Sumit", age: 21, city: "Delhi" },
            { name: "Rahul", age: 24, city: "Delhi" },
            { name: "Aman", age: 22, city: "Mumbai" },
            { name: "Priya", age: 25, city: "Mumbai" },
            { name: "Rohit", age: 28, city: "Mumbai" },
            { name: "Neha", age: 23, city: "Noida" },
            { name: "Anjali", age: 27, city: "Noida" },
            { name: "Karan", age: 30, city: "Delhi" }
        ];

        await collection.insertMany(users);
        console.log("Sample user records inserted successfully!");

        // Aggregation pipeline
        const pipeline = [
            {
                $match: {
                    age: { $gte: 21 }
                }
            },
            {
                $group: {
                    _id: "$city",
                    averageAge: { $avg: "$age" },
                    totalUsers: { $sum: 1 }
                }
            },
            {
                $sort: {
                    averageAge: 1
                }
            },
            {
                $project: {
                    _id: 0,
                    city: "$_id",
                    averageAge: { $round: ["$averageAge", 2] },
                    totalUsers: 1
                }
            }
        ];

        // Execute aggregation
        const result = await collection.aggregate(pipeline).toArray();

        console.log("\nAverage age of users in each city:");
        console.table(result);

    } catch (error) {
        console.error("Error:", error.message);
    } finally {
        await client.close();
    }
}

main();