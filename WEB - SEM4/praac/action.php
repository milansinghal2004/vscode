<?php
if ($_SERVER["REQUEST_METHOD"] == "POST") {
    // Retrieve data from the form
    $name = $_POST["name"];
    $phone_number = $_POST["pno"];

    // Display the submitted data
    echo "<h2>Submitted Information:</h2>";
    echo "<p>Name: $name</p>";
    echo "<p>Phone Number: $phone_number</p>";
} else {
    // Redirect to the form if accessed directly without a POST request
    header("Location: index.html");
    exit();
}
?>
