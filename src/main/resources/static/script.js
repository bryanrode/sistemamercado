//  (function(){
//      $("#tabclientes").on("click","btn-exluir", function(){
//          let botaoClicado = $(this)
//          $("#btnsim").attr("data-id",botaoClicado.attr("data-id"))
//          $("#modalcliente").modal("show")
//     })

//      $("#btnsim").on("click",function(){
//          let botaoSim = $(this)
//           let id = botaoSim.attr("data-id")
//           $.ajax({
//              url: "clientes/delete/" + id,
//              method: "GET",
//              success: function(){
//                  window.location.href="/clientes"
//              }
//           })
//      })
//  })();

var tabela = document.querySelector("#tabclientes");

 tabela.addEventListener("click", function(event){
     var elementoClicado = event.target;
     if (elementoClicado.classList.contains("btn-excluir")) {
         var celula = elementoClicado.parentNode;
         var linha = celula.parentNode;
         linha.remove();
     }
    
 })
