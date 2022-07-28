var campoId;
// var PessoaId = 10;
PessoaId = sessionStorage.setItem("PessoaId", 10);
var PessoaId = sessionStorage.getItem("PessoaId");
var AdminId = sessionStorage.getItem("AdminId");
var AdminId = 1;
var monitor = sessionStorage.getItem("monitorId");
// import {logout} from "./logout.js"

window.onload = async function() {
    try {
        campoId = sessionStorage.getItem("campoId");

        let campo = await $.ajax({
            url: "/api/campos/"+campoId,
            method: "get",
            dataType: "json"
        });
        let html3 = `<h1><b>${campo[0].nome}</b></h1>`

     let semanas = await $.ajax({
        url: "/api/semana",
        method: "get",
        dataType: "json",
      });


      let html10 = `<ul class="navbar-nav ms-auto">
      <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/campos.html"
              >CAMPOS</a
          >
      </li>
      <ul class="navbar-nav ms-auto">
      <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/CamposMap.html"
              >CAMPOS MAP</a
          >
      </li>
      <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/Contactos.html"
              >CONTACTOS</a
          >
      </li>`
      
      if(PessoaId){
          html10 += `
          <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/pessoaProfile.html"
              >PERFIL</a
          >
      </li>
      <li class="nav-item mx-3">
          <a class="nav-link text-white" onclick="logout()">LOGOUT
      </li>`
      }
      else if (AdminId){
          html10 += `
          <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/adminProfile.html"
              >PERFIL</a
          >
      </li>
      <li class="nav-item mx-3">
          <a class="nav-link text-white" href="/gerirMonitor.html"
              >GERIR MONITORES</a
          >
      </li>
      <li class="nav-item mx-3">
          <a class="nav-link text-white" onclick="logout()">LOGOUT
      </li>`
      }
      else{
          html10 += `
          </li>
          <li class="nav-item mx-3">
              <a class="nav-link text-white" href="/login.html"
                  >LOGIN</a
              >
          </li>
          <li class="nav-item mx-3">
              <a class="nav-link text-white" href="/register.html"
                  >REGISTAR</a
              >
          </li>
      </ul>`
      }
      
        document.getElementById("navbarNav").innerHTML = html10;
        
        let html1 = ""
        let html = ""
    if(PessoaId || AdminId || monitor){
        for (let semana of semanas) {
            html +=
            `<option value = ${semana.id}>` +
            new Date(semana.start).toLocaleDateString("pt-PT") +
            `</option>`
        }
            
        document.getElementById("semana").innerHTML= html;

        html1 += `<section>
        <p><input type="button" onclick="reservarCampo()" class="btn btn-success" value="Inscrever"></p></section>`;
}
    else{
        html1 += `<section> <p><input type="button" class="btn btn-success" onclick="toLogin()" value="Inscrever"></p></section>`;
    }

        document.getElementById("campo").innerHTML= html1;
        document.getElementById("nome").innerHTML= html3;

        
        let ativs = await $.ajax({
            url: `/api/campos/${campoId}/ativ`,
            method: "get",
            dataType: "json"
        });
        let html2="";
        for (let ativ of ativs)
            html2 += `<section class="py-3">
                <h2 class="text-uppercase">${ativ.nome}</h2>
                <h5 class="px-4">- ${ativ.disc}</h3>
                </section>`;

        document.getElementById("ativs").innerHTML =  html2;
    } catch(err) {
        console.log(err);
    }
}

async function reservarCampo(campoId, PessoaId){
    try {
        semanaId = document.getElementById("semana").value;
        PessoaId = sessionStorage.getItem("PessoaId");
        campoId = sessionStorage.getItem("campoId");
        let obj = {campoId, PessoaId, semanaId}
        console.log(obj);
        let reservas = await $.ajax({
          url: `/api/inscricoes/reservas`,
          method: "post",
          dataType: "json",
          data: JSON.stringify(obj),
          contentType: "application/json",
    });
        alert("Reserva efetuada com sucesso");

      } catch (err) {
        document.getElementById("msg").innerText = err.responseJSON.msg;
      }
    }

    async function toLogin(){
    try{
        window.location = "login.html";
    }
    catch (err) {
    document.getElementById("msg").innerText = err.responseJSON.msg;
  }
};


