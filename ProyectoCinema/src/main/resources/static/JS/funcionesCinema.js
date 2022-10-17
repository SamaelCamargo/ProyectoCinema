const url = "http://localhost:8081/api";

class Cinema {
    static insert() {
        //Cuerpo de envio
       if ($("#idCinema").val()==""|| $("#idPropietario").val()== "" || $("#idCapacity").val() == "" || $("#idDescripcion").val()== "") {
         alert("Todos los campos son obligatorios para crear el Cinema");
        } else {

            const cinema = {
                name: $("#idCinema").val(),
                owner: $("#idPropietario").val(),
                capacity: $("#idCapacity").val(),
                category: {idCategoriy: +$("#select-categoria").val()},
                Description: $("#idDescripcion").val()
            }

            $.ajax({
                url: url + "/Cinema/save",
                type: "POST",
                dataType: "json",
                crossDomain: true,
                data: JSON.stringify(cinema),
                contentType: "application/json",
                complete: function (response) {
                    if (response.status === 201) {
                        $("#idCinema").val(""),
                            $("#idPropietario").val(""),
                            $("#idCapacity").val(""),
                            $("#select-categoria").val(""),
                            $("#idDescripcion").val(""),
                            Cinema.loadAll();
                        alert("Cinema agregado");
                    } else {
                        alert("se produjo un error,el Cinema pudo ser creado");
                    }
                }
            });
        }
    }

    static update(botonActualizar) {
        if ($("#idCinema").val() == "" || $("#idPropietario").val()=="" || $("#idCapacity").val()=="" || $("#idDescripcion").val()=="") {
            alert("Todos los campos son obligatorios para actualizar el Cinema");
        } else {


            let camposCinema = {
                idCinema:botonActualizar,
                name: $("#idCinema").val(),
                owner: $("#idPropietario").val(),
                capacity: $("#idCapacity").val(),
                category: {idCategoriy: +$("#select-categoria").val()},
                Description: $("#idDescripcion").val()
            }

            $.ajax({
                url: url + "/Cinema/update",
                type: "PUT",
                dataType: "json",
                crossDomain: true,
                data: JSON.stringify(camposCinema),
                contentType: "application/json",
                complete: function (response) {
                    if (response.status === 201) {
                        $("#idCinema").val(""),
                            $("#idPropietario").val(""),
                            $("#idCapacity").val(""),
                            $("#select-categoria").val(""),
                            $("#idDescripcion").val(""),
                            Cinema.loadAll();

                        alert("Cinema actualizado");
                    } else {
                        alert("El Cinema no se pudo actualizar");
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
            url: ApiURLCinema+"/Cinema/delete/"+idBoton,
            type: "DELETE",
            dataType: "json",
            crossDomain: true,
            data: JSON.stringify(myData),
            contentType: "application/json",
            complete: function (response) {
                if (response.status === 204) {
                    Cinema.loadAll();
                    alert("Cinema eliminado");
                } else {
                    alert("se produjo un eroor, el Cinema no pudo ser eliminado");
                }
            }
        });

    }

    static loadAll() {
        $.ajax({
            url: url + "/Cinema/all",
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function (data) {
                $("tbody").html("");

                for (let index = 0; index < data.items.length; index++) {
                    $("tbody").append(`
                    <tr>
                        <td>${data.items[index].name}</td>
                        <td>${data.items[index].owner}</td>                        
                        <td>${data.items[index].capacity}</td>
                        <td>${data.items[index].category.name}</td>
                        <td>${data.items[index].Description}</td>
                       <td> <button onclick='Cinema.update ("+items[i].id+")'> Actualizar </button> " ;
                       <td> <button onclick='Cinema.deleteById ("+items[i].id+")'> Borrar </button> " ;
                       
                    </tr>
                    `);
                }
                $("#resultado2").html(myTable);
            },
            error: function () {
                alert("se produjo un error, los cinemas no fueron cargados")
            }
        });
    }

    static loadById(id) {
        $.ajax({
            url: ApiURLCinema + "/" + id,
            type: "GET",
            dataType: "json",
            crossDomain: true,
            contentType: "application/json",
            success: function (data) {
                if (data.items.length === 0) {
                    alert("Cinema no existe");
                } else {
                    $("#detallesCinema").html(`
                    <p><b>Id:</b> ${(data.items[0].id)} </p>
                    <p><b>Propietario:</b> ${data.items[0].owner}</p>
                    <p><b>Capacidad:</b> ${data.items[0].capacity}</p>
                    <p><b>Categoria:</b>  ${data.items[0].category}</p>
                    <p><b>Nombre:</b>  ${data.items[0].name}</p>
                    <button onclick="Cinema.deleteById( ${(data.items[0].id)})"type="button" id="EliminarCinema" class="btn btn-success">ELIMINAR</button>

                `);
                }
            },
            error: function () {
                alert("se produjo un error, el cinema seleccionado no pudo ser cargado");
            }
        });
    }
    static getCategoriaRelacion() {
        $.ajax({
            url: url + "/Category/all",
            type: "GET",
            crossDomain: true,
            datatype: "JSON",
            success: function (respuesta) {
                let $select = $("#select-categoria");
                $.each(respuesta, function (id, name) {
                    $select.append('<option value=' + name.idCategoriy + '>' + name.name + '</option>');
                    //console.log(name);
                });
            }

        });

    }

}
