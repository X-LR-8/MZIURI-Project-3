function deletevalue(id){
    document.getElementById(id).value=""
}
async function getvalues(){
    var label1 = document.getElementById("name").value;
    var label2 = document.getElementById("price").value;
    var label3 = document.getElementById("amount").value;
    var name = localStorage.getItem('name');
    var price = localStorage.getItem('price');
    var amount = localStorage.getItem('amount');
    label1.innerHTML=name;
    label2.innerHTML=price;
    label3.innerHTML=amount;
}
window.onload = function () {
    getvalues();
};
async function purchase(){
    var amount=document.getElementById("input").value;
    var url="/candy-shop"+"/store/product"+`?amount=${amount}`;
    var response = await fetch(url, { method: "POST" });
    console.log(response.status);
    if(!response.ok) {
        alert("Cant purchase"+ " " + response.status);
    }
    deletevalue("input");
}