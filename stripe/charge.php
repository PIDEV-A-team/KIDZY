<?php
require './vendor/autoload.php';\Stripe\Stripe::setApiKey('sk_test_8TNB5HaJ0H5lWP5qMso3OWDI00syLPhFY3');
$token = $_POST['stripeToken'];
// This is a $20.00 charge in US Dollar.
$charge = \Stripe\Charge::create(
    array(
        'amount' => 2000,
        'currency' => 'usd',
        'source' => $token
    )
);
print_r($charge);
?>