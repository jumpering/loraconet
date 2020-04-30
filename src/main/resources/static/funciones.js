function eliminar(id) {
    swal({
        title: "Segur que vols eliminar el usuari?",
        text: "Un cop eliminat, no es podrà recuperar l'usuari",
        icon: "alerta!",
        buttons: true,
        dangerMode: true,
    })
        .then((OK) => {
            if (OK) {
                $.ajax({
                    url:"/eliminar"+id,
                    succes: function(respuesta){
                        console.log(respuesta);
                    }
                });
                swal("Usuari eliminat!", {
                    icon: "Fet!",
                }).then((ok)=>{
                    if(ok){
                        localiton.href="/showusers";
                    }
                });
            } else {
                swal("El teu usuari està segur!");
            }
        });
}