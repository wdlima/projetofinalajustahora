function logar(){
    var mensagem = {
        racf:document.getElementById("txtracf").value,
        senha:document.getElementById("txtsenha").value
    };

    var carta = {
        method:"POST",
        body : JSON.stringify(mensagem),
        headers:{
            "Content-type":"application/json"
        }

    }
    
    fetch("http://localhost:8080/login", carta)
    .then(res => res.json())
    .then(res => {
        localStorage.setItem("userlogado", JSON.stringify(res));
        if (res.gestor==1){
            window.location="usuario_gestor.html";
       }else {
             window.location="usuario.html";

       }

    })
    .catch(err => {
        window.alert("Usuário e/ou senha inválido");
});
}