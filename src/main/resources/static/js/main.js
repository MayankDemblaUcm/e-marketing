
(function ($) {
    "use strict";


    /*==================================================================
    [ Focus Contact2 ]*/
    $('.input100').each(function(){
        $(this).on('blur', function(){
            if($(this).val().trim() != "") {
                $(this).addClass('has-val');
            }
            else {
                $(this).removeClass('has-val');
            }
        })    
    })
  
  
    /*==================================================================
    [ Validate ]*/
    var input = $('.validate-input .input100');

    $('.validate-form').on('submit',function(){
        var check = true;

        for(var i=0; i<input.length; i++) {
            if(validate(input[i]) == false){
                showValidate(input[i]);
                check=false;
            }
        }

        return check;
    });


    $('.validate-form .input100').each(function(){
        $(this).focus(function(){
           hideValidate(this);
        });
    });

    function validate (input) {
        if($(input).attr('type') == 'email' || $(input).attr('name') == 'email') {
            if($(input).val().trim().match(/^([a-zA-Z0-9_\-\.]+)@((\[[0-9]{1,3}\.[0-9]{1,3}\.[0-9]{1,3}\.)|(([a-zA-Z0-9\-]+\.)+))([a-zA-Z]{1,5}|[0-9]{1,3})(\]?)$/) == null) {
                return false;
            }
        }
        else {
            if($(input).val().trim() == ''){
                return false;
            }
        }
    }

    function showValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).addClass('alert-validate');
    }

    function hideValidate(input) {
        var thisAlert = $(input).parent();

        $(thisAlert).removeClass('alert-validate');
    }
    

})(jQuery);

 function validatePassword() {
            var password = document.getElementById('password').value;
            var confirmPassword = document.getElementById('confirmPassword').value;
            var errorElement = document.getElementById('passwordError');

            if (password !== confirmPassword) {
                errorElement.innerHTML = 'Passwords do not match';
                return false;
            } else {
                errorElement.innerHTML = '';
                return true;
            }
}

function displaySelectedImage(event, elementId) {
    const selectedImage = document.getElementById(elementId);
    const fileInput = event.target;

    if (fileInput.files && fileInput.files[0]) {
        const reader = new FileReader();

        reader.onload = function(e) {
            selectedImage.src = e.target.result;
        };

        reader.readAsDataURL(fileInput.files[0]);

         // Append the file to the FormData object
        formData.append('file', fileInput.files[0]);
    }
}

function adjustQuantity(change, index, itemId) {

    // Construct the id of the input element dynamically
    var inputId = 'form' + index;

    // Retrieve the quantity input element by its id
    var input = document.getElementById(inputId);

    // Get the current quantity value from the input element
    var currentValue = parseInt(input.value);

    // Calculate the new quantity value
    var newValue = currentValue + change;

    // Ensure the new quantity value is greater than or equal to zero
    newValue = Math.max(newValue, 0);

    // Update the value of the input element with the new quantity
    input.value = newValue;

    // Call the updatePrice function with the new quantity value
    updatePrice(change, newValue, index, currentValue , itemId);
}

    function updatePrice(change, quantity, index, currentValue, itemId) {

             var pricePerUnit = 1 ;

             if(quantity === 0 )
             {
                   // If quantity is zero, remove the item display from the list
                 var itemDisplay = document.getElementById('item-display-' + index);
                 itemDisplay.remove();

                // Call the DELETE API endpoint to remove the item
                 fetch('/deletecartitem/' + itemId, {
                     method: 'DELETE'
                 })
                 .then(response => {
                     if (!response.ok) {
                         throw new Error('Network response was not ok');
                     }
                     return response.json();
                 })
                 .catch(error => {
                     console.error('Error:', error);
                     // Handle errors
                 });

                pricePerUnit =  currentValue;

             }else{

             // Construct the ID of the price element dynamically
                          var priceId = 'price-' + index;

                          // Get the price element by its ID
                          var priceElement = document.getElementById(priceId);

                          // Get the price value from the text content of the price element
                          var priceText = priceElement.innerText;

                          // Extract the numeric part of the price value
                          var priceValue = parseFloat(priceText.replace(/[^\d.]/g, ''));

                          pricePerUnit = priceValue / currentValue;

                          // Calculate the total price by multiplying the price per unit with the quantity
                          var totalPrice = pricePerUnit * quantity;

                          // Format the total price with currency symbol and two decimal places
                          var formattedPrice = '$ ' + totalPrice.toFixed(2);

                          // Update the text content of the price element with the formatted total price
                          priceElement.innerText = formattedPrice;
             }

             if(change === 1){
                 let totalPriceElement = document.getElementById('totalPrice');
                 totalPriceElement.textContent = '$ ' +  (parseFloat(totalPriceElement.textContent.replace('$', '')) + pricePerUnit)

                 let totalPriceElementn = document.getElementById('totalPricen');
                 totalPriceElementn.textContent = '$ ' + (parseFloat(totalPriceElementn.textContent.replace('$', '')) + pricePerUnit)
             }else{
                 let totalPriceElement = document.getElementById('totalPrice');
                 totalPriceElement.textContent =  '$ ' + (parseFloat(totalPriceElement.textContent.replace('$', '')) - pricePerUnit)

                 let totalPriceElementn = document.getElementById('totalPricen');
                 totalPriceElementn.textContent =  '$ ' + (parseFloat(totalPriceElementn.textContent.replace('$', '')) - pricePerUnit)
             }

    }

document.addEventListener("DOMContentLoaded", function() {
    // Get the orderButton element
    let orderButton = document.getElementById("orderButton");

    // Check if the orderButton element exists
    if (orderButton) {
        // Add event listener to the orderButton
        orderButton.addEventListener("click", function() {
            showSuccessBanner();
        });
    } else {
        console.error("Order button not found.");
    }
});


// Function to display the success banner and redirect after 5 seconds
function showSuccessBanner() {
    // Display the banner
    let banner = document.getElementById("successBanner");
    banner.style.display = "block";

    // Scroll to the top of the page to make the banner visible
    window.scrollTo({ top: 0, behavior: 'smooth' });

    // Function to update the countdown
    function updateCountdown(seconds) {
        document.getElementById("countdown").textContent = seconds;
    }

    // Countdown timer
    let secondsRemaining = 5;
    updateCountdown(secondsRemaining);
    let countdownInterval = setInterval(function() {
        secondsRemaining--;
        updateCountdown(secondsRemaining);
        if (secondsRemaining <= 0) {
            clearInterval(countdownInterval);
            // Redirect to the navigators.html page
            window.location.href = "navigators";
        }
    }, 1000); // Update every second
}