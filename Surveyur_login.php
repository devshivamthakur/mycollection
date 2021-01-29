<?php

// Importing DBConfig.php file.
$HostName = 'bgfz0b2wihu6iechxgds-mysql.services.clever-cloud.com';
 
//Define your database name here.
$DatabaseName = 'bgfz0b2wihu6iechxgds';
 
//Define your database username here.
$HostUser = 'ughaijth8ft2wpjh';
 
//Define your database password here.
$HostPass = 'OBfrsxYhWiuoAhYJeHpm';
echo ("hii")
// Creating connection.
 $con = mysqli_connect($HostName,$HostUser,$HostPass,$DatabaseName);
 if($con)
 {
     echo ("Connection Successful")
                    // Getting the received JSON into $json variable.
                    $json = file_get_contents('php://input');
                    
                    // decoding the received JSON and store into $obj variable.
                    $obj = json_decode($json,true);

                    // Populate username from JSON $obj array and store into $name.
                    $name = $obj['uname'];

                    // Populate   password from JSON $obj array and store into $password.
                    $password = $obj['password']; 
                    // Creating SQL query and insert the record into MySQL database table.
                    $Sql_Query = "Select *from  Surveyur  where uname like '$name', and password like '$phone_number';";


                    if(mysqli_query($con,$Sql_Query)){

                    // If the record inserted successfully then show the message.
                    $MSG = 'Successful' ;

                    // Converting the message into JSON format.
                    $json = json_encode($MSG);

                    // Echo the message.
                    //  echo $json ;

                    }
                    else{

                    $MSG = 'not Successful' ;
                    // Converting the message into JSON format.
                    $json = json_encode($MSG);
                    }
                    mysqli_close($con);
 }else{
     echo "";
 }

 
?>