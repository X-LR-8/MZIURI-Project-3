
function deletevalue(id){
    document.getElementById(id).value=""
}
async function fill(){
    var url="/candy-shop"+"/storage";
    var response = await fetch(url, { method: "GET" });
    const product=await response.text();

}
var name1;
function openProductsPopup(name){
    var screenWidth = window.screen.width;
    var screenHeight = window.screen.height;
    var popupWidth = 400;
    var popupHeight = 400;
    var leftPosition = (screenWidth - popupWidth) / 2;
    var topPosition = (screenHeight - popupHeight) / 2;
    name1=name;

    window.open("popupview.html","popup","width=400,height=400,left=" + leftPosition + ",top=" + topPosition)
}
function purchase(){

}
async function getinfo(){
    var name=document.getElementById("username2").value;
    var password2= document.getElementById("password2").value;
    var url="/messenger"+"/message"+`?username=${username2}&password=${password2}`;
    var response = await fetch(url, { method: "GET" });
    if(!response.ok) {
        alert("Cant find User named " + username2 + " " + response.status);
    }
    deletevalue("user");
    deletevalue("message");

    var body = await response.text();
    var message=body.split('\n');
    var messagelist="";
    for(var i=0; i<message.length; i++){
        if(message[i]!=""){
            messagelist+=`<li>${message[i]}</li>`;
        }
    }
    var div = document.getElementById("inbox");
    div.innerHTML = `<ul>${messagelist}</ul>`;
}

async function getmessage(){
    var username2=document.getElementById("username2").value;
    var password2= document.getElementById("password2").value;
    var url="/messenger"+"/message"+`?username=${username2}&password=${password2}`;
    var response = await fetch(url, { method: "GET" });
    if(!response.ok) {
        alert("Cant find User named " + username2 + " " + response.status);
    }
    deletevalue("user");
    deletevalue("message");

    var body = await response.text();
    var message=body.split('\n');
    var messagelist="";
    for(var i=0; i<message.length; i++){
        if(message[i]!=""){
            messagelist+=`<li>${message[i]}</li>`;
        }
    }
    var div = document.getElementById("inbox");
    div.innerHTML = `<ul>${messagelist}</ul>`;
}
window.onload = function() {
    invokeServlet();
};
function invokeServlet() {
    var xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if (xhr.readyState === XMLHttpRequest.DONE) {
            if (xhr.status === 200) {
                console.log(xhr.responseText);
            } else {
                console.error('Error:', xhr.status, xhr.statusText);
            }
        }
    };

    xhr.open('GET', '/candy-shop', true);
    xhr.send();
}
async function getmessage(){
    var username2=document.getElementById("username2").value;
    var password2= document.getElementById("password2").value;
    var url="/messenger"+"/message"+`?username=${username2}&password=${password2}`;
    var response = await fetch(url, { method: "GET" });
    if(!response.ok) {
        alert("Cant find User named " + username2 + " " + response.status);
    }
    deletevalue("user");
    deletevalue("message");

    var body = await response.text();
    var message=body.split('\n');
    var messagelist="";
    for(var i=0; i<message.length; i++){
        if(message[i]!=""){
            messagelist+=`<li>${message[i]}</li>`;
        }
    }
    var div = document.getElementById("inbox");
    div.innerHTML = `<ul>${messagelist}</ul>`;
}