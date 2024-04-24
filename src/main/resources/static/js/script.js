'use strict';

// modal variables
const modal = document.querySelector('[data-modal]');
const modalCloseBtn = document.querySelector('[data-modal-close]');
const modalCloseOverlay = document.querySelector('[data-modal-overlay]');

// modal function
const modalCloseFunc = function () { modal.classList.add('closed') }

// modal eventListener
modalCloseOverlay.addEventListener('click', modalCloseFunc);
modalCloseBtn.addEventListener('click', modalCloseFunc);





// notification toast variables
const notificationToast = document.querySelector('[data-toast]');
const toastCloseBtn = document.querySelector('[data-toast-close]');

// notification toast eventListener
toastCloseBtn.addEventListener('click', function () {
  notificationToast.classList.add('closed');
});





// mobile menu variables
const mobileMenuOpenBtn = document.querySelectorAll('[data-mobile-menu-open-btn]');
const mobileMenu = document.querySelectorAll('[data-mobile-menu]');
const mobileMenuCloseBtn = document.querySelectorAll('[data-mobile-menu-close-btn]');
const overlay = document.querySelector('[data-overlay]');

for (let i = 0; i < mobileMenuOpenBtn.length; i++) {

  // mobile menu function
  const mobileMenuCloseFunc = function () {
    mobileMenu[i].classList.remove('active');
    overlay.classList.remove('active');
  }

  mobileMenuOpenBtn[i].addEventListener('click', function () {
    mobileMenu[i].classList.add('active');
    overlay.classList.add('active');
  });

  mobileMenuCloseBtn[i].addEventListener('click', mobileMenuCloseFunc);
  overlay.addEventListener('click', mobileMenuCloseFunc);

}





// accordion variables
const accordionBtn = document.querySelectorAll('[data-accordion-btn]');
const accordion = document.querySelectorAll('[data-accordion]');

for (let i = 0; i < accordionBtn.length; i++) {

  accordionBtn[i].addEventListener('click', function () {

    const clickedBtn = this.nextElementSibling.classList.contains('active');

    for (let i = 0; i < accordion.length; i++) {

      if (clickedBtn) break;

      if (accordion[i].classList.contains('active')) {

        accordion[i].classList.remove('active');
        accordionBtn[i].classList.remove('active');

      }

    }

    this.nextElementSibling.classList.toggle('active');
    this.classList.toggle('active');

  });

}

function logout() {
        // Perform any client-side cleanup if needed

        // Make an AJAX request to the server to invalidate the session
        var xhr = new XMLHttpRequest();
        xhr.open("POST", "/logout", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // Redirect to the logout page
                    window.location.href = "/logout";
                } else {
                    // Handle error if needed
                    console.error("Logout failed:", xhr.status);
                }
            }
        };
        xhr.send();
    }


function cart() {
        // Perform any client-side cleanup if needed

        // Make an AJAX request to the server to invalidate the session
        var xhr = new XMLHttpRequest();
        xhr.open("GET", "/cart", true);
        xhr.onreadystatechange = function () {
            if (xhr.readyState === XMLHttpRequest.DONE) {
                if (xhr.status === 200) {
                    // Redirect to the logout page
                    window.location.href = "/cart";
                } else {
                    // Handle error if needed
                    console.error("Failed to open", xhr.status);
                }
            }
        };
        xhr.send();
    }

var imageName ;
var name;
var description;
var price;

 function openPopup(event) {

 // Prevent the default behavior of the click event
     event.preventDefault();

 // Get the clicked showcase element
     var showcase = event.currentTarget.closest('.showcase');

     // Extract product details from the showcase element
     var image = showcase.querySelector('.showcase-img-box img').getAttribute('src');

      // Store the image name in a variable
     imageName = showcase.querySelector('.showcase-img-box img').getAttribute('src').split('/').pop();

     var title = showcase.querySelector('.showcase-title').textContent;
     description = title ;

     name = showcase.querySelector('.showcase-category').textContent;

     price = showcase.querySelector('.price').textContent;
     var originalPrice = showcase.querySelector('del').textContent;

     // Populate the popup with the extracted product details
     var popup = document.querySelector(".popup-product-details");
     popup.querySelector(".popup-product-image").src = image;
     popup.querySelector(".popup-product-title").textContent = title;
      popup.querySelector(".popup-product-price").innerHTML = "<del>" + originalPrice + "</del> " + price;

     document.getElementById("popup").style.display = "block";
    }

// Add event listeners to all showcase elements
var showcaseElements = document.querySelectorAll('.showcase');
showcaseElements.forEach(function(showcase) {
    showcase.addEventListener('click', openPopup);
});

function closePopup() {
      // Close the popup
      document.getElementById("popup").style.display = "none";
}

function addToCart() {

   // Get the quantity from the input field
       var quantity = document.getElementById("quantity").value;
        console.log("Quantity " + quantity)

       // Update the count displayed on the cart button
       var countButton = document.querySelector('.action-btn .count');
       if (countButton) {
           var currentCountButton = parseInt(countButton.textContent);
           countButton.textContent = currentCountButton + parseInt(quantity);
       }

       // Update the count displayed in the <span> tag
       var countSpan = document.getElementById('cartCount');
       if (countSpan) {
           var currentCountSpan = parseInt(countSpan.textContent);
           countSpan.textContent = currentCountSpan + parseInt(quantity);
       }

    // Close the popup after adding the item to the cart
    closePopup();

    // Construct the request body
        var requestBody = {
            name: name,
            description: description,
            image: imageName,
            price: price,
            quantity: quantity
        };

        // Make a POST request to your REST API endpoint
        fetch('updatecart', {
            method: 'POST',
            headers: {
                'Content-Type': 'application/json'
            },
            body: JSON.stringify(requestBody)
        })
        .then(response => {
            if (!response.ok) {
                throw new Error('Network response was not ok');
            }
            return response.json();
        })
        .then(data => {
            console.log('Response:', data);
            // Handle the response as needed
        })
        .catch(error => {
            console.error('Error:', error);
            // Handle errors
        });
}

// Function to be called when the page loads to initially update the cart count
function onPageLoad() {
    updateCartCount();
}

// Call onPageLoad function when the page loads
document.addEventListener("DOMContentLoaded", onPageLoad);

function updateCartCount() {
    fetch('/cartcount')
        .then(response => response.json())
        .then(data => {
            // Update the cart count
            document.getElementById("cartCount").textContent = data.cartCount;
        })
        .catch(error => {
            console.error('Error fetching cart count:', error);
        });
}