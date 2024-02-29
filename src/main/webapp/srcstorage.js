function deletevalue(id){
    document.getElementById(id).value=""
}
async function changeamount(){
    var name=document.getElementById("name").value
    var amount=document.getElementById("amount").value
    var password=document.getElementById("password").value
    console.log(name)
    var url="/candy-shop"+"/store/product"+`?name=${name}&amount=${amount}&password=${password}`;
    var response = await fetch(url, { method: "PUT" });
    console.log(response.status);
    if(!response.ok) {
        alert("Cant Add"+ " " + response.status);
    }
    deletevalue("user");
    deletevalue("message");
}
