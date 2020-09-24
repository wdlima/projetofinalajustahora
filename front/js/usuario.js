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
            listaocorrencias(JSON.stringify(usuariojson.id_usuario));
    }
}


function listaocorrencias(user){
         fetch("http://localhost:8080/ocorrencias/usuario/" + user)
        .then(res=> res.json())
        .then(res => montartabela(res))
        .catch(err => {
            window.alert("Não encontrado");
    });
    }

function montartabela(lista){
var tabela = 
"<div class='row'>" +
"<div class='col-12'>" +
"<table align='center' border='1' width='80%' ><tr>" +
"<th>Numero de Horas </th> <th>Data de Ocorrência </th> <th>Descrição </th> <th> Justificar </th></tr>";
//codigo pra preencher a tabela
for(cont=0;cont<lista.length;cont++){
    tabela+=
    "<tr>" +
    "<td>" + lista[cont].num_horas + "</td>" +
    "<td>" + lista[cont].data_oc + "</td>" +
    "<td>" + lista[cont].descricao + "</td>";
    if (lista[cont].status==0){
        tabela+="<td>" + "<button type='button' onclick='corrigir("+lista[cont].num_seq+")' value='"+lista[cont].num_seq+"' class='btn btn-primary'>Justificar</button>" + "</td>" + "</tr>";
    } else {
        tabela+="<td>" + "OK" + "</td>" +  "</tr>";
    }
    
    
}


tabela+="</table></div></div>";
document.getElementById("resultado").innerHTML=tabela;

}


function corrigir(id){
    localStorage.setItem("ocorrencia",id); 
    window.location="justificativa.html";
}
