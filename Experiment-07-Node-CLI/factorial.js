// Command-Line Factorial Calculator using Node.js

// Get input from command-line arguments

const input = process.argv[2];

// Check whether input is provided

if (input === undefined) {

    console.log("Error: Please provide a number.");

    console.log("Usage: node factorial.js <number>");

    process.exit(1);

}

// Validate input

if (!/^\d+$/.test(input)) {

    console.log("Error: Please enter a non-negative integer.");

    process.exit(1);

}

// Convert input into BigInt

const num = BigInt(input);

// Limit input to avoid excessive computation

if (num > 1000n) {

    console.log("Error: Please enter a number between 0 and 1000.");

    process.exit(1);

}

// Function to calculate factorial

function factorial(n) {

    let result = 1n;

    for (let i = 1n; i <= n; i++) {

        result = result * i;

    }

    return result;

}

// Calculate factorial

const answer = factorial(num);

// Display output

console.log("--------------------------------");

console.log("     FACTORIAL CALCULATOR");

console.log("--------------------------------");

console.log("Number    : " + num);

console.log("Factorial : " + answer);

console.log("--------------------------------");