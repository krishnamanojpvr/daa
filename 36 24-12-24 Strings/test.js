const incrementDigits = async (num) => {
    try {
        num++; // Increment the number
        console.log(num); // Log the updated number
        if (num < 10) {
            // If num is less than 10, call the function recursively
            incrementDigits(num);
        } else {
            // If num reaches 10, return "done!"
            return 'done!';
        }
    } catch (err) {
        console.log(err); // Log any errors
    }
};
incrementDigits(0)
incrementDigits(2)