function carregarusuario(){
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
    }
}

function montartabela(lista){
var tabela = 
"<div class='row'>" +
"<div class='col-12'>" +
"<table align='center' border='1' width='80%' ><tr>" +
"<th>Musicas</th> <th>Cadastro</th> <th>Nome Artista</th> </tr>";
//codigo pra preencher a tabela
for(cont=0;cont<lista.length;cont++){
    tabela+=
    "<tr>" +
    "<td>" + lista[cont].num_horas + "</td>" +
    "<td>" + lista[cont].data_oc + "</td>" +
    "<td>" + lista[cont].descricao + "</td>" +
    "</tr>";
}


tabela+="</table></div></div>";
document.getElementById("resultado").innerHTML=tabela;
}

function filtrar(){
    var valor = document.getElementById("cmbocorrencias").value;
    if (valor=="0" || valor=="1") {
        fetch("http://localhost:8080/ocorrencias/" + valor)
        .then(res=> res.json())
        .then(res => montartabela(res))
        .catch(err => {
            window.alert("Não encontrado");
    });

    }
}