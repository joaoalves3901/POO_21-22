window.onload = async function () {
try {
    let AdminId = 1;
    // let AdminId = sessionStorage.getItem("AdminId");
    let pedidos = await $.ajax({
      url: `/api/pessoas/pedidosMonitor`,
      method: "get",
      dataType: "json",
    });
    console.log(pedidos);
    let html = "<ul class='list-group my-3'>";
    for (let pessoa  of pedidos) {
      html += `<li class="list-group-item d-flex justify-content-between align-items-center px-5">
            <h2>${pessoa.nome}</h2>
            <p><input type="button" onclick="aceitarMonitor(${pessoa.pessoaId})" value="Aceitar o monitor" class="btn btn-success"></p>
        </li>`;
    }
    html += "</ul>";
    document.getElementById("pedidos").innerHTML = html;
  } catch (err) {
  }
}

async function aceitarMonitor(id){
    sessionStorage.setItem("monitorId", id);
    alert(id);
    try {
        let obj = {id}
        let pessoa = await $.ajax({
          url: "/api/admin/aceitarMonitor",
          method: "put",
          dataType: "json",
          data: JSON.stringify(id),
          contentType: "application/json",
        });
        location.reload(true);
      } catch (err) {
        document.getElementById("msg").innerText = err.responseJSON.msg;
      }
    }

