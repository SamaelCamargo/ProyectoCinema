const ApiURLMensaje = " https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/mensaje/mensaje";

class Comentario{
    static insertarMensaje(){
        //Cuerpo de envio
        const menssaje = {
            id: $("#idMensaje").val(),
            messagetext: $("#nombreMensaje").val()
        }

        $.ajax({
            url: ApiURLMensaje,
            type: "POST",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(menssaje),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {
                    $("#idMensaje").val(""),
                    $("#nombreMensaje").val(""),                    
                    $("#detallesMensaje").html("<p>Seleccione un mensaje</p>")
                    Mensaje.loadAll();
                    alert("Mensaje agregado");
                }else{
                    alert("Mensaje no agregado");
                }
            }
        });
    }

    static loadAll(){
        $.ajax({
            url: ApiURLMensaje,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function(data){
                $("tbody").html("");

                for(let index = 0; index < data.items.length; index++){
                    $("tbody").append(`
                    <tr>
                        <td>${data.items[index].id}</td>
                        <td>${data.items[index].messagetext}</td>
                        <td>
                            <a href = "javascript:Comentario.loadById(${data.items[index].id})" class="link-success">${data.items[index].id}</a>
                        </td>
                    </tr>
                    `);
                }
            },
            error: function(){
                alert("se produjo un error, los mensajes no fueron cargados")
            }
        });
    }

    static loadByIdMensaje(id){
        $.ajax({
            url: ApiURLMensaje+"/"+id,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function(data){
                if (data.items.length===0){
                    alert("Mensaje no existe");
                }else{
                $("#detallesMensaje").html(`
                    <p><b>Id:</b> ${(data.items[0].id)} </p>
                    <p><b>Mensaje:</b> ${data.items[0].messagetext}</p>
                    <button onclick="Comentario.deleteById( ${(data.items[0].id)})"type="button" id="EliminarMensaje" class="btn btn-delete">ELIMINAR</button>

                `);
                }
            },
            error: function(){
                alert("se produjo un error, el mensaje seleccionado no pudo ser cargado");
            }
        });
    }

    static actualizarMensaje(){
        //Cuerpo de envio
        const menssaje = {
            id: $("#idMensaje").val(),
            messagetext: $("#nombreMensaje").val()
        }

        $.ajax({
            url: ApiURLMensaje,
            type: "PUT",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(menssaje),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {
                    $("#idMensaje").val(""),
                    $("#nombreMensaje").val(""),                    
                    $("#detallesMensaje").html("<p>Seleccione un mensaje</p>")
                    Comentario.loadAll();
                    alert("Mensaje actualizado");
                }else{
                    alert("Mensaje no actualizado");
                }
            }
        });
    }

    static deleteById(id){
        $.ajax({
            url: ApiURLMensaje,
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify({id}),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 204) {
                    $("#detallesMensaje").html("<p>Seleccione un mensaje</p>")
                    Comentario.loadAll();
                    alert("Mensaje eliminado");
                }else{
                    alert("Mensaje no sea a eliminado");
                }
            }
        });
    }
}