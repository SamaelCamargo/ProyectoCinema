const ApiURLCinema = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/cinema/";
const ApiURLCliente = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/client/";
const ApiURLMensaje = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/mensaje/";
// https://gc719cfc2d6dc7f-reto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/open-api-catalog/client/
const URLPrueba= "https://gc719cfc2d6dc7f-reto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/";


class Clientes{
    static insertClient(){
        //Cuerpo de envio
        const Cliente = {
            id: $("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#email").val(),
            age: $("#edad").val(),
        };

        $.ajax({
            url: URLPrueba+"client"+"/"+"client",
            type: "POST",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(Cliente),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {
                    $("#idCliente").val("");
                    $("#nombreCliente").val("");
                    $("#email").val("");
                    $("#edad").val("");
                    $("#detallesCliente").html("<p>Seleccione un cliente</p>")
                    Clientes.loadAllClient();
                    alert("Cliente guardado");
                }else{
                    alert("se produjo un error, el cliente no fue guardado");
                }
            }
        });
    }

    static loadAllClient(){
        $.ajax({
            url: URLPrueba+"client"+"/"+"client",
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function(data){
             $("tbody").html("");
        
                for(let index = 0; index < data.items.length; ++index){
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
            error:function(){
                alert("se produjo un error, los clientes no fueron cargados");
            }
        });
    }

    static loadByIdClient(id){
        $.ajax({
            url: URLPrueba+"client"+"/"+"client"+"/"+id ,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function(data){
                if (data.items.length===0){
                    alert("Cliente no existe");
                }else{
                $("#detallesCliente").html(`
                    <p><b>Id:</b> ${(data.items[0].id)} </p>
                    <p><b>Nombre:</b>${(data.items[0].name)}</p>
                    <p><b>Email:</b>${(data.items[0].email)}</p>
                    <p><b>Edad:</b>${(data.items[0].age)}</p>
                    <button onclick="Clientes.deleteByIdClient( ${(data.items[0].id)})"type="button" id="EliminarCliente" class="btn btn-success">ELIMINAR</button>
                    


                `);
                }
            },
            error:function(){
                alert("se produjo un error, el cliente seleccionado no pudo ser cargado");
            }
        });

    }

    static updateClient(){
        const Cliente = {
            id: $("#idCliente").val(),
            name: $("#nombreCliente").val(),
            email: $("#email").val(),
            age: $("#edad").val(),
        };

        $.ajax({
            url: URLPrueba+"client"+"/"+"client",
            type: "PUT",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(Cliente),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {

                    $("#idCliente").val("");
                    $("#nombreCliente").val("");
                    $("#email").val("");
                    $("#edad").val("");
                    $("#detallesCliente").html("<p>Seleccione un cliente</p>")
                    Clientes.loadAllClient();
                    alert("Cliente fue actualizado con exito");
                }else{
                    alert("se produjo un error, el cliente no fue actualizado");
                }
            }
        });
        
    }

    static deleteByIdClient(id){
        $.ajax({
            url: URLPrueba+"client"+"/"+"client",
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify({id}),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 204) {
                    $("#detallesCliente").html("<p>Seleccione un cliente</p>")
                    Clientes.loadAllClient();
                    alert("Cliente fue eliminado con exito");
                    
                }else{
                    alert("se produjo un error, el cliente no fue eliminado");
                }
            }
        });
        
    }
}