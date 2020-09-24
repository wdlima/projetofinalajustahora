function carregarjustificativa(){
    var usuario = localStorage.getItem("userlogado");
    if (usuario==null){
        window.location="index.html";
    }else{
        var usuariojson = JSON.parse(usuario);
        document.getElementById("foto").innerHTML = 
            "<img alt='Usuário sem foto' width = '40%' src=images/" + usuariojson.link_foto + ">";
            document.getElementById("dados").innerHTML=
            "<h3> " + usuariojson.nome_usuario + "<br>" + usuariojson.email_usuario + 
            "<br> ID:" + usuariojson.id_usuario + "</h3>" ;
            preencherdados();
        }
}


function corrigir(id){
    localStorage.setItem("ocorrencia",id); 
    window.location="justificativa.html";
}



function preencherdados(){
    fetch("http://localhost:8080/ocorrencias/justificar/" + localStorage.getItem("ocorrencia"))
   .then(res=> res.json())
   .then(res =>{
    document.getElementById("data").innerHTML=JSON.stringify(res.data_oc);
    document.getElementById("quantidadehoras").innerHTML=JSON.stringify(res.num_horas);
   })
   .catch(err => {
       window.alert("Não encontrado");
});
}