const ApiURLCinema = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/cinema/cinema";
const ApiURLCliente = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/client/";
const ApiURLMensaje = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/mensaje/";

class Cinema{
    static insert(){
        //Cuerpo de envio
        const cinema = {
            id: $("#idCinema").val(),
            owner: $("#propietarioCinema").val(),
            capacity: $("#capacidadCinema").val(),
            category_ID: $("#categoriaCinema").val(),
            name: $("#nombreCinema").val()
        }

        $.ajax({
            url: ApiURLCinema,
            type: "POST",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(cinema),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {
                    $("#idCinema").val(""),
                    $("#propietarioCinema").val(""),
                    $("#capacidadCinema").val(""),
                    $("#categoriaCinema").val(""),
                    $("#nombreCinema").val(""),                    
                    $("#detallesCinema").html("<p>Seleccione un cinema</p>")
                    Cinema.loadAll();
                    alert("Cinema agregado");
                }else{
                    alert("Cinema no agregado");
                }
            }
        });
    }

    static loadAll(){
        $.ajax({
            url: ApiURLCinema,
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
                        <td>${data.items[index].owner}</td>                        
                        <td>${data.items[index].capacity}</td>
                        <td>${data.items[index].category_ID}</td>
                        <td>
                            <a href = "javascript:Cinema.loadById(${data.items[index].id})" class="link-success">${data.items[index].name}</a>
                        </td>
                    </tr>
                    `);
                }
            },
            error: function(){
                alert("se produjo un error, los cinemas no fueron cargados")
            }
        });
    }

    static loadById(id){
        $.ajax({
            url: ApiURLCinema+"/"+id,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function(data){
                if (data.items.length===0){
                    alert("Cinema no existe");
                }else{
                $("#detallesCinema").html(`
                    <p><b>Id:</b> ${(data.items[0].id)} </p>
                    <p><b>Propietario:</b> ${data.items[0].owner}</p>
                    <p><b>Capacidad:</b> ${data.items[0].capacity}</p>
                    <p><b>Categoria:</b>  ${data.items[0].category_ID}</p>
                    <p><b>Nombre:</b>  ${data.items[0].name}</p>
                    <button onclick="Cinema.deleteById( ${(data.items[0].id)})"type="button" id="EliminarCinema" class="btn btn-success">ELIMINAR</button>

                `);
                }
            },
            error: function(){
                alert("se produjo un error, el cinema seleccionado no pudo ser cargado");
            }
        });
    }

    static update(){
        const cinema = {
            id:             $("#idCinema").val(),
            owner:          $("#propietarioCinema").val(),
            capacity:       $("#capacidadCinema").val(),
            category_ID:    $("#categoriaCinema").val(),
            name:           $("#nombreCinema").val()
        }

        $.ajax({
            url: ApiURLCinema,
            type: "PUT",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(cinema),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 201) {
                    $("#idCinema").val(""),
                    $("#propietarioCinema").val(""),
                    $("#capacidadCinema").val(""),
                    $("#categoriaCinema").val(""),
                    $("#nombreCinema").val(""),                    
                    $("#detallesCinema").html("<p>Seleccione un cinema</p>")
                    Cinema.loadAll();
                    alert("Cinema actualizado");
                }else{
                    alert("Cinema no se pudo actualizar");
                }
            }
        });
    }

    static deleteById(id){
        $.ajax({
            url: ApiURLCinema,
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify({id}),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 204) {
                    $("#detallesCinema").html("<p>Seleccione un cliente</p>")
                    Cinema.loadAll();
                    alert("Cinema eliminado");
                }else{
                    alert("Cinema no sea a eliminado");
                }
            }
        });
    }
}
