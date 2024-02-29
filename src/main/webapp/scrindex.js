
function deletevalue(id){
    document.getElementById(id).value=""
}
async function openProductsPopup(name) {
    console.log(name);
    var screenWidth = window.screen.width;
    var screenHeight = window.screen.height;
    var popupWidth = 400;
    var popupHeight = 400;
    var leftPosition = (screenWidth - popupWidth) / 2;
    var topPosition = (screenHeight - popupHeight) / 2;

    var xhr = new XMLHttpRequest();
    xhr.open("GET", "/candy-shop/store/product?name=" + encodeURIComponent(name), true);
    xhr.setRequestHeader("Content-Type", "application/json");
    xhr.send()

    var xhr2 = new XMLHttpRequest();
    xhr2.onreadystatechange = function () {
        if (xhr2.readyState === 4) { // 4 corresponds to 'DONE' state
            if (xhr2.status === 200) { // 200 means a successful response
                var jsonResponse = JSON.parse(xhr2.responseText);
                var jsonname=jsonResponse.name;
                var jsonprice=jsonResponse.price;
                var jsonamount=jsonResponse.amount;
                localStorage.setItem('name', jsonname);
                localStorage.setItem('price', jsonprice);
                localStorage.setItem('amount', jsonamount);
            } else {
                // Handle errors
                console.error('Error fetching data. Status:', xhr2.status);
            }
        }
    };
    window.open("popupview.html", "popup", "width=400,height=400,left=" + leftPosition + ",top=" + topPosition);
}
window.onload = function () {
    invokeServlet();
};

async function invokeServlet() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function () {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
            } else {
                console.error('Error:', xhr.status, xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/candy-shop/store', true);
    xhr.send();
}
