function deletevalue(id){
    document.getElementById(id).value=""
}
async function getvalues(){
    var url="/candy-shop"+"/store/product";
    var response = await fetch(url, { method: "GET" });
    var body=await response.json();
    var label1 = document.getElementById("name");
    var label2 = document.getElementById("price");
    var label3 = document.getElementById("amount");
    label1.innerHTML=body.prod_name;
    label2.innerHTML=body.prod_price;
    label3.innerHTML=body.prod_amount;
}
async function purchase(){
    var amount=document.getElementById("amount").value
    var url="/candy-shop"+"/store/product"+`?amount=${amount}`;
    var response = await fetch(url, { method: "POST" });

}