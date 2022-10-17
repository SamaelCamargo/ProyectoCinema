const url = "http://localhost:8081/api";

class Clientes {
    static insertClient() {
        //Cuerpo de envio
        const Cliente = {
            id: $("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#email").val(),
            age: $("#edad").val(),
        };

        $.ajax({
            url: url + "/Client/save",
            type: "POST",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(Cliente),
            contentType: "application/json",
            complete: function (response) {
                if($("#idCliente").val() == "" && $("#nombreCliente").val() == "" &&
                    $("#email").val() == "" && $("#edad").val() == ""){                    
                    alert("Debe llenar los campos para registrar al cliente");
                }else{
                    if (response.status === 201) {
                        $("#idCliente").val("");
                        $("#nombreCliente").val("");
                        $("#email").val("");
                        $("#edad").val("");
                        alert("Cliente guardado");
                    } else {
                        alert("se produjo un error, el cliente no fue guardado");
                    }
                }
            }            
        });
    }

    static loadAllClient() {
        $.ajax({
            url: url + "/Client/all",
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function (data) {
                $("tbody").html("");
                //data.items.sort((a,b)=>a.name.localeCompare(b.name));
                //data.items.sort((a,b)=>a.id - b.id);
                for (let index = 0; index < data.items.length; ++index) {
                    $("tbody").append(`
                        <tr>
                            <td>${data.items[index].id}</td>
                            <td>
                            <a href = "javascript:Clientes.loadByIdClient(${data.items[index].id})" class="link-success">${data.items[index].name}</a>
                            </td>
                            <td>${data.items[index].email}</td>
                            <td>${data.items[index].age}</td>
                        </tr>
                        `);


                }
            },
            error: function () {
                alert("se produjo un error, los clientes no fueron cargados");
            }
        });
    }

    static loadByIdClient(id) {
        $.ajax({
            url: url + "/Client/all/" + id,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function (data) {
                if (data.items.length === 0) {
                    alert("Cliente no existe");
                } else {
                    $("#detallesCliente").html(`
                    <p><b>Id:</b> ${(data.items[0].id)} </p>
                    <p><b>Nombre:</b>${(data.items[0].name)}</p>
                    <p><b>Email:</b>${(data.items[0].email)}</p>
                    <p><b>Edad:</b>${(data.items[0].age)}</p>
                    <button onclick="Clientes.deleteByIdClient( ${(data.items[0].id)})"type="button" id="EliminarCliente" class="btn btn-danger">ELIMINAR</button>
                    


                `);
                }
            },
            error: function () {
                alert("se produjo un error, el cliente seleccionado no pudo ser cargado");
            }
        });

    }

    static updateClient() {
        const Cliente = {
            id: $("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#email").val(),
            age: $("#edad").val(),
        };

        $.ajax({
            url: url + "/Client/save",
            type: "PUT",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(Cliente),
            contentType: "application/json",
            complete: function (response) {
                if (response.status === 201) {

                    $("#idCliente").val("");
                    $("#nombreCliente").val("");
                    $("#email").val("");
                    $("#edad").val("");
                    $("#detallesCliente").html("<p>Seleccione un cliente</p>")
                    Clientes.loadAllClient();
                    alert("Cliente fue actualizado con exito");
                } else {
                    alert("se produjo un error, el cliente no fue actualizado");
                }
            }
        });

    }

    static deleteByIdClient(id) {
        $.ajax({
            url: url + "/Client",
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify({id}),
            contentType: "application/json",
            complete: function (response) {
                if (response.status === 204) {
                    $("#detallesCliente").html("<p>Seleccione un cliente</p>")
                    Clientes.loadAllClient();
                    alert("Cliente fue eliminado con exito");

                } else {
                    alert("se produjo un error, el cliente no fue eliminado");
                }
            }
        });

    }
}