const ApiURLCinema = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/cinema/";
const ApiURLCliente = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/client/";
const ApiURLMensaje = "https://g27031629e0c94a-m4bhscnvjmmafkv8.adb.ca-toronto-1.oraclecloudapps.com/ords/admin/open-api-catalog/mensaje/";
// https://gc719cfc2d6dc7f-reto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/open-api-catalog/client/
const URLPrueba= "https://gc719cfc2d6dc7f-reto1.adb.us-ashburn-1.oraclecloudapps.com/ords/admin/";

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
            success: function(response){
                for(let index = 0; index < data.items.length; index++){
                    $("body").append(``)
                }
            },
            error: function(){
                alert("Cinemas cargados...")
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
            success: function(response){
            },
            error: function(){
                alert("Cinema cargado...")
            }
        });
    }

    static update(){
        const cinema = {
            id: $("#idCinema").val(),
            owner: $("#propietarioCinema").val(),
            capacity: $("#capacidadCinema").val(),
            category_ID: $("#categoriaCinema").val(),
            name: $("#nombreCinema").val()
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
                    alert("Cinema actualizado");
                }else{
                    alert("Cinema no actualizado");
                }
            }
        });
    }

    static deleteById(id){
        $.ajax({
            url: ApiURLCinema+"/"+id,
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify({id: id}),
            contentType: "application/json",
            complete: function(response){
                if (response.status === 204) {
                    alert("Cinema eliminado");
                }else{
                    alert("Cinema no sea a eliminado");
                }
            }
        });
    }
}
