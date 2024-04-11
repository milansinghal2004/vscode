<?php
session_start();

// initializing variables
$Username = "";
$Email    = "";
$errors = array(); 

// connect to the database
$db = mysqli_connect('localhost', 'root', '', 'touristerz');

// REGISTER USER
if (isset($_POST['reg_user'])) {
  // receive all input values from the form
  $Username = mysqli_real_escape_string($db, $_POST['Username']);
  $Email = mysqli_real_escape_string($db, $_POST['Email']);
  $Password_1 = mysqli_real_escape_string($db, $_POST['Password_1']);
  $Password_2 = mysqli_real_escape_string($db, $_POST['Password_2']);

  // form validation: ensure that the form is correctly filled ...
  // by adding (array_push()) corresponding error unto $errors array
  if (empty($Username)) { array_push($errors, "Username is required"); }
  if (empty($Email)) { array_push($errors, "Email is required"); }
  if (empty($Password_1)) { array_push($errors, "Password is required"); }
  if ($Password_1 != $Password_2) {
	array_push($errors, "The two Passwords do not match");
  }

  // first check the database to make sure 
  // a user does not already exist with the same Username and/or Email
  $user_check_query = "SELECT * FROM auth WHERE Username='$Username' OR Email='$Email' LIMIT 1";
  $result = mysqli_query($db, $user_check_query);
  $user = mysqli_fetch_assoc($result);
  
  if ($user) { // if user exists
    if ($user['Username'] === $Username) {
      array_push($errors, "Username already exists");
    }

    if ($user['Email'] === $Email) {
      array_push($errors, "Email already exists");
    }
  }

  // Finally, register user if there are no errors in the form
  if (count($errors) == 0) {
  	$Password = md5($Password_1);//encrypt the Password before saving in the database

  	$query = "INSERT INTO auth (Username, Email, Password) 
  			  VALUES('$Username', '$Email', '$Password')";
  	mysqli_query($db, $query);
  	$_SESSION['Username'] = $Username;
  	$_SESSION['success'] = "You are now logged in";
  	header('location: index.html');
  }
}

// LOGIN USER
if (isset($_POST['login_user'])) {
  $Username = mysqli_real_escape_string($db, $_POST['Username']);
  $Password = mysqli_real_escape_string($db, $_POST['Password']);

  if (empty($Username)) {
  	array_push($errors, "Username is required");
  }
  if (empty($Password)) {
  	array_push($errors, "Password is required");
  }

  if (count($errors) == 0) {
  	$Password = md5($Password);
  	$query = "SELECT * FROM auth WHERE Username='$Username' AND Password='$Password'";
  	$results = mysqli_query($db, $query);
  	if (mysqli_num_rows($results) == 1) {
  	  $_SESSION['Username'] = $Username;
  	  $_SESSION['success'] = "You are now logged in";
  	  header('location: index.html');
  	}else {
  		array_push($errors, "Wrong Username/Password combination");
  	}
  }
}

?>