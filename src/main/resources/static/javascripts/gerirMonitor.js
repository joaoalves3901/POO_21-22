var PessoaId = sessionStorage.getItem("PessoaId");
var AdminId = 1;
// var AdminId = sessionStorage.getItem("AdminId");
var monitor = sessionStorage.getItem("monitorId");

window.onload = async function () {
    try {
        let campos = await $.ajax({
            url: "/api/campos",
            method: "get",
            dataType: "json",
        });

        let semanas = await $.ajax({
            url: "/api/semana",
            method: "get",
            dataType: "json",
        });

        let monitores = await $.ajax({
            url: "/api/monitor",
            method: "get",
            dataType: "json",
        });


        let html10 = `<ul class="navbar-nav ms-auto">
    <li class="nav-item mx-3">
        <a class="nav-link text-white" href="/campos.html"
            >CAMPOS</a
        >
    </li>
    <li class="nav-item mx-3">
        <a class="nav-link text-white" href="/CamposMap.html"
            >CAMPOS MAP</a
        >
    </li>
    <li class="nav-item mx-3">
        <a class="nav-link text-white" href="/Contactos.html"
            >CONTACTOS</a
        >
    </li>`;

        if (PessoaId) {
            html10 += `
        <li class="nav-item mx-3">
        <a class="nav-link text-white" href="/pessoaProfile.html"
            >PERFIL</a
        >
    </li>
    <li class="nav-item mx-3">
        <a class="nav-link text-white" onclick="logout()" href="/index.html">LOGOUT</a>
    </li>`;
        } else if (AdminId) {
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
        <a class="nav-link text-white" onclick="logout()" href="/index.html">LOGOUT</a>
    </li>`;
        } else {
            html10 += `
        
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
    </ul>`;
        }

        document.getElementById("navbarNav").innerHTML = html10;

        let html = "";
        let html1 = "";
        let html2 = "";
        for (let semana of semanas) {
            html +=
                `<option value = ${semana.id}>` +
                new Date(semana.start).toLocaleDateString("pt-PT") +
                "</option>";
        }
        for (let monitor of monitores) {
            html1 +=
                `<option value = ${monitor.monitorId}>` +
                monitor.pessoa.nome +
                "</option> ";
        }
        for (let campo of campos) {
            html2 +=
                `<option value = ${campo.campoId}>` +
                campo.nome +
                "</option>";
        }
        document.getElementById("semana").innerHTML = html;
        document.getElementById("monitor").innerHTML = html1;
        document.getElementById("campo").innerHTML = html2;
    } catch (err) {
        console.log(err);
    }
};


async function submeter() {
    try {
        
        let obj = {
            "semana":{"id" :document.getElementById("semana").value},
            "monitor":{"monitorid" : document.getElementById("monitor").value},
            "campo":{ "campoid" : document.getElementById("campo").value}
        };

        console.log(obj);
        let gerir = await $.ajax({
            url: "/api/admin/gerirMonitor",
            method: "post",
            data: JSON.stringify(obj),
            dataType: "json",
            contentType: "application/json",
        });
    } catch (err) {
        console.log(err);
    }
}