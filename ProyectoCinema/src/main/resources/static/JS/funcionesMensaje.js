const ApiURLMensaje = "http://localhost:8081/api/Message";
const ApiURLCinema = "http://localhost:8081/api/Cinema";
const ApiURLClient = "http://localhost:8081/api/Client";


class Mensaje{

    static insert(){
        if ($("#messageText").val() == "" ){
            alert("Todos los campos son obligatorios para crear el Mensaje");
        } else {
        let cajas = {
            messageText:$("#messageText").val(),
            cinema:{idCinema: +$("#select-cinema").val()},
            client:{idClient: +$("#select-client").val()},
        };
        console.log(cajas);

        $.ajax({
            url: ApiURLMensaje+"/save",
            type:"POST",
            datatype:"JSON",
            crossDomain: true,
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(cajas),
            success:function(respuesta){
                if (response.status === 201) {
                    $("#messageText").val(""),
                    $("#select-cinema").val(""),
                    $("#select-client").val(""),
                    Mensaje.loadAll();
                alert("Mensaje agregado");
            } else {
                alert("se produjo un error,el Mensajeno pudo ser creado");
    }
    }
    });
}
    }
    static update(botonActualizar) {
        if ($("#messageText").val() == "" ) {
            alert("Todos los campos son obligatorios para actualizar el Cinema");
        } else {


            let camposMensaje = {
                idMensaje:botonActualizar,
                messageText: $("#messageText").val(),
                cinema:{idCinema: +$("#select-cinema").val()},
                client:{idClient: +$("#select-client").val()},
            }

            $.ajax({
                url: ApiURLMensaje+ "/Message/update",
                type: "PUT",
                dataType: "json",
                crossDomain: true,
                data: JSON.stringify(camposMensaje),
                contentType: "application/json",
                complete: function (response) {
                    if (response.status === 201) {
                        $("#messageText").val(""),
                            $("#select-cinema").val(""),
                            $("#select-client").val(""),
                            Mensaje.loadAll();
                        alert("Mensaje actualizado");
                    } else {
                        alert("se produjo un error,el Mensajeno pudo ser actualizado");
                    }
                }
            });
        }

        }

    static deleteById(idBoton) {
        let myData={
            id:idBoton
        };
        $.ajax({
            url: ApiURLMensaje+"/Message/delete/"+idBoton,
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(myData),
            contentType: "application/json",
            complete: function (response) {
                if (response.status === 204) {
                    Mensaje.loadAll();
                    alert("Mensaje eliminado");
                } else {
                    alert("se produjo un eroor, el Mensaje no pudo ser eliminado");
                }
            }
        });

    }



    static loadAll(){
    $.ajax({
        url: ApiURLMensaje+"/all",
        type:"GET",
        datatype:"JSON",
        crossDomain: true,
        success:function(respuesta){
            console.log(respuesta);
            Mensaje.pintarRespuesta(respuesta);
        }

    });

}

/////////////////////////////////////

    static getMensajes_Cinema(){
    $.ajax({
        url:ApiURLCinema+"/all",
        type:"GET",
        datatype:"JSON",
        crossDomain: true,
        success:function(respuesta){
            console.log(respuesta);
            let $select =$("#select-cinema");

            $.each(respuesta, function (id,name) {
                $select.append('<option value='+name.idCinema+'>'+name.name+'</option>');
                //console.log(name);
            });
        }

    });

}

    static getMensajes_Client(){
    $.ajax({
        url:ApiURLClient +"/all",
        type:"GET",
        datatype:"JSON",
        crossDomain: true,
        success:function(respuesta){
            console.log(respuesta);
            let $select =$("#select-client");
            $.each(respuesta, function (id,name) {
                $select.append('<option value='+name.idClient+'>'+name.name+'</option>');
                //console.log(name);
            });
        }

    });

}

////////////////////////////////////////
    static pintarRespuesta(items) {
        let myTable = "<table>";
        for (let i = 0; i < items.length; i++) {
            myTable += "<tr>";
            myTable += "<td>" + items[i].messageText + "</td>";
            myTable += "<td>" + items[i].cinema.name + "</td>";
            myTable += "<td>" + items[i].client.name + "</td>";
            myTable+= "<td> <button onclick='Mensaje.update ("+items[i].id+")'> Actualizar </button> " ;
            myTable+= "<td> <button onclick='Mensaje.deleteById ("+items[i].id+")'> Borrar </button> " ;
        }
        myTable += "</table>";
        $("#resultado1").append(myTable);
    }
}

